/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.beans;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author jroda
 */
public class RowBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private List<FieldBean> fields = new ArrayList<FieldBean>();

	public List<FieldBean> getFields() {
		return fields;
	}

	public void setFields(List<FieldBean> fields) {
		this.fields = fields;
	}

	public void addField(FieldBean field) {
		this.fields.add(field);
	}
}
