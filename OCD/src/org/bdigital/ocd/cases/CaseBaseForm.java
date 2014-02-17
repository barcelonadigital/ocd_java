/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;




/**
 *
 * @author jroda
 */
public class CaseBaseForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String idCase;
	
//	private List<Admission> admissions;
//	private List<Admission> admissionsAll;
//	private List<Action> actions;
//	private List<Action> actionsTransfer;

	public String getIdCase() {
		return idCase;
	}

	public void setIdCase(String idCase) {
		this.idCase = idCase;
	}
	
	
}
