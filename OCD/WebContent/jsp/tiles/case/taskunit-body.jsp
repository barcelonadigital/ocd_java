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
              
	        <bean:define id="taskItem" name="task" type="org.bdigital.ocd.model.form.TaskAf"/>
            <div class="h2actions"><a href="#alertModal" role="button" data-toggle="modal" class="btn btn-warning btn-large custom-btn">Nova tasca</a></div>
            <h2 class="asses">Tasques</h2>
	        <h3><bean:write name="taskItem" property="description"/><span><bean:write name="taskItem" property="date"/> <strong></strong></span></h3>
		        
	          <div class="formlist">
	          <div class="table">
	          
		        <logic:present name="taskItem" property="forms">
			    <logic:iterate name="taskItem" property="forms" id="formItem" type="org.bdigital.ocd.model.form.FormAf" >
	            <bean:define id="formShortName" name="formItem" property="shortName" type="java.lang.String"/>
	              <div class="formrow">
					<logic:equal name="formItem" property="itemType" value="DOCUMENTALTA">
		              <a href="<html:rewrite action="/caseFormDocumentDetailsAction.do"/>?idCase=${CaseTaskUnitDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=DOCUMENTALTA&idTask=${taskItem.ref}" data-toggle="dropdown">
		              <span class="col1"><span><strong>REPORT</strong></span></span>
		              <span class="col2"><span><%= formShortName/*.toUpperCase()*/ %></span></span>
		              <span class="col3"><span>&nbsp;</span></span>
		              <span class="col4"><span>&nbsp;</span></span>
		              </a>
		              <!-- 
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              <ul class="dropdown-menu">
	                  </ul>
	                   -->
					</logic:equal>
					<logic:equal name="formItem" property="itemType" value="DOCUMENTVISIT">
		              <a href="<html:rewrite action="/caseFormDocumentDetailsAction.do"/>?idCase=${CaseTaskUnitDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=DOCUMENTVISIT&idTask=${taskItem.ref}" data-toggle="dropdown">
		              <span class="col1"><span><strong>REPORT</strong></span></span>
		              <span class="col2"><span><%= formShortName/*.toUpperCase()*/ %></span></span>
		              <span class="col3"><span>&nbsp;</span></span>
		              <span class="col4"><span>&nbsp;</span></span>
		              </a>
		              <!-- 
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              <ul class="dropdown-menu">
	                  </ul>
	                   -->
					</logic:equal>
					<logic:equal name="formItem" property="itemType" value="DOCUMENTPRESC">
		              <a href="<html:rewrite action="/caseFormDocumentDetailsAction.do"/>?idCase=${CaseTaskUnitDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=DOCUMENTPRESC&idTask=${taskItem.ref}" data-toggle="dropdown">
		              <span class="col1"><span><strong>REPORT</strong></span></span>
		              <span class="col2"><span><%= formShortName/*.toUpperCase()*/ %></span></span>
		              <span class="col3"><span>&nbsp;</span></span>
		              <span class="col4"><span>&nbsp;</span></span>
		              </a>
		              <!-- 
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              <ul class="dropdown-menu">
	                  </ul>
	                   -->
					</logic:equal>
					<logic:equal name="formItem" property="itemType" value="DOCUMENT">
		              <a href="<html:rewrite action="/caseFormDocumentDetailsAction.do"/>?idCase=${CaseTaskUnitDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=DOCUMENT&idTask=${taskItem.ref}" data-toggle="dropdown">
		              <span class="col1"><span><strong>REPORT</strong></span></span>
		              <span class="col2"><span><%= formShortName/*.toUpperCase()*/ %></span></span>
		              <span class="col3"><span>&nbsp;</span></span>
		              <span class="col4"><span>&nbsp;</span></span>
		              </a>
		              <!-- 
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              <ul class="dropdown-menu">
	                  </ul>
	                   -->
					</logic:equal>
					<logic:equal name="formItem" property="itemType" value="CATSALUT">
		              <a href="<html:rewrite action="/caseFormCatSalutAction.do"/>?idCase=${CaseTaskUnitDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.ref}" data-toggle="dropdown">
		              <span class="col1"><span><strong>REPORT</strong></span></span>
		              <span class="col2"><span><%= formShortName/*.toUpperCase()*/ %></span></span>
		              <span class="col3"><span>&nbsp;</span></span>
		              <span class="col4"><span>&nbsp;</span></span>
		              </a>
		              <!-- 
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              <ul class="dropdown-menu">
	                  </ul>
	                   -->
					</logic:equal>
					<logic:notEqual name="formItem" property="itemType" value="DOCUMENTALTA">
					<logic:notEqual name="formItem" property="itemType" value="DOCUMENTPRESC">
					<logic:notEqual name="formItem" property="itemType" value="DOCUMENTVISIT">
					<logic:notEqual name="formItem" property="itemType" value="DOCUMENT">
					<logic:notEqual name="formItem" property="itemType" value="CATSALUT">
		              <!-- 
		              < html : link action="/caseFormStaticDetailsAction?idCase=${CaseTaskUnitDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.ref}" data-toggle="dropdown">
		               -->
		              <a href="<html:rewrite action="/caseFormStaticDetailsAction.do"/>?idCase=${CaseTaskUnitDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.ref}" data-toggle="dropdown">
		              <span class="col1"><span><strong>QÜESTIONARI</strong></span></span>
		              <span class="col2"><span><%= formShortName/*.toUpperCase()*/ %></span></span>
		              <span class="col3"><span>&nbsp;</span></span>
		              <span class="col4"><span>&nbsp;</span></span>
		              </a>
		              <!-- 
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              <ul class="dropdown-menu">
	                  </ul>
	                   -->
					</logic:notEqual>
					</logic:notEqual>
					</logic:notEqual>
					</logic:notEqual>
					</logic:notEqual>

	              </div>
	              
				</logic:iterate>
				</logic:present>
				
	          </div>
	          </div>
				
              
              
          </div>
        </div>
        <logic:present name="alertFormClose">
	    <script type="text/javascript">
	    $(document).ready(function() {
	    	$('#confirmFinishModal').modal('show');
	    });
	    function doFinish(){
	    	window.location='<html:rewrite action="/formCloseAction?idCase=${CaseTaskUnitDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.ref}&accept=true"/>';
	    }
	    function doFinishAndNewTask(){
	    	window.location='<html:rewrite action="/formCloseAction?idCase=${CaseTaskUnitDetailsForm.idCase}&idAdmission=${admissionBean.idAdmission}&idForm=${formItem.ref}&idTask=${taskItem.ref}&accept=true&createTask=true"/>';
	    }
	    </script>
	    <div id="confirmFinishModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal confirmation hide fade">
	      <div class="modal-header">
	        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
	        <h3>Visita de seguiment?</h3>
	      </div>
	      <div class="modal-body">
	        <p>
	          Donat que és últim formulari pendent de finalitzar, es tancarà la tasca i es programarà la visita de seguiment. Desitja continuar?
	        </p>
	      </div>
	      <div class="modal-footer">
	        <button data-dismiss="modal" aria-hidden="true" class="btn btn-success custom-btn btn-large">Revisar</button>
	        <button onclick="doFinish()" class="btn btn-primary custom-btn btn-large">Finalitzar</button>
	        <button onclick="doFinishAndNewTask()" class="btn btn-primary custom-btn btn-large">Finalitzar i visita de seguiment</button>
	      </div>
	    </div>
        </logic:present>
        