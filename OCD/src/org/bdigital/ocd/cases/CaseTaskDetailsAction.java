/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.Forms;
import org.bdigital.ocd.model.Task;
import org.bdigital.ocd.model.Tasks;
import org.bdigital.ocd.model.form.FormAf;
import org.bdigital.ocd.model.form.TaskAf;
import org.bdigital.ocd.utils.Constants;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseTaskDetailsAction extends CaseBaseAction {

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
    	//CaseTaskDetailsForm formBean = (CaseTaskDetailsForm)form;
    	
    	menuBean.setIsActiveMenuFormularis("true");
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	//String taskId=(String)request.getAttribute("parameterIdTask")!=null?(String)request.getAttribute("parameterIdTask"):formBean.getIdTask();
    	String admissionId=admissionBean.getIdAdmission();
    	
    	if(admissionId!=null){
    	//if(taskId!=null){
    		Date admissionDate = null;
        	Calendar admissionCal = new GregorianCalendar();
        	Calendar todayCal = new GregorianCalendar();
        	
        	if(admissionBean.getDataInscripcioAdmissio()!=null
        			&& !"".equals(admissionBean.getDataInscripcioAdmissio())){
        		admissionDate = UtilsString.stringtoDate(admissionBean.getDataInscripcioAdmissio(),Constants.FORMAT_DATEHOUR_WS);
    			admissionCal = new GregorianCalendar();
    			admissionCal.setTime(admissionDate);
        	}
        	
        	StringHolder errorMsg,result;
        	List<TaskAf> tasks = new ArrayList<TaskAf>();
        	//List<Task> proTasks = new ArrayList<Task>();
        	for(int j=admissionCal.get(Calendar.YEAR);j<=todayCal.get(Calendar.YEAR)+1;j++){

            	errorMsg = new StringHolder("");
            	result = new StringHolder("");
        		proxy.task_calendar_year(tokenLK, ""+j, "ADMI", admissionId, result, errorMsg);
        		if(result.value!=null){
                	String[] datesArray = result.value.split("#");
                	for(int k=0;k<datesArray.length;k++){
                		String dateItem = datesArray[k];
                		String[] infoDateArray = dateItem.split("\\|");
                    	errorMsg = new StringHolder("");
                    	result = new StringHolder("");
                		proxy.task_list_date(tokenLK, infoDateArray[0], "ADMI", admissionId, result, errorMsg);
                		Tasks tasksObj = (Tasks)UtilsWs.xmlToObject(result.value,
                    			Tasks.class, Task.class);
                    	if(tasksObj.getTasks()!=null){
                    		for(int i=0;i<tasksObj.getTasks().size();i++){
                    			Task t = tasksObj.getTasks().get(i);
                    			TaskAf tAf = new TaskAf(t);
//                    			if("PRO_TASK".equals(t.getTaskClass())){
//                    				proTasks.add(t);
//                    			}
                    			errorMsg = new StringHolder("");
                            	result = new StringHolder("");
                            	proxy.task_get(tokenLK, t.getId(), "ADMI", result, errorMsg);
                            	Task taskObj = (Task)UtilsWs.xmlToObject(result.value,
                            			Task.class,Form.class);
                            	if(taskObj.getForms()!=null &&
                            			taskObj.getForms().size()>0){
                        			errorMsg = new StringHolder("");
                                	result = new StringHolder("");
                                	proxy.task_form_list(tokenLK, t.getId(), result, errorMsg);
                                	Forms formsObj = (Forms)UtilsWs.xmlToObject(result.value,
                                			Forms.class, Form.class);
                                	List<FormAf> forms = new ArrayList<FormAf>();
                                	if(formsObj.getForms()!=null){
                                		String statusFirstItem = "";
                                		String refFirstItem = "";
                                		for(int l=0;l<formsObj.getForms().size();l++){
                                			Form f = formsObj.getForms().get(l);
                                			FormAf fAf = new FormAf(f);
                                			if("242".equals(taskObj.getRefs()[0]) &&
                                					l==1){
                                				fAf.setShortName("Dades clíniques");
                                			}else if("242".equals(taskObj.getRefs()[0]) &&
                                					l==2){
                                				fAf.setShortName("Prescripció inicial d'OCD");
                                			}
                                			if(!"242".equals(taskObj.getRefs()[0]) ||
                                					l!=0){
                                				forms.add(fAf);
                                			}else{
                                				statusFirstItem = fAf.getStatus();
                                				refFirstItem = fAf.getRef();
                                			}
                                		}
                                		if("242".equals(taskObj.getRefs()[0])){
                                			FormAf fAf = new FormAf(new Form());
                                    		fAf.setItemType("DOCUMENT");
                                    		fAf.setShortName("Enviament de document al històric clínic");
                                			forms.add(fAf);
                                			fAf = new FormAf(new Form());
                                			fAf.setItemType("CATSALUT");
                                    		fAf.setShortName("Sol·licitud d'OCD a CatSalut");
                                			fAf.setRef(refFirstItem);
                                    		fAf.setStatus(statusFirstItem);
                                			forms.add(fAf);
                                		}
                                	}
                                	tAf.setForms(forms);
		                			tasks.add(tAf);
                            	}
                        	}
                    	}
                	}
            	}
        	}
        	request.setAttribute("tasks", tasks);

//        	if(proTasks.size()!=1){
//            	request.setAttribute("tasks", tasks);
//            	return mapping.findForward("admission");
//        	}
//
//    		Task t = proTasks.get(0);
//    		String taskId = t.getId();
//    		errorMsg = new StringHolder("");
//        	result = new StringHolder("");
//        	proxy.task_form_list(tokenLK, taskId, result, errorMsg);
//        	Forms formsObj = (Forms)UtilsWs.xmlToObject(result.value,
//        			Forms.class, Form.class);
//        	formBean.setForms(formsObj.getForms());
        	return mapping.findForward(SUCCESS);
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
