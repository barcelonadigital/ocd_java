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
import org.bdigital.ocd.beans.BoxBean;
import org.bdigital.ocd.beans.ColumnBean;
import org.bdigital.ocd.beans.GroupBean;
import org.bdigital.ocd.beans.RowBean;
import org.bdigital.ocd.beans.TabBean;
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.FormData;
import org.bdigital.ocd.model.Option;
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
public class CaseFormBoxesDetailsAction extends CaseBaseAction {

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
    	CaseFormBoxesDetailsForm formBean = (CaseFormBoxesDetailsForm)form;
    	
    	menuBean.setIsActiveMenuFormularis("true");
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String formId=formBean.getIdForm();
    	//String[] gasometriaIds = new String[]{"10","11","12","40","13","14","15"};
//    	List<String> gasometriaIdList = Arrays.asList(gasometriaIds);
//    	boolean isThereGasometria=false;
    	HashMap<String,Question> questionsMap = new HashMap<String,Question>();
    	//HashMap<String,List<Option>> optionsMap = new HashMap<String,List<Option>>();
    	HashMap<String,String> valuesMap = new HashMap<String,String>();
    	
    	if(formId!=null){

            @SuppressWarnings("unchecked")
			HashMap<String,String> questionErrorMap = (HashMap<String,String>)request.getAttribute("questionErrors");
			
    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.form_get(tokenLK, formId, result, errorMsg);
        	
        	Result resObj = (Result)UtilsWs.xmlToObject(result.value,
        			Result.class);
        	formBean.setName(resObj.getShortName());
        	
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
        		formBean.setQuestions(formObj.getFormData().getQuestions());
        		formBean.setStatus(formObj.getFormData().getStatus());
        		formBean.setName(formObj.getFormData().getName());
        		formBean.setDescription(formObj.getFormData().getDescription());
        		for(int i=0;i<formObj.getFormData().getQuestions().size();i++){
        			Question questionObj = formObj.getFormData().getQuestions().get(i);
        			formBean.setQuestionType(questionObj.getQuestionId(), questionObj.getType());
                	formBean.setQuestionId(questionObj.getQuestionId(), questionObj.getQuestionId());
                	if(questionObj.getValue()!=null && !"".equals(questionObj.getValue()) && "DATE".equals(questionObj.getType())){
                		questionObj.setValue(UtilsString.dateToString(UtilsString.stringtoDate(questionObj.getValue(), Constants.FORMAT_DATE_WS), Constants.FORMAT_DATE_WEB));
                	}
                	if(questionObj.getValue()!=null && !"".equals(questionObj.getValue()) && "NUMERICAL".equals(questionObj.getType())){
                		questionObj.setValue(questionObj.getValue().replaceAll(",", "" ).replaceAll("[.]+", "," ));
            		}
                    if(questionErrorMap!=null && questionErrorMap.get(questionObj.getQuestionId())!=null){
                    	//TODO:enlloc d'esborrar el valor caldria mantenir el valor no valid que ha provocat l'error
                    	formBean.setQuestionValue(questionObj.getQuestionId(), "");
                    	formBean.setQuestionTextValue(questionObj.getQuestionId(), "");
                    }else{
                    	formBean.setQuestionValue(questionObj.getQuestionId(), questionObj.getValue());
                        if(("VERTICAL_RADIO".equals(questionObj.getType()) || "HORIZONTAL_RADIO".equals(questionObj.getType())) &&
                        		questionObj.getValue()!=null && !"".equals(questionObj.getValue())){
                        	for(int j=0;j<questionObj.getOptions().size();j++){
                				Option optionObj = questionObj.getOptions().get(j);
                				if(optionObj.getOptionId()!=null && 
                						questionObj.getValue()!=null &&
                						optionObj.getOptionId().equals(questionObj.getValue())){
                					formBean.setQuestionTextValue(questionObj.getQuestionId(), optionObj.getDescription());
                				}
                			}
                        }else{
                        	formBean.setQuestionTextValue(questionObj.getQuestionId(), questionObj.getValue());
                        }
                    }
                	formBean.setQuestionOption(questionObj.getQuestionId(), questionObj.getValue());
                	formBean.setQuestionModified(questionObj.getQuestionId(), "");
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
    		if("164".equals(resObj.getTemplate()) && (formObj.getFormData().getName().equals("Variables") || formObj.getFormData().getParentName().equals("Variables"))){
    			
        		BoxBean box;
        		GroupBean group;
        		ColumnBean column;
        		List<ColumnBean> columns;
            	
        		columns = new ArrayList<ColumnBean>();
        		
        		//column 1
        		column = new ColumnBean();

        		box = new BoxBean();
            	box.setTitle("Diagn�stic");

        		group = new GroupBean();
        		group.setUntitled("true");
            	UtilsTabs.addSmallFieldToGroup(idForm2+"_8",idForm2+"_9",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm1+"_5",idForm1+"_6",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm1+"_7",null,questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm4+"_24",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm6+"_44",idForm6+"_45",questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);
        		columns.add(column);
        		
        		//column 2
        		column = new ColumnBean();

        		box = new BoxBean();
            	box.setTitle("Proves complement�ries");
        		
        		//espiro
        		group = new GroupBean();
        		group.setTitle("Espirometria");
        		group.setId("ESPIROMETRIA_ID");
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_10",idForm3+"_11",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_12",idForm3+"_13",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_14",null,questionsMap,group,questionErrorMap);
            	box.addGroup(group);

        		//gaso
        		group = new GroupBean();
        		group.setTitle("Gasometria");
        		group.setId("GASOMETRIA_ID");
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_15",idForm3+"_16",questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm3+"_18",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_19",idForm3+"_20",questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm3+"_21",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_22",null,questionsMap,group,questionErrorMap);
            	box.addGroup(group);

        		//pulsio
        		group = new GroupBean();
        		group.setTitle("Pulsioximetria");
        		group.setId("PULSIOXIMETRIA_ID");
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_23",null,questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);
        		
        		columns.add(column);
        		
        		//column 3
        		column = new ColumnBean();
            	
        		box = new BoxBean();
            	box.setTitle("Equip ter�pia respirat�ria");
        		group = new GroupBean();
        		group.setUntitled("true");
            	UtilsTabs.addBigFieldToGroup(idForm4+"_25",questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm4+"_26",questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm4+"_27",questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm4+"_28",questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm4+"_29",questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm4+"_30",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm4+"_31",idForm4+"_32",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm4+"_34",idForm4+"_35",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm4+"_36",null,questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm4+"_33",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm4+"_37",idForm4+"_38",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm5+"_41",idForm5+"_42",questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm5+"_43",questionsMap,group,questionErrorMap);
            	
            	box.addGroup(group);
        		column.getBoxes().add(box);
            	
        		box = new BoxBean();
            	box.setTitle("Propera visita");
        		group = new GroupBean();
        		group.setUntitled("true");
            	UtilsTabs.addBigFieldToGroup(idForm4+"_39",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm4+"_40",null,questionsMap,group,questionErrorMap);
            	box.addGroup(group);
        		column.getBoxes().add(box);
            	
        		columns.add(column);
            	
            	request.setAttribute("columns", columns);

        	}else if("164".equals(resObj.getTemplate()) && (formObj.getFormData().getName().equals("CVSO") || formObj.getFormData().getParentName().equals("CVSO"))){

        		BoxBean box;
        		GroupBean group;
        		ColumnBean column;
        		List<ColumnBean> columns;
            	
        		columns = new ArrayList<ColumnBean>();
        		
        		//column 1
        		column = new ColumnBean();

        		box = new BoxBean();
            	box.setTitle("Identificaci�");

        		group = new GroupBean();
        		group.setUntitled("true");
        		UtilsTabs.addBigFieldToGroup(idForm1+"_1",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm1+"_2",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm1+"_3",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm1+"_4",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm1+"_5",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm1+"_6",idForm1+"_7",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm1+"_8",questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);

        		box = new BoxBean();
            	box.setTitle("Adequaci� i Adherencia");

        		group = new GroupBean();
        		group.setUntitled("true");
        		UtilsTabs.addBigFieldToGroup(idForm2+"_9",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm2+"_10",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm2+"_11",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm2+"_12",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm2+"_13",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm2+"_14",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm2+"_15",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm2+"_17",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm2+"_18",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm2+"_19",questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);

        		box = new BoxBean();
            	box.setTitle("Habit tab�quic");

        		group = new GroupBean();
        		group.setUntitled("true");
        		UtilsTabs.addBigFieldToGroup(idForm4+"_62",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(null,idForm4+"_64",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm4+"_65",idForm4+"_66",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm4+"_69",questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);

        		box = new BoxBean();
            	box.setTitle("Seguiment OCD");

        		group = new GroupBean();
        		group.setUntitled("true");
        		UtilsTabs.addBigFieldToGroup(idForm6+"_67",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm6+"_68",questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);
        		
        		columns.add(column);
        		
        		//column 2
        		column = new ColumnBean();

        		box = new BoxBean();
            	box.setTitle("Proves complement�ries");
        		
        		group = new GroupBean();
        		group.setUntitled("true");
            	UtilsTabs.addBigFieldToGroup(idForm3+"_20",questionsMap,group,questionErrorMap);
            	box.addGroup(group);

        		group = new GroupBean();
        		group.setTitle("Test de la marxa");
            	UtilsTabs.addBigFieldToGroup(idForm3+"_21",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_22",null,questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm3+"_23",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_24",idForm3+"_25",questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm3+"_26",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_27",null,questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_28",idForm3+"_29",questionsMap,group,questionErrorMap);
            	box.addGroup(group);

        		group = new GroupBean();
        		group.setTitle("Pulsioximetria nocturna");
            	UtilsTabs.addBigFieldToGroup(idForm3+"_30",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_31",null,questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm3+"_32",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_33",null,questionsMap,group,questionErrorMap);
            	UtilsTabs.addBigFieldToGroup(idForm3+"_34",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_35",null,questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_36",idForm3+"_37",questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_38",null,questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_39",null,questionsMap,group,questionErrorMap);
            	UtilsTabs.addSmallFieldToGroup(idForm3+"_42",null,questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);
        		
        		columns.add(column);
        		
        		//column 3
        		column = new ColumnBean();

        		box = new BoxBean();
            	box.setTitle("Estratificaci�");

        		group = new GroupBean();
        		group.setUntitled("true");
        		UtilsTabs.addBigFieldToGroup(idForm5+"_43",questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);

        		box = new BoxBean();
            	box.setTitle("Atenci� Prim�ria / RAE");

        		group = new GroupBean();
        		group.setUntitled("true");
        		UtilsTabs.addBigFieldToGroup(idForm5+"_44",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_45",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_46",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_47",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_48",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_49",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_50",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_51",questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);

        		box = new BoxBean();
            	box.setTitle("Pneumologia");

        		group = new GroupBean();
        		group.setUntitled("true");
        		UtilsTabs.addBigFieldToGroup(idForm5+"_52",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_53",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_54",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_55",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_56",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_57",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_58",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_59",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_60",questionsMap,group,questionErrorMap);
        		UtilsTabs.addBigFieldToGroup(idForm5+"_61",questionsMap,group,questionErrorMap);
            	box.addGroup(group);
            	
        		column.getBoxes().add(box);
        		
        		columns.add(column);
        		
            	request.setAttribute("columns", columns);
        		
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
}
