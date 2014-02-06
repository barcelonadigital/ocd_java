<%-- 
    Document   : success
    Created on : 17-ene-2014, 12:06:05
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
	    <title><bean:message key="label.taskDetails"/></title>
	    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
	</head>
	<body>
	    <html:messages id="msg" property="general">
            <span style='color:red'><bean:write name="msg" /></span>
        </html:messages>
	    <html:hidden name="TaskDetailsForm" property="idTask"/>
	    <h1><bean:message key="label.taskDetails"/></h1>
	    <html:messages id="msg3" property="error">
            <span style='color:red'><bean:write name="msg3" /></span>
        </html:messages>
	    <p>id: <bean:write name="TaskDetailsForm" property="idTask" />.</p>
	    
	    <logic:present name="TaskDetailsForm" property="forms">
	    Formularis: 
		<ul>
	    <logic:iterate name="TaskDetailsForm" property="forms" id="formItem" type="org.bdigital.ocd.model.Form" >
			<li>Formulari: 
				<bean:write name="formItem" property="ref"/>,
				"<bean:write name="formItem" property="shortName"/>",
				<bean:write name="formItem" property="status"/>
				<html:link action="/formDetailsAction?idForm=${formItem.ref}">Accedir</html:link>
				<html:link action="/formCloseAction?idTask=${TaskDetailsForm.idTask}&idForm=${formItem.ref}">Tancar</html:link>
				<html:link action="/formOpenAction?idTask=${TaskDetailsForm.idTask}&idForm=${formItem.ref}">Obrir</html:link>
			</li>
		</logic:iterate>
		</ul>
		</logic:present>
	    
	</body>
</html>
