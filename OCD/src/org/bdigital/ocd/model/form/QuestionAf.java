package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.Question;

 
public class QuestionAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String questionId;
	String description;
	String numDec;
	String type;
	String mandatory;
	String exclusive;
	String tabulation;
	String value;
	FormAf form;
	String condition;
	String recommendation;
	
	public QuestionAf(Question obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNumDec() {
		return numDec;
	}
	public void setNumDec(String numDec) {
		this.numDec = numDec;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMandatory() {
		return mandatory;
	}
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	public String getExclusive() {
		return exclusive;
	}
	public void setExclusive(String exclusive) {
		this.exclusive = exclusive;
	}
	public String getTabulation() {
		return tabulation;
	}
	public void setTabulation(String tabulation) {
		this.tabulation = tabulation;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public FormAf getForm() {
		return form;
	}
	public void setForm(FormAf form) {
		this.form = form;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
}
