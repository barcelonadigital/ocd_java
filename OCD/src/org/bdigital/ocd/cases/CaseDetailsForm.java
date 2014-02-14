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
	private String dataProtocolActual;
	private String estatProtocolActual;
	
	private String streetName;
	private String number;
	private String floor;
	private String suite;
	private String district;
	private String city;
	private String postcode;
	private String state;
	private String country;
	
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

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
