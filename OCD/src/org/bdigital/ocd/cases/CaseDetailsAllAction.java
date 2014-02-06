/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.Admission;
import org.bdigital.ocd.model.AdmissionData;
import org.bdigital.ocd.model.AdmissionProgram;
import org.bdigital.ocd.model.AdmissionProtocol;
import org.bdigital.ocd.model.Admissions;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.model.Data;
import org.bdigital.ocd.model.Name;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseDetailsAllAction extends BaseAction {

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
                		}
                	}
            		formBean.setAdmissionsText(admStr);
            		formBean.setAdmissions(admissionListCase.getAdmissions());
                }
            	
            	return mapping.findForward(SUCCESS);
            }
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
