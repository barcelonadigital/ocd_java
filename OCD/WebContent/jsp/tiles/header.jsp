<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <!--[if lt IE 7]>
    <p class="chromeframe">You are using an<strong>outdated</strong>browser. Please<a href="http://browsehappy.com/">upgrade your browser</a>or<a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a>to improve your experience.</p>
    <![endif]-->
    <!-- Cabecera inicio-->
    <div class="custom-cabecera">
      <div class="container">
        <header><html:link styleClass="brand" action="/mainPg">OCD</html:link></header>
        <nav>
          <ul class="nav">
            <li class="user"><a href="#" data-toggle="dropdown"><img src="img/ico-clinician-m.png" alt="${sessionScope.userFullName}"><strong>${sessionScope.userFullName}</strong><span>${sessionScope.userCenter}</span></a>
              <div class="dropdown-menu">
                <ul>
                  <li><html:link action="/logoutAction"><bean:message key="label.myAccount"/></html:link></li>
                  <li><html:link action="/logoutAction"><bean:message key="label.logout"/></html:link></li>
                </ul>
              </div>
            </li>
          </ul>
        </nav>
      </div>
    </div>
    <!-- Cabecera (final)-->
    <!-- Menú principal-->
    <nav data-spy="affix" data-offset-top="106" class="custom-menuprincipal">
      <div class="container">
        <ul class="nav">
          <li><a href="#" data-toggle="dropdown" class="users">
              <!-- botón--><strong>Usuaris</strong><span>Pacients, metges...</span></a>
            <div class="dropdown-menu">
              <!-- dropdown menu-->
              <div class="newpacient"><html:link styleClass="brand" action="/caseSearchPg">Seleccionar <br>pacient</html:link></div>
              <!-- 
              <div class="newpacient"><a href="<html:rewrite page='/caseSearchPg'/>" role="button" data-toggle="modal">Seleccionar <br>pacient</a></div>
              <div class="newpacient"><a href="#loadpatientModal" role="button" data-toggle="modal">Seleccionar <br>pacient</a></div>
              -->
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="tasks">
              <!-- botón--><strong>Tasques</strong><span>Prescripció OCD, Altes</span></a>
            <div class="dropdown-menu">
              <!-- dropdown menu-->
              <div class="task_links">
                <ul>
			    <logic:present name="actionsTransfer">
			    <logic:iterate name="actionsTransfer" id="actionItem" type="org.bdigital.ocd.model.Action" >
					<li><html:link action="/caseTaskInsertAction?idAdmission=${CaseDetailsForm.idAdmission}&idCase=${CaseDetailsForm.idCase}" paramId="idActivity" paramName="actionItem" paramProperty="ref" onclick="return confirm('Es finalitzarà (DISCHARGE) el protocol actiu actualment. Dessitja continuar?');"><bean:write name="actionItem" property="name"/></html:link></li>
				</logic:iterate>
				</logic:present>
			    <logic:present name="actions">
			    <logic:iterate name="actions" id="actionItem" type="org.bdigital.ocd.model.Action" >
					<li><html:link action="/caseTaskInsertAction?idAdmission=${CaseDetailsForm.idAdmission}&idCase=${CaseDetailsForm.idCase}" paramId="idActivity" paramName="actionItem" paramProperty="ref"><bean:write name="actionItem" property="name"/></html:link></li>
				</logic:iterate>
				</logic:present>
                </ul>
              </div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="report">
              <!-- botón--><strong>Reports</strong><span>Estadistiques</span></a>
            <div class="dropdown-menu">
              <!-- dropdown menu-->
              <div class="links">
                <ul>
                  <li><a href="#">Link 1</a></li>
                  <li><a href="#">Link 2</a></li>
                  <li><a href="#">Link 3</a></li>
                </ul>
              </div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="more">
              <!-- botón--><strong>Altres</strong><span>Item1, Item2</span></a>
            <div class="dropdown-menu">
              <!-- dropdown menu-->
              <div class="links">
                <ul>
                  <li><a href="#">Link 1</a></li>
                  <li><a href="#">Link 2</a></li>
                  <li><a href="#">Link 3</a></li>
                </ul>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </nav>