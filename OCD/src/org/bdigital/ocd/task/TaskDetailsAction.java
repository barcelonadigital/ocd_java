/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.Forms;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class TaskDetailsAction extends BaseAction {

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
    	TaskDetailsForm formBean = (TaskDetailsForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String taskId=(String)request.getAttribute("parameterIdTask")!=null?(String)request.getAttribute("parameterIdTask"):formBean.getIdTask();
    	
    	if(taskId!=null){
    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.task_form_list(tokenLK, taskId, result, errorMsg);
        	if (!"".equals(errorMsg.value)) {

                ActionMessages errors = new ActionMessages();
                errors.add("general",new ActionMessage("errors.detail",errorMsg.value));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
            }else{

            	Forms formsObj = (Forms)UtilsWs.xmlToObject(result.value,
            			Forms.class, Form.class);
            	formBean.setForms(formsObj.getForms());
            	return mapping.findForward(SUCCESS);
            	
            }
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
