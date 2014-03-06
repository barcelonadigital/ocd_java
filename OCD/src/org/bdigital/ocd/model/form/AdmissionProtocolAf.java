package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;

import org.bdigital.ocd.model.AdmissionProtocol;


public class AdmissionProtocolAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String name;
	String description;
	
	public AdmissionProtocolAf(AdmissionProtocol obj) throws IllegalAccessException, InvocationTargetException {
		super();
		this.id=obj.getId();
		this.name=obj.getName();
		this.description=obj.getDescription();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
}
