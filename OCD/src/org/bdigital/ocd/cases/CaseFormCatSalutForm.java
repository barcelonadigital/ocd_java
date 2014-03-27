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
public class CaseFormCatSalutForm extends CaseBaseForm {

	private static final long serialVersionUID = 1L;
	private String idForm;
	private String idTask;
	
	//Prescripció de tractament
	private String dataSolicitud;
	private String nhc;
	private String telefon1;
	private String telefon2;
	private String telefon3;
	private String descDiagnostic;
	private String duracio;
	private String descMetgesSolicitant;
	
	//Variables del tractament
	private String descCanulaNasals;
	private String fluxRepos;
	private String horesDia;
	private String observacions;
	
	public String getIdForm() {
		return idForm;
	}
	public void setIdForm(String idForm) {
		this.idForm = idForm;
	}
	public String getIdTask() {
		return idTask;
	}
	public void setIdTask(String idTask) {
		this.idTask = idTask;
	}
	public String getDataSolicitud() {
		return dataSolicitud;
	}
	public void setDataSolicitud(String dataSolicitud) {
		this.dataSolicitud = dataSolicitud;
	}
	public String getNhc() {
		return nhc;
	}
	public void setNhc(String nhc) {
		this.nhc = nhc;
	}
	public String getTelefon1() {
		return telefon1;
	}
	public void setTelefon1(String telefon1) {
		this.telefon1 = telefon1;
	}
	public String getTelefon2() {
		return telefon2;
	}
	public void setTelefon2(String telefon2) {
		this.telefon2 = telefon2;
	}
	public String getTelefon3() {
		return telefon3;
	}
	public void setTelefon3(String telefon3) {
		this.telefon3 = telefon3;
	}
	public String getDescDiagnostic() {
		return descDiagnostic;
	}
	public void setDescDiagnostic(String descDiagnostic) {
		this.descDiagnostic = descDiagnostic;
	}
	public String getDuracio() {
		return duracio;
	}
	public void setDuracio(String duracio) {
		this.duracio = duracio;
	}
	public String getDescMetgesSolicitant() {
		return descMetgesSolicitant;
	}
	public void setDescMetgesSolicitant(String descMetgesSolicitant) {
		this.descMetgesSolicitant = descMetgesSolicitant;
	}
	public String getDescCanulaNasals() {
		return descCanulaNasals;
	}
	public void setDescCanulaNasals(String descCanulaNasals) {
		this.descCanulaNasals = descCanulaNasals;
	}
	public String getFluxRepos() {
		return fluxRepos;
	}
	public void setFluxRepos(String fluxRepos) {
		this.fluxRepos = fluxRepos;
	}
	public String getHoresDia() {
		return horesDia;
	}
	public void setHoresDia(String horesDia) {
		this.horesDia = horesDia;
	}
	public String getObservacions() {
		return observacions;
	}
	public void setObservacions(String observacions) {
		this.observacions = observacions;
	}
		
}
