<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        <nav class="menuizq">
          <ul>
            <li><html:link action="/caseDetailsAction?idCase=${caseBean.idCase}" styleClass="active">Informació</html:link></li>
            <li><html:link action="/caseHistoricAction?idCase=${caseBean.idCase}">Històric</html:link></li>
            <li><html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${caseBean.idAdmission}">Formularis</html:link></li>
          </ul>
        </nav>