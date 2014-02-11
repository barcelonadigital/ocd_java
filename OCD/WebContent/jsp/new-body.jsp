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
          <h1>Usuaris<strong>— Pacients</strong></h1>
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
                  <label for="cip">CIP</label>
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
                  <label for="givenName">Nom</label>
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
                  <label for="birthday">Data Naixement (aaaa-mm-dd)</label>
                  <html:text styleId="birthday" property="birthday" />
                </div>
                <div class="smallfield">
                  <label for="sex">Gènere (M/F)</label>
                  <html:text styleId="sex" property="sex" />
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