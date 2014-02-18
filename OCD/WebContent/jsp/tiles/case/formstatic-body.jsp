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
		        var idForm = '<bean:write name="CaseFormStaticDetailsForm" property="idForm"/>';
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
		    	var idForm = '<bean:write name="CaseFormStaticDetailsForm" property="idForm"/>';
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
		    //var arrayIndexes=new Array();
		    <logic:present name="CaseFormStaticDetailsForm" property="questions">
		    <logic:iterate name="CaseFormStaticDetailsForm" property="questions" id="questionItem" indexId="index" type="org.bdigital.ocd.model.Question" >
		    arrayQuestions['${index}']='<bean:write name="questionItem" property="questionId"/>';
		    //arrayIndexes['<bean:write name="questionItem" property="questionId"/>']='${index}';
		    arrayRequestCounter['<bean:write name="questionItem" property="questionId"/>']=0;
			</logic:iterate>
			</logic:present>

		    function loadQuestions(){
		    	for(var i=0;i<arrayQuestions.length;i++){
		    		ajaxGetQuestion(arrayQuestions[i]);
		    	}
		    }
		    
		    function bodyOnLoadAux(){
		    	//loadQuestions();
		    }

	    </script>
        <div class="content contabs">
          <html:form action="/formSetAnswersAction">
          <div class="contentconbotoneslaterales">
            <div class="tabbable">
              <!-- Only required for left/right tabs-->
              <ul class="nav nav-tabs">
                <logic:present name="tabs">
                <logic:iterate name="tabs" id="tabItem" indexId="index" type="org.bdigital.ocd.beans.TabBean" >
                <logic:equal name="index" value="0">
                <% request.setAttribute("activeClass","active"); %>
                </logic:equal>
                <logic:notEqual name="index" value="0">
                <% request.setAttribute("activeClass",""); %>
                </logic:notEqual>
                <li class="${activeClass}"><a href="#tab${index}" data-toggle="tab"><bean:write name="tabItem" property="title"/></a></li>
                </logic:iterate></logic:present>
              </ul>
              <div class="tab-content">
                <logic:present name="tabs">
                <logic:iterate name="tabs" id="tabItem" indexId="indexTab" type="org.bdigital.ocd.beans.TabBean" >
                <logic:equal name="indexTab" value="0">
                <% request.setAttribute("activeClass","active"); %>
                </logic:equal>
                <logic:notEqual name="indexTab" value="0">
                <% request.setAttribute("activeClass",""); %>
                </logic:notEqual>
                <div id="tab${indexTab}" class="tab-pane dataform ${activeClass}">
                  <logic:iterate name="tabItem" property="rows" id="rowItem" indexId="indexRow" type="org.bdigital.ocd.beans.RowBean" >
                  <div class="fields-row">
                    <logic:iterate name="rowItem" property="fields" id="fieldItem" indexId="indexField" type="org.bdigital.ocd.beans.FieldBean" >
                            <bean:define id="questionItem" name="fieldItem" property="question" type="org.bdigital.ocd.model.Question"/>
		                    <logic:equal name="fieldItem" property="fieldType" value="<%=org.bdigital.ocd.utils.Constants.HTML_FIELDTYPE_BIG%>">
		                    <% request.setAttribute("divClass","bigfield"); %>
		                    </logic:equal>
		                    <logic:notEqual name="fieldItem" property="fieldType" value="<%=org.bdigital.ocd.utils.Constants.HTML_FIELDTYPE_BIG%>">
		                    <% request.setAttribute("divClass","smallfield"); %>
		                    </logic:notEqual>
		                    <div class="${divClass}" id='fila<bean:write name="questionItem" property="questionId"/>'>
		                      
		                      <label>(ID: <bean:write name="questionItem" property="questionId"/>)
								<bean:write name="questionItem" property="description" filter="false"/>
								<span id='statusSaving<bean:write name="questionItem" property="questionId"/>' style='color:#bbb'></span>
								<span id='errorSaving<bean:write name="questionItem" property="questionId"/>' style='color:#f00'></span>
							  </label>
						      <html:hidden name="CaseFormStaticDetailsForm" property="questionType(${questionItem.questionId})"/>
						      <html:hidden name="CaseFormStaticDetailsForm" property="questionId(${questionItem.questionId})"/>
		                      <logic:equal name="questionItem" property="type" value="NUMERICAL">
		                        <html:text name="CaseFormStaticDetailsForm" property="questionValue(${questionItem.questionId})" onkeypress="alert('ah')"></html:text>
		                      </logic:equal>
		                      
		                    </div>
                    </logic:iterate>
                  </div>
                  </logic:iterate>
                </div>
                </logic:iterate>
                </logic:present>
              </div>
            </div>
          </div>
          </html:form>
          <div class="botoneslaterales">
            <div class="botoneslateralescontainer">
              <div>
	            <a href="#" class="btn-primary btn savedataform">Desar</a>
	            <a href="#" class="btn-warning btn canceldataform">Cancel.</a>
              </div>
            </div>
          </div>
        </div>