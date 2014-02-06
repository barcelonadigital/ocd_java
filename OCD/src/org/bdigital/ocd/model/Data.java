package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Data {
 
	String bdate;
	String nickname;
	String fullname;
	String gender;
	String age;
	String status;
	String byear;

	public String getBdate() {
		return bdate;
	}

	@XmlElement
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getGender() {
		return gender;
	}

	@XmlElement
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String getAge() {
		return age;
	}

	@XmlElement
	public void setAge(String age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	@XmlElement
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFullname() {
		return fullname;
	}

	@XmlElement(name="full_name")
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getByear() {
		return byear;
	}

	@XmlElement
	public void setByear(String byear) {
		this.byear = byear;
	}
 
}
