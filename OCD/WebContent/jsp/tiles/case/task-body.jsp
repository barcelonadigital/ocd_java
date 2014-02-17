<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        <div class="content">
            <div id="news-list">
              
	        <logic:present name="CaseTaskDetailsForm" property="forms">
		    <logic:iterate name="CaseTaskDetailsForm" property="forms" id="formItem" type="org.bdigital.ocd.model.Form" >
				
				  <html:link action="/caseFormDetailsAction?idCase=${CaseTaskDetailsForm.idCase}&idForm=${formItem.ref}" styleClass="news-block-link">
	                <div class="fulldate">
	                  <bean:write name="formItem" property="ref"/>
	                </div>
	                <div class="status">
	                  <strong><bean:write name="formItem" property="status"/></strong>
	                </div>
	                <div class="message">
	                  <h4><bean:write name="formItem" property="shortName"/></h4>
	                </div>
	              </html:link>
			</logic:iterate>
			</logic:present>
              
              
            </div>
        </div>
