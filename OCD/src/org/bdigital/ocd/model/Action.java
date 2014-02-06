package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Action {

	String ref;
	String name;
	String description;
	String actionClass;
	public String getRef() {
		return ref;
	}
	@XmlElement
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActionClass() {
		return actionClass;
	}
	@XmlElement(name = "class")
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
 

}
