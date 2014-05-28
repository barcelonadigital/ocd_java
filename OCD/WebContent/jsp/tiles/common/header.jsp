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
        <header><html:link styleClass="brand" action="/mainPg"><bean:message key="application.title"/></html:link></header>
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
              <strong><bean:message key="menu.users"/></strong><span><bean:message key="menu.users.desc"/></span></a>
            <div class="dropdown-menu">
              
              <logic:present name="caseBean">
              <div class="user_data">
                <div><strong><bean:message key="label.currentPatient"/></strong></div>
                <div class="user"><bean:write name="caseBean" property="fullname"/></div>
                <ul>
	              <li><html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}" styleClass="${formularisClass}"><bean:message key="label.tasks"/></html:link></li>
	              <li><html:link action="/caseDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}" styleClass="${infoPacientClass}"><bean:message key="label.patientInformation"/></html:link></li>
                </ul>
              </div>
              <div class="newpacient"><html:link styleClass="brand" action="/caseSearchPg"><bean:message key="label.changePatient"/></html:link></div>
              </logic:present>
              <logic:notPresent name="caseBean">
              <div class="newpacient"><html:link styleClass="brand" action="/caseSearchPg"><bean:message key="label.selectPatient"/></html:link></div>
              </logic:notPresent>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="tasks">
              <strong><bean:message key="menu.tasks"/></strong><span><bean:message key="menu.tasks.desc"/></span></a>
            <div class="dropdown-menu">
              
              <div class="task_links">
                <ul>
                <li><html:link action="/tasksAssignedAction"><bean:message key="label.pendings"/></html:link></li>
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
              <strong><bean:message key="menu.reports"/></strong><span><bean:message key="menu.reports.desc"/></span></a>
            <div class="dropdown-menu">
              
              <div class="links">
                <ul>
                  <li><a href="#"><bean:message key="label.link"/> 1</a></li>
                  <li><a href="#"><bean:message key="label.link"/> 2</a></li>
                  <li><a href="#"><bean:message key="label.link"/> 3</a></li>
                </ul>
              </div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="community">
              <!-- botón--><strong><bean:message key="menu.community"/></strong><span><bean:message key="menu.community.desc"/></span></a>
            <div class="dropdown-menu">
              <!-- dropdown menu-->
              <div class="links">
                <ul>
                  <li><a href="#"><bean:message key="label.link"/> 1</a></li>
                  <li><a href="#"><bean:message key="label.link"/> 2</a></li>
                  <li><a href="#"><bean:message key="label.link"/> 3</a></li>
                  <li><a href="#"><bean:message key="label.link"/> 4</a></li>
                  <li><a href="#"><bean:message key="label.link"/> 5</a></li>
                  <li><a href="#"><bean:message key="label.link"/> 6</a></li>
                </ul>
              </div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="more">
              <strong><bean:message key="menu.more"/></strong><span><bean:message key="menu.more.desc"/></span></a>
            <div class="dropdown-menu">
              
              <div class="links">
                <ul>
                  <li><a href="#"><bean:message key="label.link"/> 1</a></li>
                  <li><a href="#"><bean:message key="label.link"/> 2</a></li>
                  <li><a href="#"><bean:message key="label.link"/> 3</a></li>
                </ul>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </nav>
    <div class="modal hide" id="pleaseWaitDialog" data-backdrop="static" data-keyboard="false"><div class="modal-header"><h1><bean:message key="label.loading"/>...</h1></div><div class="modal-body"><div class="progress progress-striped active"><div class="bar" style="width: 100%;"></div></div></div></div>
    