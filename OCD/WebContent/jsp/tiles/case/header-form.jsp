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
          <small>Pacient</small>
          <h2><bean:write name="caseBean" property="fullname" /></h2>
          <span><strong>Edat:</strong> <bean:write name="caseBean" property="age" /></span>
          <span><strong>Gènere:</strong> <bean:write name="caseBean" property="descSex" /></span>
          <span><strong>CIP:</strong> <bean:write name="caseBean" property="cip" /></span>
          <div class="contactinfo">
            <div class="dropdown">
              <a href="#" data-toggle="dropdown" class="btn-large dropdown-toggle">Dades de contacte<span class="caret"></span></a>
              <div class="dropdown-menu">
              <ul>
                <bean:define id="contactItem" name="caseBean" property="contact" type="org.bdigital.ocd.model.Contact"/>
			    <logic:iterate name="contactItem" property="addresses" id="addressItem" indexId="addressIdx" type="org.bdigital.ocd.model.Address" >
                      <li><b>Adreça ${addressIdx+1}:</b></li>
                      <li><bean:write name="addressItem" property="street" />
                          <bean:write name="addressItem" property="number" />
                          Pis <bean:write name="addressItem" property="floor" />
                          <bean:write name="addressItem" property="suite" /></li>
                      <li><bean:write name="addressItem" property="postcode" /> 
                          <bean:write name="addressItem" property="city" /></li>
                      <li><bean:write name="addressItem" property="country" /><br></li>
				</logic:iterate>
				<logic:iterate name="contactItem" property="phones" id="phoneItem" indexId="phoneIdx" type="org.bdigital.ocd.model.Phone" >
                      <logic:notEmpty name="phoneItem" property="number"><logic:equal name="phoneItem" property="type" value="home">
                      <li><b>Telèfon:</b></li>
                      <li><bean:write name="phoneItem" property="number" /><br></li>
                      </logic:equal></logic:notEmpty>
				</logic:iterate>
				<logic:empty name="contactItem" property="addresses">
                      <li>No hi ha cap adreça</li>
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
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Avís</h3>
      </div>
      <div class="modal-body">
        <p>Si us plau, seleccioni la tasca que vol realitzar:</p>
      </div>
      <div class="modal-footer">
        <div class="btn-block">
                <button onclick="assignarProtocolParam('#TASK:N253')" class="btn btn-warning custom-btn btn-large">Prescripció d'OCD</button>
                <button onclick="assignarProtocolParam('#TASK:N261')" class="btn btn-warning custom-btn btn-large">Visita de seguiment</button>
                <button onclick="assignarProtocolParam('#XDISCHARGE')" class="btn btn-warning custom-btn btn-large">Alta del programa</button>
        </div>
      </div>
    </div>
    <div id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal confirmation hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Assignar protocol?</h3>
      </div>
      <div class="modal-body">
        <p>
          Es finalitzarà el protocol actiu actualment. Desitja continuar?
        </p>
      </div>
      <div class="modal-footer">
        <button data-dismiss="modal" aria-hidden="true" class="btn btn-success custom-btn btn-large">Revisar</button>
        <button onclick="assignarProtocol()" class="btn btn-primary custom-btn btn-large">D'acord, assignar</button>
      </div>
    </div>
    <div id="protocolsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal protocols hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Protocols assignats</h3>
      </div>
      <div class="modal-body table">
        <table>
          <tr>
            <th>Protocol</th>
            <th>Inici del protocol</th>
            <th>Estat del protocol</th>
            <th>Opcions</th>
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
                <td><html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionItem.ref}" styleClass="news-block-link">Accedir</html:link></td>
            </tr>
		</logic:iterate>
		</logic:present>
          
        </table>
      </div>
      <div class="modal-footer"></div>
    </div>