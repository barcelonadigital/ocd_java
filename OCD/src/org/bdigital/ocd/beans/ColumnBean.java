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
public class ColumnBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private List<BoxBean> boxes = new ArrayList<BoxBean>();

	public List<BoxBean> getBoxes() {
		return boxes;
	}

	public void setBoxes(List<BoxBean> boxes) {
		this.boxes = boxes;
	}

}
