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
public class BoxBean extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private List<GroupBean> groups = new ArrayList<GroupBean>();

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

	public List<GroupBean> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupBean> groups) {
		this.groups = groups;
	}

	public void addGroup(GroupBean group) {
		this.groups.add(group);
	}

}
