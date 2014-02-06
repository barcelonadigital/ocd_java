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
	    <title><bean:message key="label.admissionDetails"/></title>
	    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
	</head>
	<body>
	    <html:messages id="msg" property="general">
            <span style='color:red'><bean:write name="msg" /></span>
        </html:messages>
	    <html:hidden name="AdmissionDetailsForm" property="idAdmission"/>
	    <h1><bean:message key="label.admissionDetails"/></h1>
	    <html:messages id="msg3" property="error">
            <span style='color:red'><bean:write name="msg3" /></span>
        </html:messages>
	    <p>admission_id: <bean:write name="AdmissionDetailsForm" property="idAdmission" />.</p>
	    
	    <p>Nom programa: <bean:write name="AdmissionDetailsForm" property="programName" />.</p>
	    
	    <p>Data inscripció: <bean:write name="AdmissionDetailsForm" property="enrolDate" />.</p>
	    
	    <logic:present name="AdmissionDetailsForm" property="tasks">
	    Tasques afegides: 
		<ul>
	    <logic:iterate name="AdmissionDetailsForm" property="tasks" id="taskItem" type="org.bdigital.ocd.model.Task" >
			<li>Tasca: 
				<bean:write name="taskItem" property="id"/>,
				<bean:write name="taskItem" property="taskClass"/>, 
				<bean:write name="taskItem" property="type"/>, 
				<bean:write name="taskItem" property="date"/>, 
				<bean:write name="taskItem" property="hour"/>, 
				<bean:write name="taskItem" property="status"/>, 
				"<bean:write name="taskItem" property="description"/>"
				<html:link action="/taskDetailsAction?idTask=${taskItem.id}">Accedir</html:link>
			</li>
		</logic:iterate>
		</ul>
		</logic:present>
	    
	    <logic:present name="AdmissionDetailsForm" property="actions">
	    Accions disponibles: 
		<ul>
	    <logic:iterate name="AdmissionDetailsForm" property="actions" id="actionItem" type="org.bdigital.ocd.model.Action" >
			<li>Acció: 
				<bean:write name="actionItem" property="ref"/>, 
				"<bean:write name="actionItem" property="name"/>"
				<html:link action="/taskInsertAction?idAdmission=${AdmissionDetailsForm.idAdmission}" paramId="idActivity" paramName="actionItem" paramProperty="ref">Afegir</html:link>
			</li>
		</logic:iterate>
		</ul>
		</logic:present>
	    
	</body>
</html>
