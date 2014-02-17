package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.bdigital.ocd.model.Contact;
 
public class ContactAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ref;
	String[] refs;
	String fullName;
	NameAf name;
    List<AddressAf> addresses = new ArrayList<AddressAf>();
    List<MailAf> mails = new ArrayList<MailAf>();
    List<AIMAf> aims = new ArrayList<AIMAf>();
    List<DeviceAf> devices = new ArrayList<DeviceAf>();
    List<PhoneAf> phones = new ArrayList<PhoneAf>();
	
	public ContactAf(Contact obj) throws IllegalAccessException, InvocationTargetException {
		super();
		BeanUtils.copyProperties( this, obj ); 
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String[] getRefs() {
		return refs;
	}
	public void setRefs(String[] refs) {
		this.refs = refs;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public NameAf getName() {
		return name;
	}
	public void setName(NameAf name) {
		this.name = name;
	}
	public List<AddressAf> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressAf> addresses) {
		this.addresses = addresses;
	}
	public List<MailAf> getMails() {
		return mails;
	}
	public void setMails(List<MailAf> mails) {
		this.mails = mails;
	}
	public List<AIMAf> getAims() {
		return aims;
	}
	public void setAims(List<AIMAf> aims) {
		this.aims = aims;
	}
	public List<DeviceAf> getDevices() {
		return devices;
	}
	public void setDevices(List<DeviceAf> devices) {
		this.devices = devices;
	}
	public List<PhoneAf> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneAf> phones) {
		this.phones = phones;
	}
}
