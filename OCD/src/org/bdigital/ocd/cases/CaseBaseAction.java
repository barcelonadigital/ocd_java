/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.cases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.beans.AdmissionBean;
import org.bdigital.ocd.beans.CaseBean;
import org.bdigital.ocd.beans.MenuBean;
import org.bdigital.ocd.model.AIM;
import org.bdigital.ocd.model.Action;
import org.bdigital.ocd.model.Actions;
import org.bdigital.ocd.model.Address;
import org.bdigital.ocd.model.Admission;
import org.bdigital.ocd.model.AdmissionData;
import org.bdigital.ocd.model.AdmissionProgram;
import org.bdigital.ocd.model.AdmissionProtocol;
import org.bdigital.ocd.model.Admissions;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.model.Contact;
import org.bdigital.ocd.model.Data;
import org.bdigital.ocd.model.Device;
import org.bdigital.ocd.model.Mail;
import org.bdigital.ocd.model.Name;
import org.bdigital.ocd.model.Phone;
import org.bdigital.ocd.model.form.ActionAf;
import org.bdigital.ocd.model.form.AdmissionAf;
import org.bdigital.ocd.model.form.CaseAf;
import org.bdigital.ocd.utils.AdmissionComparator;
import org.bdigital.ocd.utils.Constants;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.utils.UtilsWs;

/**
 *
 * @author jroda
 */
public abstract class CaseBaseAction extends BaseAction {

    protected CaseBean caseBean;
    protected MenuBean menuBean;
    protected AdmissionBean admissionBean;
    
	public abstract ActionForward doCaseExecute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception;

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
    	CaseBaseForm formBean = (CaseBaseForm)form;
    	
    	caseBean = new CaseBean();
    	menuBean = new MenuBean();
    	admissionBean = new AdmissionBean();
    	request.setAttribute("menuBean",menuBean);
    	
    	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
    	String caseId=(String)request.getAttribute("case_id")!=null?(String)request.getAttribute("case_id"):formBean.getIdCase();
    	
    	CaseBean caseBeanStored = (CaseBean) request.getSession().getAttribute("caseBean");

		if(caseId==null){
			return mapping.findForward(FAILURE);
		}

    	if(caseId!=null && caseBeanStored!=null && caseId.equals(caseBeanStored.getIdCase())){
    		caseBean = caseBeanStored;
    	}else if(caseId!=null && (caseBeanStored==null || !caseId.equals(caseBeanStored.getIdCase()))){
    		
    		StringHolder errorMsg = new StringHolder("");
        	StringHolder result = new StringHolder("");
        	proxy.case_get(tokenLK,caseId,result,errorMsg);
        	
        	Case caseGet = (Case)UtilsWs.xmlToObject(result.value,Case.class,
    				Data.class);
        	CaseAf caseGetAf = new CaseAf(caseGet);
        	if(caseGetAf.getData()!=null){
        		caseBean.setFullname(caseGetAf.getData().getFullname());
        		caseBean.setNickname(caseGetAf.getData().getNickname());
        		caseBean.setBirthday(caseGetAf.getData().getBdate());
        		caseBean.setAge(caseGetAf.getData().getAge());
        		caseBean.setSex(caseGetAf.getData().getGender());
        		caseBean.setDescSex(caseGetAf.getData().getDescGender());
        	}
        	caseBean.setNick(caseGetAf.getNick());
			caseBean.setNif(caseGetAf.getNif());
			caseBean.setNie(caseGetAf.getNie());
			caseBean.setPas(caseGetAf.getPas());
			caseBean.setCip(caseGetAf.getCip());
        	caseBean.setIdCase(caseId);
        	formBean.setIdCase(caseId);
        	
        	errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.case_get_contact(tokenLK,caseId,result,errorMsg);

        	Contact contact = (Contact)UtilsWs.xmlToObject(result.value,Contact.class,Name.class,
        			Address.class,Mail.class,AIM.class,Device.class,Phone.class);
        	caseBean.setContact(contact);

        	request.getSession().setAttribute("caseBean",caseBean);
    	}
    	
    	String admissionId=(String)request.getAttribute("admission_id")!=null?(String)request.getAttribute("admission_id"):formBean.getIdAdmission();
    	
    	AdmissionBean admissionBeanStored = (AdmissionBean) request.getSession().getAttribute("admissionBean");

