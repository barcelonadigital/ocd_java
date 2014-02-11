/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bdigital.ocd.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.StringHolder;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.bdigital.ocd.base.BaseAction;

/**
 *
 * @author jroda
 */
public class LoginAction extends BaseAction {

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
        LoginForm formBean = (LoginForm)form;
        String username = formBean.getUsername();
        String password = formBean.getPassword();
        
        StringHolder errorMsg = new StringHolder("");
    	StringHolder token = new StringHolder("");
    	StringHolder user = new StringHolder(username);
    	StringHolder language = new StringHolder("");
    	StringHolder role = new StringHolder("");
    	StringHolder center = new StringHolder("");
    	StringHolder name = new StringHolder("");
    	proxy.session_init(user, password, "127.0.0.1", 
                "test.linkcare.es", language, token, 
                "", role, center, name, 
                errorMsg);
    	
        // perform validation
        if ("ERROR:Invalid user/password".equals(errorMsg.value)) {
        	
        	ActionMessages errors = new ActionMessages();
            errors.add("error",
                       new ActionMessage("label.logininvalid"));
            saveErrors(request, errors);
            
            return mapping.findForward(FAILURE);
        }else if (!"".equals(errorMsg.value)) {

            ActionMessages errors = new ActionMessages();
            errors.add("error",
                       new ActionMessage("errors.detail",errorMsg.value));
            saveErrors(request, errors);
            
            return mapping.findForward(FAILURE);
        }else{
        	request.getSession().setAttribute("tokenLK", token.value);
        	request.getSession().setAttribute("userFullName", name.value);
        	request.getSession().setAttribute("userCenter", center.value);
        	return mapping.findForward(SUCCESS);
        }
    }
}
