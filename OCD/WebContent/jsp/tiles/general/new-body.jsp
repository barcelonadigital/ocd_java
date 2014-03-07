<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <script>
      function doSubmit() {
          document.getElementById('newForm').submit();
          return false;
      }
    </script>
    <!-- Menú principal (final)-->
    <div class="gris1">
      <div class="container">
        <!-- Encabezado-->
        <div class="encabezado">
          <h1><strong>Pacients</strong></h1>
        </div>
        <hr>
        <!-- Encabezado fin-->
      </div>
    </div>
    <div class="menuizqlayout gris1 recentlayout">
      <div class="container">
        <div class="bloqueizq">
          <div class="recentbox">
            <h4>Recent...</h4>
          </div>
        </div>
        <div class="content">
	      <html:form styleId="newForm" action="/caseNewAction">
          <div class="contentconbotoneslaterales">
            <h2 class="clinician"><bean:message key="label.caseNew"/></h2>
			<html:messages id="msg2" property="general">
			    <div>
	            <span style='color:red'><bean:write name="msg2" /></span>
		        </div>
	        </html:messages>
	        <logic:messagesNotPresent property="general">
		        <html:messages id="msg3">
			    <div>
		            <span style='color:red'><bean:write name="msg3" /></span>
		        </div>
		        </html:messages>
		    </logic:messagesNotPresent>
            <div class="dataform">
              <h3>Dades personals</h3>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="cip"><bean:message key="label.cip"/></label>
                  <html:text styleId="cip" property="cip" />
                </div>
                <div class="smallfield">
                  <label for="nif">NIF</label>
                  <html:text styleId="nif" property="nif" />
                </div>
              </div>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="nie">NIE</label>
                  <html:text styleId="nie" property="nie" />
                </div>
                <div class="smallfield">
                  <label for="pas">PAS</label>
                  <html:text styleId="pas" property="pas" />
                </div>
              </div>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="givenName"><bean:message key="label.name"/></label>
                  <html:text styleId="givenName" property="givenName" />
                </div>
                <div class="smallfield">
                  <label for="middleName">Segon Nom</label>
                  <html:text styleId="middleName" property="middleName" />
                </div>
              </div>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="familyName">Primer Cognom</label>
                  <html:text styleId="familyName" property="familyName" />
                </div>
                <div class="smallfield">
                  <label for="familyName2">Segon Cognom</label>
                  <html:text styleId="familyName2" property="familyName2" />
                </div>
              </div>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="birthday"><bean:message key="label.birthday"/> (aaaa-mm-dd)</label>
                  <html:text styleId="birthday" property="birthday" />
                </div>
                <div class="smallfield">
                  <label for="sex"><bean:message key="label.sex"/> (M/F)</label>
                  <html:text styleId="sex" property="sex" />
                </div>
              </div>
              <h3>Dades de contacte</h3>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="streetName">Carrer</label>
                  <html:text styleId="streetName" property="streetName" />
                </div>
                <div class="smallfield">
                  <label for="number">Número</label>
                  <html:text styleId="number" property="number" />
                </div>
              </div>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="floor">Pis</label>
                  <html:text styleId="floor" property="floor" />
                </div>
                <div class="smallfield">
                  <label for="suite">Porta</label>
                  <html:text styleId="suite" property="suite" />
                </div>
              </div>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="district">Barri</label>
                  <html:text styleId="district" property="district" />
                </div>
                <div class="smallfield">
                  <label for="city">Ciutat</label>
                  <html:text styleId="city" property="city" />
                </div>
              </div>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="postcode">Codi postal</label>
                  <html:text styleId="postcode" property="postcode" />
                </div>
                <div class="smallfield">
                  <label for="state">Estat</label>
                  <html:text styleId="state" property="state" />
                </div>
              </div>
              <div class="fields-row">
                <div class="smallfield">
                  <label for="country">País</label>
                  <html:text styleId="country" property="country" />
                </div>
              </div>
            </div>
          </div>
          <div class="botoneslaterales">
            <div class="botoneslateralescontainer">
              <div>
              <html:link href="#" styleClass="btn-primary btn savedataform" onclick="return doSubmit();">Desar</html:link>
              <html:link action="/caseSearchPg.do" styleClass="btn-warning btn canceldataform">Cancel.</html:link>
              </div>
            </div>
          </div>
          </html:form>
        </div>
      </div>
      <!-- Contenido fin-->
    </div>