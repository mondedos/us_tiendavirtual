<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="es">
    <head>
        <title><bean:message key="app.titulo"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
	<meta http-equiv="Pragma" content="no-cache">
        <link rel="stylesheet" href="recursos/css/estilos.css" type="text/css"/>
        <link rel="stylesheet" href="recursos/css/bdi.css" type="text/css"/>
        <script type="text/javascript" src="recursos/js/bdi.js"></script>
    </head>
    <body>
<tiles:insert attribute="cabecera" />
<tiles:insert attribute="migas" />		
        <div id="areacontenido">
        <!-- capa que hace las funciones de alto mínimo -->
            <div class="minheight height450"></div>
<tiles:insert attribute="workarea" />
        </div>
<tiles:insert attribute="pie" />
    </body>
</html>
