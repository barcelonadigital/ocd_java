package org.bdigital.ocd.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Forms {

    List<Form> forms = new ArrayList<Form>();

	public List<Form> getForms() {
		return forms;
	}

	@XmlElement(name = "form")
	public void setForms(List<Form> Forms) {
		this.forms = Forms;
	}
 
	
}
