/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import org.bdigital.ocd.model.AIM;
import org.bdigital.ocd.model.Address;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.model.Contact;
import org.bdigital.ocd.model.Data;
import org.bdigital.ocd.model.Device;
import org.bdigital.ocd.model.Mail;
import org.bdigital.ocd.model.Name;
import org.bdigital.ocd.model.Phone;
import org.bdigital.ocd.model.form.CaseAf;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseSaveAction extends CaseBaseAction {

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward doCaseExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // extract user data
    	CaseSaveForm formBean = (CaseSaveForm)form;
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	
    	String caseId = formBean.getIdCase();

    	if(caseId!=null){
    		
	    	String birthday = UtilsString.stringDateWebtoStringDateWS(formBean.getBirthday());
	    	
	    	
	    	StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.case_get(tokenLK,caseId,result,errorMsg);
        	
        	Case caseObj = (Case)UtilsWs.xmlToObject(result.value,Case.class,
    				Data.class);
        	CaseAf caseGetAf = new CaseAf(caseObj);
        	caseGetAf.setNie(formBean.getNie());
        	caseGetAf.setPas(formBean.getPas());
        	caseGetAf.setNif(formBean.getNif());

        	String nie = (caseGetAf.getNie()!=null)?"NIE/"+caseGetAf.getNie():"";
        	String pas = (caseGetAf.getPas()!=null)?"PAS/"+caseGetAf.getPas():"";
        	String cip = (caseGetAf.getCip()!=null)?"CIP/"+caseGetAf.getCip():"";
        	String nick = (caseGetAf.getNick()!=null)?"NICK/"+caseGetAf.getNick():"";
        	String nif = (caseGetAf.getNif()!=null)?"NIF/"+caseGetAf.getNif():"";

        	String[] refs = new String[]{nie,nif,pas,cip,nick};
	    	caseObj.setRefs(refs);

	    	MessageResources msgResource = getResources(request);
	    	
	    	caseObj.getData().setBdate(birthday);
	    	if(formBean.getDescSex().equals(msgResource.getMessage("label.sex.home"))){
	    		caseObj.getData().setGender("M");
	    	}else if(formBean.getDescSex().equals(msgResource.getMessage("label.sex.dona"))){
	    		caseObj.getData().setGender("F");
	    	}

	    	String caseXmlString = UtilsWs.objectToXml(caseObj,Case.class,Data.class);
	    	
        	errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.case_set(tokenLK,caseXmlString,result,errorMsg);
	   
        	errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.case_get_contact(tokenLK,caseId,result,errorMsg);

        	Contact caseContactObj = (Contact)UtilsWs.xmlToObject(result.value,Contact.class,Name.class,
        			Address.class,Mail.class,AIM.class,Device.class,Phone.class);
        	
	    	caseContactObj.setRef(caseId);
	    	caseContactObj.setRefs(refs);
	    	Phone phoneObj = new Phone();
	    	phoneObj.setNumber(formBean.getPhoneNumber());
	    	phoneObj.setType("home");
	    	List<Phone> phones = new LinkedList<Phone>();
	    	phones.add(phoneObj);
	    	Address addressObj = new Address();
	    	addressObj.setKind("Main Address");
	    	addressObj.setStreet(formBean.getStreetName());
	    	addressObj.setNumber(formBean.getNumber());
	    	addressObj.setFloor(formBean.getFloor());
	    	addressObj.setSuite(formBean.getSuite());
	    	addressObj.setDistrict(formBean.getDistrict());
	    	addressObj.setCity(formBean.getCity());
	    	addressObj.setPostcode(formBean.getPostcode());
	    	addressObj.setState(formBean.getState());
	    	addressObj.setCountry(formBean.getCountry());
	    	addressObj.setComment("");
	    	List<Address> addresses = new LinkedList<Address>();
	    	addresses.add(addressObj);
	    	caseContactObj.setAddresses(addresses);
	    	caseContactObj.setPhones(phones);
	    	
	    	caseXmlString = UtilsWs.objectToXml(caseContactObj,Contact.class,Name.class,
	    			Address.class,Mail.class,AIM.class,Device.class,Phone.class);
	    	
			errorMsg = new StringHolder("");
	    	result = new StringHolder("");
	    	proxy.case_set_contact(tokenLK, caseXmlString, result, errorMsg);

        	request.getSession().setAttribute("caseBean",null);
        	
	    	return mapping.findForward(SUCCESS);
	
		}else{
			return mapping.findForward(FAILURE);
		}
    }
}
