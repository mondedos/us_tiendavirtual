<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

			<div class="menu-listado-workarea">
				<h3>Comprar carrito</h3>
				<div class="mini-container">
				<logic:present name="carrito">
					<table class="carrito">
						<thead>
							<tr>
								<th><bean:message key="app.producto.0"/></th>
								<th><bean:message key="app.producto.5"/></th>
								<th>Unidades</th>
								<th><bean:message key="app.producto.3"/> unidad</th>
								<th>Precio total</th>
								<th></th>
							</tr>
						</thead>
					<logic:iterate name="carrito" id="linea" property="lineasPedido" indexId="i">
						<tbody>
							<tr>
								<td><bean:write name="linea" property="compra.marca"/></td>
								<td><bean:write name="linea" property="compra.modelo"/></td>
								<td><bean:write name="linea" property="unidades"/> ud(s).
								<td><bean:write name="linea" property="precioUnidad"/></td>
<%
mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido lp = (mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido)pageContext.getAttribute("linea");
float total = (float) lp.getUnidades() * lp.getPrecioUnidad().floatValue();
%>
								<td><%=total %></td>
								<td><a href="listado.do?opt=2&amp;lid=<bean:write name="i"/>&amp;idcat=<bean:write name="idcat"/>&amp;idpr=<bean:write name="linea" property="compra.id"/>&amp;l=.compra"> <bean:message key="app.listado.2"/> </a>	</td>
							</tr>
						</tbody>
					</logic:iterate>
						<tfoot>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td class="compra-total"><strong><big><bean:write name="carrito" property="totalSinIVA" format="#,##0.00" /> &euro;</big></strong></td>
								<td></td>
							</tr>
						</tfoot>
					</table>
					<br><br>
					
					<html:form action="realizarCompra.do">
						
						<label for="direccionUsuario">Por favor, introduzca la dirección a la que desea que el pedido le sea enviado:</label><br>
						<html:textarea property="direccionUsuario" />
						
						<br><br>
						
						<html:submit property="Realizar compra" value="Realizar compra"/>
					</html:form>
	
				</logic:present>
				<logic:notPresent name="carrito">
					Actualmente no tiene productos en el carrito.
				</logic:notPresent>
				</div>
			</div>