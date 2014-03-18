<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
	    <script type="text/javascript">
		    function doSubmit() {
	          document.getElementById('newForm').submit();
	          return false;
	        }
		</script>
        <div class="content">
            <h2 class="newsession">Enviament de document a la historia clínica</h2>
            <h4>Per a enviar el document, prèmer el botó que hi ha a <a href="#botoEnviar">peu de pàgina</a>.</h4>

			<logic:equal name="CaseFormDocumentDetailsForm" property="idForm" value="DOCUMENTALTA">
			<iframe src="http://localhost:8080/OCD/informe/InformeAltaCAT-SPA.pdf"
                style="width:750px; height:375px;"  >
   			</iframe>
			</logic:equal>
			<logic:equal name="CaseFormDocumentDetailsForm" property="idForm" value="DOCUMENTPRESC">
			<iframe src="http://localhost:8080/OCD/informe/InformePrescripcioCAT-SPA.pdf"
                style="width:750px; height:375px;"  >
   			</iframe>
			</logic:equal>
			<logic:equal name="CaseFormDocumentDetailsForm" property="idForm" value="DOCUMENTVISIT">
			<iframe src="http://localhost:8080/OCD/informe/InformeVisitaCAT-SPA.pdf"
                style="width:750px; height:375px;"  >
   			</iframe>
			</logic:equal>
			<logic:equal name="CaseFormDocumentDetailsForm" property="idForm" value="DOCUMENT">
			<iframe src="http://localhost:8080/OCD/pdfHelloWorldAction.do?idCase=<bean:write name="CaseFormDocumentDetailsForm" property="idCase"/>"
                style="width:750px; height:375px;"  >
   			</iframe>
			</logic:equal>
			
            <div class="actions bottom">
	            <html:link action="/caseTaskUnitDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}&idTask=${CaseFormDocumentDetailsForm.idTask}" styleClass="btn btn-warning link">Cancel.</html:link>
	            <html:link action="/caseTaskUnitDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}&idTask=${CaseFormDocumentDetailsForm.idTask}" styleId="botoEnviar" styleClass="btn custom-btn btn-large btn-info">Enviar</html:link>
            </div>
        </div>
