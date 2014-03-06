package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import org.bdigital.ocd.model.Admission;

 
public class AdmissionAf extends org.apache.struts.action.ActionForm {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ref;
	AdmissionDataAf data;
	
	public AdmissionAf(Admission obj) throws IllegalAccessException, InvocationTargetException, ParseException {
		super();
		this.ref=obj.getRef();
		if(obj.getData()!=null){
			this.data = new AdmissionDataAf(obj.getData());
		}
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
