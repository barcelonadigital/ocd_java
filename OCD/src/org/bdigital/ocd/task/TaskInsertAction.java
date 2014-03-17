/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.task;

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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.Admission;
import org.bdigital.ocd.model.AdmissionData;
import org.bdigital.ocd.model.AdmissionProgram;
import org.bdigital.ocd.model.AdmissionProtocol;
import org.bdigital.ocd.model.Assignment;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.Role;
import org.bdigital.ocd.model.Task;
import org.bdigital.ocd.model.Tasks;
import org.bdigital.ocd.model.User;
import org.bdigital.ocd.utils.Constants;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.utils.UtilsWs;

/**
*
* @author jroda
*/
public class TaskInsertAction extends BaseAction {

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
   	TaskInsertForm formBean = (TaskInsertForm)form;
   	
   	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
   	//String roleId=(String)request.getAttribute("role_id")!=null?(String)request.getAttribute("role_id"):formBean.getIdRole();
   	String activityId=(String)request.getAttribute("activity_id")!=null?(String)request.getAttribute("activity_id"):formBean.getIdActivity();
   	String admissionId=formBean.getIdAdmission();
   	String caseId=formBean.getIdCase();
   	
   	if(admissionId==null || "".equals(admissionId.trim())){
   		if(caseId==null){
   			return mapping.findForward(FAILURE);
   		}
   	    //TODO: enlloc de passar el parametre "6", obtenir la action_list disponible per current_date, i si esta el #ENROL:6 , passar aquest idProgram
   		StringHolder errorMsg = new StringHolder("");
   		StringHolder result = new StringHolder("");
    	String currentTimeString = UtilsString.dateToString(new Date(), Constants.FORMAT_DATE_WS);
    	Date currentTimeZero = UtilsString.stringtoDate(currentTimeString,Constants.FORMAT_DATE_WS);
		proxy.admission_insert(tokenLK, caseId, "#XENROLL:6", UtilsString.dateToString(currentTimeZero, Constants.FORMAT_DATEHOUR_WS), result, errorMsg);
		admissionId=result.value;
		
    	Calendar todayCal = new GregorianCalendar();
		for(int j=todayCal.get(Calendar.YEAR);j<=todayCal.get(Calendar.YEAR)+1;j++){
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
                			Task taskObj = tasksObj.getTasks().get(i);
                			proxy.task_delete(tokenLK, taskObj.getId(), "DELETE", errorMsg);
                		}
                	}
            	}
    		}
		}
   	}
   	if(activityId!=null && !"".equals(activityId.trim()) && 
   			admissionId!=null && !"".equals(admissionId.trim())){
   	   	//TODO:Validar que si JOIN, llavors admission no tingui idProtocol assignat
   	   	//TODO: Aquesta validacio no la podria fer el WS?
   		if(activityId.indexOf("JOIN")!=-1){
	   		StringHolder errorMsg = new StringHolder("");
	       	StringHolder result = new StringHolder("");
	       	proxy.admission_get(tokenLK,admissionId,result,errorMsg);
	       	Admission admissionObj = (Admission)UtilsWs.xmlToObject(result.value,
           			Admission.class, Case.class, 
           			AdmissionData.class, AdmissionProgram.class, AdmissionProtocol.class);
       	    if(admissionObj.getData()!=null && 
       	    		admissionObj.getData().getProtocol()!=null && 
       	    		admissionObj.getData().getProtocol().getId()!=null &&
       	    		!"".equals(admissionObj.getData().getProtocol().getId())){
       	    	ActionMessages errors = new ActionMessages();
                errors.add("general",new ActionMessage("errors.alreadyJoinedToProtocol"));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
       	    }
   		}
   		StringHolder errorMsg = new StringHolder("");
       	StringHolder result = new StringHolder("");
       	String currentTimeString = UtilsString.dateToString(new Date(), Constants.FORMAT_DATE_WS);
       	Date currentTimeZero = UtilsString.stringtoDate(currentTimeString,Constants.FORMAT_DATE_WS);
		proxy.task_insert(tokenLK,admissionId, activityId, UtilsString.dateToString(currentTimeZero, Constants.FORMAT_DATEHOUR_WS), "", result, errorMsg);
		if(activityId.equals("#TASK:N261")){
	       	String idTask = result.value;
	       	//errorMsg = new StringHolder("");
			//result = new StringHolder("");
	       	//proxy.task_role_list(tokenLK, idTask, "", "", result, errorMsg);
	       	errorMsg = new StringHolder("");
	       	result = new StringHolder("");
	       	proxy.task_get(tokenLK, idTask, "ADMI", result, errorMsg);
	       	Task taskObj = (Task)UtilsWs.xmlToObject(result.value,
        			Task.class,Form.class,Role.class,User.class,Assignment.class);
	       	List<Assignment> assignments;
	       	if(taskObj.getAssignments()!=null){
	       		assignments = taskObj.getAssignments();
	       	}else{
	       		assignments = new ArrayList<Assignment>();
	       		taskObj.setAssignments(assignments);
	       	}
	       	Assignment assignment = new Assignment();
	       	Role role = new Role();
	       	role.setId("24");
	       	User user = new User();
	       	user.setId("1");
	       	assignment.setRole(role);
	       	assignment.setUser(user);
	       	assignments.add(assignment);
	       	String taskXmlString = UtilsWs.objectToXml(taskObj,Task.class,Form.class,
	       			Role.class,User.class,Assignment.class);
	       	proxy.task_set(tokenLK, taskXmlString, result, errorMsg);
		}else if(activityId.equals("#XDISCHARGE")){
	       	String idTask = result.value;
			errorMsg = new StringHolder("");
	       	result = new StringHolder("");
	       	proxy.task_get(tokenLK, idTask, "ADMI", result, errorMsg);
	       	Task taskObj = (Task)UtilsWs.xmlToObject(result.value,
        			Task.class,Form.class,Role.class,User.class,Assignment.class);
	       	List<Assignment> assignments = new ArrayList<Assignment>();
       		taskObj.setAssignments(assignments);
	       	String taskXmlString = UtilsWs.objectToXml(taskObj,Task.class,Form.class,
	       			Role.class,User.class,Assignment.class);
	       	errorMsg = new StringHolder("");
	       	result = new StringHolder("");
	       	proxy.task_set(tokenLK, taskXmlString, result, errorMsg);
		}
		request.getSession().setAttribute("admissionBean",null);
		request.setAttribute("admission_id","");
		return mapping.findForward(SUCCESS);
   	}else{
   		return mapping.findForward(FAILURE);
   	}
   }
}
