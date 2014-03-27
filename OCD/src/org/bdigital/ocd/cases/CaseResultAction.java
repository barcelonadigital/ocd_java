/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.util.ArrayList;
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
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.model.Contacts;
import org.bdigital.ocd.model.Data;
import org.bdigital.ocd.model.form.CaseAf;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseResultAction extends BaseAction {

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
    	CaseResultForm formBean = (CaseResultForm)form;

    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");

    	String searchStr = formBean.getSearchStr();
    	if(searchStr!=null){
    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
    		proxy.contact_search(tokenLK, "CASE", searchStr, "100", "TEAM", result, errorMsg);
    		Contacts contactsObj = (Contacts)UtilsWs.xmlToObject(result.value,
    				Contacts.class,Case.class);
    		
    		if(contactsObj.getContacts().size()==0){
    			ActionMessages errors = new ActionMessages();
                errors.add("general",new ActionMessage("errors.caseNotFound"));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
    		}else if(contactsObj.getContacts().size()==1){
    			Case caseObj = (Case)contactsObj.getContacts().get(0);
    			request.setAttribute("case_id",caseObj.getId());
    			return mapping.findForward("caseMain");
    		}else{
    			List<CaseAf> patients = new ArrayList<CaseAf>();
    			int currPage = Integer.parseInt(formBean.getCurrPage());
    			for(int i=0;i<contactsObj.getContacts().size();i++){
    				Case patientObj = contactsObj.getContacts().get(i);
    				CaseAf patientAf;
    				if(i>=(currPage-1)*6 && i<currPage*6){
    					errorMsg = new StringHolder("");
        	        	result = new StringHolder("");
        	        	proxy.case_get(tokenLK,patientObj.getId(),result,errorMsg);
        	        	
        	        	Case caseGet = (Case)UtilsWs.xmlToObject(result.value,Case.class,
        	    				Data.class);
        	        	patientAf = new CaseAf(caseGet);
    				}else{
    					patientAf = new CaseAf(patientObj);
    				}
    				
    				patients.add(patientAf);
    			}
    			request.setAttribute("patients", patients);
                return mapping.findForward(SUCCESS);
    		}
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
