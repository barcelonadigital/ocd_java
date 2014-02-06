<%-- 
    Document   : success
    Created on : 17-ene-2014, 12:06:05
    Author     : jroda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title><bean:message key="label.formDetails"/></title>
	    <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
	    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\\/script>');</script>
	    <script type="text/javascript">
		    function Ajax_query() {
		    	document.getElementById("ajaxResponseId").value = '';
		        var idForm = '<bean:write name="FormDetailsForm" property="idForm"/>';
		        var idQuestion = document.getElementById("ajaxFieldId").value;
		        var valueObj = document.getElementsByName("questionValue("+idQuestion+")")[0];
		        var value='';
		        if (typeof valueObj !== "undefined") {
		        	value = valueObj.value;
		        }
		        var type = document.getElementsByName("questionType("+idQuestion+")")[0].value;
		        var option=getRadioCheckedValue(idQuestion);
		        //var idQuestion = document.getElementsByName("questionId("+idQuestion+")")[0].value;

		        var url="formSetAnswerAction.do?idForm="+idForm+"&type="+type+"&option="+option+"&value="+value+"&idQuestion="+idQuestion;
		        ajaxCall(url,processMessage);
		    }
		    function ajaxGetQuestion(questionId) {
		    	var idForm = '<bean:write name="FormDetailsForm" property="idForm"/>';
		        var idQuestion = questionId;

		        var url="formGetQuestionAction.do?idForm="+idForm+"&idQuestion="+idQuestion;
		        ajaxCall(url,processQuestionMessage);
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
	
		    function processMessage(req){
		    	document.getElementById("ajaxResponseId").value = req.responseText;
		    	var responseOjb = JSON.parse(req.responseText);
		    	var questionsList = responseOjb.questionIds;
	    		for(var j=0;j<arrayQuestions.length;){
	    			var questionIdVisible = arrayQuestions[j];
	    			if(questionsList.indexOf(questionIdVisible) == -1){
	    				var fila = document.getElementById("fila"+questionIdVisible);
	    				fila.parentNode.removeChild(fila);
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
	    				var newLI = document.createElement('LI');
	    				newLI.innerHTML = '\n(ID: '+questionIdNew+')\n'+responseOjb.questionDescriptions[i]+'\n';
	    				newLI.id = 'fila'+questionIdNew;
	    				var fila = document.getElementById("fila"+questionIdVisible);
	    				fila.parentNode.insertBefore(newLI, fila);
	    				arrayQuestions.splice(k, 0, questionIdNew);
	    				ajaxGetQuestion(questionIdNew);
	    			}
    				k++;
    				i++;
	    		}
		    }
	
		    function processQuestionMessage(req){
		    	var questionOjb = JSON.parse(req.responseText);
		    	var fila = document.getElementById("fila"+questionOjb.questionId);
		    	if(questionOjb.type=='FORMULA'){
		    		fila.innerHTML += '<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+questionOjb.value;
		    	}else if(questionOjb.type=='TEXT' || questionOjb.type=='NUMERICAL'){
		    		var newInput = document.createElement("INPUT");
	    			newInput.name = "questionValue("+questionOjb.questionId+")";
	    			newInput.type = "text";
	    			newInput.value = questionOjb.value;
	    			fila.innerHTML += '<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
    				fila.appendChild(newInput);
		    		document.getElementById("ajaxResponseId").value = req.responseText;
		    	}else if(questionOjb.type=='VERTICAL_RADIO' || questionOjb.type=='HORIZONTAL_RADIO'){
		    		var optionsList = questionOjb.options;
		    		for(var i=0;i<optionsList.length;i++){
		    			var optionObj = optionsList[i];
		    			var newLabel = document.createElement('LABEL');
		    			var newInput = document.createElement("INPUT");
		    			newInput.name = "questionOption("+questionOjb.questionId+")";
		    			newInput.type = "radio";
		    			newInput.value = optionObj.optionId;
		    			if(optionObj.optionId == questionOjb.value){
		    				$(newInput).attr('checked',true);
		    			}
	    				newLabel.appendChild(newInput);
		    			newLabel.innerHTML += optionObj.description;
			    		fila.appendChild(newLabel);
		    		}
		    		document.getElementById("ajaxResponseId").value = req.responseText;
		    	}
		    }
		    
		    var arrayQuestions=new Array();
		    //var arrayIndexes=new Array();
		    <logic:iterate name="FormDetailsForm" property="questions" id="questionItem" indexId="index" type="org.bdigital.ocd.model.Question" >
		    arrayQuestions['${index}']='<bean:write name="questionItem" property="questionId"/>';
		    //arrayIndexes['<bean:write name="questionItem" property="questionId"/>']='${index}';
			</logic:iterate>

		    function loadQuestions(){
		    	for(var i=0;i<arrayQuestions.length;i++){
		    		ajaxGetQuestion(arrayQuestions[i]);
		    	}
		    }

	    </script>
	</head>
	<body onload="loadQuestions();">
	    <html:messages id="msg" property="general">
            <span style='color:red'><bean:write name="msg" /></span>
        </html:messages>
	    <h1><bean:message key="label.formDetails"/></h1>
	    <html:messages id="msg3" property="error">
            <span style='color:red'><bean:write name="msg3" /></span>
        </html:messages>
	    
	    <logic:present name="FormDetailsForm" property="questions">
	    <html:form action="/formSetAnswersAction">
	    <html:hidden name="FormDetailsForm" property="idForm"/>
		<html:button property="botoAjax" value="Ajax" onclick="Ajax_query()" /><input type="text" id="ajaxFieldId" name="ajaxFieldId" /><input type="text" id="ajaxResponseId" name="ajaxResponseId" style="width: 300px;" /><br/>
	    Preguntes: 
		<ul>
	    <logic:iterate name="FormDetailsForm" property="questions" id="questionItem" indexId="index" type="org.bdigital.ocd.model.Question" >
	        <html:hidden name="FormDetailsForm" property="questionType(${questionItem.questionId})"/>
	        <html:hidden name="FormDetailsForm" property="questionId(${questionItem.questionId})"/>
			<li id='fila<bean:write name="questionItem" property="questionId"/>'>
				(ID: <bean:write name="questionItem" property="questionId"/>)
				<logic:equal name="questionItem" property="type" value="STATIC_TEXT">
				    <bean:write name="questionItem" property="description" filter="false"/>
				</logic:equal>
				<logic:equal name="questionItem" property="type" value="FORMULA">
				    <bean:write name="questionItem" property="description" filter="false"/>
				</logic:equal>
				<% boolean isRadioType = false; %>  
				<logic:equal name="questionItem" property="type" value="VERTICAL_RADIO">  
				<% isRadioType = true; %>
				</logic:equal>  
				<logic:equal name="questionItem" property="type" value="HORIZONTAL_RADIO">  
				<% isRadioType = true; %>  
				</logic:equal>  
				<%  if (isRadioType) {  %>  
				    <bean:write name="questionItem" property="description" filter="false"/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <logic:iterate name="questionItem" property="options" id="optionItem" type="org.bdigital.ocd.model.Option" >
				        <label>
				        <html:radio name="FormDetailsForm" property="questionOption(${questionItem.questionId})" value="${optionItem.optionId}" />
				        <bean:write name="optionItem" property="description"/>
				        </label>
					</logic:iterate>
				<% } %>  
				<% boolean isTextType = false; %>  
				<logic:equal name="questionItem" property="type" value="TEXT">  
				<% isTextType = true; %>
				</logic:equal>  
				<logic:equal name="questionItem" property="type" value="NUMERICAL">  
				<% isTextType = true; %>  
				</logic:equal>  
				<%  if (isTextType) {  %>  
				    <bean:write name="questionItem" property="description" filter="false"/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <html:text name="FormDetailsForm" property="questionValue(${questionItem.questionId})" />
				<% } %>  
				<logic:equal name="questionItem" property="type" value="TEXT_AREA">  
				    <bean:write name="questionItem" property="description" filter="false"/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <html:textarea name="FormDetailsForm" property="questionValue(${questionItem.questionId})" />
				</logic:equal>  
				<logic:equal name="questionItem" property="type" value="DATE">  
				    <bean:write name="questionItem" property="description" filter="false"/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <html:text name="FormDetailsForm" property="questionValue(${questionItem.questionId})" />
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
			</li>
		</logic:iterate>
		</ul>
		<logic:equal name="FormDetailsForm" property="status" value="OPEN">
			<html:submit value="Enviar" />
		</logic:equal>
		</html:form>
		</logic:present>
	    
	</body>
</html>
