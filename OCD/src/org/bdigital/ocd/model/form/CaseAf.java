package org.bdigital.ocd.model.form;

import java.lang.reflect.InvocationTargetException;

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
	String[] refs;
	DataAf data;
	
	public CaseAf(Case obj) throws IllegalAccessException, InvocationTargetException {
		super();
		this.ref=obj.getRef();
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
 
}
