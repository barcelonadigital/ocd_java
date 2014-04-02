<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
	    <script type="text/javascript">
	    var options;
        <bean:size id="arraySize" name="tasks" />
        var totalElem = <bean:write name="arraySize" />;
        var elemPerPage = 6;
        var currPage=1;
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
	        
	        if(totalElem>0){
		        $('#elemTotal').text(totalElem);
		        options = {
		            currentPage: currPage,
		            totalPages: Math.ceil(totalElem/elemPerPage),
		            onPageChanged: function(e,oldPage,newPage){
		            	loadPage(newPage);
		            }
		        };
		
		        $('#example').bootstrapPaginator(options);
		        $('#example').hide();
		        loadPage(currPage);
	        }else{
	        	$('.pagination').hide();
	        }
	    });
        function loadPage(newPage) {
        	if(totalElem<newPage*elemPerPage){
        		$('#elemLast').text(totalElem);
        	}else{
        		$('#elemLast').text(newPage*elemPerPage);
        	}
        	$('#elemFirst').text((newPage-1)*elemPerPage+1);
            $('.formrow').each(function(i, item) {
            	if(!$(item).hasClass('header')){
	            	if(newPage*elemPerPage>=i && (newPage-1)*elemPerPage<i){
	            		$(item).show();
	            	}else{
	            		$(item).hide();
	            	}
                }
              });
        }
        function doSubmit() {
            document.getElementById('newForm').submit();
            return false;
        }
    </script>
    <!-- Menú principal (final)-->
    
    <div class="gris2">
      <div class="container">
        <!-- Encabezado-->
        <div class="encabezado">
          <h1><bean:message key="menu.tasks"/> <strong>— <bean:message key="label.pendings"/></strong></h1>
        </div>
        <hr>
        <!-- Encabezado fin-->
      </div>
    </div>
    <div class="menuizqlayout gris2 recentlayout">
      <div class="container">
        <div class="bloqueizq">
          <div class="recentbox">
            <h4><bean:message key="label.recent"/>...</h4>
          </div>
        </div>
        <div class="content">
	      
	      
	      	  <div class="formlist">
	          <div class="table">
	          
	            <div class="formrow header">
		            <span>
			            <a href="#" class="col1"><span><bean:message key="label.date"/></span></a>
			            <a href="#" class="col2"><span><bean:message key="label.task"/></span></a>
			            <a href="#" class="col3"><span><bean:message key="label.patient"/></span></a>
			            <a href="#" class="col4"><span></span></a>
		            </span>
	            </div>
		        <logic:present name="tasks">
			    <logic:iterate name="tasks" id="taskItem" type="org.bdigital.ocd.model.form.TaskAf" >
			    <bean:define id="caseItem" name="taskItem" property="taskCase" type="org.bdigital.ocd.model.form.CaseAf"/>
			    <bean:define id="dataItem" name="caseItem" property="data" type="org.bdigital.ocd.model.form.DataAf"/>
			    <bean:define id="admissionItem" name="taskItem" property="admission" type="org.bdigital.ocd.model.form.AdmissionAf"/>
	              <div class="formrow">
					
		              <a href="<html:rewrite action="/caseTaskUnitDetailsAction.do"/>?idCase=${caseItem.ref}&idAdmission=${admissionItem.ref}&idTask=${taskItem.id}" data-toggle="dropdown">
		              <span class="col1"><span><strong><bean:write name="taskItem" property="date"/></strong></span></span>
		              <span class="col2"><span><bean:write name="taskItem" property="description"/></span></span>
		              <span class="col3"><span><bean:write name="dataItem" property="nickname"/></span></span>
		              <span class="col4"><span>&nbsp;</span></span>
		              </a>
		              <!-- 
		              <span class="col4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              <ul class="dropdown-menu">
	                      <li></li>
	                  </ul>
	                   -->

	              </div>
	              
				</logic:iterate>
				<logic:empty name="tasks">
	              <div class="formrow">
					
		              <bean:message key="label.noElements"/>

	              </div>
				</logic:empty>
				</logic:present>
				
	          </div>
	          
            <div class="pagination">
              <div class="navigation">
	            <a href="#" onclick="$('#example').bootstrapPaginator('showFirst');"><bean:message key="pagination.first"/></a>
	            <a href="#" class="btn btn-large btn-info prev" onclick="$('#example').bootstrapPaginator('showPrevious');"><bean:message key="pagination.prev"/></a>
	            <a href="#" class="btn btn-large btn-info next" onclick="$('#example').bootstrapPaginator('showNext');"><bean:message key="pagination.next"/></a>
	            <a href="#" onclick="$('#example').bootstrapPaginator('showLast');"><bean:message key="pagination.last"/></a>
              </div>
              <div class="status"><bean:message key="pagination.showing"/> <span id="elemFirst">1</span> <bean:message key="pagination.to"/> <span id="elemLast">10</span> <bean:message key="pagination.of"/> <a href="#"><span id="elemTotal">10</span> <bean:message key="pagination.entries"/></a></div>
            </div>
	        <div id="example"></div>
	        </div>
	      
        </div>
      </div>
      <!-- Contenido fin-->
    </div>