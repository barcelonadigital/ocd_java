/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import org.apache.struts.validator.ValidatorForm;


/**
 *
 * @author jroda
 */
public class CaseNewForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;
	private String nick;
	private String nif;
	private String nie;
	private String pas;
	private String cip;
    
	private String birthday;
	private String givenName;
	private String middleName;
	private String familyName;
	private String familyName2;
	private String sex;
	
	private String streetName;
	private String number;
	private String floor;
	private String suite;
	private String district;
	private String city;
	private String postcode;
	private String state;
	private String country;
	
	private String showLinkCreate;
	private String doNew;

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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyName2() {
		return familyName2;
	}
	public void setFamilyName2(String familyName2) {
		this.familyName2 = familyName2;
	}
	public String getShowLinkCreate() {
		return showLinkCreate;
	}
	public void setShowLinkCreate(String showLinkCreate) {
		this.showLinkCreate = showLinkCreate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDoNew() {
		return doNew;
	}
	public void setDoNew(String doNew) {
		this.doNew = doNew;
	}
    

}
