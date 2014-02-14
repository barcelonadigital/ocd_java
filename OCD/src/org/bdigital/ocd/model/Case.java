package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="case")
public class Case {

	String ref;
	String[] refs;
	Data data;
 
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

	public Data getData() {
		return data;
	}

	@XmlElement
	public void setData(Data data) {
		this.data = data;
	}
}
