<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
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
    <script src="js/vendor/datepicker/bootstrap-datepicker.js"></script>
    <script src="js/vendor/bootstrap-paginator.js"></script>
    <script src="js/main.js"></script>
    <script>
      var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
      (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
      g.src='//www.google-analytics.com/ga.js';
      s.parentNode.insertBefore(g,s)}(document,'script'));
      
    </script>
    <script>
        $.fn.datepicker.dates['linkcare'] = {
    			days: ['<bean:message key="datepicker.sunday"/>', '<bean:message key="datepicker.monday"/>', '<bean:message key="datepicker.tuesday"/>', '<bean:message key="datepicker.wednesday"/>', '<bean:message key="datepicker.thursday"/>', '<bean:message key="datepicker.friday"/>', '<bean:message key="datepicker.saturday"/>', '<bean:message key="datepicker.sunday"/>'],
    			daysShort: ['<bean:message key="datepicker.sunday.abrev3"/>', '<bean:message key="datepicker.monday.abrev3"/>', '<bean:message key="datepicker.tuesday.abrev3"/>', '<bean:message key="datepicker.wednesday.abrev3"/>', '<bean:message key="datepicker.thursday.abrev3"/>', '<bean:message key="datepicker.friday.abrev3"/>', '<bean:message key="datepicker.saturday.abrev3"/>', '<bean:message key="datepicker.sunday.abrev3"/>'],
    			daysMin: ['<bean:message key="datepicker.sunday.abrev2"/>', '<bean:message key="datepicker.monday.abrev2"/>', '<bean:message key="datepicker.tuesday.abrev2"/>', '<bean:message key="datepicker.wednesday.abrev2"/>', '<bean:message key="datepicker.thursday.abrev2"/>', '<bean:message key="datepicker.friday.abrev2"/>', '<bean:message key="datepicker.saturday.abrev2"/>', '<bean:message key="datepicker.sunday.abrev2"/>'],
    			months: ['<bean:message key="datepicker.january"/>','<bean:message key="datepicker.february"/>','<bean:message key="datepicker.march"/>','<bean:message key="datepicker.april"/>','<bean:message key="datepicker.may"/>','<bean:message key="datepicker.june"/>','<bean:message key="datepicker.july"/>','<bean:message key="datepicker.august"/>','<bean:message key="datepicker.september"/>','<bean:message key="datepicker.october"/>','<bean:message key="datepicker.november"/>','<bean:message key="datepicker.december"/>'],
    			monthsShort: ['<bean:message key="datepicker.january.abrev3"/>','<bean:message key="datepicker.february.abrev3"/>','<bean:message key="datepicker.march.abrev3"/>','<bean:message key="datepicker.april.abrev3"/>','<bean:message key="datepicker.may.abrev3"/>','<bean:message key="datepicker.june.abrev3"/>','<bean:message key="datepicker.july.abrev3"/>','<bean:message key="datepicker.august.abrev3"/>','<bean:message key="datepicker.september.abrev3"/>','<bean:message key="datepicker.october.abrev3"/>','<bean:message key="datepicker.november.abrev3"/>','<bean:message key="datepicker.december.abrev3"/>'],
    			today: '<bean:message key="datepicker.today"/>',
    			clear: '<bean:message key="datepicker.clear"/>'
		};

    </script>