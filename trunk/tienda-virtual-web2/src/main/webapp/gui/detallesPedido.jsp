<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

	<div class="menu-container">
		<b>Detalles del pedido</b>
		<br><hr align="left"><br>
		
		<html:form action="detallesPedido.do">
			<table border="0">
				<tr><td><b>Dirección:  </b><bean:write name="pedido" property="direccion"/></td></tr>
				<tr><td><br></td></tr>
				<tr>
					<td><b>Estado:  </b> <bean:write name="pedido" property="estadoM"/></td>
					<td><b>Cambiar a:  </b> 
						<html:select property="nuevoEstado">
							<html:option value=""></html:option>
							<html:option value="Placed">Placed</html:option>
							<html:option value="Cancelled">Cancelled</html:option>
							<html:option value="Transient">Transient</html:option>
							<html:option value="Served">Served</html:option>
						</html:select>
					</td>
				</tr>
				<tr><td><br></td></tr>
				<tr><td><b>Importe: </b> <bean:write name="pedido" property="precioTotal"/></td></tr>
			</table>
			
			<br><br>
			<logic:present name="id">
				<input type="hidden" name="id" value="<bean:write name="id"/>"/>
			</logic:present>
			
			<html:submit value="Cambiar Estado"/>
		</html:form>
	
		<br><br>
		
		<table class="pedido" width="100%">
			<thead>
				<tr>
					<th>Referencia</th>
					<th>Categoria</th>
					<th>Marca</th>
					<th>Modelo</th>
					<th>Unidades</th>
					<th>Precio unidad</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate id="linea" name="lineasPedido">
					<tr>
						<td><bean:write name="linea" property="compra.referencia"/></td>
						<td><bean:write name="linea" property="compra.tipoItem"/></td>
						<td><bean:write name="linea" property="compra.marca"/></td>
						<td><bean:write name="linea" property="compra.modelo"/></td>
						<td><bean:write name="linea" property="unidades"/></td>
						<td><bean:write name="linea" property="precioUnidad"/></td>
						<td><bean:write name="linea" property="precioTotal"/></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
	</div>