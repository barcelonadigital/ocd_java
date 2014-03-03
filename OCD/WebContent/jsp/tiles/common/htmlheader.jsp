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
