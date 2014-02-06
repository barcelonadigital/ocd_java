package org.bdigital.ocd.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Actions {

    List<Action> actions = new ArrayList<Action>();

	public List<Action> getActions() {
		return actions;
	}

	@XmlElement(name = "action")
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
 
	
}
