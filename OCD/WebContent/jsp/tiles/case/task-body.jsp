<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
	    <script type="text/javascript">
	    $(document).ready(function() {
	        $(".formrow a").click(function(event) {
	        	var target = $(event.target);
	    		if (!$( target ).hasClass("dropdown-toggle") &&
	    				!$( target ).hasClass("caret")) {
	    			event.preventDefault();
	    			event.stopPropagation();
	    			var ct = $(event.currentTarget);
	    			window.location = $(ct).attr("href");
	    		}
	        });
	    });
	    </script>
        <div class="content">
          <div class="h2actions"><a href="#alertModal" role="button" data-toggle="modal" class="btn btn-warning btn-large custom-btn"><bean:message key="label.taskNew"/></a></div>
          <h2 class="asses"><bean:message key="label.tasks"/></h2>
          <br><br>
          <div id="news-list">
              
	        <logic:present name="tasks">
	        <logic:empty name="tasks">
	        <bean:message key="label.noElements"/>
	        </logic:empty>
	        <logic:notEmpty name="tasks">
		    <logic:iterate name="tasks" id="taskItem" type="org.bdigital.ocd.model.form.TaskAf" >


                <a href="<html:rewrite action="/caseTaskUnitDetailsAction.do"/>?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}" class="news-block-link">
	                <div class="date"><span class="month"><bean:write name="taskItem" property="dateMonth"/></span><span class="day"><bean:write name="taskItem" property="dateDay"/></span><span class="year"><bean:write name="taskItem" property="dateYear"/></span></div>
	                <div class="message">
	                  <h4><bean:write name="taskItem" property="description"/></h4>
	                  <p><bean:write name="taskItem" property="descriptionLong"/></p>
	                </div>
                </a>
                


	          
				
			</logic:iterate>
			</logic:notEmpty>
			</logic:present>
              
              
          </div>
        </div>
        <logic:present name="alertFormClose">
	    <script type="text/javascript">
	    $(document).ready(function() {
	    	$('#confirmFinishModal').modal('show');
	    });
	    function doFinish(){
	    	window.location='<html:rewrite action="/formCloseAction?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}&accept=true"/>';
	    }
	    function doFinishAndNewTask(){
	    	window.location='<html:rewrite action="/formCloseAction?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}&accept=true&createTask=true"/>';
	    }
	    </script>
	    <div id="confirmFinishModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal confirmation hide fade">
	      <div class="modal-header">
	        <button type="button" data-dismiss="modal" aria-hidden="true" class="close"><bean:message key="label.window.close"/></button>
	        <h3><bean:message key="alert.followUpVisit.title"/></h3>
	      </div>
	      <div class="modal-body">
	        <p>
	          <bean:message key="alert.followUpVisit.body1"/>
	        </p>
	      </div>
	      <div class="modal-footer">
	        <button data-dismiss="modal" aria-hidden="true" class="btn btn-success custom-btn btn-large"><bean:message key="label.review"/></button>
	        <button onclick="doFinish()" class="btn btn-primary custom-btn btn-large"><bean:message key="label.finish"/></button>
	        <button onclick="doFinishAndNewTask()" class="btn btn-primary custom-btn btn-large"><bean:message key="label.finishAndFollowUp"/></button>
	      </div>
	    </div>
        </logic:present>
        