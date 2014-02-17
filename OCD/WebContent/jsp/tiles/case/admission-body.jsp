<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        <div class="content">
            <div id="news-list">
              
	    <logic:present name="tasks">
	    <logic:iterate name="tasks" id="taskItem" type="org.bdigital.ocd.model.Task" >
			  <html:link action="/taskDetailsAction?idTask=${taskItem.id}" styleClass="news-block-link">
                <div class="fulldate">
                  <bean:write name="taskItem" property="date"/> <bean:write name="taskItem" property="hour"/>
                </div>
                <div class="status"><strong><bean:write name="taskItem" property="status"/></strong></div>
                <div class="message">
                  <h4><bean:write name="taskItem" property="id"/>,
                  <bean:write name="taskItem" property="taskClass"/>, 
				  <bean:write name="taskItem" property="type"/>, 
				  <bean:write name="taskItem" property="description"/></h4>
                </div>
              </html:link>
		</logic:iterate>
		</logic:present>
              
              
            </div>
        </div>
