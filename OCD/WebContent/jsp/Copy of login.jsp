<%-- 
    Document   : login
    Created on : 17-ene-2014, 12:00:52
    Author     : jroda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="label.login"/></title>
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
    </head>
    <body>
	    <html:messages id="msg" property="general">
            <span style='color:red'><bean:write name="msg" /></span>
        </html:messages>
        <h1><bean:message key="label.login"/></h1>
	    <html:form action="/loginAction">
	        <table class="table-login" border="0">
	            <tbody>
	                <tr>
	                    <td colspan="2">
	                       <html:messages id="msg" property="error">
			                   <span style='color:red'><bean:write name="msg" /></span>
			               </html:messages>
	                        &nbsp;</td>
	                </tr>
	                <tr>
	                    <td><bean:message key="label.username"/>:</td>
	                    <td><html:text property="username" /></td>
	                </tr>
	                <tr>
	                    <td><bean:message key="label.password"/>:</td>
	                    <td><html:password property="password" /></td>
	                </tr>
	                <tr>
	                    <td></td>
	                    <td><html:submit value="Login" /></td>
	                </tr>
	            </tbody>
	        </table>
	
	
	    </html:form>
    </body>
</html>
