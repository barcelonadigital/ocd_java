<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <!-- Menú principal (final)-->
    <div class="cabeceraperfil">
      <div class="container">
        <div id="contentnophoto" class="content">
          <small>Pacient (case_id: <bean:write name="CaseDetailsForm" property="idCase" />)</small>
          <h2><bean:write name="CaseDetailsForm" property="fullname" /></h2><span><strong>Edat:</strong> <bean:write name="CaseDetailsForm" property="age" /></span><span><strong>Gènere:</strong> <bean:write name="CaseDetailsForm" property="sex" /></span>
          <div class="actionsbottom">
            <span class="info">
	            <strong>Protocol actual</strong>
	            <bean:write name="CaseDetailsForm" property="descProtocolActual" />
            </span>
            <span class="info">
	            <strong>Inici del programa</strong>
	            <bean:write name="CaseDetailsForm" property="dataProgramaActual" />
            </span>
            <span class="info">
	            <strong>Estat del programa</strong>
	            <bean:write name="CaseDetailsForm" property="estatProgramaActual" />
            </span>
          </div>
          <div class="actionstop"><html:link action="/caseSearchPg" styleClass="btn btn-large">Seleccionar un altre pacient</html:link></div>
        </div>
      </div>
    </div>
    <div class="menuizqlayout">
      <div class="container">
        <nav class="menuizq">
          <ul>
            <li><html:link action="/caseDetailsAction?idCase=${CaseDetailsForm.idCase}">Informació</html:link></li>
            <li><html:link action="/caseHistoricAction?idCase=${CaseDetailsForm.idCase}" styleClass="active">Històric</html:link></li>
            <li><html:link action="/admissionDetailsAction?idAdmission=${CaseDetailsForm.idAdmission}">Formularis</html:link></li>
          </ul>
        </nav>
        <div class="content">
            <div id="news-list">
              
	    <logic:present name="CaseDetailsForm" property="admissions">
	    <logic:iterate offset="1" name="CaseDetailsForm" property="admissions" id="admissionItem" type="org.bdigital.ocd.model.Admission" >
			<bean:define id="dataItem" name="admissionItem" property="data" type="org.bdigital.ocd.model.AdmissionData"/>
			<bean:define id="programItem" name="dataItem" property="program" type="org.bdigital.ocd.model.AdmissionProgram"/>
			<bean:define id="protocolItem" name="dataItem" property="protocol" type="org.bdigital.ocd.model.AdmissionProtocol"/>
              <html:link action="/admissionDetailsAction?idAdmission=${admissionItem.ref}" styleClass="news-block-link">
                <div class="fulldate">
                  <bean:write name="dataItem" property="dateToDisplay"/>
                </div>
                <div class="status"><strong><bean:write name="dataItem" property="status"/></strong></div>
                <div class="message">
                  <h4><bean:write name="protocolItem" property="name"/></h4>
                </div>
              </html:link>
		</logic:iterate>
		</logic:present>
              
              
            </div>
        </div>
      </div>
      <!-- Contenido fin-->
    </div>