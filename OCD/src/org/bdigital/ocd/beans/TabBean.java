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
public class TabBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String title;
	private List<RowBean> rows = new ArrayList<RowBean>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<RowBean> getRows() {
		return rows;
	}

	public void setRows(List<RowBean> rows) {
		this.rows = rows;
	}

}
