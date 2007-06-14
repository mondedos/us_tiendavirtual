<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

			<div class="menu-listado-workarea">
				<h3><bean:write name="titulo"/></h3>
				<div class="mini-container">
					<ol>
<logic:iterate name="lista" id="producto">
						<li>
							<table  border="0" align="center">
								<tr>
									<td>
										<p>
											<span>Marca:</span> <br/>
											<bean:write name="producto" property="marca"/> <bean:write name="producto" property="modelo"/>
										</p>
										<p>
											<span>Descripci&oacute;n:</span> <br/>
											<bean:write name="producto" property="descripcion"/>
											</p>
										<p>
											<span>Dimensiones:</span> <br/>
											<bean:write name="producto" property="dimensiones"/></p>
										<p>
											<span>Precio:</span> <br/>
											<big><bean:write name="producto" property="precio"/></big> &euro;
										</p>
										<a href="#">añadir al carrito</a>

									</td>
									<td><img src="gui/images/<bean:write name="urlImg"/>/<bean:write name="producto" property="foto"/>" /></td>
							</table>
						</li>
						<hr/>
</logic:iterate>
					</ol>
				</div>
			</div>