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
	    <title><bean:message key="label.caseDetails"/></title>
	    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
	</head>
	<body>
	    <html:messages id="msg" property="general">
            <span style='color:red'><bean:write name="msg" /></span>
        </html:messages>
	    <html:hidden name="CaseDetailsForm" property="idCase"/>
	    <h1><bean:message key="label.caseDetails"/></h1>
	    <html:messages id="msg3" property="error">
            <span style='color:red'><bean:write name="msg3" /></span>
        </html:messages>
	    <p>case_id: <bean:write name="CaseDetailsForm" property="idCase" />.</p>
	    
	    <p>Nom complert: <bean:write name="CaseDetailsForm" property="fullname" />.</p>
	
	    <p>Nom abreviat: <bean:write name="CaseDetailsForm" property="nickname" />.</p>
	
	    <p>NIF: <bean:write name="CaseDetailsForm" property="nif" />.</p>
	    
	    <logic:present name="CaseDetailsForm" property="admissionsList">
	    Admissions assignades: 
		<ul>
	    <logic:iterate name="CaseDetailsForm" property="admissionsList" id="admissionItem" type="org.bdigital.ocd.model.Admission" >
			<bean:define id="dataItem" name="admissionItem" property="data" type="org.bdigital.ocd.model.AdmissionData"/>
			<bean:define id="programItem" name="dataItem" property="program" type="org.bdigital.ocd.model.AdmissionProgram"/>
			<li>Admissió: 
				<bean:write name="admissionItem" property="ref"/>, 
				"<bean:write name="programItem" property="name"/>",
				<bean:write name="dataItem" property="enrolDate"/>,
       			<bean:write name="dataItem" property="status"/>,
       			<bean:write name="dataItem" property="dateToDisplay"/>
       			<html:link action="/admissionDetailsAction?idAdmission=${admissionItem.ref}">Accedir</html:link>
			</li>
		</logic:iterate>
		</ul>
		</logic:present>
	    
	    <p><html:link action="/caseSearchPg"><bean:message key="label.caseSearch"/></html:link></p>

	    <p><html:link action="/admissionInsertAction?idCase=${CaseDetailsForm.idCase}&idProgram=2">Afegir al programa "Urban Training".</html:link></p>

	    <p><html:link action="/admissionInsertAction?idCase=${CaseDetailsForm.idCase}&idProgram=3">Afegir al programa "Renewing Health".</html:link></p>

	    <p><html:link action="/admissionInsertAction?idCase=${CaseDetailsForm.idCase}&idProgram=5">Afegir al programa "OXYGEN".</html:link></p>
	    
	</body>
</html>
