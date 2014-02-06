/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.admission;

import java.util.List;

import org.bdigital.ocd.model.Action;
import org.bdigital.ocd.model.Task;



/**
 *
 * @author jroda
 */
public class AdmissionDetailsForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String idAdmission;
	private String enrolDate;
	private String programName;
	private List<Action> actions;
	private List<Task> tasks;

	private String parameterIdTask;

	public String getIdAdmission() {
		return idAdmission;
	}

	public void setIdAdmission(String idAdmission) {
		this.idAdmission = idAdmission;
	}

	public String getEnrolDate() {
		return enrolDate;
	}

	public void setEnrolDate(String enrolDate) {
		this.enrolDate = enrolDate;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getParameterIdTask() {
		return parameterIdTask;
	}

	public void setParameterIdTask(String parameterIdTask) {
		this.parameterIdTask = parameterIdTask;
	}

	
}
