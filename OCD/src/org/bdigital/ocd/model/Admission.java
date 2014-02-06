package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Admission {
 
	String ref;
	AdmissionData data;
	public String getRef() {
		return ref;
	}
	@XmlElement
	public void setRef(String ref) {
		this.ref = ref;
	}
	public AdmissionData getData() {
		return data;
	}
	@XmlElement
	public void setData(AdmissionData data) {
		this.data = data;
	}
 

}
