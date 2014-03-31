/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.form;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.utils.Constants;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.ws.LINKCAREException;

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
    		StringHolder result = new StringHolder("");
    		StringHolder errorMsg = new StringHolder("");
    		StringHolder refresh = new StringHolder("");
        	StringHolder next = new StringHolder("");
        	StringHolder nextForm = new StringHolder("");
        	HashMap<String,String> questionErrorMap = new HashMap<String,String>();
    		Iterator<String> iter = formBean.getQuestionIdIterator();
    		while(iter.hasNext()){
    			String questionId = iter.next();
        		String modified = formBean.getQuestionModified(questionId);
        		if("true".equals(modified)){
                	String questionType = formBean.getQuestionType(questionId);
	            	if("VERTICAL_RADIO".equals(questionType) || "HORIZONTAL_RADIO".equals(questionType) ||
	            			"TEXT".equals(questionType) || "NUMERICAL".equals(questionType) || "TEXT_AREA".equals(questionType) || "DATE".equals(questionType)){
	            		String optionId = formBean.getQuestionOption(questionId);
	            		String value = formBean.getQuestionValue(questionId);
	            		if(value!=null && !"".equals(value) && "DATE".equals(questionType)){
	            			value = UtilsString.dateToString(UtilsString.stringtoDate(value, Constants.FORMAT_DATE_WEB), Constants.FORMAT_DATE_WS);
	            		}else if(value==null){
	            			value="";
	            		}
	            		if(value!=null && !"".equals(value) && "NUMERICAL".equals(questionType)){
	            			value = value.replaceAll("[.]+", "" ).replaceAll(",", "." );
	            		}else if(value==null){
	            			value="";
	            		}
	            		questionId = questionId.replaceAll("_","/");
	            		result = new StringHolder("");
	            		errorMsg = new StringHolder("");
	            		refresh = new StringHolder("");
	                	next = new StringHolder("");
	                	nextForm = new StringHolder("");
	            		try{
	            			proxy.form_set_answer(tokenLK, formId, questionId, value, optionId, "", result, refresh, next, nextForm, errorMsg);
	            		}catch(LINKCAREException e){
	            			if (errorMsg.value.contains("Maximum") && errorMsg.value.contains("exceeded")) {
	            				
	            				String errorWs = errorMsg.value;
	            				int idxMaximum = errorWs.indexOf("Maximum");
	            				int idxExceeded = errorWs.indexOf("exceeded");
	            				int lenghtMaximum = "Maximum".length();
	            				String number = errorWs.substring(idxMaximum+lenghtMaximum+1,idxExceeded-1);
	            				number = number.replaceAll(",", "" ).replaceAll("[.]+", "," );
	            				MessageResources msgResource = getResources(request);
	            	        	String msgError=msgResource.getMessage("errors.maxnumber",number);
	            				questionErrorMap.put(questionId.replaceAll("/","_"), msgError);
	            				
	    	                }else{
	            				String errorWs = errorMsg.value;
	            				questionErrorMap.put(questionId.replaceAll("/","_"), errorWs);
	    	                }
	            		}
	            		//TODO:aniria bé un WS form_set per desar totes les respostes amb una sola crida
	            		//TODO:que succeeix si no es desen en ordre les preguntes que pengen d'altres preguntes
	            	}
        		}
    		}
    		if(!questionErrorMap.isEmpty()){
//    			ActionMessages errors = new ActionMessages();
//                errors.add("general",new ActionMessage("errors.formContainsInvalidAnswers"));
//                saveErrors(request, errors);
    			request.setAttribute("questionErrors", questionErrorMap);
                return mapping.findForward(FAILURE);
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
    		//TODO: si poguessim evitar el tancament automatic de tasques, la seguent linia que reseteja el admissionBean la podriem estalviar i posar-la només en cas de tancament volutari
    		request.getSession().setAttribute("admissionBean",null);
    		
    		return mapping.findForward(SUCCESS);
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
