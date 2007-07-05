<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>

<logic:present name="carrito">
	<div id="carrito">
		<h3>Carrito</h3>
		<div class="menu-container">
			<ul>
				<logic:iterate name="carrito" id="linea" property="lineasPedido" indexId="i">
						<li>
								<logic:present name="linea" property="compra.marca">
									<bean:write name="linea" property="compra.marca"/> <bean:write name="linea" property="compra.modelo"/><br/> <bean:write name="linea" property="unidades"/> ud(s).
								</logic:present>
								<logic:present name="linea" property="compra.principal.marca">
									<strong><u>Ofert&oacute;n</u></strong> <bean:write name="linea" property="unidades"/> ud(s).<br/>
									<bean:write name="linea" property="compra.principal.marca"/> <bean:write name="linea" property="compra.principal.modelo"/><br/>
									<div style="width: 50px;text-align: center">+</div>
									<bean:write name="linea" property="compra.secundario.marca"/> <bean:write name="linea" property="compra.secundario.modelo"/><br/>
								</logic:present>
								<logic:present name="idcat">
									<a href="listado.do?opt=2&amp;
									<logic:present name="linea" property="compra.principal.marca">
										of=1&amp;
									</logic:present>
										lid=<bean:write name="i"/>&amp;
										idcat=<bean:write name="idcat"/>&amp;
										idpr=<bean:write name="linea" property="compra.id"/>"> <bean:message key="app.listado.2"/> </a>
								</logic:present>
								<logic:notPresent name="idcat">
									<a href="listado.do?opt=2&amp;
									<logic:present name="linea" property="compra.principal.marca">
										of=1&amp;
									</logic:present>
										lid=<bean:write name="i"/>&amp;
									<logic:present name="pmin">
										pmin=<bean:write name="pmin"/>&amp;
										pmax=<bean:write name="pmax"/>&amp;
										marca=<bean:write name="marca"/>&amp;
										categoria=<bean:write name="categoria"/>&amp;
									</logic:present>
										idpr=<bean:write name="linea" property="compra.id"/>"> <bean:message key="app.listado.2"/> </a>
								</logic:notPresent>

						</li>
				</logic:iterate>
					</ul>
					<p><bean:write name="carrito" property="numProductos"/> items en el carrito</p>
					<p>Precio: <bean:write name="carrito" property="totalSinIvaFormateado" format="#,##0.00"/> &euro;</p>
					<hr/><br/>
					<div>
						<table>
							<tr>
						<logic:present name="idcat">
							<td align="left">
								<a href="listado.do?opt=3&amp;
									lid=<bean:write name="i"/>&amp;
									idcat=<bean:write name="idcat"/>&amp;
									idpr=<bean:write name="linea" property="compra.id"/>">

									<bean:message key="app.listado.3"/>
								</a>
							</td>
							<td align="right">
								<a href="listado.do?opt=3&amp;
									lid=<bean:write name="i"/>&amp;
									idcat=<bean:write name="idcat"/>&amp;
									idpr=<bean:write name="linea" property="compra.id"/>">
										<img class="carroDeLaCompra" src="gui/styles/default-style/img/carrito.gif"/>
									</a>
							</td>
						</logic:present>
						<logic:notPresent name="idcat">
							<td align="left">
								<a href="listado.do?opt=3&amp;
									lid=<bean:write name="i"/>&amp;
								<logic:present name="pmin">
									pmin=<bean:write name="pmin"/>&amp;
									pmax=<bean:write name="pmax"/>&amp;
									marca=<bean:write name="marca"/>&amp;
									categoria=<bean:write name="categoria"/>&amp;
								</logic:present>
									idpr=<bean:write name="linea" property="compra.id"/>">

									<bean:message key="app.listado.3"/>
								</a>
							</td>
							<td align="right">
								<a href="listado.do?opt=3&amp;
									lid=<bean:write name="i"/>&amp;
								<logic:present name="pmin">
									pmin=<bean:write name="pmin"/>&amp;
									pmax=<bean:write name="pmax"/>&amp;
									marca=<bean:write name="marca"/>&amp;
									categoria=<bean:write name="categoria"/>&amp;
								</logic:present>
									idpr=<bean:write name="linea" property="compra.id"/>">

									<img class="carroDeLaCompra" src="gui/styles/default-style/img/carrito.gif"/>
								</a>
							</td>
						</logic:notPresent>
							</tr>
						</table>
					</div>
		</div>
	</div>
</logic:present>
