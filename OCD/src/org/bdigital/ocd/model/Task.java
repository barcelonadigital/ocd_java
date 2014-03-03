package org.bdigital.ocd.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Task {

	String taskClass;
	String id;
	String type;
	String date;
	String hour;
	String description;
	String status;
	String admission;
	Case taskCase;
	String[] refs;
    List<Form> forms = new ArrayList<Form>();

	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaskClass() {
		return taskClass;
	}
	@XmlElement(name = "class")
	public void setTaskClass(String taskClass) {
		this.taskClass = taskClass;
	}
	public String getId() {
		return id;
	}
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	@XmlElement
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	@XmlElement
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdmission() {
		return admission;
	}
	@XmlElement
	public void setAdmission(String admission) {
		this.admission = admission;
	}
	public Case getTaskCase() {
		return taskCase;
	}
	@XmlElement(name = "case")
	public void setTaskCase(Case taskCase) {
		this.taskCase = taskCase;
	}
	public String[] getRefs() {
		return refs;
	}
    @XmlElement(name="activity")
	@XmlElementWrapper
	public void setRefs(String[] refs) {
		this.refs = refs;
	}
	public List<Form> getForms() {
		return forms;
	}
	@XmlElement(name = "form")
	@XmlElementWrapper
	public void setForms(List<Form> forms) {
		this.forms = forms;
	}
 

}
