/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.util.List;

import org.bdigital.ocd.model.Form;



/**
 *
 * @author jroda
 */
public class CaseTaskUnitDetailsForm extends CaseBaseForm {

	private static final long serialVersionUID = 1L;
	private String idTask;
	private List<Form> forms;
	
	public List<Form> getForms() {
		return forms;
	}
	public void setForms(List<Form> forms) {
		this.forms = forms;
	}
	public String getIdTask() {
		return idTask;
	}
	public void setIdTask(String idTask) {
		this.idTask = idTask;
	}
	
}
