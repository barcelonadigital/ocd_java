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
        <title><bean:message key="label.caseSearch"/></title>
    </head>
    <body>
		<html:messages id="msg2" property="general">
            <span style='color:red'><bean:write name="msg2" /></span>
        </html:messages>
        <h1><bean:message key="label.caseSearch"/></h1>
	    <html:form action="/caseSearchAction">
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
		    <logic:equal name="CaseSearchForm" property="showLinkCreate" value="true">
                <span style='color:red'>El pacient no existeix. Desitja donar-lo d'alta? 
		        <html:link action="/caseNewPg?join=${join}${CaseSearchForm.doJoin}">Alta</html:link>
                </span>
			</logic:equal>
		    <br>
	        <label>NIF <html:text property="nif" /></label><br>
	        <label>NIE <html:text property="nie" /></label><br>
	        <label>PAS <html:text property="pas" /></label><br>
	        <label>CIP <html:text property="cip" /></label><br>
	        
			<html:submit value="Cercar" />
	
	    </html:form>
    </body>
</html>
