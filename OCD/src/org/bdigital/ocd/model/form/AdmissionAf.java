package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.Admission;

 
public class AdmissionAf extends org.apache.struts.action.ActionForm {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ref;
	AdmissionDataAf data;
	
	public AdmissionAf(Admission obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public AdmissionDataAf getData() {
		return data;
	}
	public void setData(AdmissionDataAf data) {
		this.data = data;
	}
 

}
