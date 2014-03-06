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
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.Forms;
import org.bdigital.ocd.model.Task;
import org.bdigital.ocd.utils.UtilsWs;
import org.bdigital.ocd.ws.LINKCAREException;

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
    	String idTask = formBean.getIdTask();
    	
    	if(formId!=null && idTask!=null){
//    		StringHolder errorMsg = new StringHolder("");
//        	StringHolder result = new StringHolder("");
//        	proxy.form_get(tokenLK, formId, result, errorMsg);
//        	Result resObj = (Result)UtilsWs.xmlToObject(result.value,
//        			Result.class);
//        	String idTask = resObj.getParentId();
        	
        	StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");

        	proxy.task_form_list(tokenLK, idTask, result, errorMsg);
        	Forms formsObj = (Forms)UtilsWs.xmlToObject(result.value,
        			Forms.class, Form.class);
        	boolean hiHaFormsPendents = false;
        	if(formsObj.getForms()!=null){
        		for(int l=0;l<formsObj.getForms().size();l++){
        			Form f = formsObj.getForms().get(l);
        			if(!formId.equals(f.getRef())
        					&& "OPEN".equals(f.getStatus())){
        				hiHaFormsPendents = true;
        			}
        		}
        	}
        	
    		if(!hiHaFormsPendents && 
    				(formBean.getAccept()==null || !"true".equals(formBean.getAccept()))){
    			request.setAttribute("alertFormClose", "true");
    			return mapping.findForward(FAILURE);
    		}else{
	        	try{
	        		errorMsg = new StringHolder("");
                	result = new StringHolder("");
	        		proxy.form_close(tokenLK, formId, result, errorMsg);
	        		
	        		if(!hiHaFormsPendents){
		        		errorMsg = new StringHolder("");
	                	result = new StringHolder("");
	                	proxy.task_get(tokenLK, idTask, "ADMI", result, errorMsg);
	                	Task taskObj = (Task)UtilsWs.xmlToObject(result.value,
	                			Task.class,Form.class);
	                	if("242".equals(taskObj.getRefs()[0])){
	                		request.setAttribute("activity_id", "#XTRANSFER_19");
	                		request.setAttribute("role_id", "21");
	                		return mapping.findForward("insert");
	                	}
	        		}
	            }catch(LINKCAREException e){
	            	
	            	if ("Form has mandatory questions without answer".equals(errorMsg.value)) {
	
	                    ActionMessages errors = new ActionMessages();
	                    errors.add("general",new ActionMessage("errors.mandatoryQuestionsIncompleted"));
	                    saveErrors(request, errors);
	                    return mapping.findForward(FAILURE);
	                }else{
	                	throw e;
	                }
	            }
    		}
        	
        	return mapping.findForward(SUCCESS);
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
