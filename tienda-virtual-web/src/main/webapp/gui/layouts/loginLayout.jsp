<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html:html xhtml="true" lang="en">
    <head>
        <title><bean:message key="app.title"/></title>
        <meta http-equiv="Pragma" content="no-cache"/>
        <link rel="stylesheet" href="gui/resources/css/estilos.css" type="text/css"/>
    </head>
    <body>
        <tiles:insert attribute="top" />
        <tiles:insert attribute="workarea" />
    </body>
</html:html>
