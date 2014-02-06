package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Form {

	String ref;
	String shortName;
	String status;
	FormData formData;
	public String getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRef() {
		return ref;
	}
	@XmlElement
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getShortName() {
		return shortName;
	}
	@XmlElement(name = "short_name")
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	@XmlElement(name = "data")
	public FormData getFormData() {
		return formData;
	}
	public void setFormData(FormData formData) {
		this.formData = formData;
	}
 

}
