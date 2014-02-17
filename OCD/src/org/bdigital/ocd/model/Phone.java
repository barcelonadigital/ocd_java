package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Phone {

	String type;
	String number;
	String comment;
	public String getComment() {
		return comment;
	}
	@XmlElement
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getType() {
		return type;
	}
	@XmlElement
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	@XmlElement
	public void setNumber(String number) {
		this.number = number;
	}
 

}
