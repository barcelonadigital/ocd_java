package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;

import org.bdigital.ocd.model.Data;

 
public class DataAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	String bdate;
	String nickname;
	String fullname;
	String gender;
	String age;
	String status;
	String byear;
	
	public DataAf(Data obj) throws IllegalAccessException, InvocationTargetException {
		super();
		this.bdate=obj.getBdate();
		this.nickname=obj.getNickname();
		this.fullname=obj.getFullname();
		this.gender=obj.getGender();
		this.age=obj.getAge();
		this.status=obj.getStatus();
		this.byear=obj.getByear();
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getByear() {
		return byear;
	}
	public void setByear(String byear) {
		this.byear = byear;
	}
}
