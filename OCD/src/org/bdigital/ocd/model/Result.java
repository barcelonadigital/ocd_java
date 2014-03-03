package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Result {

	String ref;
	String formCode;
	String shortName;
	String parentType;
	String parentId;
	String date;
	String status;
	String template;
	public String getRef() {
		return ref;
	}
	@XmlElement
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getFormCode() {
		return formCode;
	}
	@XmlElement(name = "form_code")
	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}
	public String getShortName() {
		return shortName;
	}
	@XmlElement(name = "short_name")
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getParentType() {
		return parentType;
	}
	@XmlElement(name = "parent_type")
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	public String getParentId() {
		return parentId;
	}
	@XmlElement(name = "parent_id")
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDate() {
		return date;
	}
	@XmlElement
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTemplate() {
		return template;
	}
	@XmlElement
	public void setTemplate(String template) {
		this.template = template;
	}

}
