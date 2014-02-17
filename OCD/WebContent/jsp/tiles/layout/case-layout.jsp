<%-- 
    Document   : success
    Created on : 17-ene-2014, 12:06:05
    Author     : jroda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
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
    <tiles:insert attribute="html-header"/>
    <script type="text/javascript">
	    function bodyOnLoad(){
	    	if (typeof bodyOnLoadAux !== "undefined") {
	    		bodyOnLoadAux();
	    	}
	    }

    </script>
  </head>
  <body onload="bodyOnLoad();">
    
    <tiles:insert attribute="header"/>
    <!-- Menú principal (final)-->
    <tiles:insert attribute="subheader"/>
    <div class="menuizqlayout <tiles:getAsString name="body-style"/>">
      <div class="container">
        <tiles:insert attribute="menu"/>
        <tiles:insert attribute="body"/>
      </div>
      <!-- Contenido fin-->
    </div>
    <tiles:insert attribute="footer"/>
    
  </body>
</html>