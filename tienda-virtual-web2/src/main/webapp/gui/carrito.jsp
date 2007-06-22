<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>

<logic:present name="carrito">
			<div id="carrito">
				<h3>Carrito</h3>
				<div class="menu-container">

					<ul>
				<logic:iterate name="carrito" id="linea" property="lineasPedido" indexId="i">
						<li>
							<bean:write name="linea" property="compra.marca"/> <bean:write name="linea" property="compra.modelo"/><br/> <bean:write name="linea" property="unidades"/> ud(s).
							<a href="listado.do?opt=2&amp;lid=<bean:write name="i"/>&amp;idcat=<bean:write name="idcat"/>&amp;idpr=<bean:write name="linea" property="compra.id"/>"> <bean:message key="app.listado.2"/> </a>
						</li>
				</logic:iterate>
					</ul>

					<p><bean:write name="carrito" property="numProductos"/> items en el carrito</p>
					<p>Precio: <bean:write name="carrito" property="totalSinIvaFormateado"/> &euro;</p>
					<hr/><br/>
					<div><a href="listado.do?opt=3&amp;lid=<bean:write name="i"/>&amp;idcat=<bean:write name="idcat"/>&amp;idpr=<bean:write name="linea" property="compra.id"/>" > <bean:message key="app.listado.3"/></a></div>
				</div>
			</div>
</logic:present>
