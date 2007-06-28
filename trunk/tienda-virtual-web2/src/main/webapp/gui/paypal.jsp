<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="es">
    <head>
        <</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="gui/styles/default-style/css/reset.css" rel="stylesheet" type="text/css" />
		<link href="gui/styles/default-style/css/layout.css" rel="stylesheet" type="text/css" />
		<link href="gui/styles/default-style/css/design.css" rel="stylesheet" type="text/css" />
        <script src="gui/styles/default-style/js/bdi.js"></script>
    </head>
    <body>
    	<div id="container">
<tiles:insert attribute="header" />
<tiles:insert attribute="breadcrumbs" />
		<div id="left">
<tiles:insert attribute="leftTop" />
		</div>
<tiles:insert attribute="right" />
<tiles:insert attribute="foot" />
        </div>
    </body>
</html>


	<html:hidden name="cmd" value="_cart"/>
						<html:hidden name="business" value="mfisg16@gmail.com"/>
						<html:hidden name="rm" value="2"/>
						<html:hidden name="undefined_quantity" value="1"/>
						<html:hidden name="charset" value="utf-8"/>
						<html:hidden name="no_shipping" value="1"/>
						<html:hidden name="cancel_return" value="http://localhost:8080/tiendavirtual__"/>
						<html:hidden name="no_note" value="0"/>
						
						<html:hidden name="item_name" value="Compra MFIS"/>
						<html:hidden name="amount" value="<bean:write name="carrito" property="totalSinIVA"/>"/>
						<html:hidden name="quantity" value="1"/>