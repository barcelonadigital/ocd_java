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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>OCD</title>
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
    <tiles:insert attribute="body"/>
    <tiles:insert attribute="footer"/>
    
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/vendor/bootstrap-slider-edited.js"></script>
    <script src="js/main.js"></script>
    <script>
      var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
      (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
      g.src='//www.google-analytics.com/ga.js';
      s.parentNode.insertBefore(g,s)}(document,'script'));
      
    </script>
  </body>
</html>