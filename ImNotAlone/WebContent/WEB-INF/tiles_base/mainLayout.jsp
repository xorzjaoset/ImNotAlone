	<%@ page contentType="text/html; charset=UTF-8"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	<html>
	<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">	
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/ImNotAlone/resources/css/bundle.css" rel="stylesheet">
    <link href="/ImNotAlone/resources/css/style.css" rel="stylesheet">
	<title><tiles:getAsString name="title" /></title>
    </head>

        
	<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="body1" />
	<tiles:insertAttribute name="footer" />
	</body>
	
      <script src="/ImNotAlone/resources/js/plugins/all.js"></script>
      <script src="/ImNotAlone/resources/js/finder.custom.js"></script>
	</html>