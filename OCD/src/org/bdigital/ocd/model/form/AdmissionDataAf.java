package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.AdmissionData;


public class AdmissionDataAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	CaseAf admissionCase;
	AdmissionProgramAf program;
	AdmissionProtocolAf protocol;
	String enrolDate;
	String admissionDate;
    String dischargeDate;
    String suspendedDate;
    String rejectedDate;
    String notes;
    String status;
    String dateToDisplay;
    String ageToDisplay;
    String hisEpisodeRef;
	
	public AdmissionDataAf(AdmissionData obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public CaseAf getAdmissionCase() {
		return admissionCase;
	}
	public void setAdmissionCase(CaseAf admissionCase) {
		this.admissionCase = admissionCase;
	}
	public AdmissionProgramAf getProgram() {
		return program;
	}
	public void setProgram(AdmissionProgramAf program) {
		this.program = program;
	}
	public AdmissionProtocolAf getProtocol() {
		return protocol;
	}
	public void setProtocol(AdmissionProtocolAf protocol) {
		this.protocol = protocol;
	}
	public String getEnrolDate() {
		return enrolDate;
	}
	public void setEnrolDate(String enrolDate) {
		this.enrolDate = enrolDate;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getSuspendedDate() {
		return suspendedDate;
	}
	public void setSuspendedDate(String suspendedDate) {
		this.suspendedDate = suspendedDate;
	}
	public String getRejectedDate() {
		return rejectedDate;
	}
	public void setRejectedDate(String rejectedDate) {
		this.rejectedDate = rejectedDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateToDisplay() {
		return dateToDisplay;
	}
	public void setDateToDisplay(String dateToDisplay) {
		this.dateToDisplay = dateToDisplay;
	}
	public String getAgeToDisplay() {
		return ageToDisplay;
	}
	public void setAgeToDisplay(String ageToDisplay) {
		this.ageToDisplay = ageToDisplay;
	}
	public String getHisEpisodeRef() {
		return hisEpisodeRef;
	}
	public void setHisEpisodeRef(String hisEpisodeRef) {
		this.hisEpisodeRef = hisEpisodeRef;
	}
}
