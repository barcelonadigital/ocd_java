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
            <h2 class="newsession">Enviament de document al SAP</h2>
            <h4>Per a enviar el document, prèmer el botó que hi ha a <a href="#botoEnviar">peu de pàgina</a>.</h4>
            <iframe src="http://localhost:8080/OCD/pdfHelloWorldAction.do"
                style="width:750px; height:375px;"  >
			</iframe>
            <div class="actions bottom">
	            <a class="btn btn-warning link">Cancel.</a>
	            <html:link styleId="botoEnviar" action="/caseFormCatSalutAction?idCase=${caseBean.idCase}&idAdmission=${caseBean.idAdmission}&idForm=${CaseFormDocumentDetailsForm.idForm}&idTask=${CaseFormDocumentDetailsForm.idTask}" styleClass="btn custom-btn btn-large btn-info">Enviar</html:link>
            </div>
        </div>
