






<!DOCTYPE html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7"> </html>
<![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8"> </html>
<![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9"> </html>
<![endif]-->
<!-- [if gt IE 8] <!-->
<html class="no-js">
  <!-- <![endif]-->
  <head>
    <title>OCD</title>
    



    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <link rel="stylesheet" href="js/libs/jqueryui/css/base/jquery-ui.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\\/script>')</script>
    <script src="js/libs/jqueryui/jquery-ui.js"></script>
    <!--[if lt IE 9]>
    <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script>window.html5 || document.write('<script src="js/vendor/html5shiv.js"><\\/script>')</script>
    <![endif]-->
    <!--[if (gte IE 8)&(lte IE 8)]>
    <script src="js/vendor/selectivizr.min.js"></script>
    <![endif]-->
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/vendor/bootstrap-slider-edited.js"></script>
    <script src="js/main.js"></script>
    <script>
      var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
      (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
      g.src='//www.google-analytics.com/ga.js';
      s.parentNode.insertBefore(g,s)}(document,'script'));
      
    </script>
    <link rel="stylesheet" href="js/libs/jqueryui/css/base/jquery-ui.css">
    <script src="js/libs/jqueryui/jquery-ui.js"></script>
    <script>
        $.datepicker.setDefaults({
            dateFormat: 'dd/mm/yy',
            monthNames: ["Gener","Febrer","Març","Abril","Maig","Juny",
                            "Juliol","Agost","Setembre","Octubre","Novembre","Decembre"],
            closeText: "Tancar", // Display text for close link
            prevText: "Ant", // Display text for previous month link
            nextText: "Seg", // Display text for next month link
            currentText: "Avui", // Display text for current month link
            monthNamesShort: ["Gen","Feb","Mar","Abr","Mai","Jun","Jul","Ago","Set","Oct","Nov","Dec"], // For formatting
            dayNames: ["Diumenge", "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte"], // For formatting
            dayNamesShort: ["Diu","Dil","Dim","Dim","Dij","Div","Dis"], // For formatting
            dayNamesMin: ["Dg","Dl","Dm","Dc","Dj","Dv","Ds"], // Column headings for days starting at Sunday
            weekHeader: 'Sm',
            firstDay: 1,
            isRTL: false,
            showMonthAfterYear: false,
            yearSuffix: ''

        });

    </script>

    <script type="text/javascript">
	    function bodyOnLoad(){
	    	if (typeof bodyOnLoadAux !== "undefined") {
	    		bodyOnLoadAux();
	    	}
	    }

    </script>
  </head>
  <body onload="bodyOnLoad();">
    <div id="wrapper">
	    



    <!--[if lt IE 7]>
    <p class="chromeframe">You are using an<strong>outdated</strong>browser. Please<a href="http://browsehappy.com/">upgrade your browser</a>or<a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a>to improve your experience.</p>
    <![endif]-->
    <!-- Cabecera inicio-->
    <div class="custom-cabecera">
      <div class="container">
        <header><a href="/OCD/mainPg.do" class="brand">OCD</a></header>
        <nav>
          <ul class="nav">
            <li class="user"><a href="#" data-toggle="dropdown"><img src="img/ico-clinician-m.png" alt="Claudia Pérez Beroy"><strong>Claudia Pérez Beroy</strong><span>HCPB</span></a>
              <div class="dropdown-menu">
                <ul>
                  <!--
                  <li><a href="/OCD/logoutAction.do">El meu compte</a></li>
                  -->
                  <li><a href="/OCD/logoutAction.do">Tancar sessió</a></li>
                </ul>
              </div>
            </li>
          </ul>
        </nav>
      </div>
    </div>
    <!-- Cabecera (final)-->
    <!-- Menú principal-->
    
    <nav data-spy="affix" data-offset-top="106" class="custom-menuprincipal">
      <div class="container">
        <ul class="nav">
          <li><a href="#" data-toggle="dropdown" class="users">
              <strong>Usuaris</strong><span>Pacients, metges...</span></a>
            <div class="dropdown-menu">
              
              <div class="newpacient"><a href="/OCD/caseSearchPg.do" class="brand">Seleccionar <br>pacient</a></div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="tasks">
              <strong>Tasques</strong><span>Prescripció OCD, Altes</span></a>
            <div class="dropdown-menu">
              
              <div class="task_links">
                <ul>
                <!-- 
                
			    
			    
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=228&idCase=723&amp;idActivity=%23XTRANSFER_18" onclick="return confirm('Es finalitzarà (DISCHARGE) el protocol actiu actualment. Dessitja continuar?');">Seguiment Paliatiu</a></li>
				
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=228&idCase=723&amp;idActivity=%23XTRANSFER_19" onclick="return confirm('Es finalitzarà (DISCHARGE) el protocol actiu actualment. Dessitja continuar?');">Seguiment No Paliatiu</a></li>
				
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=228&idCase=723&amp;idActivity=%23XTRANSFER_20" onclick="return confirm('Es finalitzarà (DISCHARGE) el protocol actiu actualment. Dessitja continuar?');">Revisió d&#39;oxigen prescrit</a></li>
				
				
			    
			    
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=228&idCase=723&amp;idActivity=%23XDISCHARGE">Alta del programa</a></li>
				
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=228&idCase=723&amp;idActivity=%23XREJECT">Rebuig de programa</a></li>
				
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=228&idCase=723&amp;idActivity=%23XPAUSE">Pausa del programa</a></li>
				
				
				
				-->
                </ul>
              </div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="report">
              <strong>Reports</strong><span>Estadistiques</span></a>
            <div class="dropdown-menu">
              
              <div class="links">
                <ul>
                  <li><a href="#">Link 1</a></li>
                  <li><a href="#">Link 2</a></li>
                  <li><a href="#">Link 3</a></li>
                </ul>
              </div>
            </div>
          </li>
          <li><a href="#" data-toggle="dropdown" class="more">
              <strong>Altres</strong><span>Item1, Item2</span></a>
            <div class="dropdown-menu">
              
              <div class="links">
                <ul>
                  <li><a href="#">Link 1</a></li>
                  <li><a href="#">Link 2</a></li>
                  <li><a href="#">Link 3</a></li>
                </ul>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </nav>
    
	    <!-- Menú principal (final)-->
	    



    <script>
      
      var idActivitat;
      function preAssignarProtocol(idActivitatSeleccionada) {
    	  idActivitat = idActivitatSeleccionada;
    	  $('#alertModal').modal('hide');
    	  $('#confirmationModal').modal('show');
      }
      function assignarProtocol() {
    	  var params = { idAdmission:'228', idCase:'723', idActivity:idActivitat };
    	  var str = $.param( params );
    	  window.location='/OCD/caseTaskInsertAction.do?'+str;
      }
    </script>
    <div class="cabeceraperfil">
      <div class="container">
        <div id="contentnophoto" class="content">
          <small>Pacient</small>
          <h2>Jordi Roda Vilella</h2><span><strong>Edat:</strong> 32</span><span><strong>Gènere:</strong> M</span>
          <div class="actionsbottom">
            <div class="dropdown"><a data-toggle="dropdown" class="btn btn-blancogris btn-doslineas btn-large">
                <strong>Protocol</strong>
				
				
				
                Avaluació i Prescripció ...
                
                &nbsp;<span class="caret triangulo"></span></a>
			    
			    
			    <ul class="dropdown-menu">
			    
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=723&idAdmission=228">Avaluació i Prescripció (RAE/Hosp)</a>
			           </li>
				
				</ul>
				
				
            </div>
            <span class="info">
	            <strong>Inici del protocol</strong>
	            2014-02-25 13:40:18&nbsp;
            </span>
            <span class="info">
	            <strong>Estat del protocol</strong>
	            ACTIVE&nbsp;
            </span>
            <a href="#alertModal" role="button" data-toggle="modal" class="btn btn-warning btn-large custom-btn">Nou protocol</a>
          </div>
          <div class="actionstop"><a href="/OCD/caseSearchPg.do" class="btn btn-large">Seleccionar un altre pacient</a></div>
          <div class="contactinfo">
            <div class="dropdown">
              <a href="#" data-toggle="dropdown" class="btn-large dropdown-toggle">Dades de contacte<span class="caret"></span></a>
              <div class="dropdown-menu">
              <ul>
                
                
                
			    
                      <li><b>Adreça 1:</b></li>
                      <li>Muntaner
                          122
                          Pis 1
                          3</li>
                      <li>08032 
                          Barcelona</li>
                      <li>España<br></li>
				
				
				
                
				
                
              </ul></div>
            </div>  
          </div>
          <!-- 
          <div class="contactinfo">
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="#protocolsModal" role="button" data-toggle="modal">Històric protocols</a>
          </div>
          -->
        </div>
      </div>
    </div>
    <!-- Lightbox-->
    <div id="alertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal alert hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Avís</h3>
      </div>
      <div class="modal-body">
        <p>Si us plau, seleccioni el protocol que vol assignar al pacient:</p>
      </div>
      <div class="modal-footer">
        <div class="btn-block">
                
			    
			    
					<button onclick="preAssignarProtocol('#XTRANSFER_18')" class="btn btn-warning custom-btn btn-large">Seguiment Paliatiu</button>
				
					<button onclick="preAssignarProtocol('#XTRANSFER_19')" class="btn btn-warning custom-btn btn-large">Seguiment No Paliatiu</button>
				
					<button onclick="preAssignarProtocol('#XTRANSFER_20')" class="btn btn-warning custom-btn btn-large">Revisió d&#39;oxigen prescrit</button>
				
				
			    
			    
					<button onclick="preAssignarProtocol('#XDISCHARGE')" class="btn btn-warning custom-btn btn-large">Alta del programa</button>
				
					<button onclick="preAssignarProtocol('#XREJECT')" class="btn btn-warning custom-btn btn-large">Rebuig de programa</button>
				
					<button onclick="preAssignarProtocol('#XPAUSE')" class="btn btn-warning custom-btn btn-large">Pausa del programa</button>
				
				
				
        </div>
      </div>
    </div>
    <div id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal confirmation hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Assignar protocol?</h3>
      </div>
      <div class="modal-body">
        <p>
          Es finalitzarà el protocol actiu actualment. Dessitja continuar?
        </p>
      </div>
      <div class="modal-footer">
        <button data-dismiss="modal" aria-hidden="true" class="btn btn-success custom-btn btn-large">Revisar</button>
        <button onclick="assignarProtocol()" class="btn btn-primary custom-btn btn-large">D'acord, assignar</button>
      </div>
    </div>
    <div id="protocolsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal protocols hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Protocols assignats</h3>
      </div>
      <div class="modal-body table">
        <table>
          <tr>
            <th>Protocol</th>
            <th>Inici del protocol</th>
            <th>Estat del protocol</th>
            <th>Opcions</th>
          </tr>
	    
	    
			
			
			
            <tr>
                <td>Avaluació i Prescripció (RAE/Hosp)</td>
                <td>2014-02-26 16:16:30</td>
                <td>ACTIVE</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=723&idAdmission=228" class="news-block-link">Accedir</a></td>
            </tr>
		
		
          
        </table>
      </div>
      <div class="modal-footer"></div>
    </div>
	    <div class="menuizqlayout gris1">
	      <div class="container">
	        



        
        
	        
	        
		        
		        
		        
		        
	        
        
        <nav class="menuizq">
          <ul>
            <!-- 
             -->
            <li><a href="/OCD/caseTaskDetailsAction.do?idCase=723&idAdmission=228" class="active">Formularis</a></li>
            <li><a href="/OCD/caseDetailsAction.do?idCase=723&idAdmission=228" class="">Informació pacient</a></li>
            <!-- 
            <li><a href="/OCD/caseHistoricAction.do?idCase=723" class="">Protocols anteriors</a></li>
             -->
          </ul>
        </nav>
	        



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
		        var idForm = '300';
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
		    	var idForm = '300';
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
		    
		    
		    arrayQuestions['0']='4';
		    //arrayIndexes['4']='0';
		    arrayRequestCounter['4']=0;
		    arrayConditions['0']='';
			
		    arrayQuestions['1']='36';
		    //arrayIndexes['36']='1';
		    arrayRequestCounter['36']=0;
		    arrayConditions['1']='$4,EQUAL,9';
			
		    arrayQuestions['2']='6';
		    //arrayIndexes['6']='2';
		    arrayRequestCounter['6']=0;
		    arrayConditions['2']='$4,EQUAL,1';
			
		    arrayQuestions['3']='38';
		    //arrayIndexes['38']='3';
		    arrayRequestCounter['38']=0;
		    arrayConditions['3']='$4,EQUAL,1';
			
		    arrayQuestions['4']='7';
		    //arrayIndexes['7']='4';
		    arrayRequestCounter['7']=0;
		    arrayConditions['4']='$4,EQUAL,1';
			
		    arrayQuestions['5']='39';
		    //arrayIndexes['39']='5';
		    arrayRequestCounter['39']=0;
		    arrayConditions['5']='$4,EQUAL,1';
			
		    arrayQuestions['6']='8';
		    //arrayIndexes['8']='6';
		    arrayRequestCounter['8']=0;
		    arrayConditions['6']='$4,EQUAL,1';
			
		    arrayQuestions['7']='11';
		    //arrayIndexes['11']='7';
		    arrayRequestCounter['11']=0;
		    arrayConditions['7']='';
			
		    arrayQuestions['8']='12';
		    //arrayIndexes['12']='8';
		    arrayRequestCounter['12']=0;
		    arrayConditions['8']='';
			
		    arrayQuestions['9']='40';
		    //arrayIndexes['40']='9';
		    arrayRequestCounter['40']=0;
		    arrayConditions['9']='$12,RANGE,56,60';
			
		    arrayQuestions['10']='13';
		    //arrayIndexes['13']='10';
		    arrayRequestCounter['13']=0;
		    arrayConditions['10']='';
			
		    arrayQuestions['11']='14';
		    //arrayIndexes['14']='11';
		    arrayRequestCounter['14']=0;
		    arrayConditions['11']='';
			
		    arrayQuestions['12']='15';
		    //arrayIndexes['15']='12';
		    arrayRequestCounter['15']=0;
		    arrayConditions['12']='';
			
		    arrayQuestions['13']='16';
		    //arrayIndexes['16']='13';
		    arrayRequestCounter['16']=0;
		    arrayConditions['13']='$15,EQUAL,2';
			
		    arrayQuestions['14']='17';
		    //arrayIndexes['17']='14';
		    arrayRequestCounter['17']=0;
		    arrayConditions['14']='';
			
		    arrayQuestions['15']='51';
		    //arrayIndexes['51']='15';
		    arrayRequestCounter['51']=0;
		    arrayConditions['15']='';
			
		    arrayQuestions['16']='52';
		    //arrayIndexes['52']='16';
		    arrayRequestCounter['52']=0;
		    arrayConditions['16']='$51,EQUAL,1';
			
		    arrayQuestions['17']='30';
		    //arrayIndexes['30']='17';
		    arrayRequestCounter['30']=0;
		    arrayConditions['17']='';
			
			

		    function loadQuestions(){
		    	for(var i=0;i<arrayQuestions.length;i++){
		    		ajaxGetQuestion(arrayQuestions[i]);
		    	}
		    }
		    
		    function checkConditions(){
		    	for(var i=0;i<arrayConditions.length;i++){
		    		var condition = arrayConditions[i];
		    		if(condition!==''){
			    		var elems = condition.split(',');
			    		var idQuestion = elems[0].substring(1);
			    		var oper = elems[1];
			    		var valueObj = getInputValue(idQuestion);
			    		var option=getRadioCheckedValue(idQuestion);
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
		    	   var options = document.getElementsByName("questionOption("+idQuestion+")");
		    	   for(var i=0;i<options.length;i++){
		    		   options[i].disabled = disabledValue;
		    	   }
		       }else{
		    	   document.getElementsByName("questionValue("+idQuestion+")")[0].disabled = disabledValue;
		       }
		    }
		    
		    function bodyOnLoadAux(){
		    	checkConditions();
		    }

	        function doSubmit() {
	          document.getElementById('newForm').submit();
	          return false;
	        }
	    </script>
        <div class="content contabs">
        
          <h3>DADES CLÍNIQUES</h3>
          <form name="FormSetAnswersForm" id="newForm" method="post" action="/OCD/formSetAnswersAction.do">
          <input type="hidden" name="idCase" value="723">
          <input type="hidden" name="idAdmission" value="228">
          <input type="hidden" name="idForm" value="300">
          <div class="contentconbotoneslaterales">
            <div class="tabbable">
              <!-- Only required for left/right tabs-->
              <ul class="nav nav-tabs">
                
                
                
                
                
                
                <li class="active"><a href="#tab0" data-toggle="tab">Diagnostic</a></li>
                
                
                
                
                
                <li class=""><a href="#tab1" data-toggle="tab">Espirometria</a></li>
                
                
                
                
                
                <li class=""><a href="#tab2" data-toggle="tab">Gasometria</a></li>
                
                
                
                
                
                <li class=""><a href="#tab3" data-toggle="tab">Pulsioximetria</a></li>
                
                
                
                
                
                <li class=""><a href="#tab4" data-toggle="tab">Prescripció</a></li>
                
              </ul>
              <div class="tab-content">
                
                
                
                
                
                
                <div id="tab0" class="tab-pane dataform active">
                  
                  
                  
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="bigfield" id='fila4'>
		                      
		                      <label class="description">
								Diagnostic principal
								<span id='statusSaving4' style='color:#bbb'></span>
								<span id='errorSaving4' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute; fds df sf sdfds df sf sdfds df sf sd fds df sf sdfds df sf sdfds df sf sd fds df sf sd
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(4)" value="VERTICAL_RADIO">
						      <input type="hidden" name="questionId(4)" value="4">
						        
			 				    
			 				  
			 				    
			 				    
			 				  
			 				  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="1" onchange="checkConditions()">
		 				        Respiratori - MPOC
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="2" onchange="checkConditions()">
		 				        Respiratori - Fibrosi pulmonar
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="3" onchange="checkConditions()">
		 				        Respiratori - Bronquièctasis
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="4" onchange="checkConditions()">
		 				        Respiratori - Asma
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="4" onchange="checkConditions()">
		 				        Respiratori - Apnea del son
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="4" onchange="checkConditions()">
		 				        Respiratori - Altres
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="5" onchange="checkConditions()">
		 				        Cardiològic - Insuficiència cardíaca
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="6" onchange="checkConditions()">
		 				        Malalties Neuromusculars
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="7" onchange="checkConditions()">
		 				        Malalties Caixa toràcica
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(4)" value="8" onchange="checkConditions()">
		 				        Càncer
		 				        </label>
		 					  
		 				        
		 				        
		 				          
		 				        
		 				        <label class="radio active">
		 				        <input type="radio" name="questionOption(4)" value="9" checked="checked" onchange="checkConditions()">
		 				        Altres
		 				        </label>
		 					  
			  				    
			  				    
			 				    
			 				    
			 				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="bigfield" id='fila36'>
		                      
		                      <label class="description">
								Altres
								<span id='statusSaving36' style='color:#bbb'></span>
								<span id='errorSaving36' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(36)" value="TEXT_AREA">
						      <input type="hidden" name="questionId(36)" value="36">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			  				  
			  				  
		                        <textarea name="questionValue(36)" onkeyup="checkConditions()"></textarea>
		                      
		                      
		                      
		                    </div>
                    
                  </div>
                  
                </div>
                
                
                
                
                
                <div id="tab1" class="tab-pane dataform ">
                  
                  
                  
                  
                  <div class="h3actions"><a href="#helpEspiroModal" role="button" data-toggle="modal" class="help"></a></div>
                  
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila6'>
		                      
		                      <label class="description">
								FEV<sub>1</sub> (Litres)
								<span id='statusSaving6' style='color:#bbb'></span>
								<span id='errorSaving6' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(6)" value="NUMERICAL">
						      <input type="hidden" name="questionId(6)" value="6">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(6)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila38'>
		                      
		                      <label class="description">
								FEV<sub>1</sub> (%)
								<span id='statusSaving38' style='color:#bbb'></span>
								<span id='errorSaving38' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(38)" value="NUMERICAL">
						      <input type="hidden" name="questionId(38)" value="38">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(38)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila7'>
		                      
		                      <label class="description">
								FVC (Litres)
								<span id='statusSaving7' style='color:#bbb'></span>
								<span id='errorSaving7' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(7)" value="NUMERICAL">
						      <input type="hidden" name="questionId(7)" value="7">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(7)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila39'>
		                      
		                      <label class="description">
								FVC (%)
								<span id='statusSaving39' style='color:#bbb'></span>
								<span id='errorSaving39' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(39)" value="NUMERICAL">
						      <input type="hidden" name="questionId(39)" value="39">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(39)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila8'>
		                      
		                      <label class="description">
								FEV<sub>1</sub>/FVC (%)
								<span id='statusSaving8' style='color:#bbb'></span>
								<span id='errorSaving8' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(8)" value="NUMERICAL">
						      <input type="hidden" name="questionId(8)" value="8">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(8)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                </div>
                
                
                
                
                
                <div id="tab2" class="tab-pane dataform ">
                  
                  
                  <div class="h3actions"><a href="#helpGasometriaModal" role="button" data-toggle="modal" class="help"></a></div>
                  
                  
                  
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila11'>
		                      
		                      <label class="description">
								pH
								<span id='statusSaving11' style='color:#bbb'></span>
								<span id='errorSaving11' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(11)" value="NUMERICAL">
						      <input type="hidden" name="questionId(11)" value="11">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(11)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila12'>
		                      
		                      <label class="description">
								pO<SUB>2</SUB> (mmHg)
								<span id='statusSaving12' style='color:#bbb'></span>
								<span id='errorSaving12' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(12)" value="NUMERICAL">
						      <input type="hidden" name="questionId(12)" value="12">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(12)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="bigfield" id='fila40'>
		                      
		                      <label class="description">
								en cas de que els valors PO<SUB>2</SUB>  entre 56 i 59 anotar si evidencia:
								<span id='statusSaving40' style='color:#bbb'></span>
								<span id='errorSaving40' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(40)" value="HORIZONTAL_RADIO">
						      <input type="hidden" name="questionId(40)" value="40">
						        
			 				    
			 				    
			 				    
			 				    
			 				  
			 				  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(40)" value="1" onchange="checkConditions()">
		 				        Hipertensió pulmonar
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(40)" value="2" onchange="checkConditions()">
		 				        Cor pulmonale
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(40)" value="3" onchange="checkConditions()">
		 				        Policitèmia
		 				        </label>
		 					  
			  				    
			  				    
			 				    
			 				    
			 				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila13'>
		                      
		                      <label class="description">
								pCO<SUB>2</SUB> (mmHg)
								<span id='statusSaving13' style='color:#bbb'></span>
								<span id='errorSaving13' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(13)" value="NUMERICAL">
						      <input type="hidden" name="questionId(13)" value="13">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(13)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila14'>
		                      
		                      <label class="description">
								EB  (mEq/L)
								<span id='statusSaving14' style='color:#bbb'></span>
								<span id='errorSaving14' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(14)" value="NUMERICAL">
						      <input type="hidden" name="questionId(14)" value="14">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(14)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="bigfield" id='fila15'>
		                      
		                      <label class="description">
								Condicions en les que s´ha fet la gasometría arterial
								<span id='statusSaving15' style='color:#bbb'></span>
								<span id='errorSaving15' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(15)" value="VERTICAL_RADIO">
						      <input type="hidden" name="questionId(15)" value="15">
						        
			 				    
			 				  
			 				    
			 				    
			 				  
			 				  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(15)" value="1" onchange="checkConditions()">
		 				        Basal
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(15)" value="2" onchange="checkConditions()">
		 				        Oxigen
		 				        </label>
		 					  
			  				    
			  				    
			 				    
			 				    
			 				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila16'>
		                      
		                      <label class="description">
								Fluxe de O<SUB>2</SUB> (litres/minut)
								<span id='statusSaving16' style='color:#bbb'></span>
								<span id='errorSaving16' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(16)" value="NUMERICAL">
						      <input type="hidden" name="questionId(16)" value="16">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(16)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                </div>
                
                
                
                
                
                <div id="tab3" class="tab-pane dataform ">
                  
                  
                  
                  <div class="h3actions"><a href="#helpPulsioModal" role="button" data-toggle="modal" class="help"></a></div>
                  
                  
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="smallfield" id='fila17'>
		                      
		                      <label class="description">
								Saturació de  O<SUB>2</SUB> Basal (%)
								<span id='statusSaving17' style='color:#bbb'></span>
								<span id='errorSaving17' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(17)" value="NUMERICAL">
						      <input type="hidden" name="questionId(17)" value="17">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			 				    
			 				    
		                        <input type="text" name="questionValue(17)" value="" onkeyup="checkConditions()">
			  				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                </div>
                
                
                
                
                
                <div id="tab4" class="tab-pane dataform ">
                  
                  
                  
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="bigfield" id='fila51'>
		                      
		                      <label class="description">
								Es prescriu oxigen?
								<span id='statusSaving51' style='color:#bbb'></span>
								<span id='errorSaving51' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(51)" value="HORIZONTAL_RADIO">
						      <input type="hidden" name="questionId(51)" value="51">
						        
			 				    
			 				    
			 				    
			 				    
			 				  
			 				  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(51)" value="1" onchange="checkConditions()">
		 				        Si
		 				        </label>
		 					  
		 				        
		 				        
		 				        <label class="radio ">
		 				        <input type="radio" name="questionOption(51)" value="2" onchange="checkConditions()">
		 				        No
		 				        </label>
		 					  
			  				    
			  				    
			 				    
			 				    
			 				    
			  				  
			  				  
		                      
		                      
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
			 				  
		                    </div>
                    
                  </div>
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="bigfield" id='fila52'>
		                      
		                      <label class="description">
								Si us plau, en cas que no compleixi criteris, justifiqui el motiu pel que ha de portar el oxigen
								<span id='statusSaving52' style='color:#bbb'></span>
								<span id='errorSaving52' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(52)" value="TEXT_AREA">
						      <input type="hidden" name="questionId(52)" value="52">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			  				  
			  				  
		                        <textarea name="questionValue(52)" onkeyup="checkConditions()"></textarea>
		                      
		                      
		                      
		                    </div>
                    
                  </div>
                  
                  <div class="fields-row">
                    
                            
		                    
		                    
		                    
		                    
		                    <div class="bigfield" id='fila30'>
		                      
		                      <label class="description">
								Observacions
								<span id='statusSaving30' style='color:#bbb'></span>
								<span id='errorSaving30' style='color:#f00'></span>
								<span class="hint">
								  <a href="#" data-toggle="dropdown"><img src="img/ico-alert-green.png" alt="Hint"></a>
					              <span class="dropdown-menu">
					                Texte recomanaci&oacute;
					              </span>
					            </span>
								
							  </label>
						      <input type="hidden" name="questionType(30)" value="TEXT_AREA">
						      <input type="hidden" name="questionId(30)" value="30">
						        
			 				    
			 				    
			 				    
			  				    
			 				    
			 				    
			 				    
			  				  
			  				  
		                        <textarea name="questionValue(30)" onkeyup="checkConditions()"></textarea>
		                      
		                      
		                      
		                    </div>
                    
                  </div>
                  
                </div>
                
                
              </div>
            </div>
          </div>
          </form>
          <div class="botoneslaterales">
            <div class="botoneslateralescontainer">
              <div>
	            <a href="#" class="btn-primary btn savedataform" onclick="return doSubmit();">Desar</a>
                <a href="/OCD/caseTaskDetailsAction.do?idCase=723&idAdmission=228" class="btn-warning btn canceldataform">Cancel.</a>
              </div>
            </div>
          </div>
        </div>
    
    <div id="helpGasometriaModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal loadsession hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Informació</h3>
      </div>
      <div class="modal-body">
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
    </div>
    
    
    <div id="helpPulsioModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal loadsession hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Informació</h3>
      </div>
      <div class="modal-body">
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
    </div>
    
    
    <div id="helpEspiroModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal loadsession hide fade">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-hidden="true" class="close">close</button>
        <h3>Informació</h3>
      </div>
      <div class="modal-body">
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
    </div>
    
	      </div>
	      <!-- Contenido fin-->
	    </div>
    	<div class="push gris1"></div>
    </div>
        <div class="footer">
      <div class="container">© BDigital 2014</div>
    </div>
    
  </body>
</html>