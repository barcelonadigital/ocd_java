/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.util.HashMap;
import java.util.List;

import org.bdigital.ocd.model.Question;




/**
 *
 * @author jroda
 */
public class CaseFormDetailsForm extends CaseBaseForm {

	private static final long serialVersionUID = 1L;
	private String idForm;
	private String status;
	private String name;
	private String description;
	private List<Question> questions;
	private HashMap<String,String> questionTypeMap = new HashMap<String,String>();
	private HashMap<String,String> questionOptionMap = new HashMap<String,String>();
	private HashMap<String,String> questionIdMap = new HashMap<String,String>();
	private HashMap<String,String> questionValueMap = new HashMap<String,String>();
	private String isThereGasometria;
	public String getIdForm() {
		return idForm;
	}
	public void setIdForm(String idForm) {
		this.idForm = idForm;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQuestionType(String index) {
		return questionTypeMap.get(index);
	}
	public void setQuestionType(String index, String value) {
		this.questionTypeMap.put(index,value);
	}
	public String getQuestionOption(String index) {
		return questionOptionMap.get(index);
	}
	public void setQuestionOption(String index, String value) {
		this.questionOptionMap.put(index,value);
	}
	public String getQuestionId(String index) {
		return questionIdMap.get(index);
	}
	public void setQuestionId(String index, String value) {
		this.questionIdMap.put(index,value);
	}
	public String getQuestionValue(String index) {
		return questionValueMap.get(index);
	}
	public void setQuestionValue(String index, String value) {
		this.questionValueMap.put(index,value);
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
	public String getIsThereGasometria() {
		return isThereGasometria;
	}
	public void setIsThereGasometria(String isThereGasometria) {
		this.isThereGasometria = isThereGasometria;
	}
	
}
