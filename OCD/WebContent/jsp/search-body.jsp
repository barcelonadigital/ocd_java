<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <script>
      function doNewPatient() {
    	  document.location='<html:rewrite action="/caseNewPg.do"/>';
          return false;
      }
    </script>
    <!-- Menú principal (final)-->
    <div class="gris1">
      <div class="container">
        <!-- Encabezado-->
        <div class="encabezado bordebajo">
          <div class="h1actions">
            <html:link action="/caseNewPg.do" styleClass="btn btn-large btn-warning">Nou pacient</html:link>
          </div>
          <header>
            <h1>Usuaris<strong>— Pacients</strong></h1>
          </header>
        </div>
        <!-- Encabezado fin-->
      </div>
      <div class="menuizqlayout">
        <div class="container">
          <div class="content">
            <h2 class="clinician"><bean:message key="label.caseSearch"/></h2>
            
            <html:form action="/caseSearchAction">
			<html:messages id="msg2" property="general">
		           <span style='color:red'><bean:write name="msg2" /></span>
		    </html:messages>
		    <logic:messagesNotPresent property="general">
		        <html:messages id="msg3">
		            <span style='color:red'><bean:write name="msg3" /></span>
		        </html:messages>
		    </logic:messagesNotPresent>
            <logic:equal name="CaseSearchForm" property="showLinkCreate" value="true">
                <span style='color:red'>El pacient no existeix. Desitja donar-lo d'alta? 
		        <html:link action="/caseNewPg?join=${join}${CaseSearchForm.doJoin}">Alta</html:link>
                </span>
			</logic:equal>
            <div id="search-patient">
                <label for="nif">NIF</label>
                <html:text styleId="nif" property="nif" />
                <label for="nie">NIE</label>
                <html:text styleId="nie" property="nie" />
                <label for="pas">PAS</label>
                <html:text styleId="pas" property="pas" />
                <label for="cip">CIP</label>
                <html:text styleId="cip" property="cip" />
                
            </div>
            <div class="actions bottom">
                <html:submit styleClass="btn custom-btn btn-large btn-info" value="Cercar" />
            </div>
            </html:form>
          </div>
        </div>
      </div>
      <!-- Contenido fin-->
    </div>