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
        <title><bean:message key="label.caseNew"/></title>
    </head>
    <body>
		<html:messages id="msg2" property="general">
            <span style='color:red'><bean:write name="msg2" /></span>
        </html:messages>
        <h1><bean:message key="label.caseNew"/></h1>
	    <html:form action="/caseNewAction">
	        <%if(request.getParameter("join")!=null && "true".equals(request.getParameter("join"))){%>
	        <html:hidden property="doJoin" value="true"/>
	        <%}else{%>
	        <html:hidden property="doJoin"/>
	        <%}%>
	        <logic:messagesNotPresent property="general">
		        <html:messages id="msg3">
		            <span style='color:red'><bean:write name="msg3" /></span>
		        </html:messages>
		    </logic:messagesNotPresent>
		    <br>
		    <label>NIF <html:text property="nif" /></label><br>
	        <label>NIE <html:text property="nie" /></label><br>
	        <label>PAS <html:text property="pas" /></label><br>
	        <label>CIP <html:text property="cip" /></label><br>
	        
	        <label>Nom <html:text property="givenName" /></label><br>
	        <label>Segon nom <html:text property="middleName" /></label><br>
	        <label>Primer Cognom <html:text property="familyName" /></label><br>
	        <label>Segon Cognom <html:text property="familyName2" /></label><br>
	        <label>Data Naixement (aaaa-mm-dd) <html:text property="birthday" /></label><br>
	        <label>Gènere (M/F) <html:text property="sex" /></label><br>
			
			<html:submit value="Desar" />
	
	    </html:form>
    </body>
</html>
