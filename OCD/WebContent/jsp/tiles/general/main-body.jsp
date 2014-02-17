<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <div class="container">
      <!-- Encabezado-->
      <div class="encabezado">
        <h1>Hola ${sessionScope.userFullName}!<strong>&mdash; Qu&egrave; hi ha de nou?</strong></h1>
      </div>
      <!-- Encabezado fin-->
      <!-- Contenido-->
      <div>
        <div class="table">
          <h2 class="messages new">Nou<span>(0)</span></h2>
          <ul class="table messages new">
          </ul>
        </div>
        <div class="table">
          <h2 class="messages past">Llegit<span>(0)</span></h2>
          <ul class="table messages past">
          </ul>
        </div>
        <!-- Contenido fin-->
      </div>
        <br>
    </div>
    <!-- Lightbox-->
    <div id="loadpatientModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal loadpatient hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3><bean:message key="label.caseSearch"/></h3>
      </div>
      <div class="modal-body">
        <html:form action="/caseSearchAction">
          <div class="control-group">
            <label for="numNIF">NIF</label>
            <html:text property="nif" />
          </div>
          <div class="control-group">
            <label for="numNIE">NIE</label>
            <html:text property="nie" />
          </div>
          <div class="control-group">
            <label for="numPAS">PAS</label>
            <div class="controls">
            <html:text property="pas" />
            </div>
          </div>
          <div class="control-group">
            <label for="numCIP">CIP</label>
            <div class="controls">
            <html:text property="cip" />
            </div>
          </div>
          <html:submit styleClass="btn btn-primary custom-btn btn-large" value="Cercar" />
        </html:form>
      </div>
      <div class="modal-footer">
      </div>
    </div>
