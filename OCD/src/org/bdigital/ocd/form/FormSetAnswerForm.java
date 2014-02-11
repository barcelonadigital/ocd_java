/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.form;






/**
 *
 * @author jroda
 */
public class FormSetAnswerForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String idForm;
	private String type;
	private String option;
	private String idQuestion;
	private String value;
	private String requestCounter;
	public String getIdForm() {
		return idForm;
	}
	public void setIdForm(String idForm) {
		this.idForm = idForm;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(String idQuestion) {
		this.idQuestion = idQuestion;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRequestCounter() {
		return requestCounter;
	}
	public void setRequestCounter(String requestCounter) {
		this.requestCounter = requestCounter;
	}

}
