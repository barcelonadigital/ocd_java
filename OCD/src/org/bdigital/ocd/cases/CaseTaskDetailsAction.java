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
    	CaseTaskDetailsForm formBean = (CaseTaskDetailsForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	//String taskId=(String)request.getAttribute("parameterIdTask")!=null?(String)request.getAttribute("parameterIdTask"):formBean.getIdTask();
    	String admissionId=formBean.getIdAdmission();
    	
    	if(admissionId!=null){
    	//if(taskId!=null){
    		Date admissionDate = null;
        	Calendar admissionCal = new GregorianCalendar();
        	Calendar todayCal = new GregorianCalendar();
        	
        	if(caseBean.getDataInscripcioAdmissio()!=null
        			&& !"".equals(caseBean.getDataInscripcioAdmissio())){
        		admissionDate = UtilsString.stringtoDate(caseBean.getDataInscripcioAdmissio(),UtilsWs.FORMAT_DATEHOUR_WS);
    			admissionCal = new GregorianCalendar();
    			admissionCal.setTime(admissionDate);
        	}
        	
        	StringHolder errorMsg,result;
        	List<Task> tasks = new ArrayList<Task>();
        	List<Task> proTasks = new ArrayList<Task>();
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
                    			if("PRO_TASK".equals(t.getTaskClass())){
                    				proTasks.add(t);
                    			}
                    			tasks.add(t);
                        	}
                    	}
                	}
            	}
        	}

        	if(proTasks.size()!=1){
            	request.setAttribute("tasks", tasks);
            	return mapping.findForward("admission");
        	}

    		Task t = proTasks.get(0);
    		String taskId = t.getId();
    		errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.task_form_list(tokenLK, taskId, result, errorMsg);
        	Forms formsObj = (Forms)UtilsWs.xmlToObject(result.value,
        			Forms.class, Form.class);
        	formBean.setForms(formsObj.getForms());
        	return mapping.findForward(SUCCESS);
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
