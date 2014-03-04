/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.beans;




/**
 *
 * @author jroda
 */
public class MenuBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String isActiveMenuHistoric;
	private String isActiveMenuInfoPacient;
	private String isActiveMenuFormularis;
	

	public String getIsActiveMenuHistoric() {
		return isActiveMenuHistoric;
	}

	public void setIsActiveMenuHistoric(String isActiveMenuHistoric) {
		this.isActiveMenuHistoric = isActiveMenuHistoric;
	}

	public String getIsActiveMenuInfoPacient() {
		return isActiveMenuInfoPacient;
	}

	public void setIsActiveMenuInfoPacient(String isActiveMenuInfoPacient) {
		this.isActiveMenuInfoPacient = isActiveMenuInfoPacient;
	}

	public String getIsActiveMenuFormularis() {
		return isActiveMenuFormularis;
	}

	public void setIsActiveMenuFormularis(String isActiveMenuFormularis) {
		this.isActiveMenuFormularis = isActiveMenuFormularis;
	}

}
