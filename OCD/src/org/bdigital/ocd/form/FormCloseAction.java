/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.bdigital.ocd.base.BaseAction;

/**
 *
 * @author jroda
 */
public class FormCloseAction extends BaseAction {

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
    	FormCloseForm formBean = (FormCloseForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String formId=formBean.getIdForm();
    	
    	if(formId!=null){
    		StringHolder result = new StringHolder("");
    		StringHolder errorMsg = new StringHolder("");
        	proxy.form_close(tokenLK, formId, result, errorMsg);
        	if ("Form has mandatory questions without answer".equals(errorMsg.value)) {

                ActionMessages errors = new ActionMessages();
                errors.add("general",new ActionMessage("errors.mandatoryQuestionsIncompleted"));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
            }else if (null!=errorMsg.value && !"".equals(errorMsg.value)) {

                ActionMessages errors = new ActionMessages();
                errors.add("general",new ActionMessage("errors.detail",errorMsg.value));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
            }else{
            	return mapping.findForward(SUCCESS);
            }
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
