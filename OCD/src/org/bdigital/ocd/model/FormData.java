package org.bdigital.ocd.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="data")
public class FormData {
 
	String name;
	String description;
    String status;
    Form next;
    Form prev;
    String parentType;
    String parentId;
    String parentStatus;
    String parentName;
    List<Question> questions = new ArrayList<Question>();
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}
	public Form getNext() {
		return next;
	}
	@XmlElement
	public void setNext(Form next) {
		this.next = next;
	}
	public Form getPrev() {
		return prev;
	}
	@XmlElement
	public void setPrev(Form prev) {
		this.prev = prev;
	}
	public String getParentType() {
		return parentType;
	}
	@XmlElement(name = "parent_type")
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	public String getParentId() {
		return parentId;
	}
	@XmlElement(name = "parent_id")
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentStatus() {
		return parentStatus;
	}
	@XmlElement(name = "parent_status")
	public void setParentStatus(String parentStatus) {
		this.parentStatus = parentStatus;
	}
	public String getParentName() {
		return parentName;
	}
	@XmlElement(name = "parent_name")
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	@XmlElement(name = "question")
	@XmlElementWrapper
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
