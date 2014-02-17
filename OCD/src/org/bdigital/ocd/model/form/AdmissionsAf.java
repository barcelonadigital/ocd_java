package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.Admissions;
 
public class AdmissionsAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    List<AdmissionAf> admissions = new ArrayList<AdmissionAf>();
	
	public AdmissionsAf(Admissions obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public List<AdmissionAf> getAdmissions() {
		return admissions;
	}

	public void setAdmissions(List<AdmissionAf> admissions) {
		this.admissions = admissions;
	}
 
	
}
