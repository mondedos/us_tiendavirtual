<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

			<div class="menu-listado-workarea">
				<h3>Detalle del producto</h3>
				<div class="mini-container">
					<form id="form<bean:write name="producto" property="id"/>" action="listado.do">
						<input type="hidden" name="idpr" value="<bean:write name="producto" property="id"/>"/>
						<input type="hidden" name="refpr" value="<bean:write name="producto" property="referencia"/>"/>
						<input type="hidden" name="idcat" value="<bean:write name="idcat"/>"/>
						<table  border="0" align="center">
							<tr>
								<td>
									<p>
										<span><bean:message key="app.producto.0"/>:</span> <br/>
										<bean:write name="producto" property="marca"/> <bean:write name="producto" property="modelo"/>
									</p>
									<p>
										<span><bean:message key="app.producto.1"/>:</span> <br/>
										<bean:write name="producto" property="descripcion"/>
									</p>
									<p>
										<span><bean:message key="app.producto.2"/>:</span> <br/>
										<bean:write name="producto" property="dimensiones"/>
									</p>
									<p>
										<span><bean:message key="app.producto.3"/>:</span> <br/>
										<big><bean:write name="producto" property="precioFormateado"/></big> &euro;
									</p>
									<br/>
									<p style="text-align: center">
										<img class="minienlace" src="gui/styles/default-style/img/cart.gif"/> <input class="minienlace" type="submit" name="opt" value="<bean:message key="app.listado.1"/>"></input> <input type="text" name="unidades" size="1" maxlength="3" value="1"/> ud/s
										<!-- <a href="listado.do?opt=1&amp;idpr=<bean:write name="producto" property="id"/>&amp;refpr=<bean:write name="producto" property="referencia"/>&amp;idcat=<bean:write name="idcat"/>"><img class="minienlace" src="gui/styles/default-style/img/cart.gif"/> <bean:message key="app.listado.1"/></a> -->
									</p>
									</td>
								<td><img src="<bean:write name="urlImg"/>/<bean:write name="producto" property="foto"/>" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>