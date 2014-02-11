/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.Action;
import org.bdigital.ocd.model.Actions;
import org.bdigital.ocd.model.Admission;
import org.bdigital.ocd.model.AdmissionData;
import org.bdigital.ocd.model.AdmissionProgram;
import org.bdigital.ocd.model.AdmissionProtocol;
import org.bdigital.ocd.model.Admissions;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.model.Data;
import org.bdigital.ocd.model.Name;
import org.bdigital.ocd.utils.AdmissionComparator;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseDetailsAction extends BaseAction {

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward doExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // extract user data
    	CaseDetailsForm formBean = (CaseDetailsForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String caseId=(String)request.getAttribute("case_id")!=null?(String)request.getAttribute("case_id"):formBean.getIdCase();
    	
    	if(caseId!=null){
    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.case_get(tokenLK,caseId,result,errorMsg);
        	if (!"".equals(errorMsg.value)) {

                ActionMessages errors = new ActionMessages();
                errors.add("general",new ActionMessage("errors.detail",errorMsg.value));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
            }else if ("".equals(result.value) || result.value==null) {

                ActionMessages errors = new ActionMessages();
                errors.add("general",new ActionMessage("errors.resultWS",""));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
            }else{
            	Case caseGet = (Case)UtilsWs.xmlToObject(result.value,Case.class,
        				Name.class, Data.class);
            	if(caseGet.getData()!=null){
            		formBean.setFullname(caseGet.getData().getFullname());
            		formBean.setNickname(caseGet.getData().getNickname());
            		formBean.setBirthday(caseGet.getData().getBdate());
            		formBean.setAge(caseGet.getData().getAge());
            		formBean.setSex(caseGet.getData().getGender());
            	}
            	for(int i=0;i<caseGet.getRefs().length;i++){
            		String item = caseGet.getRefs()[i];
            		if(item.indexOf("NICK")==0){
            			formBean.setNick(UtilsWs.getValue(item, "NICK"));
            		}else if(item.indexOf("NIF")==0){
            			formBean.setNif(UtilsWs.getValue(item, "NIF"));
            		}else if(item.indexOf("NIE")==0){
            			formBean.setNie(UtilsWs.getValue(item, "NIE"));
            		}else if(item.indexOf("PAS")==0){
            			formBean.setPas(UtilsWs.getValue(item, "PAS"));
            		}else if(item.indexOf("CIP")==0){
            			formBean.setCip(UtilsWs.getValue(item, "CIP"));
            		} 
            	}
            	formBean.setIdCase(caseId);

        		errorMsg = new StringHolder("");
            	result = new StringHolder("");
            	proxy.admission_list_case(tokenLK,caseId, "true", result, errorMsg);
            	if (!"".equals(errorMsg.value)) {

                    ActionMessages errors = new ActionMessages();
                    errors.add("general",new ActionMessage("errors.detail",errorMsg.value));
                    saveErrors(request, errors);
                    return mapping.findForward(FAILURE);
                }else{
                	List<Admission> admissions = new ArrayList<Admission>();
                	List<Admission> admissionsAll = new ArrayList<Admission>();
                	Admissions admissionListCase = (Admissions)UtilsWs.xmlToObject(result.value,
                			Admissions.class, Admission.class, Case.class, 
                			AdmissionData.class, AdmissionProgram.class, AdmissionProtocol.class);
            		String admStr = "";
                	if(admissionListCase.getAdmissions()!=null){
                		for(int i=0;i<admissionListCase.getAdmissions().size();i++){
                			Admission adm = admissionListCase.getAdmissions().get(i);
                			admStr+="<Ref:"+adm.getRef()
                    				+",ProgramDescription:"+adm.getData().getProgram().getDescription()
                    				+",EnrolDate:"+adm.getData().getEnrolDate()
                    				+",Status:"+adm.getData().getStatus()
                    				+",DateToDisplay:"+adm.getData().getDateToDisplay()+"> ";
                			if(adm.getData()!=null && adm.getData().getProgram()!=null && 
                					"5".equals(adm.getData().getProgram().getId())){
                				if(adm.getData().getProtocol()!=null &&
                						!"".equals(adm.getData().getProtocol().getId())){
                					admissions.add(adm);
                				}
                				admissionsAll.add(adm);
                			}
                		}
                	}
                	Collections.sort(admissions, new AdmissionComparator());
                	Collections.sort(admissionsAll, new AdmissionComparator());
                	Collections.reverse(admissions);
                	Collections.reverse(admissionsAll);
            		formBean.setAdmissionsText(admStr);
            		formBean.setAdmissions(admissions);
            		formBean.setAdmissionsAll(admissionsAll);
            		boolean ferAdmissionInsert = false;
            		if(admissionsAll.size()>0){
	            		Admission a = admissionsAll.get(0);
	            		if(a.getData()!=null && !"ENROLLED".equals(a.getData().getStatus()) && 
	            				!"PAUSED".equals(a.getData().getStatus()) && 
	            				!"ACTIVE".equals(a.getData().getStatus())){
	            			ferAdmissionInsert = true;
	            		}
            		}else{
            			ferAdmissionInsert = true;
            		}
            		if(ferAdmissionInsert){
            			//TODO: enlloc de passar el parametre "5", obtenir la action_list disponible per current_date, i si esta el #ENROL:5 , passar aquest idProgram
            			errorMsg = new StringHolder("");
                    	result = new StringHolder("");
                    	String currentTimeString = UtilsString.dateToString(new Date(), UtilsWs.FORMAT_DATE_WS);
                    	Date currentTimeZero = UtilsString.stringtoDate(currentTimeString,UtilsWs.FORMAT_DATE_WS);
            			proxy.admission_insert(tokenLK, caseId, "#XENROLL:5", UtilsString.dateToString(currentTimeZero, UtilsWs.FORMAT_DATEHOUR_WS), result, errorMsg);
                    	if (!"".equals(errorMsg.value)) {

                            ActionMessages errors = new ActionMessages();
                            errors.add("general",new ActionMessage("errors.detail",errorMsg.value));
                            saveErrors(request, errors);
                            return mapping.findForward(FAILURE);
                        }else{
                        	Admission a = new Admission();
                        	a.setRef(result.value);
                        	AdmissionData ad = new AdmissionData();
                        	AdmissionProgram apg = new AdmissionProgram();
                        	AdmissionProtocol apt = new AdmissionProtocol();
                        	a.setData(ad);
                        	ad.setProgram(apg);
                        	ad.setProtocol(apt);
                        	ad.setStatus("ENROLLED");
                        	admissionsAll.add(0,a);
                        }
            		}
            		Admission a = admissionsAll.get(0);
            		formBean.setIdAdmission(a.getRef());
            		if(a.getData()!=null){
	            		if(a.getData().getProtocol()!=null){
	            			formBean.setDescProtocolActual(a.getData().getProtocol().getName());
	            		}
	            		formBean.setDataProgramaActual(a.getData().getAdmissionDate());
	            		formBean.setEstatProgramaActual(a.getData().getStatus());
            		}
            		errorMsg = new StringHolder("");
                	result = new StringHolder("");
                	proxy.action_list(tokenLK,"","MNG",a.getRef(),"","",result,errorMsg);
                	if (!"".equals(errorMsg.value)) {

                        ActionMessages errors = new ActionMessages();
                        errors.add("general",new ActionMessage("errors.detail",errorMsg.value));
                        saveErrors(request, errors);
                        return mapping.findForward(FAILURE);
                    }else{
                    	List<Action> actions = new ArrayList<Action>();
                    	Actions actionsObj = (Actions)UtilsWs.xmlToObject(result.value,
                    			Actions.class, Action.class);
                    	boolean containsTransfer = false;
                    	if(actionsObj.getActions()!=null){
                    		for(int i=0;i<actionsObj.getActions().size();i++){
                    			Action act = actionsObj.getActions().get(i);
                    			if("#XPATH:TRANSFER".equals(act.getRef())){
                    				containsTransfer = true;
                    			}else{
                    				actions.add(act);
                    			}
                    		}
                    	}
                    	formBean.setActions(actions);
                    	request.setAttribute("actions",actions);
                    	if(containsTransfer){
                    		errorMsg = new StringHolder("");
    	                	result = new StringHolder("");
    	                	proxy.action_list(tokenLK,"","MNG",a.getRef(),"","#XPATH:TRANSFER",result,errorMsg);
    	                	if (!"".equals(errorMsg.value)) {
    	
    	                        ActionMessages errors = new ActionMessages();
    	                        errors.add("general",new ActionMessage("errors.detail",errorMsg.value));
    	                        saveErrors(request, errors);
    	                        return mapping.findForward(FAILURE);
    	                    }else{
    	                    	actionsObj = (Actions)UtilsWs.xmlToObject(result.value,
    	                    			Actions.class, Action.class);
    	                    	formBean.setActionsTransfer(actionsObj.getActions());
    	                    	request.setAttribute("actionsTransfer",actionsObj.getActions());
    	                    }
                    	}
                    }
                }
            	
            	return mapping.findForward(SUCCESS);
            }
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
