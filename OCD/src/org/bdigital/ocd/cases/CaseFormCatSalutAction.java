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
import org.bdigital.ocd.beans.RowBean;
import org.bdigital.ocd.beans.TabBean;
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.FormData;
import org.bdigital.ocd.model.Option;
import org.bdigital.ocd.model.Phone;
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
import org.bdigital.ocd.tabs.UtilsTabs;
import org.bdigital.ocd.utils.Constants;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseFormCatSalutAction extends CaseBaseAction {

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
    	CaseFormCatSalutForm formBean = (CaseFormCatSalutForm)form;

    	menuBean.setIsActiveMenuFormularis("true");
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String formId=formBean.getIdForm();
    	HashMap<String,Question> questionsMap = new HashMap<String,Question>();
    	HashMap<String,String> valuesMap = new HashMap<String,String>();
    	
    	if(formId!=null){

    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.form_get(tokenLK, formId, result, errorMsg);
        	
        	Result resObj = (Result)UtilsWs.xmlToObject(result.value,
        			Result.class);
        	
        	Form formObj;
        	String xml2;
        	String idForm1="",idForm2="",idForm3="",idForm4="",idForm5="",idForm6="";
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
            	
            	if("164".equals(resObj.getTemplate())){
            		if(formObj.getFormData().getName().equals("Variables") || formObj.getFormData().getParentName().equals("Variables")){
                		xml2 = readFile("variables.xml");
            		}else if(formObj.getFormData().getName().equals("CVSO") || formObj.getFormData().getParentName().equals("CVSO")){
            			xml2 = readFile("cvso.xml");
            		}else{
            			return mapping.findForward(FAILURE);
            		}
                	formObj = (Form)UtilsWs.xmlToObject(result.value,
                			Form.class, FormData.class, Question.class);
                	if(formObj.getFormData()!=null && formObj.getFormData().getQuestions()!=null){
                		for(int i=0;i<formObj.getFormData().getQuestions().size();i++){
                			Question questionObj = formObj.getFormData().getQuestions().get(i);
                			questionObj.setQuestionId(questionObj.getQuestionId().replaceAll("/", "_"));
                        	valuesMap.put(questionObj.getQuestionId(), questionObj.getValue());
                		}
                	}
                	
                	idForm1 = ""+(Integer.parseInt(formId)+1);
                	idForm2 = ""+(Integer.parseInt(formId)+2);
                	idForm3 = ""+(Integer.parseInt(formId)+3);
                	idForm4 = ""+(Integer.parseInt(formId)+4);
                	idForm5 = ""+(Integer.parseInt(formId)+5);
                	idForm6 = ""+(Integer.parseInt(formId)+6);
            		String[] idsArray = new String[]{idForm1,idForm2,idForm3,
                			idForm4,idForm5,idForm6};
                	List<Question> questions=new ArrayList<Question>();
            		Form form2Obj = (Form)UtilsWs.xmlToObject(xml2,
                			Form.class, FormData.class, Question.class);
                	if(form2Obj.getFormData()!=null && form2Obj.getFormData().getQuestions()!=null){
                		for(int i=0;i<form2Obj.getFormData().getQuestions().size();i++){
                			Question questionObj = form2Obj.getFormData().getQuestions().get(i);
                			questionObj.setQuestionId(replaceIDs(questionObj.getQuestionId(),idsArray));
                			questionObj.setCondition(replaceIDs(questionObj.getCondition(),idsArray));
                			questionObj.setValue(valuesMap.get(questionObj.getQuestionId()));
                			for(int j=0;j<questionObj.getOptions().size();j++){
                				Option optionObj = questionObj.getOptions().get(j);
                				if(optionObj.getDescription()!=null && 
                						questionObj.getValue()!=null &&
                						optionObj.getDescription().trim().equals(questionObj.getValue().trim())){
                					questionObj.setValue(optionObj.getOptionId());
                				}
                			}
                		}
                		questions.addAll(form2Obj.getFormData().getQuestions());
                	}
                	formObj.getFormData().setQuestions(questions);
            	}
        	}

    		if(formObj.getFormData()!=null){
        		/*formBean.setQuestions(formObj.getFormData().getQuestions());
        		formBean.setStatus(formObj.getFormData().getStatus());
        		formBean.setName(formObj.getFormData().getName());
        		formBean.setDescription(formObj.getFormData().getDescription());*/
        		for(int i=0;i<formObj.getFormData().getQuestions().size();i++){
        			Question questionObj = formObj.getFormData().getQuestions().get(i);
        			/*formBean.setQuestionType(questionObj.getQuestionId(), questionObj.getType());
                	formBean.setQuestionId(questionObj.getQuestionId(), questionObj.getQuestionId());
                	if(questionObj.getValue()!=null && !"".equals(questionObj.getValue()) && "DATE".equals(questionObj.getType())){
                		questionObj.setValue(UtilsString.dateToString(UtilsString.stringtoDate(questionObj.getValue(), Constants.FORMAT_DATE_WS), Constants.FORMAT_DATE_WEB));
                	}
                	if(questionObj.getValue()!=null && !"".equals(questionObj.getValue()) && "NUMERICAL".equals(questionObj.getType())){
                		questionObj.setValue(questionObj.getValue().replaceAll(",", "" ).replaceAll("[.]+", "," ));
            		}
                    @SuppressWarnings("unchecked")
					HashMap<String,String> questionErrorMap = (HashMap<String,String>)request.getAttribute("questionErrors");
                    if(questionErrorMap!=null && questionErrorMap.get(questionObj.getQuestionId())!=null){
                    	//TODO:enlloc d'esborrar el valor caldria mantenir el valor no valid que ha provocat l'error
                    	formBean.setQuestionValue(questionObj.getQuestionId(), "");
                    }else{
                    	formBean.setQuestionValue(questionObj.getQuestionId(), questionObj.getValue());
                    }
                	formBean.setQuestionOption(questionObj.getQuestionId(), questionObj.getValue());*/
                	//questionObj.setOptions(optionsMap.get(questionObj.getQuestionId()));
                	questionsMap.put(questionObj.getQuestionId(), questionObj);
//                	List<Option> options=new ArrayList<Option>();
//                	Option op1 = new Option();
//                	op1.setDescription("Si");
//                	options.add(op1);
//                	Option op2 = new Option();
//                	op2.setDescription("No");
//                	options.add(op2);
//					questionObj.setOptions(options);
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
    		if("164".equals(resObj.getTemplate()) && (formObj.getFormData().getName().equals("Variables") || formObj.getFormData().getParentName().equals("Variables"))){

    			//Prescripció de tractament
    			if(caseBean.getContact()!=null && caseBean.getContact().getPhones()!=null){
    				for(int i=0;i<caseBean.getContact().getPhones().size();i++){
        				Phone phoneObj =caseBean.getContact().getPhones().get(i);
        				if("home".equals(phoneObj.getType())){
        					formBean.setTelefon1(phoneObj.getNumber());
        				}else if("work".equals(phoneObj.getType())){
        					formBean.setTelefon2(phoneObj.getNumber());
        				}else if("ext".equals(phoneObj.getType())){
        					formBean.setTelefon3(phoneObj.getNumber());
        				}
        			}
    			}
    			formBean.setNhc(caseBean.getNhc());
    			
    			String descDiagnostic       = getValueDescription(idForm2+"_8",questionsMap);
    			String descDiagnosticAltres = getValueDescription(idForm2+"_9",questionsMap);
    			if(descDiagnosticAltres!=null && !"".equals(descDiagnosticAltres)){
    				descDiagnostic += " - "+descDiagnosticAltres;
    			}
    			formBean.setDescDiagnostic(descDiagnostic);
    			
    			String dataSolicitud = getValueDescription(idForm1+"_5",questionsMap);
    			if(dataSolicitud!=null && !"".equals(dataSolicitud)){
    				formBean.setDataSolicitud(UtilsString.dateToString(UtilsString.stringtoDate(dataSolicitud, Constants.FORMAT_DATE_WS), Constants.FORMAT_DATE_WEB));
    			}
    			formBean.setDuracio(getValueDescription(idForm4+"_39",questionsMap));

    			String descSolicitant       = getValueDescription(idForm6+"_44",questionsMap);
    			String descSolicitantAltres = getValueDescription(idForm6+"_45",questionsMap);
    			if(descSolicitantAltres!=null && !"".equals(descSolicitantAltres)){
    				descSolicitant += " - "+descSolicitantAltres;
    			}
    			formBean.setDescMetgesSolicitant(descSolicitant);
    			

    			//Variables del tractament
    			String valueSistAdm = getValue(idForm4+"_30",questionsMap);
    			if("1".equals(valueSistAdm)){
    				formBean.setDescCanulaNasals("Si");
    			}else if(valueSistAdm!=null && !"".equals(valueSistAdm)){
    				formBean.setDescCanulaNasals("No");
    			}
    			formBean.setFluxRepos(getValueDescription(idForm4+"_34",questionsMap));
    			formBean.setHoresDia(getValueDescription(idForm4+"_33",questionsMap));
    			formBean.setObservacions(getValueDescription(idForm5+"_43",questionsMap));
    			
        	}else if("164".equals(resObj.getTemplate()) && (formObj.getFormData().getName().equals("CVSO") || formObj.getFormData().getParentName().equals("CVSO"))){

        		List<TabBean> tabs = new ArrayList<TabBean>();
        		
        		TabBean tab;
            	List<RowBean> rows;
            	
        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Identificació");
            	UtilsTabs.addBigField(idForm1+"_1",questionsMap,rows);
            	UtilsTabs.addBigField(idForm1+"_2",questionsMap,rows);
            	UtilsTabs.addBigField(idForm1+"_3",questionsMap,rows);
            	UtilsTabs.addBigField(idForm1+"_4",questionsMap,rows);
            	UtilsTabs.addBigField(idForm1+"_5",questionsMap,rows);
            	UtilsTabs.addSmallField(idForm1+"_6",idForm1+"_7",questionsMap,rows);
            	UtilsTabs.addBigField(idForm1+"_8",questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);
        		
        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Adequació i Adherencia");
            	UtilsTabs.addBigField(idForm2+"_9",questionsMap,rows);
            	UtilsTabs.addBigField(idForm2+"_10",questionsMap,rows);
            	UtilsTabs.addBigField(idForm2+"_11",questionsMap,rows);
            	UtilsTabs.addBigField(idForm2+"_12",questionsMap,rows);
            	UtilsTabs.addBigField(idForm2+"_13",questionsMap,rows);
            	UtilsTabs.addBigField(idForm2+"_14",questionsMap,rows);
            	UtilsTabs.addBigField(idForm2+"_15",questionsMap,rows);
            	UtilsTabs.addBigField(idForm2+"_17",questionsMap,rows);
            	UtilsTabs.addBigField(idForm2+"_18",questionsMap,rows);
            	UtilsTabs.addBigField(idForm2+"_19",questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);

        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Proves complementàries");
            	UtilsTabs.addBigField(idForm3+"_20",questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);

        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Test de la marxa");
            	UtilsTabs.addBigField(idForm3+"_21",questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_22",null,questionsMap,rows);
            	UtilsTabs.addBigField(idForm3+"_23",questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_24",idForm3+"_25",questionsMap,rows);
            	UtilsTabs.addBigField(idForm3+"_26",questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_27",null,questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_28",idForm3+"_29",questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);

        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Pulsioximetria nocturna");
            	UtilsTabs.addBigField(idForm3+"_30",questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_31",null,questionsMap,rows);
            	UtilsTabs.addBigField(idForm3+"_32",questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_33",null,questionsMap,rows);
            	UtilsTabs.addBigField(idForm3+"_34",questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_35",null,questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_36",idForm3+"_37",questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_38",null,questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_39",null,questionsMap,rows);
            	UtilsTabs.addSmallField(idForm3+"_42",null,questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);

        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Habit tabàquic");
            	UtilsTabs.addBigField(idForm4+"_62",questionsMap,rows);
            	UtilsTabs.addSmallField(null,idForm4+"_64",questionsMap,rows);
            	UtilsTabs.addSmallField(idForm4+"_65",idForm4+"_66",questionsMap,rows);
            	UtilsTabs.addBigField(idForm4+"_69",questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);

        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Estratificació");
            	UtilsTabs.addBigField(idForm5+"_43",questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);

        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Atenció Primària / RAE");
            	UtilsTabs.addBigField(idForm5+"_44",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_45",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_46",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_47",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_48",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_49",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_50",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_51",questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);

        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Pneumologia");
            	UtilsTabs.addBigField(idForm5+"_52",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_53",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_54",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_55",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_56",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_57",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_58",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_59",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_60",questionsMap,rows);
            	UtilsTabs.addBigField(idForm5+"_61",questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);
            	
        		tab = new TabBean();
        		rows = new ArrayList<RowBean>();
            	tab.setTitle("Seguiment OCD");
            	UtilsTabs.addBigField(idForm6+"_67",questionsMap,rows);
            	UtilsTabs.addBigField(idForm6+"_68",questionsMap,rows);
        		tab.setRows(rows);
        		tabs.add(tab);
            	
            	request.setAttribute("tabs", tabs);
        	}else if("157".equals(resObj.getTemplate())){
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
    public String getValueDescription(String idQuestion, HashMap<String, Question> questionsMap) {
		
		if(questionsMap.get(idQuestion)!=null){
    		Question questionObj = questionsMap.get(idQuestion);
    		if("VERTICAL_RADIO".equals(questionObj.getType()) ||
    				"HORIZONTAL_RADIO".equals(questionObj.getType())){
        		for(int j=0;j<questionObj.getOptions().size();j++){
    				Option optionObj = questionObj.getOptions().get(j);
    				if(optionObj.getDescription()!=null && 
    						questionObj.getValue()!=null &&
    						optionObj.getValue().equals(questionObj.getValue())){
    					return optionObj.getDescription();
    				}
        		}
    		}else{
    			return questionObj.getValue();
    		}
    	}
		return "";
	}
    public String getValue(String idQuestion, HashMap<String, Question> questionsMap) {
		
		if(questionsMap.get(idQuestion)!=null){
    		Question questionObj = questionsMap.get(idQuestion);
    		return questionObj.getValue();
    	}
		return "";
	}
	private String replaceIDs(String inputString, String[] idsArray) {
		if(inputString==null){
			return inputString;
		}else{
			inputString = inputString.replaceAll("ID2", idsArray[0]);
			inputString = inputString.replaceAll("ID3", idsArray[1]);
			inputString = inputString.replaceAll("ID4", idsArray[2]);
			inputString = inputString.replaceAll("ID5", idsArray[3]);
			inputString = inputString.replaceAll("ID6", idsArray[4]);
			inputString = inputString.replaceAll("ID7", idsArray[5]);
			inputString = inputString.replaceAll("/", "_");
			return inputString;
		}
	}
    /*
    public void homePage() throws Exception {
        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage("https://salut.gencat.net/pls/gsa/gsapk030.inici_portal");
        final HtmlTextInput inputUser = (HtmlTextInput) page.getByXPath("//input[@name='v_nom_usu']").get(0);
        final HtmlPasswordInput inputPwd = (HtmlPasswordInput) page.getByXPath("//input[@name='v_clau']").get(0);
        final HtmlImage image = (HtmlImage) page.getByXPath("//img[@src='https://salut.gencat.net/apps/portal/graf/ico_ok.gif']").get(0);
        final HtmlAnchor anchor = (HtmlAnchor) image.getParentNode();
        
        inputUser.setValueAttribute("josep.abreu");
        inputPwd.setValueAttribute("clinic");
        
        // Now submit the form by clicking the button and get back the second page.
        final HtmlPage page2 = anchor.click();
        //page2.getWebResponse().getContentAsString()
        
        webClient.closeAllWindows();
    }*/
}
