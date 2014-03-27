package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.utils.UtilsWs;

 
public class CaseAf extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ref;
	String nick;
	String nif;
	String nie;
	String pas;
	String cip;
	String nhc;
	String id;
	String nickname;
	String nameComplete;
	String[] refs;
	DataAf data;
	
	public CaseAf(Case obj) throws IllegalAccessException, InvocationTargetException, ParseException {
		super();
		this.ref=obj.getRef();
		this.id=obj.getId();
		this.nickname=obj.getNickname();
		this.nameComplete=obj.getNameComplete();
		this.refs=obj.getRefs();
		if(obj.getRefs()!=null){
	    	for(int i=0;i<obj.getRefs().length;i++){
				String item = obj.getRefs()[i];
				if(item.indexOf("NICK")==0){
					this.nick = UtilsWs.getValue(item, "NICK");
				}else if(item.indexOf("NIF")==0){
					this.nif = UtilsWs.getValue(item, "NIF");
				}else if(item.indexOf("NIE")==0){
					this.nie = UtilsWs.getValue(item, "NIE");
				}else if(item.indexOf("PAS")==0){
					this.pas = UtilsWs.getValue(item, "PAS");
				}else if(item.indexOf("CIP")==0){
					this.cip = UtilsWs.getValue(item, "CIP");
				}else if(item.indexOf("NHC")==0){
					this.nhc = UtilsWs.getValue(item, "NHC");
				}
			}
		}
		if(obj.getData()!=null){
			this.data = new DataAf(obj.getData());
		}
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
	public DataAf getData() {
		return data;
	}
	public void setData(DataAf data) {
		this.data = data;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNie() {
		return nie;
	}
	public void setNie(String nie) {
		this.nie = nie;
	}
	public String getPas() {
		return pas;
	}
	public void setPas(String pas) {
		this.pas = pas;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getNhc() {
		return nhc;
	}
	public void setNhc(String nhc) {
		this.nhc = nhc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNameComplete() {
		return nameComplete;
	}
	public void setNameComplete(String nameComplete) {
		this.nameComplete = nameComplete;
	}
 
}
