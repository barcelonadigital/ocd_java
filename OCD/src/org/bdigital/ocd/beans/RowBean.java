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
public class RowBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private Question bigFieldQuestion;
	private Question smallFieldQuestion1;
	private Question smallFieldQuestion2;
	public Question getBigFieldQuestion() {
		return bigFieldQuestion;
	}
	public void setBigFieldQuestion(Question bigFieldQuestion) {
		this.bigFieldQuestion = bigFieldQuestion;
	}
	public Question getSmallFieldQuestion1() {
		return smallFieldQuestion1;
	}
	public void setSmallFieldQuestion1(Question smallFieldQuestion1) {
		this.smallFieldQuestion1 = smallFieldQuestion1;
	}
	public Question getSmallFieldQuestion2() {
		return smallFieldQuestion2;
	}
	public void setSmallFieldQuestion2(Question smallFieldQuestion2) {
		this.smallFieldQuestion2 = smallFieldQuestion2;
	}
	
}
