<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <script>
      
      var idActivitat;
      function preAssignarProtocol(idActivitatSeleccionada) {
    	  idActivitat = idActivitatSeleccionada;
    	  $('#alertModal').modal('hide');
    	  $('#confirmationModal').modal('show');
      }
      function assignarProtocol() {
    	  assignarProtocolParam(idActivitat);
      }
      function assignarProtocolParam(paramActivitat) {
    	  var params = { idAdmission:'${admissionBean.idAdmission}', idCase:'${caseBean.idCase}', idActivity:paramActivitat };
    	  var str = $.param( params );
    	  window.location='<html:rewrite action="/caseTaskInsertAction.do"/>?'+str;
      }
    </script>
    <div class="cabeceraperfil">
      <div class="container">
        <div id="contentnophotoslim" class="content">
          <small><bean:message key="label.patient"/></small>
          <h2><bean:write name="caseBean" property="fullname" /></h2>
          <span><strong><bean:message key="label.age"/>:</strong> <bean:write name="caseBean" property="age" /></span>
          <span><strong><bean:message key="label.sex"/>:</strong> <bean:write name="caseBean" property="descSex" /></span>
          <span><strong><bean:message key="label.cip"/>:</strong> <bean:write name="caseBean" property="cip" /></span>
          <div class="contactinfo">
            <div class="dropdown">
              <a href="#" data-toggle="dropdown" class="btn-large dropdown-toggle"><bean:message key="label.contactData"/><span class="caret"></span></a>
              <div class="dropdown-menu">
              <ul>
                <bean:define id="contactItem" name="caseBean" property="contact" type="org.bdigital.ocd.model.Contact"/>
			    <logic:iterate name="contactItem" property="addresses" id="addressItem" indexId="addressIdx" type="org.bdigital.ocd.model.Address" >
                      <li><b><bean:message key="label.address"/> ${addressIdx+1}:</b></li>
                      <li><bean:write name="addressItem" property="street" />
                          <bean:write name="addressItem" property="number" />
                          <bean:message key="label.floor"/> <bean:write name="addressItem" property="floor" />
                          <bean:write name="addressItem" property="suite" /></li>
                      <li><bean:write name="addressItem" property="postcode" /> 
                          <bean:write name="addressItem" property="city" /></li>
                      <li><bean:write name="addressItem" property="country" /><br></li>
				</logic:iterate>
				<logic:iterate name="contactItem" property="phones" id="phoneItem" indexId="phoneIdx" type="org.bdigital.ocd.model.Phone" >
                      <logic:notEmpty name="phoneItem" property="number"><logic:equal name="phoneItem" property="type" value="home">
                      <li><b><bean:message key="label.phoneNumber"/>:</b></li>
                      <li><bean:write name="phoneItem" property="number" /><br></li>
                      </logic:equal></logic:notEmpty>
				</logic:iterate>
				<logic:empty name="contactItem" property="addresses">
                      <li><bean:message key="label.noAddress"/></li>
				</logic:empty>
              </ul></div>
            </div>  
          </div>
          <!-- 
          <div class="contactinfo">
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="#protocolsModal" role="button" data-toggle="modal">Històric protocols</a>
          </div>
          -->
        </div>
      </div>
    </div>
    <!-- Lightbox-->
    <div id="alertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal alert hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close"><bean:message key="label.window.close"/></button>
        <h3><bean:message key="label.window.alert"/></h3>
      </div>
      <div class="modal-body">
        <p><bean:message key="alert.taskNew.body1"/></p>
      </div>
      <div class="modal-footer">
        <div class="btn-block">
                <button onclick="assignarProtocolParam('<%=org.bdigital.ocd.utils.Constants.LINKCARE_TASKCODE_PRESCRIPTION%>')" class="btn btn-warning custom-btn btn-large"><bean:message key="label.ocdPrescription"/></button>
                <button onclick="assignarProtocolParam('<%=org.bdigital.ocd.utils.Constants.LINKCARE_TASKCODE_VISITFOLLOWUP%>')" class="btn btn-warning custom-btn btn-large"><bean:message key="label.followUpVisit"/></button>
                <button onclick="assignarProtocolParam('<%=org.bdigital.ocd.utils.Constants.LINKCARE_TASKCODE_DISCHARGE%>')" class="btn btn-warning custom-btn btn-large"><bean:message key="label.dischargeProgram"/></button>
        </div>
      </div>
    </div>
    <div id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal confirmation hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close"><bean:message key="label.window.close"/></button>
        <h3><bean:message key="alert.protocolNew.title"/></h3>
      </div>
      <div class="modal-body">
        <p>
          <bean:message key="alert.protocolNew.body1"/>
        </p>
      </div>
      <div class="modal-footer">
        <button data-dismiss="modal" aria-hidden="true" class="btn btn-success custom-btn btn-large"><bean:message key="label.review"/></button>
        <button onclick="assignarProtocol()" class="btn btn-primary custom-btn btn-large"><bean:message key="label.okAssign"/></button>
      </div>
    </div>
    <div id="protocolsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal protocols hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close"><bean:message key="label.window.close"/></button>
        <h3><bean:message key="label.assignedProtocols"/></h3>
      </div>
      <div class="modal-body table">
        <table>
          <tr>
            <th><bean:message key="label.protocol"/></th>
            <th><bean:message key="label.protocolStart"/></th>
            <th><bean:message key="label.protocolStatus"/></th>
            <th><bean:message key="label.options"/></th>
          </tr>
	    <logic:present name="admissions">
	    <logic:iterate name="admissions" id="admissionItem" type="org.bdigital.ocd.model.form.AdmissionAf" >
			<bean:define id="dataItem" name="admissionItem" property="data" type="org.bdigital.ocd.model.form.AdmissionDataAf"/>
			<bean:define id="programItem" name="dataItem" property="program" type="org.bdigital.ocd.model.form.AdmissionProgramAf"/>
			<bean:define id="protocolItem" name="dataItem" property="protocol" type="org.bdigital.ocd.model.form.AdmissionProtocolAf"/>
            <tr>
                <td><bean:write name="protocolItem" property="name"/></td>
                <td><bean:write name="dataItem" property="dateToDisplay"/></td>
                <td><bean:write name="dataItem" property="status"/></td>
                <td><html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionItem.ref}" styleClass="news-block-link"><bean:message key="label.load"/></html:link></td>
            </tr>
		</logic:iterate>
		</logic:present>
          
        </table>
      </div>
      <div class="modal-footer"></div>
    </div>