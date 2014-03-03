package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.bdigital.ocd.model.FormData;

public class FormDataAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	String name;
	String description;
    String status;
    FormAf next;
    FormAf prev;
    String parentType;
    String parentId;
    String parentStatus;
    String parentName;
    List<QuestionAf> questions = new ArrayList<QuestionAf>();
	
	public FormDataAf(FormData obj) throws IllegalAccessException, InvocationTargetException {
		super();
		this.name=obj.getName();
		this.description=obj.getDescription();
	    this.status=obj.getStatus();
	    this.parentType=obj.getParentType();
	    this.parentId=obj.getParentId();
	    this.parentStatus=obj.getParentStatus();
	    this.parentName=obj.getParentName();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public FormAf getNext() {
		return next;
	}
	public void setNext(FormAf next) {
		this.next = next;
	}
	public FormAf getPrev() {
		return prev;
	}
	public void setPrev(FormAf prev) {
		this.prev = prev;
	}
	public String getParentType() {
		return parentType;
	}
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentStatus() {
		return parentStatus;
	}
	public void setParentStatus(String parentStatus) {
		this.parentStatus = parentStatus;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public List<QuestionAf> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionAf> questions) {
		this.questions = questions;
	}
}
