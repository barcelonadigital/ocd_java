/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.json;

import java.util.ArrayList;
import java.util.List;






/**
 *
 * @author jroda
 */
public class ResponseQuestionsJson extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String formStatus;
	private List<String> questionIds = new ArrayList<String>();
	private List<String> questionDescriptions = new ArrayList<String>();
	private List<String> questionTypes = new ArrayList<String>();
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<String> getQuestionIds() {
		return questionIds;
	}
	public void setQuestionIds(List<String> questionIds) {
		this.questionIds = questionIds;
	}
	public List<String> getQuestionDescriptions() {
		return questionDescriptions;
	}
	public void setQuestionDescriptions(List<String> questionDescriptions) {
		this.questionDescriptions = questionDescriptions;
	}
	public void addToQuestionIds(String q) {
		questionIds.add(q);
	}
	public void addToQuestionDescriptions(String q) {
		questionDescriptions.add(q);
	}
	public void addToQuestionTypes(String q) {
		questionTypes.add(q);
	}
	public List<String> getQuestionTypes() {
		return questionTypes;
	}
	public void setQuestionTypes(List<String> questionTypes) {
		this.questionTypes = questionTypes;
	}
	public String getFormStatus() {
		return formStatus;
	}
	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

}
