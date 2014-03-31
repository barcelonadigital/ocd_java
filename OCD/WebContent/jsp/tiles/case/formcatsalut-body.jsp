<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
	    <script type="text/javascript">
	    $(document).ready(
	    	    function() {
	    	        $('.copyText').click(
	    	        		function() {
//	    	        			window.prompt('COPIA el texte i TANCA la finestra',this.innerText); 
// 	    	        			var span = $(this)[0],
// 		    	    	        sel, range;

// 		    		    	    if(window.getSelection){
// 		    		    	        sel = window.getSelection();
// 		    		    	        range = document.createRange();
		    	
// 		    		    	        range.selectNode(span);
// 		    		    	        sel.removeAllRanges();
// 		    		    	        sel.addRange(range);
// 		    		    	     } else {
// 		    		    	        range = document.body.createTextRange();
// 		    		    	        range.moveToElementText(span);
// 		    		    	        range.select();
// 		    		    	     }
   	        		});

	    	});
	    </script>
        <div class="content">
            <h2 class="newsession">Sol·licitud d'OCD a CatSalut</h2>
            <!-- 
            <h4>Realitzi la sol·licitud a CatSalut a través d'aquesta finestra o d'una <a href="https://salut.gencat.net/pls/gsa/gsapk030.portal" target="_blank">nova</a>.</h4>
             -->
            <!-- 
            , i una vegada finalitzada indiqui-ho prement el botó que hi ha a <a href="#botoCompletat">peu de pàgina</a>
             -->
            <!-- 
            <iframe src="https://salut.gencat.net/pls/gsa/gsapk030.portal"
                style="width:750px; height:375px;"  >
			</iframe>
             -->
              <div class="columnboxes clearfix">
                <div class="column por2">
                  <fieldset>
                    <legend>Prescripció de tractament</legend>
                    <!-- 
                    <p>Diagnòstic principal: Altres; Si ha sel·leccionat "Altres" especifiqui: Bronquitis crónica; Motiu de la Sol·licitud: Inici de prescripció;Situació del Pacient: Estable; Metge Sol·licitant: Atenció Integrada</p>
                    -->
                    <p>
                    <span class="question">Data de Prescripció</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="dataSolicitud"/></span><br/>
                    <span class="question">Número d'Història Clínica</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="nhc"/></span><br/>
                    <span class="question">Telèfon de pacient 1</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="telefon1"/></span><br/>
                    <span class="question">Telèfon de pacient 2</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="telefon2"/></span><br/>
                    <span class="question">Telèfon de pacient 3</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="telefon3"/></span><br/>
                    <span class="question">Diagnòstic</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="descDiagnostic"/></span><br/>
                    <span class="question">Periode de validesa del tractament</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="duracio"/></span><br/>
                    <span class="question">Metge prescriptor</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="descMetgesSolicitant"/></span><br/>
                    
                    </p>
                  </fieldset>
                </div>
                <div class="column por2">
                  <fieldset>
                    <legend>Variables del tractament</legend>
                    <!-- 
                    <p>Diagnòstic principal: Altres; Si ha sel·leccionat "Altres" especifiqui: Bronquitis crónica; Motiu de la Sol·licitud: Inici de prescripció;Situació del Pacient: Estable; Metge Sol·licitant: Atenció Integrada</p>
                    -->
                    <p>
                    <span class="question">Ulleres nasals</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="descCanulaNasals"/></span><br/>
                    <span class="question">Flux repos I/MIN</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="fluxRepos"/></span><br/>
                    <span class="question">Hores/Dia&gt;15/</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="horesDia"/></span><br/>
                    <span class="question">Observacions</span> <span class="answer"><bean:write name="CaseFormCatSalutForm" property="observacions"/></span><br/>
                    </p>
                  </fieldset>
                </div>
              </div>
              
        <a href="#tab3" data-toggle="tab">Login</a>
        <a href="#tab0" data-toggle="tab">Prescripció</a>
        <a href="#tab1" data-toggle="tab">Variables</a>
        <a href="#tab2" data-toggle="tab">Retirada</a>
        <div class="tab-content">
          <div id="tab3" class="tab-pane dataform active">
            <iframe src="https://salut.gencat.net/pls/gsa/gsapk030.portal"
                style="width:750px; height:375px;"  >
			</iframe>
          </div>
          <div id="tab0" class="tab-pane dataform">
            <iframe src="/OCD/jsp/catsalut/_formulari_prescripcio.htm"
                style="width:750px; height:375px;"  >
			</iframe>
          </div>
          <div id="tab1" class="tab-pane dataform">
            <iframe src="/OCD/jsp/catsalut/_formulari_variables.htm"
                style="width:750px; height:375px;"  >
			</iframe>
          </div>
          <div id="tab2" class="tab-pane dataform">
            <iframe src="/OCD/jsp/catsalut/_formulari_retirada.htm"
                style="width:750px; height:375px;"  >
			</iframe>
          </div>
      </div>
            <!-- 
            <div class="actions bottom">
                <html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}" styleClass="btn btn-warning link">Cancel.</html:link>
	            <html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}" styleId="botoCompletat" styleClass="btn custom-btn btn-large btn-info">Finalitzat</html:link>
            </div>
             -->
        </div>
