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
public class CaseResultForm extends ValidatorForm {
    
	private static final long serialVersionUID = 1L;
	private String searchStr;
	private String elemPerPage="6";
	private String resultAction;
	private String currPage="1";
	
	public String getSearchStr() {
		return searchStr;
	}
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}
	public String getCurrPage() {
		return currPage;
	}
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	public String getResultAction() {
		return resultAction;
	}
	public void setResultAction(String resultAction) {
		this.resultAction = resultAction;
	}
	public String getElemPerPage() {
		return elemPerPage;
	}
	public void setElemPerPage(String elemPerPage) {
		this.elemPerPage = elemPerPage;
	}
}
