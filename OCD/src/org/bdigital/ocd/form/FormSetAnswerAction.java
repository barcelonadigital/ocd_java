/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.form;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.json.ResponseQuestionsJson;
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.FormData;
import org.bdigital.ocd.model.Question;
import org.bdigital.ocd.utils.UtilsWs;
import org.bdigital.ocd.ws.LINKCAREException;

/**
 *
 * @author jroda
 */
public class FormSetAnswerAction extends BaseAction {

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


    	response.setContentType("text/json");
    	PrintWriter out = response.getWriter();
    	
    	ResponseQuestionsJson respJson = doSave(form,request,out);
    	
		if(respJson!=null){
	    	JSONObject json = JSONObject.fromObject(respJson);
	    	out.println(json.toString());
		}
	    
	    out.flush();
	    return(null);
    }

	private ResponseQuestionsJson doSave(ActionForm form,
    		HttpServletRequest request, PrintWriter out) throws Exception {
		
		FormSetAnswerForm formBean = (FormSetAnswerForm)form;
		ResponseQuestionsJson respJson = null;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String formId=formBean.getIdForm();
	    
	    if(formId!=null){
	    	StringHolder result = new StringHolder("");
    		StringHolder errorMsg = new StringHolder("");
    		StringHolder refresh = new StringHolder("");
        	StringHolder next = new StringHolder("");
        	StringHolder nextForm = new StringHolder("");
        	String questionType = formBean.getType();
        	if("VERTICAL_RADIO".equals(questionType) || 
        			"HORIZONTAL_RADIO".equals(questionType) ||
        			"DATE".equals(questionType) ||
        			"TEXT".equals(questionType) || 
        			"NUMERICAL".equals(questionType) || 
        			"TEXT_AREA".equals(questionType)){

        		respJson = new ResponseQuestionsJson();
        		String optionId = formBean.getOption();
        		String value = formBean.getValue();
        		String questionId = formBean.getIdQuestion();
        		respJson.setIdQuestion(questionId);
        		respJson.setRequestCounter(formBean.getRequestCounter());

        		try{
            		proxy.form_set_answer(tokenLK, formId, questionId, value, optionId, "", result, refresh, next, nextForm, errorMsg);
                }catch(LINKCAREException e){
                	
                	respJson.setErrorMessage(errorMsg.value);
                	return respJson;
                }
        		
            	errorMsg = new StringHolder("");
            	result = new StringHolder("");
            	
            	try{
                	proxy.form_get_summary(tokenLK, formId, result, errorMsg);
                }catch(LINKCAREException e){
                	
                	respJson.setErrorMessage(errorMsg.value);
                	return respJson;
                }
            	
            	Form formObj = (Form)UtilsWs.xmlToObject(result.value,
            			Form.class, FormData.class, Question.class);
            	if(formObj.getFormData()!=null){
                	respJson.setFormStatus(formObj.getFormData().getStatus());
            		for(int i=0;i<formObj.getFormData().getQuestions().size();i++){
            			Question questionObj = formObj.getFormData().getQuestions().get(i);
            			respJson.addToQuestionIds(questionObj.getQuestionId());
                		respJson.addToQuestionDescriptions(questionObj.getDescription());
                		respJson.addToQuestionTypes(questionObj.getType());
            		}
            	}
            	JSONObject json = JSONObject.fromObject(respJson);
            	out.println(json.toString());
        	}
	    }
	    return respJson;
	}

}
