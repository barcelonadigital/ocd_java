<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        <div class="content">
            <h2 class="newsession">Enviament de document al SAP</h2>
            <iframe src="http://localhost:8080/OCD/pdfHelloWorldAction.do"
                style="width:750px; height:375px;"  >
			</iframe>
            <div class="actions bottom">
	            <a class="btn btn-warning link">Cancel.</a>
	            <a class="btn custom-btn btn-large btn-info">Enviar</a>
            </div>
        </div>
