<%-- 
    Document   : success
    Created on : 17-ene-2014, 12:06:05
    Author     : jroda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>Pantalla principal</title>
	    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
	</head>
	<body>
	    <h1>Pantalla principal</h1>
	
	    <p><html:link action="/caseSearchPg"><bean:message key="label.caseSearch"/></html:link></p>
	
	    <p><html:link action="/caseSearchPg?join=true"><bean:message key="label.caseSearchAndJoin"/></html:link></p>
	</body>
</html>
