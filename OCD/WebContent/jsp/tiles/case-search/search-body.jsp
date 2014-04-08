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
            <a href="#confirmNewModal" role="button" data-toggle="modal" class="btn btn-large btn-warning"><bean:message key="label.caseNew"/></a>
          </div>
          <header>
            <h1><bean:message key="menu.users"/> <strong>— <bean:message key="label.patients"/></strong></h1>
          </header>
        </div>
        <!-- Encabezado fin-->
      </div>
      <div class="menuizqlayout">
        <div class="container">
          <div class="content">
            <h2 class="clinician"><bean:message key="label.caseSearch"/></h2>
            <a href="#info1" role="button" data-toggle="modal" class="info_popup"><bean:message key="label.info"/></a>            
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
                <span style='color:red'><bean:message key="errors.caseNotFoundAndCreate"/>
		        <html:link styleId="linkNew" href="#"><bean:message key="label.discharge"/></html:link>
                </span>
			</logic:equal>
            <div id="search-patient">
                <html:text styleId="searchStr" property="searchStr" />
                
            </div>
            <div class="actions bottom">
                <html:submit styleClass="btn custom-btn btn-large btn-info" ><bean:message key="label.search"/></html:submit>
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
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close"><bean:message key="label.window.close"/></button>
        <h3><bean:message key="label.caseSearch"/></h3>
      </div>
      <div class="modal-body">
        <h4><bean:message key="alert.helpCaseSearch.title"/></h4>
        <p><bean:message key="alert.helpCaseSearch.body1"/></p>
        <p><bean:message key="alert.helpCaseSearch.body2"/></p>
      </div>
    </div>
    <div id="confirmNewModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal confirmation hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close"><bean:message key="label.window.close"/></button>
        <h3><bean:message key="alert.notUpdateHis.title"/></h3>
      </div>
      <div class="modal-body">
        <p>
          <bean:message key="alert.notUpdateHis.body1"/><br/><bean:message key="alert.notUpdateHis.body2"/>
        </p>
      </div>
      <div class="modal-footer">
        <button data-dismiss="modal" aria-hidden="true" class="btn btn-success custom-btn btn-large"><bean:message key="label.review"/></button>
        <button onclick="window.location='<html:rewrite action="/caseNewPg.do"/>'" class="btn btn-primary custom-btn btn-large"><bean:message key="label.okcontinue"/></button>
      </div>
    </div>