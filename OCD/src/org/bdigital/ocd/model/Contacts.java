package org.bdigital.ocd.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Contacts {

    List<Case> contacts = new ArrayList<Case>();

	public List<Case> getContacts() {
		return contacts;
	}

	@XmlElement(name = "case")
	public void setContacts(List<Case> contacts) {
		this.contacts = contacts;
	}
 
	
}
