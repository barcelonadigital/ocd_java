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
                  <!--
                  <li><html:link action="/logoutAction"><bean:message key="label.myAccount"/></html:link></li>
                  -->
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
              <strong>Usuaris</strong><span>Pacients, metges...</span></a>
            <div class="dropdown-menu">
              
              <logic:present name="caseBean">
              <div class="user_data">
                <div><strong>Pacient actual</strong></div>
                <div class="user"><bean:write name="caseBean" property="fullname"/></div>
                <ul>
	              <li><html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}" styleClass="${formularisClass}">Tasques</html:link></li>
	              <li><html:link action="/caseDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}" styleClass="${infoPacientClass}">Informació pacient</html:link></li>
                </ul>
              </div>
              <div class="newpacient"><html:link styleClass="brand" action="/caseSearchPg">Seleccionar un <br>altre pacient</html:link></div>
              </logic:present>
              <logic:notPresent name="caseBean">
              <div class="newpacient"><html:link styleClass="brand" action="/caseSearchPg">Seleccionar <br>pacient</html:link></div>
              </logic:notPresent>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="tasks">
              <strong>Tasques</strong><span>Pendents, ...</span></a>
            <div class="dropdown-menu">
              
              <div class="task_links">
                <ul>
                <li><html:link action="/tasksAssignedAction">Pendents</html:link></li>
                <!-- 
                <logic:present name="caseBean">
			    <logic:present name="actionsTransfer">
			    <logic:iterate name="actionsTransfer" id="actionItem" type="org.bdigital.ocd.model.form.ActionAf" >
					<li><html:link action="/caseTaskInsertAction?idAdmission=${admissionBean.idAdmission}&idCase=${caseBean.idCase}" paramId="idActivity" paramName="actionItem" paramProperty="ref" onclick="return confirm('Es finalitzarà (DISCHARGE) el protocol actiu actualment. Desitja continuar?');"><bean:write name="actionItem" property="name"/></html:link></li>
				</logic:iterate>
				</logic:present>
			    <logic:present name="actions">
			    <logic:iterate name="actions" id="actionItem" type="org.bdigital.ocd.model.form.ActionAf" >
					<li><html:link action="/caseTaskInsertAction?idAdmission=${admissionBean.idAdmission}&idCase=${caseBean.idCase}" paramId="idActivity" paramName="actionItem" paramProperty="ref"><bean:write name="actionItem" property="name"/></html:link></li>
				</logic:iterate>
				</logic:present>
				</logic:present>
				-->
                </ul>
              </div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="report">
              <strong>Reports</strong><span>Estadistiques</span></a>
            <div class="dropdown-menu">
              
              <div class="links">
                <ul>
                  <li><a href="#">Link 1</a></li>
                  <li><a href="#">Link 2</a></li>
                  <li><a href="#">Link 3</a></li>
                </ul>
              </div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="community">
              <!-- botón--><strong>Community</strong><span>Forum, news, ranking</span></a>
            <div class="dropdown-menu">
              <!-- dropdown menu-->
              <div class="links">
                <ul>
                  <li><a href="#">Link 1</a></li>
                  <li><a href="#">Link 2</a></li>
                  <li><a href="#">Link 3</a></li>
                  <li><a href="#">Link 4</a></li>
                  <li><a href="#">Link 5</a></li>
                  <li><a href="#">Link 6</a></li>
                </ul>
              </div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="more">
              <strong>Altres</strong><span>Item1, Item2</span></a>
            <div class="dropdown-menu">
              
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
    <div class="modal hide" id="pleaseWaitDialog" data-backdrop="static" data-keyboard="false"><div class="modal-header"><h1>Processant...</h1></div><div class="modal-body"><div class="progress progress-striped active"><div class="bar" style="width: 100%;"></div></div></div></div>
    