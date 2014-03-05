<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
        <div class="content">
            <h2 class="newsession">Sol·licitud d'OCD a CatSalut</h2>
            <h4>Realitzi la sol·licitud a CatSalut a través d'aquesta finestra o d'una <a href="https://salut.gencat.net/pls/gsa/gsapk030.portal" target="_blank">nova</a>, i una vegada finalitzada indiqui-ho prement el botó que hi ha a <a href="#botoCompletat">peu de pàgina</a>.</h4>
            <iframe src="https://salut.gencat.net/pls/gsa/gsapk030.portal"
                style="width:750px; height:375px;"  >
			</iframe>
            <div class="actions bottom">
                <html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}" styleClass="btn btn-warning link">Cancel.</html:link>
	            <html:link action="/caseTaskDetailsAction?idCase=${caseBean.idCase}&idAdmission=${admissionBean.idAdmission}" styleId="botoCompletat" styleClass="btn custom-btn btn-large btn-info">Finalitzat</html:link>
            </div>
        </div>
