package org.bdigital.ocd.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Admissions {

    List<Admission> admissions = new ArrayList<Admission>();

	public List<Admission> getAdmissions() {
		return admissions;
	}

	@XmlElement(name = "admission")
	public void setAdmissions(List<Admission> admissions) {
		this.admissions = admissions;
	}
 
	
}
