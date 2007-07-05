<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>

<div class="menu-listado-workarea">
<h3>Comprar carrito</h3>
<div class="mini-container"><logic:present name="carrito">
	<table class="carrito">
		<thead>
			<tr>
				<th><bean:message key="app.producto.0" /></th>
				<th><bean:message key="app.producto.5" /></th>
				<th>Unidades</th>
				<th><bean:message key="app.producto.3" /> unidad</th>
				<th>Precio total</th>
				<th></th>
			</tr>
		</thead>
		<logic:iterate name="carrito" id="linea" property="lineasPedido"
			indexId="i">
			<tbody>
				<tr>
			<logic:present name="linea" property="compra.marca">
					<td><bean:write name="linea" property="compra.marca" /></td>
					<td><bean:write name="linea" property="compra.modelo" /></td>
			</logic:present>
			<logic:present name="linea" property="compra.principal.marca">
					<td>
						<bean:write name="linea" property="compra.principal.marca" /> <br/>
						<bean:write name="linea" property="compra.secundario.marca" />
					</td>
					<td>
						<bean:write name="linea" property="compra.principal.modelo" /> <br/>
						<bean:write name="linea" property="compra.secundario.modelo" />
					</td>
			</logic:present>
					<td><bean:write name="linea" property="unidades" /></td> <%
 			mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido lp = (mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido) pageContext
 			.getAttribute("linea");
 			float totalFloat = (float) lp.getUnidades()
 			* lp.getPrecioUnidad().floatValue();
 			float unidadFloat = (float) lp.getPrecioUnidad()
 			.floatValue();
 			String precioTotal = null;
 			String precioUnidad = null;

 			precioTotal = mfis.tiendavirtual.util.Utilidades
 			.obtenerPrecio(Float.toString(totalFloat));
 			precioUnidad = mfis.tiendavirtual.util.Utilidades
 			.obtenerPrecio(Float.toString(unidadFloat));
 %>

					<td><%=precioUnidad%> &euro;</td>
					<td><%=precioTotal%> &euro;</td>
					<td>
						<a href="listado.do?opt=2&amp;
							lid=<bean:write name="i"/>&amp;
							idcat=<logic:present name="idcat"><bean:write name="idcat"/></logic:present><logic:notPresent name="idcat">0</logic:notPresent>&amp;
							idpr=<bean:write name="linea" property="compra.id"/>&amp;
							l=.compra">
					<bean:message key="app.listado.2" /> </a></td>
				</tr>
			</tbody>
		</logic:iterate>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td class="compra-total"><strong><big><bean:write
					name="carrito" property="totalSinIvaFormateado" /> &euro;</big></strong></td>
				<td></td>
			</tr>
		</tfoot>
	</table>
	<br>
	<br>

	<html:form action="realizarCompra.do?opt=1" styleId="compraForm"
		onsubmit="return validarPagina(this)">

		<label for="direccionUsuario">Por favor, introduzca la
		direcci�n a la que desea que el pedido le sea enviado:</label>
		<br>
		<html:textarea styleId="direccionUsuario" property="direccionUsuario" />

		<br>
		<br>

		<input type="image"
			src="https://www.paypal.com/es_ES/i/btn/x-click-but01.gif" border="0"
			name="submit"
			alt="Realice pagos con PayPal: es r�pido, gratis y seguro." />
	</html:form>

</logic:present>
<logic:notPresent name="carrito">
	Actualmente no tiene productos en el carrito.
	</logic:notPresent></div>
</div>
