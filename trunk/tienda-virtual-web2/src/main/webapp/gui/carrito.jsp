<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>

<logic:present name="carrito">
			<div id="carrito">
				<h3>Carrito</h3>
				<div class="menu-container">
					<ul>
				<logic:iterate name="carrito" id="linea" property="lineasPedido" indexId="i">
						<li>
							<bean:write name="linea" property="compra.marca"/> <bean:write name="linea" property="compra.modelo"/> <br/>
							<big><bean:write name="linea" property="precioUnidad"/> &euro;</big><br/>
							<a href="listado.do?opt=2&amp;lid=<bean:write name="i"/>&amp;idcat=<bean:write name="idcat"/>&amp;idpr=<bean:write name="linea" property="compra.id"/>">borrar</a>
						</li>
				</logic:iterate>
					</ul>
					<div>Total: <bean:write name="carrito" property="totalSinIVA" /> &euro;</div>
				</div>
			</div>
</logic:present>