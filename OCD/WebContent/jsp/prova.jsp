






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

		      var test = document.getElementById("test");


		      test.addEventListener("click", whatClicked, false);

	    }

	      function whatClicked(event) {
	    	  var target = $(event.target);
	    		if ($( target ).hasClass("dropdown-toggle")) {
	    		    //target = target.parent('a')
	    		}else{
	    			event.preventDefault();
	    			event.stopPropagation();
	    			var ct = $(event.currentTarget);
	    			window.location = $(event.currentTarget).attr("href");
	    		}
	          //alert(event.target.id);
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
            <li class="user"><a href="#" data-toggle="dropdown"><img src="img/ico-clinician-m.png" alt="Joan Ignasi Martinez Roldan"><strong>Joan Ignasi Martinez Roldan</strong><span>HCPB</span></a>
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
                
			    
			    
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=124&idCase=609&amp;idActivity=%23XTRANSFER_18" onclick="return confirm('Es finalitzarà (DISCHARGE) el protocol actiu actualment. Desitja continuar?');">Palliative Follow-up</a></li>
				
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=124&idCase=609&amp;idActivity=%23XTRANSFER_19" onclick="return confirm('Es finalitzarà (DISCHARGE) el protocol actiu actualment. Desitja continuar?');">Non palliative Follow-up</a></li>
				
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=124&idCase=609&amp;idActivity=%23XTRANSFER_20" onclick="return confirm('Es finalitzarà (DISCHARGE) el protocol actiu actualment. Desitja continuar?');">Prescribed oxygen review</a></li>
				
				
			    
			    
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=124&idCase=609&amp;idActivity=%23XDISCHARGE">Program Discharge</a></li>
				
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=124&idCase=609&amp;idActivity=%23XREJECT">Program Rejection</a></li>
				
					<li><a href="/OCD/caseTaskInsertAction.do?idAdmission=124&idCase=609&amp;idActivity=%23XPAUSE">Pause Program</a></li>
				
				
				
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
    	  var params = { idAdmission:'124', idCase:'609', idActivity:idActivitat };
    	  var str = $.param( params );
    	  window.location='/OCD/caseTaskInsertAction.do?'+str;
      }
    </script>
    <div class="cabeceraperfil">
      <div class="container">
        <div id="contentnophoto" class="content">
          <small>Pacient</small>
          <h2>Roda Jordi </h2>
          <span><strong>Edat:</strong> 32</span>
          <span><strong>Gènere:</strong> M</span>
          <span><strong>CIP:</strong> ROTOXXXXXXXX3C</span>
          <div class="actionsbottom">
            <div class="dropdown"><a data-toggle="dropdown" class="btn btn-blancogris btn-doslineas btn-large">
                <strong>Protocol</strong>
				
				
				
                Evaluation and Prescript...
                
                &nbsp;<span class="caret triangulo"></span></a>
			    
			    
			    <ul class="dropdown-menu">
			    
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=124">Evaluation and Prescription (RAE...</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=123">Palliative Follow-up</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=122">Evaluation and Prescription (RAE...</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=121">Evaluation and Prescription (RAE...</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=120">RAE Evaluation and Prescription</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=119">Palliative Follow-up</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=118">Prescribed oxygen review</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=115">Prescribed oxygen review</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=111">Non palliative Follow-up</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=110">Palliative Follow-up</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=108">Prescribed oxygen review</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=107">Evaluation and Prescription (RAE...</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=106">RAE Evaluation and Prescription</a>
			           </li>
				
					
					
					
					
					
			           <li>
			             <a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=105">Evaluation and Prescription (RAE...</a>
			           </li>
				
				</ul>
				
				
            </div>
            <span class="info">
	            <strong>Inici del protocol</strong>
	            2014-02-07 11:04:46&nbsp;
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
                
                
                
			    
				
                      <li>No hi ha cap adreça</li>
				
				
                
				
                
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
                
			    
			    
					<button onclick="preAssignarProtocol('#XTRANSFER_18')" class="btn btn-warning custom-btn btn-large">Palliative Follow-up</button>
				
					<button onclick="preAssignarProtocol('#XTRANSFER_19')" class="btn btn-warning custom-btn btn-large">Non palliative Follow-up</button>
				
					<button onclick="preAssignarProtocol('#XTRANSFER_20')" class="btn btn-warning custom-btn btn-large">Prescribed oxygen review</button>
				
				
			    
			    
					<button onclick="preAssignarProtocol('#XDISCHARGE')" class="btn btn-warning custom-btn btn-large">Program Discharge</button>
				
					<button onclick="preAssignarProtocol('#XREJECT')" class="btn btn-warning custom-btn btn-large">Program Rejection</button>
				
					<button onclick="preAssignarProtocol('#XPAUSE')" class="btn btn-warning custom-btn btn-large">Pause Program</button>
				
				
				
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
          Es finalitzarà el protocol actiu actualment. Desitja continuar?
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
                <td>Evaluation and Prescription (RAE/Hosp)</td>
                <td>2014-02-25 13:27:45</td>
                <td>ACTIVE</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=124" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Palliative Follow-up</td>
                <td>2014-02-07 11:04:45</td>
                <td>DISCHARGED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=123" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Evaluation and Prescription (RAE/Hosp)</td>
                <td>2014-02-06 17:23:07</td>
                <td>DISCHARGED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=122" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Evaluation and Prescription (RAE/Hosp)</td>
                <td>2014-02-06 13:51:24</td>
                <td>REJECTED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=121" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>RAE Evaluation and Prescription</td>
                <td>2014-02-06 12:05:52</td>
                <td>DISCHARGED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=120" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Palliative Follow-up</td>
                <td>2014-02-06 11:57:54</td>
                <td>DISCHARGED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=119" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Prescribed oxygen review</td>
                <td>2014-02-06 11:55:13</td>
                <td>PAUSED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=118" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Prescribed oxygen review</td>
                <td>2014-02-06 11:49:58</td>
                <td>REJECTED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=115" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Non palliative Follow-up</td>
                <td>2014-02-06 09:54:19</td>
                <td>DISCHARGED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=111" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Palliative Follow-up</td>
                <td>2014-02-06 09:45:56</td>
                <td>DISCHARGED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=110" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Prescribed oxygen review</td>
                <td>2014-02-06 09:33:19</td>
                <td>REJECTED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=108" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Evaluation and Prescription (RAE/Hosp)</td>
                <td>2014-02-05 18:45:26</td>
                <td>DISCHARGED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=107" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>RAE Evaluation and Prescription</td>
                <td>2014-02-05 18:33:47</td>
                <td>DISCHARGED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=106" class="news-block-link">Accedir</a></td>
            </tr>
		
			
			
			
            <tr>
                <td>Evaluation and Prescription (RAE/Hosp)</td>
                <td>2014-02-05 18:19:17</td>
                <td>DISCHARGED</td>
                <td><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=105" class="news-block-link">Accedir</a></td>
            </tr>
		
		
          
        </table>
      </div>
      <div class="modal-footer"></div>
    </div>
	    <div class="menuizqlayout ">
	      <div class="container">
	        



        
        
	        
	        
		        
		        
		        
		        
	        
        
        <nav class="menuizq">
          <ul>
            <!-- 
             -->
            <li><a href="/OCD/caseDetailsAction.do?idCase=609&idAdmission=124" class="">Informació pacient</a></li>
            <li><a href="/OCD/caseTaskDetailsAction.do?idCase=609&idAdmission=124" class="active">Formularis</a></li>
            <!-- 
            <li><a href="/OCD/caseHistoricAction.do?idCase=609" class="">Protocols anteriors</a></li>
             -->
          </ul>
        </nav>
	        



        <div class="content">
          
          
          
          
          <h3>Clinical data and COT Initial prescription (HOSPITAL)<span>2014-02-11 <strong>PENDING</strong></span></h3>
          <div class="formlist">
          <div class="table">
              <div class="formrow">
	              <a href="#" data-toggle="dropdown">
	              <span class="col1"><span><strong>FORMULARI</strong></span></span>
	              <span class="col2"><span>Dades cliniques</span></span>
	              <span class="col3"><span>Finalitzat</span></span>
	              <span class="col4 actions"><span><span class="btn dropdown-toggle">Options<span class="caret"></span></span></span></span>
	              </a>
	              <ul class="dropdown-menu">
                      <li><a href="#">Reobrir</a></li>
                  </ul>
              </div>
              <div class="formrow">
	              <a id="test" href="http://localhost:8080/OCD/caseFormStaticDetailsAction.do?idCase=723&idAdmission=228&idForm=301" data-toggle="dropdown">
	              <span id="a1" class="col1"><span><strong>FORMULARI</strong></span></span>
	              <span id="a2" class="col2"><span>Prescripcio inicial d'OCD</span></span>
	              <span id="a3" class="col3"><span>Finalitzat</span></span>
	              <span id="a4" class="col4 actions"><span><span class="btn dropdown-toggle">Options<span class="caret"></span></span></span></span>
	              </a>
	              <ul class="dropdown-menu">
                      <li><a href="#">Reobrir</a></li>
                  </ul>
              </div>
              <div class="formrow">
	              <a href="#" data-toggle="dropdown">
	              <span class="col1"><span><strong>REPORT</strong></span></span>
	              <span class="col2"><span>Enviament doc SAP</span></span>
	              <span class="col3"><span>Pendent</span></span>
	              <span class="col4 actions"><span><span class="btn dropdown-toggle">Options<span class="caret"></span></span></span></span>
	              </a>
	              <ul class="dropdown-menu">
                      <li><a href="#">Finalitzar</a></li>
                      <li><a href="#">Descarregar</a></li>
                  </ul>
              </div>
              <div class="formrow">
	              <a href="#" data-toggle="dropdown">
	              <span class="col1"><span><strong>REPORT</strong></span></span>
	              <span class="col2"><span>Solicitud CatSalut</span></span>
	              <span class="col3"><span>Pendent</span></span>
	              <span class="col4 actions"><span><span class="btn dropdown-toggle">Options<span class="caret"></span></span></span></span>
	              </a>
	              <ul class="dropdown-menu">
                      <li><a href="#">Finalitzar</a></li>
                      <li><a href="#">Descarregar</a></li>
                  </ul>
              </div>
          </div>
          </div>
            
          
          
          
          
          
          
        </div>

	      </div>
	      <!-- Contenido fin-->
	    </div>
    	<div class="push "></div>
    </div>
        <div class="footer">
      <div class="container">© BDigital 2014</div>
    </div>
    
  </body>
</html>