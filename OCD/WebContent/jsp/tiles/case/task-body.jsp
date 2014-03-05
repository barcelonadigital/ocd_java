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
          <div id="news-list">
              
	        <logic:present name="tasks">
	        <logic:empty name="tasks">
	        No hi ha elements per mostrar.
	        </logic:empty>
	        <logic:notEmpty name="tasks">
		    <logic:iterate name="tasks" id="taskItem" type="org.bdigital.ocd.model.form.TaskAf" >
	        <h3><bean:write name="taskItem" property="description"/><span><bean:write name="taskItem" property="date"/> <strong><bean:write name="taskItem" property="status"/></strong></span></h3>
		        
	          <div class="formlist">
	          <div class="table">
	          
		        <logic:present name="taskItem" property="forms">
			    <logic:iterate name="taskItem" property="forms" id="formItem" type="org.bdigital.ocd.model.form.FormAf" >
	            <bean:define id="formShortName" name="formItem" property="shortName" type="java.lang.String"/>
	              <div class="formrow">
					<logic:equal name="formItem" property="itemType" value="DOCUMENT">
		              <a href="<html:rewrite action="/caseFormDocumentDetailsAction.do"/>?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}" data-toggle="dropdown">
		              <span class="col1"><span><strong>REPORT</strong></span></span>
		              <span class="col2"><span><%= formShortName/*.toUpperCase()*/ %></span></span>
		              <span class="col3"><span>Pendent</span></span>
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              </a>
		              <ul class="dropdown-menu">
	                  </ul>
					</logic:equal>
					<logic:equal name="formItem" property="itemType" value="CATSALUT">
		              <a href="<html:rewrite action="/caseFormCatSalutAction.do"/>?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}" data-toggle="dropdown">
		              <span class="col1"><span><strong>REPORT</strong></span></span>
		              <span class="col2"><span><%= formShortName/*.toUpperCase()*/ %></span></span>
		              <logic:equal name="formItem" property="status" value="CLOSED">
		              <span class="col3"><span>Finalitzat</span></span>
		              </logic:equal>
		              <logic:equal name="formItem" property="status" value="OPEN">
		              <span class="col3"><span>Pendent</span></span>
		              </logic:equal>
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              </a>
		              <ul class="dropdown-menu">
		              <logic:equal name="formItem" property="status" value="CLOSED">
	                      <li><html:link action="/formOpenAction?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}">Reobrir</html:link></li>
		              </logic:equal>
		              <logic:equal name="formItem" property="status" value="OPEN">
	                      <li><html:link action="/formCloseAction?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}">Finalitzar</html:link></li>
		              </logic:equal>
	                  </ul>
					</logic:equal>
					<logic:notEqual name="formItem" property="itemType" value="DOCUMENT">
					<logic:notEqual name="formItem" property="itemType" value="CATSALUT">
		              <!-- 
		              < html : link action="/caseFormStaticDetailsAction?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}" data-toggle="dropdown">
		               -->
		              <a href="<html:rewrite action="/caseFormStaticDetailsAction.do"/>?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}" data-toggle="dropdown">
		              <span class="col1"><span><strong>QÜESTIONARI</strong></span></span>
		              <span class="col2"><span><%= formShortName/*.toUpperCase()*/ %></span></span>
		              <logic:equal name="formItem" property="status" value="CLOSED">
		              <span class="col3"><span>Finalitzat</span></span>
		              </logic:equal>
		              <logic:equal name="formItem" property="status" value="OPEN">
		              <span class="col3"><span>Pendent</span></span>
		              </logic:equal>
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              </a>
		              <ul class="dropdown-menu">
		              <logic:equal name="formItem" property="status" value="CLOSED">
	                      <li><html:link action="/formOpenAction?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}">Reobrir</html:link></li>
		              </logic:equal>
		              <logic:equal name="formItem" property="status" value="OPEN">
	                      <li><html:link action="/formCloseAction?idCase=${CaseTaskDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.id}">Finalitzar</html:link></li>
		              </logic:equal>
	                  </ul>
					</logic:notEqual>
					</logic:notEqual>

	              </div>
	              
				</logic:iterate>
				</logic:present>
				
	          </div>
	          </div>
				
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
	    </script>
	    <div id="confirmFinishModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal confirmation hide fade">
	      <div class="modal-header">
	        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
	        <h3>Finalitzar formulari?</h3>
	      </div>
	      <div class="modal-body">
	        <p>
	          Donat que és últim formulari pendent de finalitzar, es tancarà la tasca. Desitja continuar?
	        </p>
	      </div>
	      <div class="modal-footer">
	        <button data-dismiss="modal" aria-hidden="true" class="btn btn-success custom-btn btn-large">Revisar</button>
	        <button onclick="doFinish()" class="btn btn-primary custom-btn btn-large">D'acord, finalitzar</button>
	      </div>
	    </div>
        </logic:present>
        