<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<div class="menu-container">	
		<bean:write name="mensajeError"/>
		<br>
		<br>
		<bean:define id="mensaje" name="mensajeError"/>
		<a href="listado.do?opt=3&amp;lid=<bean:write name="lid"/>&amp;idcat=<bean:write name="idcat"/>&amp;idpr=<bean:write name="idpr"/>" >Volver a la página anterior</a>
</div>