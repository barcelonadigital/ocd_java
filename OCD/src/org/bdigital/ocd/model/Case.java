package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="case")
public class Case {

	String ref;
	String id;
	String nickname;
	String nameComplete;
	String[] refs;
	Data data;
 
	public String getRef() {
		return ref;
	}

	@XmlElement
	public void setRef(String ref) {
		this.ref = ref;
	}

	public String[] getRefs() {
		return refs;
	}

    @XmlElement(name="ref")
	@XmlElementWrapper
	public void setRefs(String[] refs) {
		this.refs = refs;
	}

	public Data getData() {
		return data;
	}

	@XmlElement
	public void setData(Data data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	@XmlElement
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNameComplete() {
		return nameComplete;
	}

	@XmlElement(name="name_complete")
	public void setNameComplete(String nameComplete) {
		this.nameComplete = nameComplete;
	}
}
