/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import org.apache.struts.validator.ValidatorForm;


/**
 *
 * @author jroda
 */
public class CaseJoinForm extends ValidatorForm {
    
	private static final long serialVersionUID = 1L;
	private String idCase;
	
	public String getIdCase() {
		return idCase;
	}
	public void setIdCase(String idCase) {
		this.idCase = idCase;
	}
}
