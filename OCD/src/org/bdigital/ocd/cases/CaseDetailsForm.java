/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.util.List;

import org.bdigital.ocd.model.Action;
import org.bdigital.ocd.model.Admission;


/**
 *
 * @author jroda
 */
public class CaseDetailsForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String nick;
	private String nif;
	private String nie;
	private String pas;
	private String cip;
    
	private String fullname;
	private String nickname;
	private String birthday;
	private String age;
	private String sex;

	private String idCase;
	private String idProgram;
	private String idAdmission;

	private String descProtocolActual;
	private String dataProgramaActual;
	private String estatProgramaActual;
	
	private String admissionsText;
	private List<Admission> admissions;
	private List<Admission> admissionsAll;
	private List<Action> actions;
	private List<Action> actionsTransfer;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNie() {
		return nie;
	}

	public void setNie(String nie) {
		this.nie = nie;
	}

	public String getPas() {
		return pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

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

	public String getIdAdmission() {
		return idAdmission;
	}

	public void setIdAdmission(String idAdmission) {
		this.idAdmission = idAdmission;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Admission> getAdmissions() {
		return admissions;
	}

	public void setAdmissions(List<Admission> admissions) {
		this.admissions = admissions;
	}

	public String getAdmissionsText() {
		return admissionsText;
	}

	public void setAdmissionsText(String admissionsText) {
		this.admissionsText = admissionsText;
	}

	public List<Action> getActionsTransfer() {
		return actionsTransfer;
	}

	public void setActionsTransfer(List<Action> actionsTransfer) {
		this.actionsTransfer = actionsTransfer;
	}

	public List<Admission> getAdmissionsAll() {
		return admissionsAll;
	}

	public void setAdmissionsAll(List<Admission> admissionsAll) {
		this.admissionsAll = admissionsAll;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDescProtocolActual() {
		return descProtocolActual;
	}

	public void setDescProtocolActual(String descProtocolActual) {
		this.descProtocolActual = descProtocolActual;
	}

	public String getDataProgramaActual() {
		return dataProgramaActual;
	}

	public void setDataProgramaActual(String dataProgramaActual) {
		this.dataProgramaActual = dataProgramaActual;
	}

	public String getEstatProgramaActual() {
		return estatProgramaActual;
	}

	public void setEstatProgramaActual(String estatProgramaActual) {
		this.estatProgramaActual = estatProgramaActual;
	}
	
	
}