    	if(admissionId!=null && admissionBeanStored!=null && admissionId.equals(admissionBeanStored.getIdAdmission())){
    		admissionBean = admissionBeanStored;
    	}else{
    		StringHolder errorMsg = new StringHolder("");
    		StringHolder result = new StringHolder("");
        	proxy.admission_list_case(tokenLK,caseId, "true", result, errorMsg);
        	List<AdmissionAf> admissions = new ArrayList<AdmissionAf>();
        	List<AdmissionAf> admissionsAll = new ArrayList<AdmissionAf>();
        	Admissions admissionListCase = (Admissions)UtilsWs.xmlToObject(result.value,
        			Admissions.class, Admission.class, Case.class, 
        			AdmissionData.class, AdmissionProgram.class, AdmissionProtocol.class);
//    		String admStr = "";
        	if(admissionListCase.getAdmissions()!=null){
        		for(int i=0;i<admissionListCase.getAdmissions().size();i++){
        			Admission adm = admissionListCase.getAdmissions().get(i);
        			AdmissionAf admAf = new AdmissionAf(adm);
//        			admStr+="<Ref:"+adm.getRef()
//            				+",ProgramDescription:"+adm.getData().getProgram().getDescription()
//            				+",EnrolDate:"+adm.getData().getEnrolDate()
//            				+",Status:"+adm.getData().getStatus()
//            				+",DateToDisplay:"+adm.getData().getDateToDisplay()+"> ";
        			if(admAf.getData()!=null && admAf.getData().getProgram()!=null && 
        					"6".equals(admAf.getData().getProgram().getId())){
        				if(admAf.getData().getProtocol()!=null &&
        						!"".equals(admAf.getData().getProtocol().getId())){
        					//TODO:cal corregir WS: la seguent crida no hauria de caler fer pq ja hauria de contenir el name. 
        					if(admAf.getData().getProtocol().getName()==null || 
        							"".equals(admAf.getData().getProtocol().getName().trim())){
        						errorMsg = new StringHolder("");
        		            	result = new StringHolder("");
        		    			proxy.admission_get(tokenLK, adm.getRef(), result, errorMsg);
        		    			Admission admissionObj = (Admission)UtilsWs.xmlToObject(result.value,
        		            			Admission.class, Case.class, 
        		            			AdmissionData.class, AdmissionProgram.class, AdmissionProtocol.class);
        		    			admAf.getData().getProtocol().setName(admissionObj.getData().getProtocol().getName());
        		    			admAf.getData().getProtocol().setDescription(admissionObj.getData().getProtocol().getDescription());
        					}
        					admissions.add(admAf);
        				}
        				admissionsAll.add(admAf);
        			}
        		}
        	}
        	Collections.sort(admissions, new AdmissionComparator());
        	Collections.sort(admissionsAll, new AdmissionComparator());
        	Collections.reverse(admissions);
        	Collections.reverse(admissionsAll);
        	//caseBean.setAdmissionsText(admStr);
    		request.getSession().setAttribute("admissions",admissions);
        	request.getSession().setAttribute("admissionsAll",admissionsAll);
    		boolean ferAdmissionInsert = false;
    		if(admissionsAll.size()>0){
        		AdmissionAf a = admissionsAll.get(0);
        		if(a.getData()!=null && !"ENROLLED".equals(a.getData().getStatus()) && 
        				!"PAUSED".equals(a.getData().getStatus()) && 
        				!"ACTIVE".equals(a.getData().getStatus())){
        			ferAdmissionInsert = true;
        		}
    		}else{
    			ferAdmissionInsert = true;
    		}
    		if(ferAdmissionInsert){
    			//TODO: enlloc de passar el parametre "6", obtenir la action_list disponible per current_date, i si esta el #ENROL:6 , passar aquest idProgram
    			errorMsg = new StringHolder("");
            	result = new StringHolder("");
            	String currentTimeString = UtilsString.dateToString(new Date(), Constants.FORMAT_DATE_WS);
            	Date currentTimeZero = UtilsString.stringtoDate(currentTimeString,Constants.FORMAT_DATE_WS);
    			proxy.admission_insert(tokenLK, caseId, "#XENROLL:6", UtilsString.dateToString(currentTimeZero, Constants.FORMAT_DATEHOUR_WS), result, errorMsg);
    			Admission a = new Admission();
            	a.setRef(result.value);
            	AdmissionData ad = new AdmissionData();
            	AdmissionProgram apg = new AdmissionProgram();
            	AdmissionProtocol apt = new AdmissionProtocol();
            	a.setData(ad);
            	ad.setProgram(apg);
            	ad.setProtocol(apt);
            	ad.setStatus("ENROLLED");
            	admissionsAll.add(0,new AdmissionAf(a));
    		}
    		AdmissionAf admissionFirst = admissionsAll.get(0);
    		AdmissionAf admissionSelected=null;
    		if(admissionId!=null && 
    				!"".equals(admissionId)){
    			for(int i=0;i<admissionsAll.size();i++){
    				AdmissionAf adm = admissionsAll.get(i);
        			if(adm.getRef().equals(admissionId)){
        				admissionSelected = adm;
        			}
    			}
    		}
    		if(admissionSelected==null){
	    		admissionSelected = admissionFirst;
    		}
    		admissionBean.setIdAdmission(admissionSelected.getRef());
    		admissionBean.setIdAdmissionFirst(admissionFirst.getRef());
    		if(admissionSelected.getData()!=null){
        		if(admissionSelected.getData().getProtocol()!=null 
        				&& admissionSelected.getData().getProtocol().getId()!=null 
        				&& !"".equals(admissionSelected.getData().getProtocol().getId())){
        			admissionBean.setDescProtocolActual(admissionSelected.getData().getProtocol().getName());
        			admissionBean.setDataProtocolActual(admissionSelected.getData().getAdmissionDate());
        			admissionBean.setDataInscripcioAdmissio(admissionSelected.getData().getEnrolDate());
        			admissionBean.setEstatProtocolActual(admissionSelected.getData().getDescStatus());
        		}
    		}
    		errorMsg = new StringHolder("");
        	result = new StringHolder("");
        	proxy.action_list(tokenLK,"","MNG",admissionFirst.getRef(),"","",result,errorMsg);
        	List<ActionAf> actions = new ArrayList<ActionAf>();
        	List<ActionAf> actionsTransfer = new ArrayList<ActionAf>();
        	Actions actionsObj = (Actions)UtilsWs.xmlToObject(result.value,
        			Actions.class, Action.class);
        	boolean containsTransfer = false;
        	if(actionsObj.getActions()!=null){
        		for(int i=0;i<actionsObj.getActions().size();i++){
        			Action act = actionsObj.getActions().get(i);
            		ActionAf actAf = new ActionAf(act);
        			if("#XPATH:TRANSFER".equals(act.getRef())){
        				containsTransfer = true;
        			}else{
        				actions.add(actAf);
        			}
        		}
        	}
        	//formBean.setActions(actions);
        	if(containsTransfer){
        		errorMsg = new StringHolder("");
            	result = new StringHolder("");
            	proxy.action_list(tokenLK,"","MNG",admissionFirst.getRef(),"","#XPATH:TRANSFER",result,errorMsg);
            	actionsObj = (Actions)UtilsWs.xmlToObject(result.value,
            			Actions.class, Action.class);
            	//formBean.setActionsTransfer(actionsObj.getActions());
            	for(int i=0;i<actionsObj.getActions().size();i++){
        			Action act = actionsObj.getActions().get(i);
            		ActionAf actAf = new ActionAf(act);
            		actionsTransfer.add(actAf);
            	}
        	}
        	for(int i = 0; i<actions.size();){
        		ActionAf obj = actions.get(i);
        		if("#XDISCHARGE".equals(obj.getRef())){
        			obj.setDescription("Alta del protocol");
        			obj.setName("Alta del protocol");
        		}else if("#XREJECT".equals(obj.getRef())){
        			obj.setDescription("Rebuig del protocol");
        			obj.setName("Rebuig del protocol");
        		}else if("#XPAUSE".equals(obj.getRef())){
        			obj.setDescription("Pausa del protocol");
        			obj.setName("Pausa del protocol");
        		}else if("#XRESUME".equals(obj.getRef())){
        			obj.setDescription("Reactivació del protocol");
        			obj.setName("Reactivació del protocol");
        		} 
        		if("#XJOIN:15".equals(obj.getRef()) || 
        				"#XJOIN:16".equals(obj.getRef())){
        			actions.remove(obj);
        		}else{
        			i++;
        		}
        	}
        	for(int i = 0; i<actionsTransfer.size();){
        		ActionAf obj = actionsTransfer.get(i); 
        		if("#XTRANSFER_15".equals(obj.getRef()) || 
        				"#XTRANSFER_16".equals(obj.getRef())){
        			actionsTransfer.remove(obj);
        		}else{
        			i++;
        		}
        	}
        	request.getSession().setAttribute("admissionBean",admissionBean);
        	request.getSession().setAttribute("actions",actions);
        	request.getSession().setAttribute("actionsTransfer",actionsTransfer);
    	}
    	
    	
    	return doCaseExecute(mapping, form, request, response);
    }
}
