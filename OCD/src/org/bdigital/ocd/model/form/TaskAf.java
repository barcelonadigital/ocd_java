package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.bdigital.ocd.model.Task;

 
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
	String admission;
	CaseAf taskCase;
	List<FormAf> forms = new ArrayList<FormAf>();
	
	public TaskAf(Task obj) throws IllegalAccessException, InvocationTargetException {
		super();
		this.taskClass=obj.getTaskClass();
		this.id=obj.getId();
		this.type=obj.getType();
		this.date=obj.getDate();
		this.hour=obj.getHour();
		this.description=obj.getDescription();
		this.status=obj.getStatus();
		this.admission=obj.getAdmission();
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
	public String getAdmission() {
		return admission;
	}
	public void setAdmission(String admission) {
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
}
