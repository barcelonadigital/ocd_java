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
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.Option;
import org.bdigital.ocd.model.Question;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class FormGetQuestionAction extends BaseAction {

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
    	
    	FormGetQuestionForm formBean = (FormGetQuestionForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String formId=formBean.getIdForm();
    	
    	response.setContentType("text/json");
    	PrintWriter out = response.getWriter();
	    
	    if(formId!=null){
    		StringHolder result = new StringHolder("");
    		StringHolder errorMsg = new StringHolder("");
    		String questionId = formBean.getIdQuestion();
        	proxy.form_get_question(tokenLK, formId, questionId, result, errorMsg);
        	Question questionObj = (Question)UtilsWs.xmlToObject(result.value,
        			Question.class,Form.class,Option.class);
        	JSONObject json = JSONObject.fromObject(questionObj);
        	out.println(json.toString());
	    }
	    
	    out.flush();
	    return(null);
    }

}
