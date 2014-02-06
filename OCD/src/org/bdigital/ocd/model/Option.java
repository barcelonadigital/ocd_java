package org.bdigital.ocd.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Option {

	String optionId;
	String description;
	String mnemonic;
	String value;
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValue() {
		return value;
	}
	@XmlElement
	public void setValue(String value) {
		this.value = value;
	}
	public String getOptionId() {
		return optionId;
	}
	@XmlElement(name="option_id")
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public String getMnemonic() {
		return mnemonic;
	}
	@XmlElement
	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}
}
