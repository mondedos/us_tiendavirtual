<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<title><bean:message key="app.titulo"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">    
	</head>
	<body>
<tiles:insert attribute="workarea" />
<script>disableLinks();</script>
	</body>
</html>