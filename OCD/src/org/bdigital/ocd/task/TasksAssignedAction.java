/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.Admission;
import org.bdigital.ocd.model.Task;
import org.bdigital.ocd.model.Tasks;
import org.bdigital.ocd.model.form.TaskAf;
import org.bdigital.ocd.utils.UtilsWs;

/**
*
* @author jroda
*/
public class TasksAssignedAction extends BaseAction {

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
    	//TasksAssignedForm formBean = (TasksAssignedForm)form;

    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");

    	StringHolder errorMsg,result,userId;

    	userId = new StringHolder("");
    	errorMsg = new StringHolder("");
    	proxy.session_get_user(tokenLK, userId, errorMsg);
    	String idUser = userId.value;
    	
    	result = new StringHolder("");
    	errorMsg = new StringHolder("");
    	
	    Calendar todayCal = new GregorianCalendar();
    	List<TaskAf> tasks = new ArrayList<TaskAf>();
    	for(int j=todayCal.get(Calendar.YEAR);j<=todayCal.get(Calendar.YEAR)+1;j++){

        	errorMsg = new StringHolder("");
        	result = new StringHolder("");
    		proxy.task_calendar_year(tokenLK, ""+j, "USR", idUser, result, errorMsg);
    		//proxy.task_calendar_year(tokenLK, "", "ADMI", admissionId, result, errorMsg);
    		if(result.value!=null){
            	String[] datesArray = result.value.split("#");
            	for(int k=0;k<datesArray.length;k++){
            		String dateItem = datesArray[k];
            		String[] infoDateArray = dateItem.split("\\|");
                	errorMsg = new StringHolder("");
                	result = new StringHolder("");
            		proxy.task_list_date(tokenLK, infoDateArray[0], "USR", idUser, result, errorMsg);
            		Tasks tasksObj = (Tasks)UtilsWs.xmlToObject(result.value,
                			Tasks.class, Task.class, Admission.class);
                	if(tasksObj.getTasks()!=null){
                		for(int i=0;i<tasksObj.getTasks().size();i++){
                			Task taskObj = tasksObj.getTasks().get(i);
                			TaskAf tAf = new TaskAf(taskObj);
                			tasks.add(tAf);
                			if("VARIABLES".equals(taskObj.getDescription())){
                    			tAf.setDescription("Prescripció d'OCD");
                    		}else if("CVSO".equals(taskObj.getDescription())){
                    			tAf.setDescription("Visita de seguiment");
                    		}
//                			if(!"1539".equals(tAf.getId())){
//                				errorMsg = new StringHolder("");
//                		       	result = new StringHolder("");
//                		       	proxy.task_get(tokenLK, tAf.getId(), "ADMI", result, errorMsg);
//                		       	taskObj = (Task)UtilsWs.xmlToObject(result.value,
//                	        			Task.class,Form.class,Role.class,User.class,Assignment.class);
//                		       	List<Assignment> assignments;
//                		       	if(taskObj.getAssignments()!=null){
//                		       		assignments = taskObj.getAssignments();
//                		       	}else{
//                		       		assignments = new ArrayList<Assignment>();
//                		       		taskObj.setAssignments(assignments);
//                		       	}
//                		       	for(int l=0;l<assignments.size();l++){
//                		       		Assignment assignment = assignments.get(l);
//                		       		if(assignment.getRole()!=null && assignment.getRole().getId().equals("24") &&
//                		       				assignment.getUser()!=null && assignment.getUser().getId().equals("1") ){
//                		       			assignments.remove(l);
//                		       			l--;
//                		       		}
//                		       	}
//                		       	String taskXmlString = UtilsWs.objectToXml(taskObj,Task.class,Form.class,
//                		       			Role.class,User.class,Assignment.class);
//                		       	errorMsg = new StringHolder("");
//                		       	result = new StringHolder("");
//                		       	proxy.task_set(tokenLK, taskXmlString, result, errorMsg);
//                			}
                		}
                	}
            	}
    		}
    	}
    	request.setAttribute("tasks", tasks);
		
	    return mapping.findForward(SUCCESS);
    }
}
