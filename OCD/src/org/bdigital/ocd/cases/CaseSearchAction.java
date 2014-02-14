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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.model.Data;
import org.bdigital.ocd.utils.UtilsWs;
import org.bdigital.ocd.ws.LINKCAREException;

/**
 *
 * @author jroda
 */
public class CaseSearchAction extends BaseAction {

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
    	
    	if("true".equals(formBean.getDoNew())){
    		return mapping.findForward("casenew");
    	}
    	
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

    	try{
    		proxy.case_insert(tokenLK,caseXmlString,result,type,errorMsg);
        }catch(LINKCAREException e){
        	
        	if ("Fill all reguired fields".equals(e.getMessage())) {
        		formBean.setShowLinkCreate("true");
                return mapping.findForward(FAILURE);
        	}else{
            	throw e;
            }
        }
   
    	String caseId = result.value;
    	if (!"EXIST".equals(type.value)) {
    		ActionMessages errors = new ActionMessages();
            errors.add("general",new ActionMessage("errors.resultWS",type.value));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
    	}else{
        	if("true".equals(formBean.getDoJoin())){
        		request.setAttribute("parameterIdCase",caseId);
        		return mapping.findForward("casejoin");
        	}else{
	        	request.setAttribute("case_id",caseId);
        		return mapping.findForward(SUCCESS);
        	}
    	}
    }
}
