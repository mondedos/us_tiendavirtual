<div class="menu-container">
	Compra realizada correctamente
	<br>
	<br>
	<a href="start.do">Volver a la página inicial</a>
</div>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<div class="menu-container">	
	<bean:write name="mensajeError"/>
	<br>
	<br>
	<a href="listado.do?opt=3&amp;lid=<bean:write name="lid"/>&amp;idcat=<bean:write name="idcat"/>&amp;idpr=<bean:write name="idpr"/>" >Volver a la página anterior</a>
</div>
