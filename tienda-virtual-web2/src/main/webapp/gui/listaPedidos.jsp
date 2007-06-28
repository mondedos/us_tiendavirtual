<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

	<div class="menu-container">
	
		<logic:present name="listaPedidos">
			Lista de pedidos para el operador:  <b><bean:write name="operador"/></b>
			<br><br><br><br>
			<table class="carrito">
				<thead>
					<tr>
						<th>Fecha de pedido</th>
						<th>Estado</th>
						<th>Fecha del último estado</th>
						<th>Importe</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<logic:iterate id="pedido" name="listaPedidos">
						
						<tr>
							<td><bean:write name="pedido" property="fechaPedido"/></td>
							<td><bean:write name="pedido" property="estado"/></td>
							<td><bean:write name="pedido" property="fechaDeServicio"/></td>
							<td><bean:write name="pedido" property="precioTotal" format="#,##0.00"/></td>
							<td>
								<form action="detallesPedido.do">
									<input type="hidden" name="id" value="<bean:write name="pedido" property="id"/>"/>
									<input type="submit" value="Detalles"/>
								</form>
							</td>
						</tr>
							
					</logic:iterate>		
				</tbody>
			</table>
		</logic:present>
		
		<logic:notPresent name="listaPedidos">
			No hay pedidos para el operador:  <b><bean:write name="operador"/></b>
		</logic:notPresent>
	</div>