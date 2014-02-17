package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Address {

	String kind;
	String street;
	String number;
	String floor;
	String suite;
	String district;
	String city;
	String postcode;
	String state;
	String country;
	String comment;
	public String getKind() {
		return kind;
	}
	@XmlElement
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getStreet() {
		return street;
	}
	@XmlElement
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	@XmlElement
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFloor() {
		return floor;
	}
	@XmlElement
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getSuite() {
		return suite;
	}
	@XmlElement
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getDistrict() {
		return district;
	}
	@XmlElement
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	@XmlElement
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getState() {
		return state;
	}
	@XmlElement
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}
	public String getComment() {
		return comment;
	}
	@XmlElement
	public void setComment(String comment) {
		this.comment = comment;
	}
 

}
