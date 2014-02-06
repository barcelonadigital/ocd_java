package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="data")
public class AdmissionData {
 
	Case admissionCase;
	AdmissionProgram program;
	AdmissionProtocol protocol;
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
	public Case getAdmissionCase() {
		return admissionCase;
	}
    @XmlElement(name="case")
	public void setAdmissionCase(Case admissionCase) {
		this.admissionCase = admissionCase;
	}
	public AdmissionProgram getProgram() {
		return program;
	}
	@XmlElement
	public void setProgram(AdmissionProgram program) {
		this.program = program;
	}
	public String getEnrolDate() {
		return enrolDate;
	}
	@XmlElement(name="enrol_date")
	public void setEnrolDate(String enrolDate) {
		this.enrolDate = enrolDate;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	@XmlElement(name="admission_date")
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDischargeDate() {
		return dischargeDate;
	}
	@XmlElement(name="discharge_date")
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getSuspendedDate() {
		return suspendedDate;
	}
	@XmlElement(name="suspended_date")
	public void setSuspendedDate(String suspendedDate) {
		this.suspendedDate = suspendedDate;
	}
	public String getRejectedDate() {
		return rejectedDate;
	}
	@XmlElement(name="rejected_date")
	public void setRejectedDate(String rejectedDate) {
		this.rejectedDate = rejectedDate;
	}
	public String getNotes() {
		return notes;
	}
	@XmlElement
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateToDisplay() {
		return dateToDisplay;
	}
	@XmlElement(name="date_to_display")
	public void setDateToDisplay(String dateToDisplay) {
		this.dateToDisplay = dateToDisplay;
	}
	public String getAgeToDisplay() {
		return ageToDisplay;
	}
	@XmlElement(name="age_to_display")
	public void setAgeToDisplay(String ageToDisplay) {
		this.ageToDisplay = ageToDisplay;
	}
	public String getHisEpisodeRef() {
		return hisEpisodeRef;
	}
	@XmlElement(name="his_episode_ref")
	public void setHisEpisodeRef(String hisEpisodeRef) {
		this.hisEpisodeRef = hisEpisodeRef;
	}
	public AdmissionProtocol getProtocol() {
		return protocol;
	}
	@XmlElement
	public void setProtocol(AdmissionProtocol protocol) {
		this.protocol = protocol;
	}
	    
}
