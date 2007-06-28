<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="es">
    <head>
        <title><bean:message key="app.header.title"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="gui/styles/default-style/css/reset.css" rel="stylesheet" type="text/css" />
		<link href="gui/styles/default-style/css/layout.css" rel="stylesheet" type="text/css" />
		<link href="gui/styles/default-style/css/design.css" rel="stylesheet" type="text/css" />
        <script src="gui/styles/default-style/js/mfis.js"></script>
    </head>
    <body>
    	<div id="container">
<tiles:insert attribute="header" />
<tiles:insert attribute="breadcrumbs" />
			<div id="menu">
<tiles:insert attribute="menu" />
			</div>
			<div id="workarea">
<tiles:insert attribute="workarea" />
			</div>
<tiles:insert attribute="foot" />
        </div>
    </body>
</html>
