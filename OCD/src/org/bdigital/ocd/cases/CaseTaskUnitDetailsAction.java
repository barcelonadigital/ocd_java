/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.model.Form;
import org.bdigital.ocd.model.Forms;
import org.bdigital.ocd.model.Task;
import org.bdigital.ocd.model.form.FormAf;
import org.bdigital.ocd.model.form.TaskAf;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public class CaseTaskUnitDetailsAction extends CaseBaseAction {

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
    	CaseTaskUnitDetailsForm formBean = (CaseTaskUnitDetailsForm)form;
    	
    	menuBean.setIsActiveMenuFormularis("true");
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String taskId=(String)request.getAttribute("parameterIdTask")!=null?(String)request.getAttribute("parameterIdTask"):formBean.getIdTask();
    	//String admissionId=admissionBean.getIdAdmission();
    	
    	if(taskId!=null){
    	//if(taskId!=null){
    		StringHolder errorMsg = new StringHolder("");
    		StringHolder result = new StringHolder("");
        	proxy.task_get(tokenLK, taskId, "ADMI", result, errorMsg);
        	Task taskObj = (Task)UtilsWs.xmlToObject(result.value,
        			Task.class,Form.class);
        	TaskAf tAf = new TaskAf(taskObj);
    		if("227".equals(taskObj.getRefs()[0])){
    			tAf.setDescription("Visita de seguiment");
    		}else if("VARIABLES".equals(taskObj.getDescription().toUpperCase())){
    			tAf.setDescription("Prescripció d'OCD");
    		}else if("CVSO".equals(taskObj.getDescription().toUpperCase())){
    			tAf.setDescription("Visita de seguiment");
    		}
    		if(taskObj.getForms()!=null &&
        			taskObj.getForms().size()>0){
    			errorMsg = new StringHolder("");
            	result = new StringHolder("");
            	proxy.task_form_list(tokenLK, taskId, result, errorMsg);
            	Forms formsObj = (Forms)UtilsWs.xmlToObject(result.value,
            			Forms.class, Form.class);
            	List<FormAf> forms = new ArrayList<FormAf>();
            	if(formsObj.getForms()!=null){
            		String statusFirstItem = "";
            		String refFirstItem = "";
            		for(int l=0;l<formsObj.getForms().size();l++){
            			Form f = formsObj.getForms().get(l);
            			FormAf fAf = new FormAf(f);
            			if("242".equals(taskObj.getRefs()[0]) &&
            					l==1){
            				fAf.setShortName("Dades clíniques");
            			}else if("242".equals(taskObj.getRefs()[0]) &&
            					l==2){
            				fAf.setShortName("Prescripció inicial d'OCD");
            			}
            			if(!"242".equals(taskObj.getRefs()[0]) ||
            					l!=0){
            				forms.add(fAf);
            			}else{
            				statusFirstItem = fAf.getStatus();
            				refFirstItem = fAf.getRef();
            			}
            		}
            		if("VARIABLES".equals(taskObj.getDescription().toUpperCase())){
            			FormAf fAf = new FormAf(new Form());
                		fAf.setItemType("DOCUMENTPRESC");
                		fAf.setShortName("Enviament de document a la historia clínica");
            			forms.add(fAf);
            			fAf = new FormAf(new Form());
            			fAf.setItemType("CATSALUT");
                		fAf.setShortName("Sol·licitud d'OCD a CatSalut");
            			fAf.setRef(refFirstItem);
                		fAf.setStatus(statusFirstItem);
            			forms.add(fAf);
            		}else if("CVSO".equals(taskObj.getDescription().toUpperCase())){
            			FormAf fAf = new FormAf(new Form());
                		fAf.setItemType("DOCUMENTVISIT");
                		fAf.setShortName("Enviament de document a la historia clínica");
            			forms.add(fAf);
            			fAf = new FormAf(new Form());
            			fAf.setItemType("CATSALUT");
                		fAf.setShortName("Sol·licitud d'OCD a CatSalut");
            			fAf.setRef(refFirstItem);
                		fAf.setStatus(statusFirstItem);
            			forms.add(fAf);
            		}else if("DISCHARGE".equals(taskObj.getType())){
            			FormAf fAf = new FormAf(new Form());
                		fAf.setItemType("DOCUMENTALTA");
                		fAf.setShortName("Enviament de document a la historia clínica");
            			forms.add(fAf);
            			fAf = new FormAf(new Form());
            			fAf.setItemType("CATSALUT");
                		fAf.setShortName("Sol·licitud d'OCD a CatSalut");
            			fAf.setRef(refFirstItem);
                		fAf.setStatus(statusFirstItem);
            			forms.add(fAf);
            		}
            	}
            	tAf.setForms(forms);
            	request.setAttribute("task", tAf);
        	}
        	return mapping.findForward(SUCCESS);
    	}else{
    		return mapping.findForward(FAILURE);
    	}
    }
}
