/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.beans;

import org.bdigital.ocd.model.Question;



/**
 *
 * @author jroda
 */
public class FieldBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String fieldType;
	private Question question;
	public FieldBean(String fieldType, Question question) {
		super();
		this.fieldType = fieldType;
		this.question = question;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
}
