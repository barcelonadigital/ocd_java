package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.Device;

 
public class DeviceAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String type;
	String id;
	String comment;
	
	public DeviceAf(Device obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
