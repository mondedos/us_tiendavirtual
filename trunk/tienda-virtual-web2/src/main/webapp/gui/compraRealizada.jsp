<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

	<div class="menu-container">
	
		Compra realizada correctamente
		<br>
		El identificador del pedido generado es: <bean:write name="idPedido"/>
		
		<br><br>
		
		<a href="start.do">Volver a la página inicial</a>
		
		
	
	</div>
