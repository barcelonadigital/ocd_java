<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        <div class="content">
            <div id="news-list">
              
	    <logic:present name="CaseDetailsForm" property="admissions">
	    <logic:iterate offset="1" name="CaseDetailsForm" property="admissions" id="admissionItem" type="org.bdigital.ocd.model.Admission" >
			<bean:define id="dataItem" name="admissionItem" property="data" type="org.bdigital.ocd.model.AdmissionData"/>
			<bean:define id="programItem" name="dataItem" property="program" type="org.bdigital.ocd.model.AdmissionProgram"/>
			<bean:define id="protocolItem" name="dataItem" property="protocol" type="org.bdigital.ocd.model.AdmissionProtocol"/>
              <html:link action="/admissionDetailsAction?idAdmission=${admissionItem.ref}" styleClass="news-block-link">
                <div class="fulldate">
                  <bean:write name="dataItem" property="dateToDisplay"/>
                </div>
                <div class="status"><strong><bean:write name="dataItem" property="status"/></strong></div>
                <div class="message">
                  <h4><bean:write name="protocolItem" property="name"/></h4>
                </div>
              </html:link>
		</logic:iterate>
		</logic:present>
              
              
            </div>
        </div>
        