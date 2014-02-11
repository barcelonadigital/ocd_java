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
    <div class="menuizqlayout gris1">
      <div class="container">
        <nav class="menuizq">
          <ul>
            <li><html:link action="/caseDetailsAction?idCase=${CaseDetailsForm.idCase}" styleClass="active">Informació</html:link></li>
            <li><html:link action="/caseHistoricAction?idCase=${CaseDetailsForm.idCase}">Històric</html:link></li>
            <li><html:link action="/admissionDetailsAction?idAdmission=${CaseDetailsForm.idAdmission}">Formularis</html:link></li>
          </ul>
        </nav>
        <div class="content contabs">
          <html:form styleId="newForm" action="/caseNewAction">
          <div class="contentconbotoneslaterales">
            <div class="tabbable">
              <!-- Only required for left/right tabs-->
              <ul class="nav nav-tabs">
                <li class="active"><a href="#tab1" data-toggle="tab">Clinical data</a></li>
                <li><a href="#tab2" data-toggle="tab">Assesments</a></li>
                <li><a href="#tab3" data-toggle="tab">Personal data</a></li>
                <li><a href="#tab4" data-toggle="tab">Contact data</a></li>
              </ul>
              <div class="tab-content">
                <div id="tab1" class="tab-pane dataform active">
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="cip">CIP</label>
                      <html:text name="CaseDetailsForm" styleId="cip" property="cip" disabled="true" />
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
                      <label for="birthday">Data Naixement (aaaa-mm-dd)</label>
                      <html:text name="CaseDetailsForm" styleId="birthday" property="birthday" disabled="true" />
                    </div>
                    <div class="smallfield">
                      <label for="sex">Gènere (M/F)</label>
                      <html:text name="CaseDetailsForm" styleId="sex" property="sex" disabled="true" />
                    </div>
                  </div>
                </div>
                <div id="tab2" class="tab-pane dataform">
                  <div class="fields-row">
                    <div class="bigfield">
                      <label for="first_name">First name</label>
                      <input name="first_name" type="text" value="Marc">
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="first_name">First name</label>
                      <input name="first_name" type="text" value="Marc">
                    </div>
                    <div class="smallfield">
                      <label for="last_name">Last name</label>
                      <input name="last_name" type="text" value="Solà">
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="user_name">User name</label>
                      <input name="user_name" type="text" value="clinicasec">
                    </div>
                    <div class="smallfield">
                      <label for="work_experience">Work experience</label>
                      <input name="work_experience" type="text" value="5 years">
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="first_name">First name</label>
                      <input name="first_name" type="text" value="Marc">
                    </div>
                  </div>
                </div>
                <div id="tab3" class="tab-pane dataform">
                  <h3>About the patient</h3>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="last_name">Last name</label>
                      <input name="last_name" type="text" value="Solà">
                    </div>
                    <div class="smallfield">
                      <label for="user_name">User name</label>
                      <input name="user_name" type="text" value="clinicasec">
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="work_experience">Work experience</label>
                      <input name="work_experience" type="text" value="5 years">
                    </div>
                    <div class="smallfield">
                      <label for="first_name">First name</label>
                      <input name="first_name" type="text" value="Marc">
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="last_name">Last name</label>
                      <input name="last_name" type="text" value="Solà">
                    </div>
                    <div class="smallfield">
                      <label for="user_name">User name</label>
                      <input name="user_name" type="text" value="clinicasec">
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="work_experience">Work experience</label>
                      <input name="work_experience" type="text" value="5 years">
                    </div>
                    <div class="smallfield">
                      <label for="phone_option[]">Contact phone
                        <div class="multiple input-prepend">
                          <div class="btn-group">
                            <button data-toggle="dropdown" class="btn btn-large dropdown-toggle">Mobile<span class="caret triangulo"></span></button>
                            <ul class="dropdown-menu">
                              <li><a href="#">Personal</a></li>
                              <li><a href="#">Mobile</a></li>
                              <li><a href="#">Work</a></li>
                            </ul>
                            <input id="prependedDropdownButton" name="phone_input[]" type="text" value="+34 222 444 777">
                            <button class="btn btn-large btn-warning right remove">Remove</button>
                          </div>
                          <div class="btn-group">
                            <button data-toggle="dropdown" class="btn btn-large dropdown-toggle">Work<span class="caret triangulo"></span></button>
                            <ul class="dropdown-menu">
                              <li><a href="#">Personal</a></li>
                              <li><a href="#">Mobile</a></li>
                              <li><a href="#">Work</a></li>
                            </ul>
                            <input id="prependedDropdownButton" name="phone_input[]" type="text" value="+34 999 555 111">
                            <button class="btn btn-large btn-warning right remove">Remove</button>
                          </div>
                          <button class="btn btn-large btn-info add">Add</button>
                        </div>
                      </label>
                    </div>
                  </div>
                  <div class="fields-group clearfix">
                    <div class="fg-header">
                      <div class="h3actions"><a href="#" class="remove">Remove Caregiver</a></div>
                      <h3>Caregiver</h3>
                    </div>
                    <div class="fields-row">
                      <div class="smallfield">
                        <label for="last_name">Last name</label>
                        <input name="last_name" type="text" value="Solà">
                      </div>
                      <div class="smallfield">
                        <label for="user_name">User name</label>
                        <input name="user_name" type="text" value="clinicasec">
                      </div>
                    </div>
                    <div class="fields-row">
                      <div class="smallfield">
                        <label for="work_experience">Work experience</label>
                        <input name="work_experience" type="text" value="5 years">
                      </div>
                      <div class="smallfield">
                        <label for="first_name">First name</label>
                        <input name="first_name" type="text" value="Marc">
                      </div>
                    </div>
                    <div class="fields-row">
                      <div class="smallfield">
                        <label for="last_name">Last name</label>
                        <input name="last_name" type="text" value="Solà">
                      </div>
                      <div class="smallfield">
                        <label for="user_name">User name</label>
                        <input name="user_name" type="text" value="clinicasec">
                      </div>
                    </div>
                    <div class="fields-row">
                      <div class="smallfield">
                        <label for="work_experience">Work experience</label>
                        <input name="work_experience" type="text" value="5 years">
                      </div>
                      <div class="smallfield">
                        <label for="phone_option[]">Contact phone
                          <div class="multiple input-prepend">
                            <div class="btn-group">
                              <button data-toggle="dropdown" class="btn btn-large dropdown-toggle">Mobile<span class="caret triangulo"></span></button>
                              <ul class="dropdown-menu">
                                <li><a href="#">Personal</a></li>
                                <li><a href="#">Mobile</a></li>
                                <li><a href="#">Work</a></li>
                              </ul>
                              <input id="prependedDropdownButton" name="phone_input[]" type="text" value="+34 222 444 777">
                              <button class="btn btn-large btn-warning right remove">Remove</button>
                            </div>
                            <div class="btn-group">
                              <button data-toggle="dropdown" class="btn btn-large dropdown-toggle">Work<span class="caret triangulo"></span></button>
                              <ul class="dropdown-menu">
                                <li><a href="#">Personal</a></li>
                                <li><a href="#">Mobile</a></li>
                                <li><a href="#">Work</a></li>
                              </ul>
                              <input id="prependedDropdownButton" name="phone_input[]" type="text" value="+34 999 555 111">
                              <button class="btn btn-large btn-warning right remove">Remove</button>
                            </div>
                            <button class="btn btn-large btn-info add">Add</button>
                          </div>
                        </label>
                      </div>
                    </div>
                    <div class="fields-row">
                      <div class="smallfield">
                        <label for="last_name">Email</label>
                        <input name="last_name" type="text" value="chewacca@hotmail.com">
                      </div>
                    </div>
                  </div>
                  <button class="btn btn-large btn-info add-fields-group">Add Caregiver</button>
                </div>
                <div id="tab4" class="tab-pane dataform">
                  <div class="fields-row">
                    <div class="bigfield">
                      <label for="first_name">First name</label>
                      <input name="first_name" type="text" value="Marc">
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="last_name">Last name</label>
                      <input name="last_name" type="text" value="Solà">
                    </div>
                    <div class="smallfield">
                      <label for="user_name">User name</label>
                      <input name="user_name" type="text" value="clinicasec">
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="work_experience">Work experience</label>
                      <input name="work_experience" type="text" value="5 years">
                    </div>
                    <div class="smallfield">
                      <label for="first_name">First name</label>
                      <input name="first_name" type="text" value="Marc">
                    </div>
                  </div>
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
	            <a href="#" class="btn-primary btn savedataform">Desar</a>
	            <a href="#" class="btn-warning btn canceldataform">Cancel.</a>
              </div>
            </div>
          </div>
          </html:form>
        </div>
      </div>
      <!-- Contenido fin-->
    </div>