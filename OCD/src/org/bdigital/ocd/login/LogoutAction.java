/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.bdigital.ocd.base.BaseAction;
import org.bdigital.ocd.model.form.ActionAf;

/**
 *
 * @author jroda
 */
public class LogoutAction extends BaseAction {

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
        
    	request.getSession().setAttribute("tokenLK", null);
    	request.getSession().setAttribute("userFullName", null);
    	request.getSession().setAttribute("userCenter", null);
    	request.getSession().setAttribute("caseBean",null);
    	request.getSession().setAttribute("admissions",null);
    	request.getSession().setAttribute("admissionsAll",null);
    	request.getSession().setAttribute("admissionBean",null);
    	request.getSession().setAttribute("actions",null);
    	request.getSession().setAttribute("actionsTransfer",null);
    	return mapping.findForward("login");
    }
}
