/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.task;



/**
 *
 * @author jroda
 */
public class TasksAssignedForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String idActivity;
	private String idAdmission;
	private String idCase;
	private String idRole;
	public String getIdActivity() {
		return idActivity;
	}
	public void setIdActivity(String idActivity) {
		this.idActivity = idActivity;
	}
	public String getIdAdmission() {
		return idAdmission;
	}
	public void setIdAdmission(String idAdmission) {
		this.idAdmission = idAdmission;
	}
	public String getIdCase() {
		return idCase;
	}
	public void setIdCase(String idCase) {
		this.idCase = idCase;
	}
	public String getIdRole() {
		return idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	
}
