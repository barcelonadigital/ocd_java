package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.MessageResources;
import org.bdigital.ocd.model.Task;
import org.bdigital.ocd.utils.UtilsString;

 
public class TaskAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String taskClass;
	String id;
	String type;
	String date;
	String hour;
	String description;
	String status;
	String descStatus;
	String dateMonth;
	String dateYear;
	String dateDay;
	String descriptionLong;
	AdmissionAf admission;
	CaseAf taskCase;
	List<FormAf> forms = new ArrayList<FormAf>();
	
	public TaskAf(Task obj) throws IllegalAccessException, InvocationTargetException, ParseException {
		super();
		this.taskClass=obj.getTaskClass();
		this.id=obj.getId();
		this.type=obj.getType();
		this.date=UtilsString.stringDateWStoStringDateWeb(obj.getDate());
		this.hour=obj.getHour();
		this.description=obj.getDescription();
		this.status=obj.getStatus();
		MessageResources messages = MessageResources.getMessageResources("ApplicationResource");
	    if("DONE".equals(this.status)){
	    	this.descStatus=messages.getMessage("task.status.done");
	    }else if("UNASSIGNED".equals(this.status)){
	    	this.descStatus=messages.getMessage("task.status.unassigned");
	    }else if("PENDING".equals(this.status)){
	    	this.descStatus=messages.getMessage("task.status.pending");
	    }else{
	    	this.descStatus=this.status;
	    }
		if(obj.getAdmission()!=null){
			this.admission = new AdmissionAf(obj.getAdmission());
		}
		if(obj.getTaskCase()!=null){
			this.taskCase = new CaseAf(obj.getTaskCase());
		}
	}
	public String getTaskClass() {
		return taskClass;
	}
	public void setTaskClass(String taskClass) {
		this.taskClass = taskClass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AdmissionAf getAdmission() {
		return admission;
	}
	public void setAdmission(AdmissionAf admission) {
		this.admission = admission;
	}
	public CaseAf getTaskCase() {
		return taskCase;
	}
	public void setTaskCase(CaseAf taskCase) {
		this.taskCase = taskCase;
	}
	public List<FormAf> getForms() {
		return forms;
	}
	public void setForms(List<FormAf> forms) {
		this.forms = forms;
	}
	public String getDescStatus() {
		return descStatus;
	}
	public void setDescStatus(String descStatus) {
		this.descStatus = descStatus;
	}
	public String getDateMonth() {
		return dateMonth;
	}
	public void setDateMonth(String dateMonth) {
		this.dateMonth = dateMonth;
	}
	public String getDateYear() {
		return dateYear;
	}
	public void setDateYear(String dateYear) {
		this.dateYear = dateYear;
	}
	public String getDateDay() {
		return dateDay;
	}
	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}
	public String getDescriptionLong() {
		return descriptionLong;
	}
	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}
}
