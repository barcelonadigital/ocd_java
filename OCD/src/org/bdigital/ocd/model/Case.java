package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="case")
public class Case {

	String ref;
	String[] refs;
	Data data;
	String fullName;
	Name name;
 
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

	public Data getData() {
		return data;
	}

	@XmlElement
	public void setData(Data data) {
		this.data = data;
	}
}
