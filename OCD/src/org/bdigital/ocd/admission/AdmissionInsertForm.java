/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.admission;



/**
 *
 * @author jroda
 */
public class AdmissionInsertForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String idCase;
	private String idProgram;
	public String getIdCase() {
		return idCase;
	}
	public void setIdCase(String idCase) {
		this.idCase = idCase;
	}
	public String getIdProgram() {
		return idProgram;
	}
	public void setIdProgram(String idProgram) {
		this.idProgram = idProgram;
	}
	
}
