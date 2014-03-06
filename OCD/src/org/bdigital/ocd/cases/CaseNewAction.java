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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.AIM;
import org.bdigital.ocd.model.Address;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.model.Contact;
import org.bdigital.ocd.model.Data;
import org.bdigital.ocd.model.Device;
import org.bdigital.ocd.model.Mail;
import org.bdigital.ocd.model.Name;
import org.bdigital.ocd.model.Phone;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseNewAction extends BaseAction {

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
    public ActionForward doExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // extract user data
    	CaseNewForm formBean = (CaseNewForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	
    	String birthday = (formBean.getBirthday()!=null)?formBean.getBirthday():"";
    	String nie = (formBean.getNie()!=null)?"NIE/"+formBean.getNie():"";
    	String pas = (formBean.getPas()!=null)?"PAS/"+formBean.getPas():"";
    	String cip = (formBean.getCip()!=null)?"CIP/"+formBean.getCip():"";
    	String nick = (formBean.getNick()!=null)?"NICK/"+formBean.getNick():"";
    	String nif = (formBean.getNif()!=null)?"NIF/"+formBean.getNif():"";
    			
    	Case caseObj = new Case();
    	caseObj.setRef("");
    	Data dataObj = new Data();
    	dataObj.setBdate(birthday);
    	dataObj.setGender("M");
    	dataObj.setStatus("ACTIVE");
    	caseObj.setData(dataObj);
    	String[] refs = new String[]{nie,nif,pas,cip,nick};
    	caseObj.setRefs(refs);
   
    	String caseXmlString = UtilsWs.objectToXml(caseObj,Case.class,Data.class);
    	
    	StringHolder errorMsg = new StringHolder("");
    	StringHolder type = new StringHolder("");
    	StringHolder result = new StringHolder("");
    	proxy.case_insert(tokenLK,caseXmlString,result,type,errorMsg);
   
    	String caseId = result.value;
    	if ("EXIST".equals(type.value)) {
    		errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.case_get(tokenLK,caseId,result,errorMsg);
    		String caseDesc = "";
        	if (result.value!=null) {

        		Case caseGet = (Case)UtilsWs.xmlToObject(result.value,Case.class,
        				Data.class);
            	
            	if(caseGet.getData()!=null){
            		caseDesc += caseGet.getData().getNickname()+" ";
            	}
            	for(int i=0;i<caseGet.getRefs().length;i++){
            		String item = caseGet.getRefs()[i];
            		if(item.indexOf("NICK")==0){
            			caseDesc += "<NICK: "+UtilsWs.getValue(item, "NICK") + "> ";
            		}else if(item.indexOf("NIF")==0){
            			caseDesc += "<NIF: "+UtilsWs.getValue(item, "NIF") + "> ";
            		}else if(item.indexOf("NIE")==0){
            			caseDesc += "<NIE: "+UtilsWs.getValue(item, "NIE") + "> ";
            		}else if(item.indexOf("PAS")==0){
            			caseDesc += "<PAS: "+UtilsWs.getValue(item, "PAS") + "> ";
            		}else if(item.indexOf("CIP")==0){
            			caseDesc += "<CIP: "+UtilsWs.getValue(item, "CIP") + "> ";
            		}
            	}
        	}
    		ActionMessages errors = new ActionMessages();
            errors.add("error",new ActionMessage("errors.caseNewExists",caseDesc));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
    	}else if ("NEW".equals(type.value)) {
    		Contact caseContactObj = new Contact();
        	caseContactObj.setRef(caseId);
        	caseContactObj.setRefs(refs);
        	Name nameObj = new Name();
        	nameObj.setGivenName(formBean.getGivenName());
        	nameObj.setMiddleName(formBean.getMiddleName());
        	nameObj.setFamilyName(formBean.getFamilyName());
        	nameObj.setFamilyName2(formBean.getFamilyName2());
        	caseContactObj.setName(nameObj);
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
        	
        	caseXmlString = UtilsWs.objectToXml(caseContactObj,Contact.class,Name.class,
        			Address.class,Mail.class,AIM.class,Device.class,Phone.class);
        	
    		errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.case_set_contact(tokenLK, caseXmlString, result, errorMsg);
    	}else{
    		ActionMessages errors = new ActionMessages();
            errors.add("error",new ActionMessage("errors.caseNewError"));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
    	}
    	request.setAttribute("case_id",caseId);
		return mapping.findForward(SUCCESS);
    }
        
}
