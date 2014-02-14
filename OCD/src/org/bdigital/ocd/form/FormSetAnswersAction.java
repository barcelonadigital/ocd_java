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
import org.bdigital.ocd.base.BaseAction;

/**
 *
 * @author jroda
 */
public class FormSetAnswersAction extends BaseAction {

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
    	FormSetAnswersForm formBean = (FormSetAnswersForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String formId=formBean.getIdForm();
    	
    	if(formId!=null){
    		while(formBean.getQuestionIdIterator().hasNext()){
        		StringHolder result = new StringHolder("");
        		StringHolder errorMsg = new StringHolder("");
        		StringHolder refresh = new StringHolder("");
            	StringHolder next = new StringHolder("");
            	StringHolder next_form = new StringHolder("");
    			String questionId = formBean.getQuestionIdIterator().next();
            	String questionType = formBean.getQuestionType(questionId);
            	if("VERTICAL_RADIO".equals(questionType) || "HORIZONTAL_RADIO".equals(questionType) ||
            			"TEXT".equals(questionType) || "NUMERICAL".equals(questionType) || "TEXT_AREA".equals(questionType)){
            		String optionId = formBean.getQuestionOption(questionId);
            		String value = formBean.getQuestionValue(questionId);
            		proxy.form_set_answer(tokenLK, formId, questionId, value, optionId, "", result, refresh, next, next_form, errorMsg);
            	}
    		}
//        	for(int i=0;i<formBean.getQuestionSize();i++){
//        		StringHolder result = new StringHolder("");
//        		StringHolder errorMsg = new StringHolder("");
//        		StringHolder refresh = new StringHolder("");
//            	StringHolder next = new StringHolder("");
//            	StringHolder next_form = new StringHolder("");
//            	String questionType = formBean.getQuestionType(""+i);
//            	if("VERTICAL_RADIO".equals(questionType) || "HORIZONTAL_RADIO".equals(questionType) ||
//            			"TEXT".equals(questionType) || "NUMERICAL".equals(questionType) || "TEXT_AREA".equals(questionType)){
//            		String optionId = formBean.getQuestionOption(""+i);
//            		String value = formBean.getQuestionValue(""+i);
//            		String questionId = formBean.getQuestionId(""+i);
//            		proxy.form_set_answer(tokenLK, formId, questionId, value, optionId, "", result, refresh, next, next_form, errorMsg);
//            	}
//        	}
        	return mapping.findForward(SUCCESS);
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
