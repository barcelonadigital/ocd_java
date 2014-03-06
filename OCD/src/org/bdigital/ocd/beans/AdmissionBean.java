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
public class AdmissionBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String idAdmission;
	private String idAdmissionFirst;

	private String descProtocolActual;
	private String dataProtocolActual;
	private String estatProtocolActual;
	private String dataInscripcioAdmissio;
	public String getIdAdmission() {
		return idAdmission;
	}
	public void setIdAdmission(String idAdmission) {
		this.idAdmission = idAdmission;
	}
	public String getDescProtocolActual() {
		return descProtocolActual;
	}
	public void setDescProtocolActual(String descProtocolActual) {
		this.descProtocolActual = descProtocolActual;
	}
	public String getDataProtocolActual() {
		return dataProtocolActual;
	}
	public void setDataProtocolActual(String dataProtocolActual) {
		this.dataProtocolActual = dataProtocolActual;
	}
	public String getEstatProtocolActual() {
		return estatProtocolActual;
	}
	public void setEstatProtocolActual(String estatProtocolActual) {
		this.estatProtocolActual = estatProtocolActual;
	}
	public String getDataInscripcioAdmissio() {
		return dataInscripcioAdmissio;
	}
	public void setDataInscripcioAdmissio(String dataInscripcioAdmissio) {
		this.dataInscripcioAdmissio = dataInscripcioAdmissio;
	}
	public String getIdAdmissionFirst() {
		return idAdmissionFirst;
	}
	public void setIdAdmissionFirst(String idAdmissionFirst) {
		this.idAdmissionFirst = idAdmissionFirst;
	}
	
}
