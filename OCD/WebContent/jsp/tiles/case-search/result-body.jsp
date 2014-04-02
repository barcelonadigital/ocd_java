<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
	    <script type="text/javascript">
	    var options;
        <bean:size id="arraySize" name="patients" />
        var totalElem = <bean:write name="arraySize" />;
        var elemPerPage = <bean:write name="CaseResultForm" property="elemPerPage"/>;
        var currPage=<bean:write name="CaseResultForm" property="currPage"/>;
        var numPages = Math.ceil(totalElem/elemPerPage);
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
		            totalPages: numPages,
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
        function doResultAction(actionName) {
        	var resultPage=0;
        	if(actionName=='first'){
        		if(currPage!=1){
        			resultPage = 1;
        		}
        	}else if(actionName=='next'){
        		if(currPage+1<=numPages){
        			resultPage = currPage+1;
        		}
        	}else if(actionName=='prev'){
        		if(currPage-1>=1){
        			resultPage = currPage-1;
        		}
        	}else if(actionName=='last'){
        		if(currPage!=numPages){
    				resultPage = numPages;
        		}
        	}
        	if(resultPage==0){
        		return;
        	}else{
        		$('#currPage').val(resultPage);
        		$('#resultForm').submit();
        	}
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
          <h1><bean:message key="menu.users"/> <strong>— <bean:message key="label.patients"/></strong></h1>
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
			            <a href="#" class="item1"><span><bean:message key="label.cip"/></span></a>
			            <a href="#" class="item2"><span><bean:message key="label.nif"/></span></a>
			            <a href="#" class="item3"><span><bean:message key="label.fullname"/></span></a>
			            <a href="#" class="item4"><span></span></a>
		            </span>
	            </div>
		        <logic:present name="patients">
			    <logic:iterate name="patients" id="caseItem" type="org.bdigital.ocd.model.form.CaseAf" >
	              <div class="formrow">
					
		              <a href="<html:rewrite action="/caseMainAction.do"/>?idCase=${caseItem.ref}" data-toggle="dropdown">
		              <span class="item1"><span><bean:write name="caseItem" property="cip"/></span></span>
		              <span class="item2"><span><bean:write name="caseItem" property="nif"/></span></span>
		              <span class="item3"><span>
		              <logic:present name="caseItem" property="data">
			    		<bean:define id="dataItem" name="caseItem" property="data" type="org.bdigital.ocd.model.form.DataAf"/>
		                <bean:write name="dataItem" property="fullname"/>
		              </logic:present>&nbsp;
		              </span></span>
		              <span class="item4"><span>&nbsp;</span></span>
		              </a>
		              <!-- 
		              <span class="item4 actions"><span><span class="btn dropdown-toggle">Opcions<span class="caret"></span></span></span></span>
		              <ul class="dropdown-menu">
	                      <li></li>
	                  </ul>
	                   -->

	              </div>
	              
				</logic:iterate>
				<logic:empty name="patients">
	              <div class="formrow">
					
		              <bean:message key="label.noElements"/>

	              </div>
				</logic:empty>
				</logic:present>
				
	          </div>
	          
	        <html:form styleId="resultForm" action="/caseResultAction">
            <html:hidden name="CaseResultForm" property="searchStr" />
            <html:hidden name="CaseResultForm" property="currPage" styleId="currPage" />
            <html:hidden name="CaseResultForm" property="resultAction" styleId="resultAction" />
            <div class="pagination">
              <div class="navigation">
	            <a href="#" onclick="doResultAction('first');return false;"><bean:message key="pagination.first"/></a>
	            <a href="#" onclick="doResultAction('prev');return false;" class="btn btn-large btn-info prev"><bean:message key="pagination.prev"/></a>
	            <a href="#" onclick="doResultAction('next');return false;" class="btn btn-large btn-info next"><bean:message key="pagination.next"/></a>
	            <a href="#" onclick="doResultAction('last');return false;"><bean:message key="pagination.last"/></a>
              </div>
              <div class="status"><bean:message key="pagination.showing"/> <span id="elemFirst">1</span> <bean:message key="pagination.to"/> <span id="elemLast">10</span> <bean:message key="pagination.of"/> <a href="#"><span id="elemTotal">10</span> <bean:message key="pagination.entries"/></a></div>
            </div>
            </html:form>
	        <div id="example"></div>
	        </div>
	      
        </div>
      </div>
      <!-- Contenido fin-->
    </div>