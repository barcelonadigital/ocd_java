<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        <div class="content">
          <div id="news-list">
              
	        <logic:present name="tasks">
	        <logic:empty name="tasks">
	        No hi ha elements per mostrar.
	        </logic:empty>
	        <logic:notEmpty name="tasks">
		    <logic:iterate name="tasks" id="taskItem" type="org.bdigital.ocd.model.form.TaskAf" >
	        <h3><bean:write name="taskItem" property="description"/><span><bean:write name="taskItem" property="date"/></span></h3>
		        <logic:present name="taskItem" property="forms">
			    <logic:iterate name="taskItem" property="forms" id="formItem" type="org.bdigital.ocd.model.form.FormAf" >
					  <html:link action="/caseFormStaticDetailsAction?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${caseBean.idAdmission}&idForm=${formItem.ref}" styleClass="news-block-link">
		                <div class="form-entry">
		                  <bean:define id="formShortName" name="formItem" property="shortName" type="java.lang.String"/>
		                  <h4><%= formShortName/*.toUpperCase()*/ %></h4>
		                </div>
		              </html:link>
				</logic:iterate>
				</logic:present>
			</logic:iterate>
			</logic:notEmpty>
			</logic:present>
              
              
          </div>
        </div>
