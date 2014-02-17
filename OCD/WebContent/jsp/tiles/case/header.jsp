<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <div class="cabeceraperfil">
      <div class="container">
        <div id="contentnophoto" class="content">
          <small>Pacient (case_id: <bean:write name="caseBean" property="idCase" />)</small>
          <h2><bean:write name="caseBean" property="fullname" /></h2><span><strong>Edat:</strong> <bean:write name="caseBean" property="age" /></span><span><strong>Gènere:</strong> <bean:write name="caseBean" property="sex" /></span>
          <div class="actionsbottom">
            <span class="info">
	            <strong>Protocol actual</strong>
	            <bean:write name="caseBean" property="descProtocolActual" />&nbsp;
            </span>
            <span class="info">
	            <strong>Inici del protocol</strong>
	            <bean:write name="caseBean" property="dataProtocolActual" />&nbsp;
            </span>
            <span class="info">
	            <strong>Estat del protocol</strong>
	            <bean:write name="caseBean" property="estatProtocolActual" />&nbsp;
            </span>
          </div>
          <div class="actionstop"><html:link action="/caseSearchPg" styleClass="btn btn-large">Seleccionar un altre pacient</html:link></div>
        </div>
      </div>
    </div>