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
import org.bdigital.ocd.model.FormData;
import org.bdigital.ocd.model.Question;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class FormDetailsAction extends BaseAction {

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
    	FormDetailsForm formBean = (FormDetailsForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String formId=formBean.getIdForm();
    	
    	if(formId!=null){
    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.form_get_summary(tokenLK, formId, result, errorMsg);
        	if (!"".equals(errorMsg.value)) {

                ActionMessages errors = new ActionMessages();
                errors.add("general",new ActionMessage("errors.detail",errorMsg.value));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
            }else{

            	Form formObj = (Form)UtilsWs.xmlToObject(result.value,
            			Form.class, FormData.class, Question.class);
            	if(formObj.getFormData()!=null){
            		formBean.setQuestions(formObj.getFormData().getQuestions());
            		formBean.setStatus(formObj.getFormData().getStatus());
            		formBean.setName(formObj.getFormData().getName());
            		formBean.setDescription(formObj.getFormData().getDescription());
            		for(int i=0;i<formObj.getFormData().getQuestions().size();i++){
            			Question questionObj = formObj.getFormData().getQuestions().get(i);
            			formBean.setQuestionType(questionObj.getQuestionId(), questionObj.getType());
                    	formBean.setQuestionId(questionObj.getQuestionId(), questionObj.getQuestionId());
            		}
//            		for(int i=0;i<formObj.getFormData().getQuestions().size();i++){
//            			Question q = formObj.getFormData().getQuestions().get(i);
//            			errorMsg = new StringHolder("");
//                    	result = new StringHolder("");
//                    	proxy.form_get_question(tokenLK, formId, q.getQuestionId(), result, errorMsg);
//                    	if (!"".equals(errorMsg.value)) {
//
//                            ActionMessages errors = new ActionMessages();
//                            errors.add("general",new ActionMessage("errors.detail",errorMsg.value));
//                            saveErrors(request, errors);
//                            return mapping.findForward(FAILURE);
//                        }else{
//                        	Question questionObj = (Question)UtilsWs.xmlToObject(result.value,
//                        			Question.class,Form.class,Option.class);
//                        	formBean.setQuestionType(""+i, questionObj.getType());
//                        	formBean.setQuestionId(""+i, questionObj.getQuestionId());
//                        	formBean.setQuestionOption(""+i, questionObj.getValue());
//                        	formBean.setQuestionValue(""+i, questionObj.getValue());
//                        	formObj.getFormData().getQuestions().set(i,questionObj);
//                        }
//            		}
            	}
            	return mapping.findForward(SUCCESS);
            	
            }
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
