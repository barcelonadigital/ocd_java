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
public class GroupBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String untitled;
	private String hasErrors;
	private List<RowBean> rows = new ArrayList<RowBean>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RowBean> getRows() {
		return rows;
	}

	public void setRows(List<RowBean> rows) {
		this.rows = rows;
	}

	public String getUntitled() {
		return untitled;
	}

	public void setUntitled(String untitled) {
		this.untitled = untitled;
	}

	public String getHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(String hasErrors) {
		this.hasErrors = hasErrors;
	}

}
