<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <script>
      function doNewPatient() {
    	  document.location='<html:rewrite action="/caseNewPg.do"/>';
          return false;
      }
      $(document).ready(function() {
          $('#linkNew2').click(function(e){
        	  e.preventDefault();
        	  $('#doNew').val('true');
        	  $('#formSearch').submit();
          });
          $('#linkNew').click(function(e){
        	  e.preventDefault();
        	  var params = { doNew:'true', cip:$('#cip').val(), nif:$('#nif').val(), nie:$('#nie').val(), pas:$('#pas').val() };
        	  var str = $.param( params );
        	  document.location='<html:rewrite action="/caseSearchAction.do"/>?'+str;
          });
      });
    </script>
    <!-- Menú principal (final)-->
    <div class="gris1">
      <div class="container">
        <!-- Encabezado-->
        <div class="encabezado bordebajo">
          <div class="h1actions">
            <a href="#confirmNewModal" role="button" data-toggle="modal" class="btn btn-large btn-warning">Nou pacient</a>
          </div>
          <header>
            <h1>Usuaris <strong>— Pacients</strong></h1>
          </header>
        </div>
        <!-- Encabezado fin-->
      </div>
      <div class="menuizqlayout">
        <div class="container">
          <div class="content">
            <h2 class="clinician"><bean:message key="label.caseSearch"/></h2>
            
            <html:form styleId="formSearch" action="/caseSearchAction">
            <html:hidden name="CaseNewForm" property="doNew" styleId="doNew"/>
			<html:messages id="msg2" property="general">
		           <span style='color:red'><bean:write name="msg2" /></span>
		    </html:messages>
		    <logic:messagesNotPresent property="general">
		        <html:messages id="msg3">
		            <span style='color:red'><bean:write name="msg3" /></span>
		        </html:messages>
		    </logic:messagesNotPresent>
            <logic:equal name="CaseNewForm" property="showLinkCreate" value="true">
                <span style='color:red'>El pacient no existeix. Desitja donar-lo d'alta? 
		        <html:link styleId="linkNew" href="#">Alta</html:link>
                </span>
			</logic:equal>
            <div id="search-patient">
                <label for="searchStr">
                Cerca per tots els camps
				<a href="#info1" role="button" data-toggle="modal" class="info_popup">Info</a>               
                </label>
                <html:text styleId="searchStr" property="searchStr" />
                
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
    <!-- Lightboxes-->
    <div id="info1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal detail hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Seleccionar pacient</h3>
      </div>
      <div class="modal-body">
        <h4>Sobre quins camps es realitza la cerca?</h4>
        <p><strong>CIP i NHC</strong>, en cas de pacients que existeixin al <strong>HIS</strong>.</p>
        <p><strong>CIP, NHC, NIF, NIE, passaport, nom, cognoms i telèfon</strong>, en cas de pacients que existeixin al <strong>Open Health Practice</strong>.</p>
      </div>
    </div>
    <div id="confirmNewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal confirmation hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>El HIS no s'actualitzarà</h3>
      </div>
      <div class="modal-body">
        <p>
          El pacient només es crearà al Open Health Practice. <br/>El HIS s'haurà d'actualitzar a part. Desitja continuar?
        </p>
      </div>
      <div class="modal-footer">
        <button data-dismiss="modal" aria-hidden="true" class="btn btn-success custom-btn btn-large">Revisar</button>
        <button onclick="window.location='<html:rewrite action="/caseNewPg.do"/>'" class="btn btn-primary custom-btn btn-large">D'acord, continuar</button>
      </div>
    </div>