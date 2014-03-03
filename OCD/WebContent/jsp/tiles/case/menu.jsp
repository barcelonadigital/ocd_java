<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        <logic:equal name="caseBean" property="isActiveMenuHistoric" value="true">
        <% request.setAttribute("historicClass","active"); %>
        </logic:equal>
        <logic:notEqual name="caseBean" property="isActiveMenuHistoric" value="true">
	        <logic:equal name="caseBean" property="isActiveMenuInfoPacient" value="true">
	        <% request.setAttribute("infoPacientClass","active"); %>
	        </logic:equal>
	        <logic:notEqual name="caseBean" property="isActiveMenuInfoPacient" value="true">
		        <logic:equal name="caseBean" property="isActiveMenuFormularis" value="true">
		        <% request.setAttribute("formularisClass","active"); %>
		        </logic:equal>
		        <logic:notEqual name="caseBean" property="isActiveMenuFormularis" value="true">
		        </logic:notEqual>
	        </logic:notEqual>
        </logic:notEqual>
        <nav class="menuizq">
          <ul>
            <!-- 
             -->
            <li><html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${caseBean.idAdmission}" styleClass="${formularisClass}">Formularis</html:link></li>
            <li><html:link action="/caseDetailsAction?idCase=${caseBean.idCase}&idAdmission=${caseBean.idAdmission}" styleClass="${infoPacientClass}">Informació pacient</html:link></li>
            <!-- 
            <li><html:link action="/caseHistoricAction?idCase=${caseBean.idCase}" styleClass="${historicClass}">Protocols anteriors</html:link></li>
             -->
          </ul>
        </nav>