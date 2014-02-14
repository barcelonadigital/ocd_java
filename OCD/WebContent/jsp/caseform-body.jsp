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
		        var idForm = '<bean:write name="FormDetailsForm" property="idForm"/>';
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
		    	var idForm = '<bean:write name="FormDetailsForm" property="idForm"/>';
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
	    			newInput.onkeyup = function() { 
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
	    			newInput.onkeyup = function() { 
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
		    <logic:present name="FormDetailsForm" property="questions">
		    <logic:iterate name="FormDetailsForm" property="questions" id="questionItem" indexId="index" type="org.bdigital.ocd.model.Question" >
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
		    	loadQuestions();
		    }

	    </script>
    <!-- Menú principal (final)-->
    <div class="menuizqlayout">
      <div class="container">
        <nav class="menuizq">
          <ul>
            <li><html:link action="/caseDetailsAction?idCase=${CaseDetailsForm.idCase}">Informació</html:link></li>
            <li><html:link action="/caseHistoricAction?idCase=${CaseDetailsForm.idCase}">Històric</html:link></li>
            <li><html:link action="/admissionDetailsAction?idAdmission=${CaseDetailsForm.idAdmission}">Formularis</html:link></li>
          </ul>
        </nav>
        <div class="content">
          <h2 class="asses"><bean:write name="FormDetailsForm" property="name" /></h2><a href="#" class="h2 back clearfix"><span>Tornar</span></a>
          <h3><bean:write name="FormDetailsForm" property="description" /> <span id="formStatusContainer"><bean:write name="FormDetailsForm" property="status"/></span></h3>
	      <html:messages id="msg" property="general">
              <span style='color:red'><bean:write name="msg" /></span>
          </html:messages>
	      <html:messages id="msg3" property="error">
              <span style='color:red'><bean:write name="msg3" /></span>
          </html:messages>
	    
		  Debug: <input type="text" id="ajaxResponseId" name="ajaxResponseId" style="width: 300px;" readonly="readonly" /><br/>
	      
	      <logic:present name="FormDetailsForm" property="questions">
          <html:form action="/formSetAnswersAction">
	      <html:hidden name="FormDetailsForm" property="idForm"/>
	      <logic:iterate name="FormDetailsForm" property="questions" id="questionItem" indexId="index" type="org.bdigital.ocd.model.Question" >
			<logic:equal name="questionItem" property="type" value="STATIC_TEXT">
			<p id='fila<bean:write name="questionItem" property="questionId"/>'>(ID: <bean:write name="questionItem" property="questionId"/>)
				<bean:write name="questionItem" property="description" filter="false"/>
		        <html:hidden name="FormDetailsForm" property="questionType(${questionItem.questionId})"/>
		        <html:hidden name="FormDetailsForm" property="questionId(${questionItem.questionId})"/>
				<span id='statusSaving<bean:write name="questionItem" property="questionId"/>' style='color:#bbb'></span>
				<span id='errorSaving<bean:write name="questionItem" property="questionId"/>' style='color:#f00'></span>
			</p>
			</logic:equal>
			<logic:notEqual name="questionItem" property="type" value="STATIC_TEXT">
			<fieldset id='fila<bean:write name="questionItem" property="questionId"/>'>
				<legend class="questionform">(ID: <bean:write name="questionItem" property="questionId"/>)
				<bean:write name="questionItem" property="description" filter="false"/>
				<span id='statusSaving<bean:write name="questionItem" property="questionId"/>' style='color:#bbb'></span>
				<span id='errorSaving<bean:write name="questionItem" property="questionId"/>' style='color:#f00'></span>
				</legend>
		        <html:hidden name="FormDetailsForm" property="questionType(${questionItem.questionId})"/>
		        <html:hidden name="FormDetailsForm" property="questionId(${questionItem.questionId})"/>
			</fieldset>
			</logic:notEqual>
		  </logic:iterate>
          <logic:equal name="FormDetailsForm" property="status" value="OPEN">
		<!--  
		    <html:submit value="Enviar" />
            <div class="actions bottom"><a class="btn btn-warning link">Cancel</a><a class="btn custom-btn btn-large btn-info">Submit</a></div>
		-->
		  </logic:equal>
          </html:form>
		  </logic:present>
        </div>
      </div>
      <!-- Contenido fin-->
    </div>