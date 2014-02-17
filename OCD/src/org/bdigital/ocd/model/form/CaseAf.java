package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.Case;

 
public class CaseAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ref;
	String[] refs;
	DataAf data;
	
	public CaseAf(Case obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String[] getRefs() {
		return refs;
	}
	public void setRefs(String[] refs) {
		this.refs = refs;
	}
	public DataAf getData() {
		return data;
	}
	public void setData(DataAf data) {
		this.data = data;
	}
 
}
