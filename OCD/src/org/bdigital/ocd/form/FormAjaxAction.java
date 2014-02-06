/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.form;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.base.BaseAction;

/**
 *
 * @author jroda
 */
public class FormAjaxAction extends BaseAction {

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
    	
    	PrintWriter out = response.getWriter();
	    String content=(String)request.getParameter("messsage");
	    String subject=(String)request.getParameter("subject");
	    if(content.length()>500 || subject.length()>50)
	        out.println("Subject/Content Length is too Long");
	    if(subject.length()<5 || content.length()<10)
	        out.println("Subject/Content Length is too Short");
	    else
	        out.println("Subject/Content OK");
	    out.flush();
	    return(null);
    }

}
