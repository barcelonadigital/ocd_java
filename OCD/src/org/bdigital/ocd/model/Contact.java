package org.bdigital.ocd.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="contact")
public class Contact {

	String ref;
	String[] refs;
	String fullName;
	Name name;
    List<Address> addresses = new ArrayList<Address>();
    List<Mail> mails = new ArrayList<Mail>();
    List<AIM> aims = new ArrayList<AIM>();
    List<Device> devices = new ArrayList<Device>();
    List<Phone> phones = new ArrayList<Phone>();

	public List<Address> getAddresses() {
		return addresses;
	}

    @XmlElement(name="address")
	@XmlElementWrapper
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
 
	public String getRef() {
		return ref;
	}

	@XmlElement
	public void setRef(String ref) {
		this.ref = ref;
	}

	public String[] getRefs() {
		return refs;
	}

    @XmlElement(name="ref")
	@XmlElementWrapper
	public void setRefs(String[] refs) {
		this.refs = refs;
	}

	public String getFullName() {
		return fullName;
	}

	@XmlElement(name="full_name")
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Name getName() {
		return name;
	}

	@XmlElement
	public void setName(Name name) {
		this.name = name;
	}

	public List<Mail> getMails() {
		return mails;
	}

	@XmlElement(name = "mail")
	@XmlElementWrapper
	public void setMails(List<Mail> mails) {
		this.mails = mails;
	}

	public List<AIM> getAims() {
		return aims;
	}

	@XmlElement(name = "AIM")
	@XmlElementWrapper
	public void setAims(List<AIM> aims) {
		this.aims = aims;
	}

	public List<Device> getDevices() {
		return devices;
	}

	@XmlElement(name = "device")
	@XmlElementWrapper
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	@XmlElement(name = "phone")
	@XmlElementWrapper
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}
