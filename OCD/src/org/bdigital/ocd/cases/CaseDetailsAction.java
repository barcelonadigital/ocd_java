/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.model.AIM;
import org.bdigital.ocd.model.Address;
import org.bdigital.ocd.model.Contact;
import org.bdigital.ocd.model.Device;
import org.bdigital.ocd.model.Mail;
import org.bdigital.ocd.model.Name;
import org.bdigital.ocd.model.Phone;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseDetailsAction extends CaseBaseAction {

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
    	CaseDetailsForm formBean = (CaseDetailsForm)form;
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String caseId=(String)request.getAttribute("case_id")!=null?(String)request.getAttribute("case_id"):formBean.getIdCase();
    	
    	if(caseId!=null){
    		
        	formBean.setCip(caseBean.getCip());
        	formBean.setNif(caseBean.getNif());
        	formBean.setPas(caseBean.getPas());
        	formBean.setNie(caseBean.getNie());
        	formBean.setSex(caseBean.getSex());
        	formBean.setBirthday(caseBean.getBirthday());

    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.case_get_contact(tokenLK,caseId,result,errorMsg);

        	Contact contact = (Contact)UtilsWs.xmlToObject(result.value,Contact.class,Name.class,
        			Address.class,Mail.class,AIM.class,Device.class,Phone.class);
        	if(contact.getAddresses()!=null && contact.getAddresses().size()>0){
        		
        		Address addressObj =contact.getAddresses().get(0);
        		formBean.setStreetName(addressObj.getStreet());
        		formBean.setNumber(addressObj.getNumber());
        		formBean.setFloor(addressObj.getFloor());
        		formBean.setSuite(addressObj.getSuite());
        		formBean.setDistrict(addressObj.getDistrict());
        		formBean.setCity(addressObj.getCity());
        		formBean.setPostcode(addressObj.getPostcode());
        		formBean.setState(addressObj.getState());
        		formBean.setCountry(addressObj.getCountry());
        	}
        	
        	return mapping.findForward(SUCCESS);

    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
