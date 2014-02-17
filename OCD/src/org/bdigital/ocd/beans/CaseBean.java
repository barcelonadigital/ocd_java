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
public class CaseBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String fullname;
	private String age;
	private String sex;
	private String idCase;
	private String idAdmission;

	private String descProtocolActual;
	private String dataProtocolActual;
	private String estatProtocolActual;
	private String dataInscripcioAdmissio;
	private String nick;
	private String nif;
	private String nie;
	private String pas;
	private String cip;
    
	private String nickname;
	private String birthday;

	private String admissionsText;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getIdCase() {
		return idCase;
	}

	public void setIdCase(String idCase) {
		this.idCase = idCase;
	}

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

	public String getAdmissionsText() {
		return admissionsText;
	}

	public void setAdmissionsText(String admissionsText) {
		this.admissionsText = admissionsText;
	}

	public String getDataInscripcioAdmissio() {
		return dataInscripcioAdmissio;
	}

	public void setDataInscripcioAdmissio(String dataInscripcioAdmissio) {
		this.dataInscripcioAdmissio = dataInscripcioAdmissio;
	}
	
	
}
