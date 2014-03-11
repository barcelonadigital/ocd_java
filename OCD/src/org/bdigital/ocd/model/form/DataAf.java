package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import org.apache.struts.util.MessageResources;
import org.bdigital.ocd.model.Data;
import org.bdigital.ocd.utils.UtilsString;

 
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
	String descGender;
	
	public DataAf(Data obj) throws IllegalAccessException, InvocationTargetException, ParseException {
		super();
		this.bdate=UtilsString.stringDateWStoStringDateWeb(obj.getBdate());
		this.nickname=obj.getNickname();
		this.fullname=obj.getFullname();
		this.gender=obj.getGender();
		MessageResources messages = MessageResources.getMessageResources("ApplicationResource");
	    if("M".equals(this.gender)){
	    	this.descGender=messages.getMessage("label.sex.home");
	    }else if("F".equals(this.gender)){
	    	this.descGender=messages.getMessage("label.sex.dona");
	    }else{
	    	this.descGender=this.gender;
	    }
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
	public String getDescGender() {
		return descGender;
	}
	public void setDescGender(String descGender) {
		this.descGender = descGender;
	}
}
