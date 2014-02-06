package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Name {

    String prefix;
    String givenName;
    String middleName;
    String maidenName;
    String familyName;
    String familyName2;
    String sufix;
	public String getPrefix() {
		return prefix;
	}
	@XmlElement
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getGivenName() {
		return givenName;
	}
	@XmlElement(name="given_name")
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getMiddleName() {
		return middleName;
	}
	@XmlElement(name="middle_name")
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getMaidenName() {
		return maidenName;
	}
	@XmlElement(name="maiden_name")
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}
	public String getFamilyName() {
		return familyName;
	}
	@XmlElement(name="family_name")
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyName2() {
		return familyName2;
	}
	@XmlElement(name="family_name2")
	public void setFamilyName2(String familyName2) {
		this.familyName2 = familyName2;
	}
	public String getSufix() {
		return sufix;
	}
	@XmlElement
	public void setSufix(String sufix) {
		this.sufix = sufix;
	}
}
