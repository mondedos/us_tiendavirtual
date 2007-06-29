<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

	<div class="menu-container">
		<bean:write name="mensajeInformativo"/>
		<br><br>
		<a href="<bean:write name="paginaRetorno"/>">
			<bean:write name="mensajeRetorno"/>
		</a>
		
	</div>