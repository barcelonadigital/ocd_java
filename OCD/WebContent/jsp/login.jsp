<%-- 
    Document   : login
    Created on : 17-ene-2014, 12:00:52
    Author     : jroda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
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
    <!--[if lt IE 9]>
    <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script>window.html5 || document.write('<script src="js/vendor/html5shiv.js"><\\/script>')</script>
    <![endif]-->
    <!--[if (gte IE 8)&(lte IE 8)]>
    <script src="js/vendor/selectivizr.min.js"></script>
    <![endif]-->
  </head>
  <body class="login">
    <div class="container">
      <div class="nav">
        <ul>
          <li><a href="#">English</a></li>
          <li><a href="#">Español</a></li>
        </ul>
      </div>
      <h1 class="logo-ocd">OCD</h1>
      <div class="caja">
        <html:form action="/loginAction">
        <div class="dataform">
          <div class="smallfield">
					   <html:messages id="msg" property="general">
				           <span style='color:red'><bean:write name="msg" /></span>
				       </html:messages>
                       <html:messages id="msg" property="error">
		                   <span style='color:red'><bean:write name="msg" /></span>
		               </html:messages>&nbsp;
          </div>
          <div class="smallfield">
            <label><bean:message key="label.username"/></label>
            <html:text property="username" />
          </div>
          <div class="smallfield">
            <label><bean:message key="label.password"/></label>
            <html:password property="password" />
          </div>
          <div class="actions">
            <html:submit styleId="buttonEnter" styleClass="btn btn-large btn-primary" value="Entrar" />
            <buttom class="btn btn-large btn-primary cancel">Cancel·lar</buttom>
          </div>
        </div>
        </html:form>
      </div>
    </div>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.1.min.js"><\\/script>')</script>
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
