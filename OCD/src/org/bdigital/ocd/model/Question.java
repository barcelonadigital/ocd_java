package org.bdigital.ocd.model;

import java.util.ArrayList;
import java.util.List;

import org.bdigital.ocd.model.Option;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Question {

	String questionId;
	String description;
	String numDec;
	String type;
	String mandatory;
	String exclusive;
	String tabulation;
	String value;
	Form form;
	String condition;
	String recommendation;
	List<Option> options = new ArrayList<Option>();
    public String getQuestionId() {
		return questionId;
	}
	@XmlElement(name="question_id")
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNumDec() {
		return numDec;
	}
	@XmlElement(name="num_dec")
	public void setNumDec(String numDec) {
		this.numDec = numDec;
	}
	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	public String getMandatory() {
		return mandatory;
	}
	@XmlElement
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	public String getExclusive() {
		return exclusive;
	}
	@XmlElement
	public void setExclusive(String exclusive) {
		this.exclusive = exclusive;
	}
	public String getTabulation() {
		return tabulation;
	}
	@XmlElement
	public void setTabulation(String tabulation) {
		this.tabulation = tabulation;
	}
	public String getValue() {
		return value;
	}
	@XmlElement
	public void setValue(String value) {
		this.value = value;
	}
	public Form getForm() {
		return form;
	}
	@XmlElement
	public void setForm(Form form) {
		this.form = form;
	}
	public List<Option> getOptions() {
		return options;
	}
	@XmlElement(name = "option")
	@XmlElementWrapper
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public String getCondition() {
		return condition;
	}
	@XmlElement
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getRecommendation() {
		return recommendation;
	}
	@XmlElement
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

}
