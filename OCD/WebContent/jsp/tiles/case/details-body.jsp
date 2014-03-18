<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
	    <script type="text/javascript">
		    function doSave() {
	          document.getElementById('newForm2').submit();
	          return false;
	        }
	    </script>
        <div class="content contabs">
          <html:form styleId="newForm2" action="/caseSaveAction">
          <html:hidden name="CaseDetailsForm" property="idCase" />
          <div class="contentconbotoneslaterales">
            <div class="tabbable">
              <!-- Only required for left/right tabs-->
              <ul class="nav nav-tabs">
                <li class="active"><a href="#tab1" data-toggle="tab">Dades personals</a></li>
                <li><a href="#tab2" data-toggle="tab">Dades de contacte</a></li>
              </ul>
              <div class="tab-content">
                <div id="tab1" class="tab-pane dataform active">
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="cip">CIP</label>
                      <html:text name="CaseDetailsForm" styleId="cip" property="cip" disabled="true" readonly="true" />
                    </div>
                    <div class="smallfield">
                      <label for="nif">NIF</label>
                      <html:text name="CaseDetailsForm" styleId="nif" property="nif" disabled="true" />
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="nie">NIE</label>
                      <html:text name="CaseDetailsForm" styleId="nie" property="nie" disabled="true" />
                    </div>
                    <div class="smallfield">
                      <label for="pas">PAS</label>
                      <html:text name="CaseDetailsForm" styleId="pas" property="pas" disabled="true" />
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="birthday">Data Naixement</label>
                      <html:text name="CaseDetailsForm" styleId="birthday" property="birthday" disabled="true" />
	                  <script>
				        $( "#birthday" ).datepicker();
				      </script>
                    </div>
                    <div class="smallfield">
                      <label for="descSex">Gènere</label>
	                  <div class="btn-group">
	                    <html:hidden property="descSex" styleId="descSex" />
	                    <button disabled="disabled" data-toggle="dropdown" data-target="descSex" class="btn btn-large dropdown-toggle disabled"><bean:write name="CaseDetailsForm" property="descSex" /><span class="caret triangulo"></span></button>
	                    <ul class="dropdown-menu">
	                      <li><a href="#"><bean:message key="label.sex.dona"/></a></li>
	                      <li><a href="#"><bean:message key="label.sex.home"/></a></li>
	                    </ul>
	                  </div>
                    </div>
                  </div>
                </div>
                <div id="tab2" class="tab-pane dataform">
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="streetName">Carrer</label>
                      <html:text name="CaseDetailsForm" styleId="streetName" property="streetName" disabled="true" />
                    </div>
                    <div class="smallfield">
                      <label for="number">Número</label>
                      <html:text name="CaseDetailsForm" styleId="number" property="number" disabled="true" />
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="floor">Pis</label>
                      <html:text name="CaseDetailsForm" styleId="floor" property="floor" disabled="true" />
                    </div>
                    <div class="smallfield">
                      <label for="suite">Porta</label>
                      <html:text name="CaseDetailsForm" styleId="suite" property="suite" disabled="true" />
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="postcode">Codi postal</label>
                      <html:text name="CaseDetailsForm" styleId="postcode" property="postcode" disabled="true" />
                    </div>
                    <div class="smallfield">
                      <label for="city">Ciutat</label>
                      <html:text name="CaseDetailsForm" styleId="city" property="city" disabled="true" />
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="country">País</label>
                      <html:text name="CaseDetailsForm" styleId="country" property="country" disabled="true" />
                    </div>
                    <div class="smallfield">
                      <label for="phoneNumber">Telèfon</label>
                      <html:text name="CaseDetailsForm" styleId="phoneNumber" property="phoneNumber" disabled="true" />
                    </div>
                  </div>
                  <!-- 
                  <button onclick="" class="btn btn-large btn-info add-fields-group">Afegir adreça</button>
                   -->
                </div>
              </div>
            </div>
          </div>
          <div class="botoneslaterales">
            <div class="botoneslateralescontainer">
              <div class="viewform"> 
              	<a href="#" class="btn-primary btn editdataform">Editar</a>
              </div>
              <div class="editform">
	            <a onclick="doSave()" href="#" class="btn-primary btn savedataform">Desar</a>
	            <a href="#" class="btn-warning btn canceldataform">Cancel.</a>
              </div>
            </div>
          </div>
          </html:form>
        </div>