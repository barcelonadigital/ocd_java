<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
	    <script type="text/javascript">
	        var timeOutIds=new Array();
	        function ajaxSetAnswerById(idQuestion) {
	        	if (typeof arrayRequestCounter[idQuestion] === "undefined") {
	        		arrayRequestCounter[idQuestion] = 0;
	        	}
	        	var requestCounter = ++arrayRequestCounter[idQuestion];
		    	document.getElementById("ajaxResponseId").value = '';
		    	document.getElementById("statusSaving"+idQuestion).innerHTML = 'Desant';
		    	document.getElementById("errorSaving"+idQuestion).innerHTML = '';
		        var idForm = '<bean:write name="CaseFormBoxesDetailsForm" property="idForm"/>';
		    	var valueObj = document.getElementsByName("questionValue("+idQuestion+")")[0];
		        var value='';
		        if (typeof valueObj !== "undefined") {
		        	value = valueObj.value;
		        }
		        var type = document.getElementsByName("questionType("+idQuestion+")")[0].value;
		        var option=getRadioCheckedValue(idQuestion);
		        //var idQuestion = document.getElementsByName("questionId("+idQuestion+")")[0].value;

		        var url="formSetAnswerAction.do?idForm="+idForm+"&type="+type+"&option="+option+"&value="+value+"&idQuestion="+idQuestion+"&requestCounter="+requestCounter;
		        ajaxCall(url,processMessageSetAnswer);
	        }
		    function ajaxSetAnswer() {
		        var idQuestion = document.getElementById("ajaxFieldId").value;
		        ajaxSetAnswerById(idQuestion);
		    }
		    function ajaxGetQuestion(questionId) {
		    	var idForm = '<bean:write name="CaseFormBoxesDetailsForm" property="idForm"/>';
		        var idQuestion = questionId;

		        var url="formGetQuestionAction.do?idForm="+idForm+"&idQuestion="+idQuestion;
		        ajaxCall(url,processMessageGetQuestion);
		    }
		    function ajaxCall(url,callback) {
		    	if(url !=""){
		    		var req;
		    		if(window.XMLHttpRequest){// Non-IE browsers
		                req =new XMLHttpRequest();
		                req.onreadystatechange = function ()
			                {
			                    if(req.readyState==4 && req.status==200)
			                    {
			                      callback(req);
			                    }
			                };
		                try {
		                    req.open("GET", url, true);
		                } catch (e){}
		                req.send(null);
		            }
		            else if(window.ActiveXObject){// IE
		                req =new ActiveXObject("Microsoft.XMLHTTP");
		                if(req){
		                    req.onreadystatechange = function ()
				                {
				                    if(req.readyState==4 && req.status==200)
				                    {
				                      callback(req);
				                    }
				                };
		                    req.open("POST", url, true);
		                    req.send(null);
		                }
		            }
		        }
		    }
		    
		    function getRadioCheckedValue(index)
		    {
		       var oRadio = document.getElementsByName("questionOption("+index+")");
		       if (typeof oRadio === "undefined") {
		        	return '';
		        }
		        
		     
		       for(var i = 0; i < oRadio.length; i++)
		       {
		          if(oRadio[i].checked)
		          {
		             return oRadio[i].value;
		          }
		       }
		     
		       return '';
		    }
		    
		    function getDropdownSelectedValue(index)
		    {
		       var oDropdown = document.getElementsByName("questionOption("+index+")");
		       if (typeof oDropdown === "undefined") {
		        	return '';
		        }
		        
		     
		       if(oDropdown.length>0){
		    	   return oDropdown[0].value;
		       }
		     
		       return '';
		    }
		    
		    function getInputValue(idQuestion)
		    {
		       var oInput=document.getElementsByName("questionValue("+idQuestion+")")[0];
		       if (typeof oInput === "undefined") {
		        	return '';
		       }
		        
		     
		       return oInput.value;
		    }
	
		    function processMessageSetAnswer(req){
		    	document.getElementById("ajaxResponseId").value = req.responseText;
		    	var responseOjb = JSON.parse(req.responseText);
		    	if (typeof arrayRequestCounter[responseOjb.idQuestion] === "undefined" ||
		    			responseOjb.requestCounter < arrayRequestCounter[responseOjb.idQuestion]){
		    		return;
		    	}
		    	if(responseOjb.errorMessage==''){
			    	//document.getElementById("statusSaving"+responseOjb.idQuestion).innerHTML = 'Desat';
			    	$( "#statusSaving"+responseOjb.idQuestion ).html('Desat');
		    		document.getElementById("formStatusContainer").innerHTML = responseOjb.formStatus;
			    	var questionsList = responseOjb.questionIds;
		    		for(var j=0;j<arrayQuestions.length;){
		    			var questionIdVisible = arrayQuestions[j];
		    			if(questionsList.indexOf(questionIdVisible) == -1){
		    				var fila = document.getElementById("fila"+questionIdVisible);
		    				$(fila).slideUp("slow", function() { $(this).remove(); } );
		    				//fila.parentNode.removeChild(fila);
		    				arrayQuestions.splice(j, 1);
		    			}else{
		    				j++;
		    			}
		    		}
	    			var k=0;
	    			var i=0;
		    		while(i<questionsList.length){
		    			var questionIdNew = questionsList[i];
		    			var questionIdVisible = arrayQuestions[k];
		    			if(questionIdNew!=questionIdVisible){
		    				var newFS;
		    				if(responseOjb.questionTypes[i]==='STATIC_TEXT'){
		    					newFS = document.createElement('p');
			    				newFS.innerHTML = '\n(ID: '+questionIdNew+')\n'+responseOjb.questionDescriptions[i]+'\n';
		    				}else{
		    					newFS = document.createElement('fieldset');
			    				newFS.innerHTML = '<legend class="questionform">\n(ID: '+questionIdNew+')\n'+responseOjb.questionDescriptions[i]+'\n</legend>';
		    				}
		    				newFS.id = 'fila'+questionIdNew;
		    				newFS.style.display = 'none';
		    				var newSpan = document.createElement("SPAN");
		    				newSpan.id = "statusSaving"+questionIdNew;
		    				newSpan.style.color = '#bbb';
		    				var newSpanError = document.createElement("SPAN");
		    				newSpanError.id = "errorSaving"+questionIdNew;
		    				newSpanError.style.color = '#f00';
		    				var newInputType = document.createElement("INPUT");
			    			newInputType.name = "questionType("+questionIdNew+")";
			    			newInputType.type = "hidden";
			    			newInputType.value = responseOjb.questionTypes[i];
		    				var newInputId = document.createElement("INPUT");
		    				newInputId.name = "questionId("+questionIdNew+")";
		    				newInputId.type = "hidden";
		    				newInputId.value = questionIdNew;
		    				newFS.appendChild(newSpan);
		    				newFS.appendChild(newSpanError);
		    				newFS.appendChild(newInputType);
		    				newFS.appendChild(newInputId);
		    				if (typeof questionIdVisible !== "undefined") {
			    				var fila = document.getElementById("fila"+questionIdVisible);
			    				//fila.parentNode.insertBefore(newFS, fila);
			    				$(newFS).insertBefore(fila).slideDown('slow');
		    				}else{
		    					var llista = document.getElementById("llistaQuestions");
		    					//llista.insertBefore(newFS, fila);
		    					$(newFS).appendTo(llista).slideDown('slow');
		    				}
		    				arrayQuestions.splice(k, 0, questionIdNew);
		    				ajaxGetQuestion(questionIdNew);
		    			}
	    				k++;
	    				i++;
		    		}
		    	}else{
		    		$( "#statusSaving"+responseOjb.idQuestion ).html('');
		    		$( "#errorSaving"+responseOjb.idQuestion ).html(responseOjb.errorMessage);
		    	}
		    }
	
		    function processMessageGetQuestion(req){
		    	var questionOjb = JSON.parse(req.responseText);
		    	var fila = document.getElementById("fila"+questionOjb.questionId);
		    	if(questionOjb.type=='FORMULA'){
		    		//fila.innerHTML += '<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+questionOjb.value;
		    		var newDiv = document.createElement("DIV");
	    			newDiv.style.display = 'none';
	    			newDiv.innerHTML = questionOjb.value;
	    			$(newDiv).appendTo(fila).slideDown('slow');
		    	}else if(questionOjb.type=='TEXT_AREA'){
		    		var newInput = document.createElement("TEXTAREA");
	    			newInput.name = "questionValue("+questionOjb.questionId+")";
	    			newInput.value = questionOjb.value;
	    			newInput.rows = 5;
	    			newInput.onkeypress = function(e) { 
	    				document.getElementById("statusSaving"+questionOjb.questionId).innerHTML = '';
	    				document.getElementById("errorSaving"+questionOjb.questionId).innerHTML = '';
	    				if(typeof timeOutIds !== "undefined"){
	    					clearTimeout(timeOutIds[questionOjb.questionId]);
	    				}
	    				timeOutIds[questionOjb.questionId]=setTimeout(function() {
	    				    ajaxSetAnswerById(questionOjb.questionId);}, 1000); 
	    			};
	    			var newDiv = document.createElement("DIV");
	    			newDiv.style.display = 'none';
    				newDiv.appendChild(newInput);
    				newInput.style.display = 'none';
	    			//fila.innerHTML += '<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	    			//fila.appendChild(newDiv);
    				$(newInput).appendTo(fila).slideDown('slow');
		    	}else if(questionOjb.type=='TEXT' || questionOjb.type=='NUMERICAL' || questionOjb.type=='DATE'){
		    		var newInput = document.createElement("INPUT");
	    			newInput.name = "questionValue("+questionOjb.questionId+")";
	    			newInput.type = "text";
	    			newInput.value = questionOjb.value;
	    			newInput.onkeypress = function(e) { 
	    				document.getElementById("statusSaving"+questionOjb.questionId).innerHTML = '';
	    				document.getElementById("errorSaving"+questionOjb.questionId).innerHTML = '';
	    				if(typeof timeOutIds !== "undefined"){
	    					clearTimeout(timeOutIds[questionOjb.questionId]);
	    				}
	    				timeOutIds[questionOjb.questionId]=setTimeout(function() {
	    				    ajaxSetAnswerById(questionOjb.questionId);}, 1000);
	    			};
	    			var newDiv = document.createElement("DIV");
	    			newDiv.style.display = 'none';
    				newDiv.appendChild(newInput);
    				newInput.style.display = 'none';
	    			//fila.innerHTML += '<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
    				//fila.appendChild(newInput);
    				$(newInput).appendTo(fila).slideDown('slow');
    				///newInput.stop().animate({'top':'50px'},400);
		    	}else if(questionOjb.type=='VERTICAL_RADIO' || questionOjb.type=='HORIZONTAL_RADIO'){
		    		var optionsList = questionOjb.options;
	    			//fila.innerHTML += '<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
		    		var newDiv = document.createElement("DIV");
	    			newDiv.style.display = 'none';
		    		for(var i=0;i<optionsList.length;i++){
		    			var optionObj = optionsList[i];
		    			var newLabel = document.createElement('LABEL');
		    			newLabel.innerHTML += optionObj.description;
		    			newLabel.className = "radio";
		    			newLabel.onchange = function() { 
		    				document.getElementById("statusSaving"+questionOjb.questionId).innerHTML = '';
		    				document.getElementById("errorSaving"+questionOjb.questionId).innerHTML = '';
		    				ajaxSetAnswerById(questionOjb.questionId); };
		    			var newInput = document.createElement("INPUT");
		    			newInput.name = "questionOption("+questionOjb.questionId+")";
		    			newInput.type = "radio";
		    			newInput.value = optionObj.optionId;
		    			if(optionObj.optionId == questionOjb.value){
		    				$(newInput).attr('checked',true);
		    				newLabel.className += " active";
		    			}
		    			newLabel.appendChild(newInput);
			    		//fila.appendChild(newLabel);
	    				newDiv.appendChild(newLabel);
			    		//$(newLabel).slideDown('slow');
		    			newLabel.style.display = 'none';
	    				$(newLabel).appendTo(fila).slideDown('slow');
		    		}
    				//$(newDiv).appendTo(fila).slideDown('slow');
		    	}else if(questionOjb.type!='STATIC_TEXT'){
		    		//fila.innerHTML += '<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
		    		//fila.innerHTML += 'type not found '+questionOjb.type;
		    		var newDiv = document.createElement("DIV");
	    			newDiv.style.display = 'none';
	    			newDiv.innerHTML = 'type not found '+questionOjb.type;
	    			$(newDiv).appendTo(fila).slideDown('slow');
		    	}
	    		document.getElementById("ajaxResponseId").value = req.responseText;
		    }
		    
		    var arrayQuestions=new Array();
		    var arrayRequestCounter=new Array();
		    var arrayConditions=new Array();
		    //var arrayIndexes=new Array();
		    <logic:present name="CaseFormBoxesDetailsForm" property="questions">
		    <logic:iterate name="CaseFormBoxesDetailsForm" property="questions" id="questionItem" indexId="index" type="org.bdigital.ocd.model.Question" >
		    arrayQuestions['${index}']='<bean:write name="questionItem" property="questionId"/>';
		    //arrayIndexes['<bean:write name="questionItem" property="questionId"/>']='${index}';
		    arrayRequestCounter['<bean:write name="questionItem" property="questionId"/>']=0;
		    arrayConditions['${index}']='<bean:write name="questionItem" property="condition"/>';
			</logic:iterate>
			</logic:present>

		    function loadQuestions(){
		    	for(var i=0;i<arrayQuestions.length;i++){
		    		ajaxGetQuestion(arrayQuestions[i]);
		    	}
		    }
		    
		    function fieldModified(idQuestion){
		    	var valueObj = document.getElementsByName("questionModified("+idQuestion+")")[0];
		        if (typeof valueObj !== "undefined") {
		        	valueObj.value = 'true';
		        }
		        checkConditions();
		    }
		    
		    function checkConditions(){
		    	for(var i=0;i<arrayConditions.length;i++){
		    		var condition = arrayConditions[i];
		    		if(condition!==''){
			    		var elems = condition.split(',');
			    		var idQuestion = elems[0].substring(1);
			    		var oper = elems[1];
			    		var valueObj = getInputValue(idQuestion);
			    		var option=getDropdownSelectedValue(idQuestion);
			    		if(oper==='EQUAL'){
				    		var valueThatEnables = elems[2];
				    		if(valueObj === valueThatEnables || option === valueThatEnables){
				    			setDisabledElement(arrayQuestions[i],false);
				    		}else{
				    			setDisabledElement(arrayQuestions[i],true);
				    		}
			    		}else if(oper==='RANGE'){
				    		var valueThatEnables1 = +elems[2];
				    		var valueThatEnables2 = +elems[3];
				    		valueObj = +(valueObj.replace('.', '' ).replace(',', '.' ));
				    		option = +option;
				    		if((valueObj >= valueThatEnables1 && valueObj < valueThatEnables2) || 
				    				(option >= valueThatEnables1 && option < valueThatEnables2)){
				    			setDisabledElement(arrayQuestions[i],false);
				    		}else{
				    			setDisabledElement(arrayQuestions[i],true);
				    		}
			    		}
			    	}
		    	}
		    }
		    

		    function setDisabledElement(idQuestion,disabledValue)
		    {
		       var inputType=document.getElementsByName("questionType("+idQuestion+")")[0].value;
		       if (inputType === "VERTICAL_RADIO" || inputType === "HORIZONTAL_RADIO") {
		    	   var options = document.getElementById("questionButtonOption("+idQuestion+")");
		    	   if(typeof options !== "undefined"){
		    		   options.disabled = disabledValue;
		    	   }
		    	   options = document.getElementById("questionOption("+idQuestion+")");
		    	   if(typeof options !== "undefined"){
		    		   options.disabled = disabledValue;
		    	   }
		       }else{
		    	   document.getElementsByName("questionValue("+idQuestion+")")[0].disabled = disabledValue;
		       }
	    	   var valueObj = document.getElementsByName("questionModified("+idQuestion+")")[0];
		       if (typeof valueObj !== "undefined") {
		           valueObj.value = 'true';
		       }
		    }
		    
		    function bodyOnLoadAux(){
		    	checkConditions();
		    }

		    function doSave() {
	          $("#newForm").submit();
	          return false;
	        }
	        function doFinish() {
	          document.getElementById('newForm').finish.value = 'true';
	          $("#newForm").submit();
	          return false;
	        }
	        $(document).ready(function() {
	      	  $( ".modificable" ).change(function() {
	      		$(this).trigger('keyup');
	      	  });
	        });
	    </script>
        <div class="content full">
          <bean:define id="formShortName" name="CaseFormBoxesDetailsForm" property="name" type="java.lang.String"/>
          <h2 class="asses"><%= formShortName/*.toUpperCase()*/ %></h2>
          
          <div class="columnboxes clearfix">
            <logic:iterate name="columns" id="columnItem" indexId="idxColumn" type="org.bdigital.ocd.beans.ColumnBean" >
            <div class="column por3">
              <logic:iterate name="columnItem" property="boxes" id="boxItem" indexId="idxBox" type="org.bdigital.ocd.beans.BoxBean" >
              <fieldset>
                <legend><bean:write name="boxItem" property="title"/></legend>
                <logic:notEmpty name="boxItem" property="groups">
                  <logic:iterate name="boxItem" property="groups" id="groupItem" indexId="idxGroup" type="org.bdigital.ocd.beans.GroupBean" >
                  <logic:equal name="groupItem" property="untitled" value="true">
                  <div class="h2actions"><a href="#detailModal_${idxColumn}_${idxBox}_${idxGroup}" data-toggle="modal" class="pencil">Editar</a></div>
                  </logic:equal>
                  <logic:notEqual name="groupItem" property="untitled" value="true">
                  <a href="#detailModal_${idxColumn}_${idxBox}_${idxGroup}" data-toggle="modal"><bean:write name="groupItem" property="title"/></a>
                  </logic:notEqual>
                  <logic:equal name="groupItem" property="hasErrors" value="true">
                  <span class="help-inline">(Conté errors)</span>
                  </logic:equal>
                  <p>
                  <% request.setAttribute("hiHaElements",""); %>
                  <logic:iterate name="groupItem" property="rows" id="rowItem" indexId="indexRow" type="org.bdigital.ocd.beans.RowBean" >
                  <logic:iterate name="rowItem" property="fields" id="fieldItem" type="org.bdigital.ocd.beans.FieldBean" >
                  <bean:define id="questionItem" name="fieldItem" property="question" type="org.bdigital.ocd.model.Question"/>
                  <logic:notEmpty name="CaseFormBoxesDetailsForm" property="questionTextValue(${questionItem.questionId})">
                  <% request.setAttribute("hiHaElements","true"); %>
                  <span class="question"><bean:write name="questionItem" property="description" filter="false"/></span> 
                  <span class="answer"><bean:write name="CaseFormBoxesDetailsForm" property="questionTextValue(${questionItem.questionId})"/></span><br/>
                  </logic:notEmpty>
                  </logic:iterate>
                  </logic:iterate>
                  <logic:notEqual name="hiHaElements" value="true">
                  No hi han dades per mostrar.
                  </logic:notEqual>
                  </p>
                  </logic:iterate>
                </logic:notEmpty>
              </fieldset>
              </logic:iterate>
            </div>
            </logic:iterate>
          </div>
        </div>
    <html:form styleId="newForm" action="/formSetAnswersAction">
    <html:hidden property="finish"/>
    <html:hidden name="CaseFormBoxesDetailsForm" property="idCase"/>
    <html:hidden name="CaseFormBoxesDetailsForm" property="idAdmission"/>
    <html:hidden name="CaseFormBoxesDetailsForm" property="idForm"/>
    <html:hidden name="CaseFormBoxesDetailsForm" property="idTask"/>
    <logic:iterate name="columns" id="columnItem" indexId="idxColumn" type="org.bdigital.ocd.beans.ColumnBean" >
    <logic:iterate name="columnItem" property="boxes" id="boxItem" indexId="idxBox" type="org.bdigital.ocd.beans.BoxBean" >
    <logic:notEmpty name="boxItem" property="groups">
    <logic:iterate name="boxItem" property="groups" id="groupItem" indexId="idxGroup" type="org.bdigital.ocd.beans.GroupBean" >
	<script type="text/javascript">
      $(document).ready(function() {
		  $('#detailModal_${idxColumn}_${idxBox}_${idxGroup}').on('hidden', function () {
			  document.getElementById('newForm').reset();
			  $("button.dropdown-toggle").each(function(i, item) {
				  var targetId = $(item).data('targetinput');
				  if(typeof targetId !== 'undefined'){
					  var targetObj=$('[name="' + targetId + '"]');
					  if(targetObj.length>0){
						  var optionSelected = $(item).parent().children(".dropdown-menu").find('a[data-value="'+$(targetObj[0]).val()+'"]');
						  if(optionSelected.length>0){
							  var desc = $(optionSelected[0]).text();
							  var triangulo=($(this).children('span.caret.triangulo'));
						      $(this).html(desc + "<span class=\"caret"+(triangulo?" triangulo":"")+"\"></span>");
						  }
		    		  }
				  }
			  });
			  checkConditions();
		  });
      });
    </script>
    <div id="detailModal_${idxColumn}_${idxBox}_${idxGroup}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal detail hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <logic:equal name="groupItem" property="untitled" value="true">
        <h3><bean:write name="boxItem" property="title"/></h3>
        </logic:equal>
        <logic:notEqual name="groupItem" property="untitled" value="true">
        <h3><bean:write name="groupItem" property="title"/></h3>
        </logic:notEqual>
      </div>
      <div class="modal-body">
        <div class="tab-content">
          <div id="tab_${idxColumn}_${idxBox}_${idxGroup}_0" class="tab-pane dataform active">
            <logic:equal name="groupItem" property="hasErrors" value="true">
            <div class="formerror">El formulari conté algun camp no vàlid que no s'ha pogut desar.</div>
            </logic:equal>
            <logic:iterate name="groupItem" property="rows" id="rowItem" indexId="indexRow" type="org.bdigital.ocd.beans.RowBean" >
            <% request.setAttribute("hiHaError","false"); %>
            <div class="fields-row">
                <logic:iterate name="rowItem" property="fields" id="fieldItem" indexId="indexField" type="org.bdigital.ocd.beans.FieldBean" >
                <bean:define id="questionItem" name="fieldItem" property="question" type="org.bdigital.ocd.model.Question"/>
                <% request.setAttribute("divClass",""); %>
                <logic:equal name="fieldItem" property="fieldType" value="<%=org.bdigital.ocd.utils.Constants.HTML_FIELDTYPE_BIG%>">
                <% request.setAttribute("divClass","bigfield"); %>
                </logic:equal>
                <logic:notEqual name="fieldItem" property="fieldType" value="<%=org.bdigital.ocd.utils.Constants.HTML_FIELDTYPE_BIG%>">
                <% request.setAttribute("divClass","smallfield"); %>
                </logic:notEqual>
                <% request.setAttribute("divErrorClass",""); %>
                <logic:present name="questionErrors" property="${questionItem.questionId}">
                    <% request.setAttribute("divErrorClass","error"); %>
                    <% request.setAttribute("hiHaError","true"); %>
				<script type="text/javascript">
		        $(document).ready(function() {
		        	$('#detailModal_${idxColumn}_${idxBox}_${idxGroup}').modal('show');
		        });
		        </script>
		        </logic:present>
                <div class="${divClass} ${divErrorClass}" id='fila<bean:write name="questionItem" property="questionId"/>'>
	              <label for="first_name"><bean:write name="questionItem" property="description" filter="false"/></label>
			      <html:hidden name="CaseFormBoxesDetailsForm" property="questionType(${questionItem.questionId})"/>
			      <html:hidden name="CaseFormBoxesDetailsForm" property="questionId(${questionItem.questionId})"/>
			      <html:hidden name="CaseFormBoxesDetailsForm" property="questionModified(${questionItem.questionId})"/>
			      <% boolean isRadioType = false; %>  
					  <logic:equal name="questionItem" property="type" value="VERTICAL_RADIO">  
					  <% isRadioType = true; %>
					  </logic:equal>  
					  <logic:equal name="questionItem" property="type" value="HORIZONTAL_RADIO">  
					  <% isRadioType = true; %>  
					  </logic:equal>  
					  <%  if (isRadioType) {  %>
		              <div class="dropdown">
		                <html:text onchange="fieldModified('${questionItem.questionId}')" name="CaseFormBoxesDetailsForm" property="questionOption(${questionItem.questionId})" styleId="questionOption(${questionItem.questionId})" style="display:none" />
		                <button data-toggle="dropdown" data-targetinput="questionOption(${questionItem.questionId})" class="btn btn-large dropdown-toggle" id="questionButtonOption(${questionItem.questionId})">
		                  <logic:notEmpty name="CaseFormBoxesDetailsForm" property="questionOption(${questionItem.questionId})">
		                    <bean:write name="CaseFormBoxesDetailsForm" property="questionTextValue(${questionItem.questionId})"/><span class="caret triangulo"></span>
		                  </logic:notEmpty>
		                  <logic:empty name="CaseFormBoxesDetailsForm" property="questionOption(${questionItem.questionId})">
		                    Seleccioni una opció<span class="caret triangulo"></span>
		                  </logic:empty>
		                </button>
		                <ul class="dropdown-menu">
		 				  <logic:iterate name="questionItem" property="options" id="optionItem" type="org.bdigital.ocd.model.Option" >
	 				        <% request.setAttribute("activeClass",""); %>
	 				        <logic:equal name="questionItem" property="value" value="${optionItem.optionId}">
	 				          <% request.setAttribute("activeClass","active"); %>
	 				        </logic:equal>
	                              <li><a data-value="<bean:write name="optionItem" property="optionId"/>" href="#"><bean:write name="optionItem" property="description"/></a></li>
	 					  </logic:iterate>
		                </ul>
		              </div>
	 				  <% } %>  
	 				  <% boolean isTextType = false; %>  
					  <logic:equal name="questionItem" property="type" value="TEXT">  
					  <% isTextType = true; %>
					  </logic:equal>  
					  <logic:equal name="questionItem" property="type" value="NUMERICAL">  
					  <% isTextType = true; %>  
					  </logic:equal>  
					  <% if (isTextType) {  %>  
	                      <html:text name="CaseFormBoxesDetailsForm" property="questionValue(${questionItem.questionId})" styleClass="modificable" onkeyup="fieldModified('${questionItem.questionId}')" ></html:text>
	 				  <% } %>  
	 				  <logic:equal name="questionItem" property="type" value="FORMULA">
	 				    <html:text name="CaseFormBoxesDetailsForm" property="questionValue(${questionItem.questionId})" readonly="true"></html:text>
	 				  </logic:equal>
	 				  <logic:equal name="questionItem" property="type" value="TEXT_AREA">
	                      <html:textarea name="CaseFormBoxesDetailsForm" property="questionValue(${questionItem.questionId})" styleClass="modificable" onkeyup="fieldModified('${questionItem.questionId}')" />
	                    </logic:equal>
	                    <logic:equal name="questionItem" property="type" value="DATE">
	                      <html:text name="CaseFormBoxesDetailsForm" property="questionValue(${questionItem.questionId})" styleId="questionValue${questionItem.questionId}" styleClass="modificable form-control date" onkeyup="fieldModified('${questionItem.questionId}')" />
	                    </logic:equal>
	                    <logic:notEqual name="questionItem" property="type" value="TEXT_AREA">
					  <logic:notEqual name="questionItem" property="type" value="TEXT">
					  <logic:notEqual name="questionItem" property="type" value="DATE">
					  <logic:notEqual name="questionItem" property="type" value="NUMERICAL">
					  <logic:notEqual name="questionItem" property="type" value="VERTICAL_RADIO">
					  <logic:notEqual name="questionItem" property="type" value="HORIZONTAL_RADIO">
				      <logic:notEqual name="questionItem" property="type" value="STATIC_TEXT">
					        <logic:notEqual name="questionItem" property="type" value="FORMULA">
					            type not found: <bean:write name="questionItem" property="type"/>
					        </logic:notEqual>
					    </logic:notEqual>
					  </logic:notEqual>
					  </logic:notEqual>
					  </logic:notEqual>
					  </logic:notEqual>
					  </logic:notEqual>
					  </logic:notEqual>
	            </div>
	            </logic:iterate>
            </div>
            <logic:equal name="hiHaError" value="true">  
            <div class="fields-row">
              <logic:iterate name="rowItem" property="fields" id="fieldItem" indexId="indexField" type="org.bdigital.ocd.beans.FieldBean" >
              <bean:define id="questionItem" name="fieldItem" property="question" type="org.bdigital.ocd.model.Question"/>
              <% request.setAttribute("divClass",""); %>
              <logic:equal name="fieldItem" property="fieldType" value="<%=org.bdigital.ocd.utils.Constants.HTML_FIELDTYPE_BIG%>">
              <% request.setAttribute("divClass","bigfield"); %>
              </logic:equal>
              <logic:notEqual name="fieldItem" property="fieldType" value="<%=org.bdigital.ocd.utils.Constants.HTML_FIELDTYPE_BIG%>">
              <% request.setAttribute("divClass","smallfield"); %>
              </logic:notEqual>
              <div class="${divClass}">
                  <logic:present name="questionErrors" property="${questionItem.questionId}">
				  <span class="help-inline"><bean:write name="questionErrors" property="${questionItem.questionId}" filter="false"/></span>
				  </logic:present>
				  <logic:notPresent name="questionErrors" property="${questionItem.questionId}">
				  &nbsp;
				  </logic:notPresent>
              </div>
              </logic:iterate>
            </div>
            </logic:equal>
            </logic:iterate>
          </div>
          <logic:equal name="groupItem" property="id" value="GASOMETRIA_ID">
          <div id="tab_${idxColumn}_${idxBox}_${idxGroup}_1" class="tab-pane dataform">
            <h6>Procediment de la Gasometria arterial</h6>
            <p><strong>Descripció:</strong> Obtenció d’una mostra de sang arterial mitjançant punció d’una arteria radial o braquial (per aquest ordre) amb finalitat diagnòstica.</p>
            <p><strong>Preparació del pacient abans del procediment:</strong></p>
            <p>Informar al pacient que se li va a realitzar i explicar-li com pot col·laborar.</p>
            <p>Si es tracta d’una gasometria basal, sense oxigen, el pacient ha d’estar al menys 20 minuts abans, en repòs sense oxigen. En el cas que porti oxigen (a la FiO2 que correspongui), assegurar que el pacient porta l’oxigenoteràpia prescrita durant al menys 20 minuts i que està en repòs.</p>
            <p>Per evitar el dolor de la punció i com a conseqüència provocar que el pacient hiperventili, situació que pot alterar els resultats gasomètrics, es recomana l’administració d’anestèsic (mepivacaína clorhidrat o lidocaïna 1%) sense vasoconstricció, via subcutània, infiltrant 0,2 ml d’anestèsic amb una agulla fina (d’insulina 0,36 mm) propera a la zona on es farà la punció arterial, fent un petit massatge després de la retirada de la xeringa i deixant que passin 1-2 minuts, perquè faci efecte.</p>
            <p><strong>Procediment:</strong></p>
            <p><strong>Material necessari:</strong> Xeringa de gasometria (si no, xeringa de 3 cossos de 2ml + agulla 21-23G + Heparina Na 1% + tap per la mostra arterial), anestèsic local (mepivacaína clorhidrat o lidocaïna 1%), xeringa d’insulina, gases, alcohol 70%, guants no estèrils, coixí o tovallola enrotllada, pinça hemostàsia, apòsit, etiqueta identificativa del pacient.</p>
            <p>Seqüència de acció:</p>
            <p>El lloc de elecció son per aquest ordre la arteria radial y la arteria humeral.</p>
            <p><span style="text-decoration:underline;">Punció arterial radial:</span></p>
            <p>
                <img src="img-contenido/gasometria1.jpg" align="left">
                <img src="img-contenido/gasometria2.jpg" align="left">Quant la via de elecció es la arteria radial (zona del canal carpià), es realitzarà el Test d’Allen modificat, per comprovar la permeabilitat de la circulació col•lateral de la ma. (<a href="http://www.nejm.org/doi/full/10.1056/NEJMicm1001091" target="_blank">http://www.nejm.org/doi/full/10.1056/NEJMicm1001091)</a></p>
            <p>Test d’Allen modificat: consisteix en que el pacient obri i tanqui la ma varies vegades, al mateix temps que la infermera pressiona simultàniament amb els dits índex i mig  la arteria radial i cubital de la ma explorada. La palma de la ma i els dits de la ma es tornen pàl•lids. Es deixa de pressionar la arteria cubital i s’observa el retorn del flux de sang a la ma adquirint un color vermell en menys de 10 segons, el que constitueix test d’Allen positiu. La arteria radial es pot puncionar.</p>
            <p><img src="img-contenido/gasometria3.jpg" align="left">Rentat de mans i col•locació de guants no estèrils.</p>
            <p>Posicionarem l’avantbraç en extensió sobre una superfície plana. El canell ha de estar en flexió dorsal i a sota del canell es col•locarà una tovallola enrotllada.</p>
            <p><img src="img-contenido/gasometria4.jpg" align="left">Desinfectarem la zona de la pell amb alcohol i mantindrem un parell de minuts el seu efecte.</p>
            <p>Aplicarem anestèsic local.</p>
            <p>Si es una xeringa especifica per gasometria col•locarem l’èmbol en la posició de 2ml. En un altre cas heparinitzarem la xeringa i l’agulla amb 0,5ml d’Heparina Na al 1% desplaçant l’èmbol varies vegades per impregnar las parets de la xeringa de heparina.</p>
            <p><img src="img-contenido/gasometria5.jpg" align="left">Rebutjant la resta.</p>
            <p>Localitzem el lloc exacte mitjançant la palpació de la artèria radial amb els dits de la ma. Amb l’altre ma s’ introdueix l’agulla amb el bisell cap amunt, avançant lentament amb l’agulla en direcció proximal (cap el tronc), en un angle de 45º. Indicar al pacient que respiri amb normalitat i que no es mogui.</p>
            <p><img src="img-contenido/gasometria6.jpg" align="left">En el cas de xeringa especifica de gasometria, esperar sense mobilitzar l’agulla a obtenir els 2ml de sang arterial. En un altre cas aspirar suaument fins obtenir 2ml de sang arterial.</p>
            <p>Purgar la xeringa amb la mostra de sang arterial, perquè no quedi cap bombolla d’aire.</p>
            <p>Tirar l’ agulla al contenidor y col•locar el tap a la xeringa.</p>
            <p><img src="img-contenido/gasometria7.jpg" align="left">Realitzar compressió digital durant 5 minuts. S’allargarà a 10-15 min. En el cas de que el pacient tingui problemes de coagulació o prengui medicació anticoagulant (acenocumarol).</p>
            <p>Identificar la mostra amb l’etiqueta identificativa. Retirar la compressió i col•locarem un apòsit.</p>
            <p><span style="text-decoration:underline;">Punció arterial humeral:</span></p>
            <ul>
                <li>Localitzarem el lloc exacte mitjançant la palpació de la arteria humeral amb els dits de la mà.</li>
                <li>L’ inclinació de l’agulla serà de 60º dirigint la punció en direcció proximal (cap el tronc).</li>
                <li>El temps de compressió serà de 7 a 10 min. que s’allargarà a 15-20 min. En el cas que el pacient tingui problemes de coagulació o tingui pautats anticoagulants.</li>
            </ul>
            <p><strong>Descripció de problemes e intervencions relacionats amb el procediment</strong></p>
            <p>Hematoma: Assegurar una bona compressió, valorant las condiciones del pacient; si te alteració de la coagulació, o bé està en tractament anticoagulant, assegurarem el temps de compressió en aquests casos.</p>
            <p>Aspectes a remarcar:</p>
            <ul>
                <li>Si la prova d’Allen modificada es negativa, s’ha de buscar un altre arteria per a la punció.</li>
                <li>Utilitzar sempre anestesia per realitzar el procediment, a fi d’evitar alteracions de la PO2/PCO2, per hiperventilació secundaria al dolor de la punció.</li>
                <li>Respectar el temps que necessita l’anestèsic per tenir efecte.</li>
            </ul>
            <p><strong>Bibliografia/ evidencia científica / Recomanacions de societats científiques</strong></p>
            <p>Normativa SEPAR sobre gasometria arterial. Agustí GN, A, Burgos F, Casna P, Perpiñá M, Rodriguez Roisin R, Sánchez AL, Sobradillo V, Togores B. Arch Bronconeumol 1998; 34: 142-153. (<a href="http://issuu.com/separ/docs/normativa_006" target="_blank">http://issuu.com/separ/docs/normativa_006</a>)</p>
          </div>
          </logic:equal>
          <logic:equal name="groupItem" property="id" value="PULSIOXIMETRIA_ID">
          <div id="tab_${idxColumn}_${idxBox}_${idxGroup}_1" class="tab-pane dataform">
          <h6>Procediment de la medició puntual de pulsioximetria</h6>
          <ol>
            <li>Comprovar que el pulsioxímetre tingui piles abans de començar la medició. (Es comprova mirant en el dibuix en forma de pila que hi ha en el pulsioxímetre. Si falten piles, s’encén i s’apaga).</li>
            <li>Comprovar que la qualitat de la senyal es òptima (amplitud de la onda de pols) en cas contrari pot produir valors erronis.</li>
            <li>El pacient ha d’estar assegut o incorporat al llit i tranquil.</li>
            <li>Comprovar que les ungles de les mans estan netes i sense esmalt.</li>
            <li>La medició de la pulsioximetria ha de realitzar-se (si no s’indica el contrari) en las següents condicions:</li>
            <li>Basal (sense oxigen)</li>
            <li>Ha de quedar registrat en quines condicions s’ha realitzat la medició al costat del resultat. 
                <br>Exemple: Cànules nasals 2 litres/mi (SatO<sub>2</sub> 95%);  Basal (SatO<sub>2</sub> 96%)
            </li>
            <li>Col·locar el didal tal como mostra la figura y posar en marxa el pulsioxímetre.
                <br><img src="img-contenido/pulsioximetria.png"></li>
            <li>Esperar a que la xifra dels resultats es mantingui tal como mostra la figura.</li>
            <li>Després de la medició, retirar el pulsioxímetre i guardar amb l’embolcall corresponent.</li>
          </ol>
          </div>
          </logic:equal>
          <logic:equal name="groupItem" property="id" value="ESPIROMETRIA_ID">
          <div id="tab_${idxColumn}_${idxBox}_${idxGroup}_1" class="tab-pane dataform">
          <h6>Procediment de la Espirometria Forçada</h6>
          <p>Realitzar per personal ensinistrat. <strong>UNA PROVA REALITZADA INCORRECTAMENT ES UN RESULTAT NO FIABLE</strong></p>
          <ol>
            <li>Informar al pacient</li>
            <li><strong>EVITAR L’ADMINISTRACIÓ DE BRONCODILATADORS Y REGISTRAR EN CAS DE  QUE ELS HAGI PRES</strong> (6 hores els d’acció curta; 12 hores els d’acció llarga, 24 hores els anticolinèrgics d’acció llarga)</li>
            <li>Pes i talla</li>
            <li>Pacient assegut sense creuar les cames</li>
            <li>Col·locar pinça nasal</li>
            <li>Realitzar <strong>UN MINIM DE TRES MANIOBRES I UN MAXIM DE VUIT MANIOBRES</strong> amb inici brusc e intentar que <strong>DUES DE ELLES ESTIGUIN LLIURES D’ERRORS</strong> i que las diferencies de la <strong>FVC y FEV1 siguin inferiors al 5% o 150 ml</strong> (100 si la FVC és inferior a un litre): El temps de duració de cada maniobra no serà inferior a 4 segons (preferiblement 6 segons).</li>
          </ol>
          </div>
          </logic:equal>
        </div>
      </div>
      <div class="modal-footer outside">
          <a href="#tab_${idxColumn}_${idxBox}_${idxGroup}_0" data-toggle="tab">Introducció de dades</a>
          <logic:equal name="groupItem" property="id" value="GASOMETRIA_ID">
          <a href="#tab_${idxColumn}_${idxBox}_${idxGroup}_1" data-toggle="tab">Ajuda</a>
          </logic:equal>
          <logic:equal name="groupItem" property="id" value="PULSIOXIMETRIA_ID">
          <a href="#tab_${idxColumn}_${idxBox}_${idxGroup}_1" data-toggle="tab">Ajuda</a>
          </logic:equal>
          <logic:equal name="groupItem" property="id" value="ESPIROMETRIA_ID">
          <a href="#tab_${idxColumn}_${idxBox}_${idxGroup}_1" data-toggle="tab">Ajuda</a>
          </logic:equal>
          <button class="btn btn-primary save" onclick="return doSave();"><span></span>Desar</button>
          <button type="button" data-dismiss="modal" aria-hidden="true" class="btn btn-warning link">Cancel·lar</button>
      </div>
    </div>
    </logic:iterate></logic:notEmpty></logic:iterate></logic:iterate>
    </html:form>
          
    