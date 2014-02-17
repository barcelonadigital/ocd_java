package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.Forms;

public class FormsAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    List<FormAf> forms = new ArrayList<FormAf>();
	
	public FormsAf(Forms obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public List<FormAf> getForms() {
		return forms;
	}

	public void setForms(List<FormAf> forms) {
		this.forms = forms;
	}

}
