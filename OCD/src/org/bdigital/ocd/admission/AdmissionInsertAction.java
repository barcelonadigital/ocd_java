/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.admission;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.Admission;
import org.bdigital.ocd.model.AdmissionData;
import org.bdigital.ocd.model.AdmissionProgram;
import org.bdigital.ocd.model.AdmissionProtocol;
import org.bdigital.ocd.model.Admissions;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.utils.Constants;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class AdmissionInsertAction extends BaseAction {

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
    	AdmissionInsertForm formBean = (AdmissionInsertForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String caseId=(String)request.getAttribute("parameterIdCase")!=null?(String)request.getAttribute("parameterIdCase"):formBean.getIdCase();
    	String programId=(String)request.getAttribute("parameterIdProgram")!=null?(String)request.getAttribute("parameterIdProgram"):formBean.getIdProgram();
    	
    	if(caseId!=null && programId!=null){
    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.admission_list_case(tokenLK,caseId, "true", result, errorMsg);
        	Admissions admissionListCase = (Admissions)UtilsWs.xmlToObject(result.value,
        			Admissions.class, Admission.class, Case.class, 
        			AdmissionData.class, AdmissionProgram.class, AdmissionProtocol.class);
//    		boolean alreadyAssigned=false;
        	if(admissionListCase.getAdmissions()!=null){
        		for(int i=0;i<admissionListCase.getAdmissions().size();i++){
        			Admission adm = admissionListCase.getAdmissions().get(i);
        			if(programId.equals(adm.getData().getProgram().getId())){
//        				alreadyAssigned=true;
        			}
        		}
        	}
//        	if(alreadyAssigned){
//        		ActionMessages errors = new ActionMessages();
//                errors.add("error",new ActionMessage("errors.admissionInsertExists"));
//                saveErrors(request, errors);
//                return mapping.findForward(FAILURE);
//        	}
    		
    		errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	String currentTimeString = UtilsString.dateToString(new Date(), Constants.FORMAT_DATE_WS);
        	Date currentTimeZero = UtilsString.stringtoDate(currentTimeString,Constants.FORMAT_DATE_WS);
			proxy.admission_insert(tokenLK, caseId, programId, UtilsString.dateToString(currentTimeZero, Constants.FORMAT_DATEHOUR_WS), result, errorMsg);
			request.setAttribute("case_id",caseId);
        	return mapping.findForward(SUCCESS);
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
