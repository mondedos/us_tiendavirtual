<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<div class="menu-container">	
	<bean:write name="mensajeError"/>
	<br>
	<br>
	<a href="<bean:write name="direccionRetorno"/>">Volver a la página anterior</a>
</div>
