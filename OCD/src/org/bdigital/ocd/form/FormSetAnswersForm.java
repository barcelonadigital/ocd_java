/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.form;

import java.util.HashMap;
import java.util.Iterator;





/**
 *
 * @author jroda
 */
public class FormSetAnswersForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String idForm;
	private String finish;

	private HashMap<String,String> questionTypeMap = new HashMap<String,String>();
	private HashMap<String,String> questionOptionMap = new HashMap<String,String>();
	private HashMap<String,String> questionIdMap = new HashMap<String,String>();
	private HashMap<String,String> questionValueMap = new HashMap<String,String>();


	public String getIdForm() {
		return idForm;
	}
	public void setIdForm(String idForm) {
		this.idForm = idForm;
	}
	public int getQuestionSize() {
		return questionTypeMap.size();
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
	public Iterator<String> getQuestionIdIterator() {
		return questionIdMap.values().iterator();
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
}
