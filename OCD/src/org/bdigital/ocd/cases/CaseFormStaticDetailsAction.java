/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.beans.TabBean;
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.FormData;
import org.bdigital.ocd.model.Question;
import org.bdigital.ocd.model.Result;
import org.bdigital.ocd.tabs.AltresTab;
import org.bdigital.ocd.tabs.CipapBipapTab;
import org.bdigital.ocd.tabs.DiagnosticTab;
import org.bdigital.ocd.tabs.DomiciliTab;
import org.bdigital.ocd.tabs.EquipamentTab;
import org.bdigital.ocd.tabs.EspirometriaTab;
import org.bdigital.ocd.tabs.FluxPrescritTab;
import org.bdigital.ocd.tabs.GasometriaTab;
import org.bdigital.ocd.tabs.HoresDiaTab;
import org.bdigital.ocd.tabs.ObservacionsTab;
import org.bdigital.ocd.tabs.PlanificacioTab;
import org.bdigital.ocd.tabs.PrescripcioTab;
import org.bdigital.ocd.tabs.ProveidorTab;
import org.bdigital.ocd.tabs.PulsioximetriaTab;
import org.bdigital.ocd.tabs.SistemaAdmTab;
import org.bdigital.ocd.tabs.SituacioPacientTab;
import org.bdigital.ocd.tabs.SollicitantTab;
import org.bdigital.ocd.tabs.SollicitudTab;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseFormStaticDetailsAction extends CaseBaseAction {

	String readFile(String fileName) throws IOException {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		Reader r = new InputStreamReader(inputStream, "UTF-8");
	    BufferedReader br = new BufferedReader(r);
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
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
    public ActionForward doCaseExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // extract user data
    	CaseFormStaticDetailsForm formBean = (CaseFormStaticDetailsForm)form;
    	
    	menuBean.setIsActiveMenuFormularis("true");
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String formId=formBean.getIdForm();
    	//String[] gasometriaIds = new String[]{"10","11","12","40","13","14","15"};
//    	List<String> gasometriaIdList = Arrays.asList(gasometriaIds);
//    	boolean isThereGasometria=false;
    	HashMap<String,Question> questionsMap = new HashMap<String,Question>();
    	
    	if(formId!=null){

    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.form_get(tokenLK, formId, result, errorMsg);
        	
        	Result resObj = (Result)UtilsWs.xmlToObject(result.value,
        			Result.class);
        	
        	Form formObj;
        	String xml2;
        	if("157".equals(resObj.getTemplate())){
        		xml2 = readFile("diagnostic.xml");
            	formObj = (Form)UtilsWs.xmlToObject(xml2,
            			Form.class, FormData.class, Question.class);
        	}else if("158".equals(resObj.getTemplate())){
        		xml2 = readFile("prescripcio.xml");
            	formObj = (Form)UtilsWs.xmlToObject(xml2,
            			Form.class, FormData.class, Question.class);
        	}else{
        		errorMsg = new StringHolder("");
            	result = new StringHolder("");
            	//proxy.form_get_summary_all(tokenLK, formId, result, errorMsg);
            	proxy.form_get_summary(tokenLK, formId, result, errorMsg);
            	
            	formObj = (Form)UtilsWs.xmlToObject(result.value,
            			Form.class, FormData.class, Question.class);
        	}

    		if(formObj.getFormData()!=null){
        		formBean.setQuestions(formObj.getFormData().getQuestions());
        		formBean.setStatus(formObj.getFormData().getStatus());
        		formBean.setName(formObj.getFormData().getName());
        		formBean.setDescription(formObj.getFormData().getDescription());
        		for(int i=0;i<formObj.getFormData().getQuestions().size();i++){
        			Question questionObj = formObj.getFormData().getQuestions().get(i);
        			formBean.setQuestionType(questionObj.getQuestionId(), questionObj.getType());
                	formBean.setQuestionId(questionObj.getQuestionId(), questionObj.getQuestionId());
                	formBean.setQuestionValue(questionObj.getQuestionId(), questionObj.getValue());
                	formBean.setQuestionOption(questionObj.getQuestionId(), questionObj.getValue());
                	questionsMap.put(questionObj.getQuestionId(), questionObj);
//                	List<Option> options=new ArrayList<Option>();
//                	Option op1 = new Option();
//                	op1.setDescription("Si");
//                	options.add(op1);
//                	Option op2 = new Option();
//                	op2.setDescription("No");
//                	options.add(op2);
//					questionObj.setOptions(options);
/*
            		errorMsg = new StringHolder("");
                	result = new StringHolder("");
                	proxy.form_get_question(tokenLK, formId, questionObj.getQuestionId(), result, errorMsg);
                	questionObj = (Question)UtilsWs.xmlToObject(result.value,
                			Question.class,Form.class,Option.class);
                	formObj.getFormData().getQuestions().set(i,questionObj);
                	questionsMap.put(questionObj.getQuestionId(), questionObj);
                	*/
//                	if(gasometriaIdList.contains(questionObj.getQuestionId())){
//                		isThereGasometria=true;
//                	}
        		}
        	}
//        	if(isThereGasometria){
//        		formBean.setIsThereGasometria("true");
//        		getpregunta10
//        		new row large 
//        	}
        	if("157".equals(resObj.getTemplate())){
        		List<TabBean> tabs = new ArrayList<TabBean>();
            	DiagnosticTab.generateTab(questionsMap,tabs);
            	EspirometriaTab.generateTab(questionsMap,tabs);
            	GasometriaTab.generateTab(questionsMap,tabs);
            	PulsioximetriaTab.generateTab(questionsMap,tabs);
            	PrescripcioTab.generateTab(questionsMap,tabs);
            	AltresTab.generateTab(questionsMap,tabs);
            	request.setAttribute("tabs", tabs);
        	}else if("158".equals(resObj.getTemplate())){
        		List<TabBean> tabs = new ArrayList<TabBean>();
        		SollicitudTab.generateTab(questionsMap,tabs);
        		SituacioPacientTab.generateTab(questionsMap,tabs);
        		EquipamentTab.generateTab(questionsMap,tabs);
        		SistemaAdmTab.generateTab(questionsMap,tabs);
        		HoresDiaTab.generateTab(questionsMap,tabs);
        		FluxPrescritTab.generateTab(questionsMap,tabs);
        		CipapBipapTab.generateTab(questionsMap,tabs);
        		PlanificacioTab.generateTab(questionsMap,tabs);
        		DomiciliTab.generateTab(questionsMap,tabs);
        		ProveidorTab.generateTab(questionsMap,tabs);
        		SollicitantTab.generateTab(questionsMap,tabs);
        		ObservacionsTab.generateTab(questionsMap,tabs);
        		AltresTab.generateTab(questionsMap,tabs);
            	request.setAttribute("tabs", tabs);
        	}else{
        		List<TabBean> tabs = new ArrayList<TabBean>();
        		AltresTab.generateTab(questionsMap,tabs);
            	request.setAttribute("tabs", tabs);
        	}
        	
        	
        	return mapping.findForward(SUCCESS);
            	
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
