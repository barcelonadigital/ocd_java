/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.task;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.Admission;
import org.bdigital.ocd.model.AdmissionData;
import org.bdigital.ocd.model.AdmissionProgram;
import org.bdigital.ocd.model.AdmissionProtocol;
import org.bdigital.ocd.model.Case;
import org.bdigital.ocd.utils.Constants;
import org.bdigital.ocd.utils.UtilsString;
import org.bdigital.ocd.utils.UtilsWs;

/**
*
* @author jroda
*/
public class TaskInsertAction extends BaseAction {

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
   	TaskInsertForm formBean = (TaskInsertForm)form;
   	
   	String tokenLK = (String)request.getSession().getAttribute("tokenLK");
   	String activityId=formBean.getIdActivity();
   	String admissionId=formBean.getIdAdmission();
   	
   	if(activityId!=null && admissionId!=null){
   	   	//TODO:Validar que si JOIN, llavors admission no tingui idProtocol assignat
   	   	//TODO: Aquesta validacio no la podria fer el WS?
   		if(activityId.indexOf("JOIN")!=-1){
	   		StringHolder errorMsg = new StringHolder("");
	       	StringHolder result = new StringHolder("");
	       	proxy.admission_get(tokenLK,admissionId,result,errorMsg);
	       	Admission admissionObj = (Admission)UtilsWs.xmlToObject(result.value,
           			Admission.class, Case.class, 
           			AdmissionData.class, AdmissionProgram.class, AdmissionProtocol.class);
       	    if(admissionObj.getData()!=null && 
       	    		admissionObj.getData().getProtocol()!=null && 
       	    		admissionObj.getData().getProtocol().getId()!=null &&
       	    		!"".equals(admissionObj.getData().getProtocol().getId())){
       	    	ActionMessages errors = new ActionMessages();
                errors.add("general",new ActionMessage("errors.alreadyJoinedToProtocol"));
                saveErrors(request, errors);
                return mapping.findForward(FAILURE);
       	    }
   		}
   		StringHolder errorMsg = new StringHolder("");
       	StringHolder result = new StringHolder("");
       	String currentTimeString = UtilsString.dateToString(new Date(), Constants.FORMAT_DATE_WS);
       	Date currentTimeZero = UtilsString.stringtoDate(currentTimeString,Constants.FORMAT_DATE_WS);
		proxy.task_insert(tokenLK,admissionId, activityId, UtilsString.dateToString(currentTimeZero, Constants.FORMAT_DATEHOUR_WS), "", result, errorMsg);
		return mapping.findForward(SUCCESS);
   	}else{
   		return mapping.findForward(FAILURE);
   	}
   }
}
