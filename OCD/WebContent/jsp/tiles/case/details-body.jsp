<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        <div class="content contabs">
          <html:form styleId="newForm2" action="/caseDetailsAction">
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
                      <label for="district">Barri</label>
                      <html:text name="CaseDetailsForm" styleId="district" property="district" disabled="true" />
                    </div>
                    <div class="smallfield">
                      <label for="city">Ciutat</label>
                      <html:text name="CaseDetailsForm" styleId="city" property="city" disabled="true" />
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="postcode">Codi postal</label>
                      <html:text name="CaseDetailsForm" styleId="postcode" property="postcode" disabled="true" />
                    </div>
                    <div class="smallfield">
                      <label for="state">Estat</label>
                      <html:text name="CaseDetailsForm" styleId="state" property="state" disabled="true" />
                    </div>
                  </div>
                  <div class="fields-row">
                    <div class="smallfield">
                      <label for="country">País</label>
                      <html:text name="CaseDetailsForm" styleId="country" property="country" disabled="true" />
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
	            <a href="#" class="btn-primary btn savedataform">Desar</a>
	            <a href="#" class="btn-warning btn canceldataform">Cancel.</a>
              </div>
            </div>
          </div>
          </html:form>
        </div>