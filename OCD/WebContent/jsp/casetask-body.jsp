<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <!-- Menú principal (final)-->
    <div class="menuizqlayout">
      <div class="container">
        <nav class="menuizq">
          <ul>
            <li><html:link action="/caseDetailsAction?idCase=${CaseDetailsForm.idCase}">Informació</html:link></li>
            <li><html:link action="/caseHistoricAction?idCase=${CaseDetailsForm.idCase}">Històric</html:link></li>
            <li><html:link action="/admissionDetailsAction?idAdmission=${CaseDetailsForm.idAdmission}">Formularis</html:link></li>
          </ul>
        </nav>
        <div class="content">
            <div id="news-list">
              
	        <logic:present name="TaskDetailsForm" property="forms">
		    <logic:iterate name="TaskDetailsForm" property="forms" id="formItem" type="org.bdigital.ocd.model.Form" >
				
				  <html:link action="/formDetailsAction?idForm=${formItem.ref}" styleClass="news-block-link">
	                <div class="fulldate">
	                  <bean:write name="formItem" property="ref"/>
	                </div>
	                <div class="status">
	                  <strong><bean:write name="formItem" property="status"/></strong>
	                </div>
	                <div class="message">
	                  <h4><bean:write name="formItem" property="shortName"/></h4>
	                </div>
	              </html:link>
			</logic:iterate>
			</logic:present>
              
              
            </div>
        </div>
      </div>
      <!-- Contenido fin-->
    </div>