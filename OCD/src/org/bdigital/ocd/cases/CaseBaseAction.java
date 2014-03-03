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
import org.bdigital.ocd.beans.CaseBean;
import org.bdigital.ocd.model.AIM;
import org.bdigital.ocd.model.Action;
import org.bdigital.ocd.model.Actions;
import org.bdigital.ocd.model.Address;
import org.bdigital.ocd.model.Admission;
import org.bdigital.ocd.model.AdmissionData;
import org.bdigital.ocd.model.AdmissionProgram;
import org.bdigital.ocd.model.AdmissionProtocol;
import org.bdigital.ocd.model.Admissions;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.model.Contact;
import org.bdigital.ocd.model.Data;
import org.bdigital.ocd.model.Device;
import org.bdigital.ocd.model.Mail;
import org.bdigital.ocd.model.Name;
import org.bdigital.ocd.model.Phone;
import org.bdigital.ocd.utils.AdmissionComparator;
import org.bdigital.ocd.utils.Constants;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.utils.UtilsWs;
import org.bdigital.ocd.ws.LINKCAREException;

/**
 *
 * @author jroda
 */
public abstract class CaseBaseAction extends BaseAction {
    
    protected CaseBean caseBean;
    
	public abstract ActionForward doCaseExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception;

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
    	CaseBaseForm formBean = (CaseBaseForm)form;
    	
    	caseBean = new CaseBean();
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String caseId=(String)request.getAttribute("case_id")!=null?(String)request.getAttribute("case_id"):formBean.getIdCase();
    	
    	if(caseId!=null){
    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	try{
            	proxy.case_get(tokenLK,caseId,result,errorMsg);
            }catch(LINKCAREException e){
            	
            	if ("".equals(result.value) || result.value==null) {

                    ActionMessages errors = new ActionMessages();
                    errors.add("general",new ActionMessage("errors.resultWS",""));
                    saveErrors(request, errors);
                    return mapping.findForward(FAILURE);
                }else{
                	throw e;
                }
            }
        	
        	Case caseGet = (Case)UtilsWs.xmlToObject(result.value,Case.class,
    				Data.class);
        	if(caseGet.getData()!=null){
        		caseBean.setFullname(caseGet.getData().getFullname());
        		caseBean.setNickname(caseGet.getData().getNickname());
        		caseBean.setBirthday(caseGet.getData().getBdate());
        		caseBean.setAge(caseGet.getData().getAge());
        		caseBean.setSex(caseGet.getData().getGender());
        	}
        	for(int i=0;i<caseGet.getRefs().length;i++){
        		String item = caseGet.getRefs()[i];
        		if(item.indexOf("NICK")==0){
        			caseBean.setNick(UtilsWs.getValue(item, "NICK"));
        		}else if(item.indexOf("NIF")==0){
        			caseBean.setNif(UtilsWs.getValue(item, "NIF"));
        		}else if(item.indexOf("NIE")==0){
        			caseBean.setNie(UtilsWs.getValue(item, "NIE"));
        		}else if(item.indexOf("PAS")==0){
        			caseBean.setPas(UtilsWs.getValue(item, "PAS"));
        		}else if(item.indexOf("CIP")==0){
        			caseBean.setCip(UtilsWs.getValue(item, "CIP"));
        		} 
        	}
        	caseBean.setIdCase(caseId);
        	formBean.setIdCase(caseId);
        	
        	errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.case_get_contact(tokenLK,caseId,result,errorMsg);

        	Contact contact = (Contact)UtilsWs.xmlToObject(result.value,Contact.class,Name.class,
        			Address.class,Mail.class,AIM.class,Device.class,Phone.class);
        	caseBean.setContact(contact);
        	
    		errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.admission_list_case(tokenLK,caseId, "true", result, errorMsg);
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
        	caseBean.setAdmissionsText(admStr);
    		request.setAttribute("admissions",admissions);
        	request.setAttribute("admissionsAll",admissionsAll);
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
            	String currentTimeString = UtilsString.dateToString(new Date(), Constants.FORMAT_DATE_WS);
            	Date currentTimeZero = UtilsString.stringtoDate(currentTimeString,Constants.FORMAT_DATE_WS);
    			proxy.admission_insert(tokenLK, caseId, "#XENROLL:5", UtilsString.dateToString(currentTimeZero, Constants.FORMAT_DATEHOUR_WS), result, errorMsg);
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
    		Admission a=null;
    		if(formBean.getIdAdmission()!=null && 
    				!"".equals(formBean.getIdAdmission())){
    			for(int i=0;i<admissionsAll.size();i++){
        			Admission adm = admissionsAll.get(i);
        			if(adm.getRef().equals(formBean.getIdAdmission())){
        				a = adm;
        			}
    			}
    		}
    		if(a==null){
	    		a = admissionsAll.get(0);
    		}
    		caseBean.setIdAdmission(a.getRef());
    		if(a.getData()!=null){
        		if(a.getData().getProtocol()!=null 
        				&& a.getData().getProtocol().getId()!=null 
        				&& !"".equals(a.getData().getProtocol().getId())){
        			caseBean.setDescProtocolActual(a.getData().getProtocol().getName());
        			caseBean.setDataProtocolActual(a.getData().getAdmissionDate());
        			caseBean.setDataInscripcioAdmissio(a.getData().getEnrolDate());
        			caseBean.setEstatProtocolActual(a.getData().getStatus());
        		}
    		}
    		errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.action_list(tokenLK,"","MNG",a.getRef(),"","",result,errorMsg);
        	List<Action> actions = new ArrayList<Action>();
        	List<Action> actionsTransfer = new ArrayList<Action>();
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
        	//formBean.setActions(actions);
        	if(containsTransfer){
        		errorMsg = new StringHolder("");
            	result = new StringHolder("");
            	proxy.action_list(tokenLK,"","MNG",a.getRef(),"","#XPATH:TRANSFER",result,errorMsg);
            	actionsObj = (Actions)UtilsWs.xmlToObject(result.value,
            			Actions.class, Action.class);
            	//formBean.setActionsTransfer(actionsObj.getActions());
            	actionsTransfer = actionsObj.getActions();
            	
        	}
        	for(int i = 0; i<actions.size();){
        		Action obj = actions.get(i); 
        		if("#XJOIN:15".equals(obj.getRef()) || 
        				"#XJOIN:16".equals(obj.getRef())){
        			actions.remove(obj);
        		}else{
        			i++;
        		}
        	}
        	for(int i = 0; i<actionsTransfer.size();){
        		Action obj = actionsTransfer.get(i); 
        		if("#XTRANSFER_15".equals(obj.getRef()) || 
        				"#XTRANSFER_16".equals(obj.getRef())){
        			actionsTransfer.remove(obj);
        		}else{
        			i++;
        		}
        	}
        	request.setAttribute("actions",actions);
        	request.setAttribute("actionsTransfer",actionsTransfer);
        	
        	request.setAttribute("caseBean",caseBean);
        	return doCaseExecute(mapping, form, request, response);

    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
