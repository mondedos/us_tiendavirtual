<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

			<div class="menu-listado-workarea">
				<h3><bean:message key="app.listado"/> <bean:write name="titulo"/></h3>
				<div class="mini-container">
					<ol>
<logic:iterate name="lista" id="producto">
						<li>
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
											<bean:write name="producto" property="dimensiones"/></p>
										<p>
											<span><bean:message key="app.producto.3"/>:</span> <br/>
											<big><bean:write name="producto" property="precio"/></big> &euro;
										</p>
										<p style="text-align: center">
											<a href="listado.do?opt=0&amp;idpr=<bean:write name="producto" property="id"/>&amp;refpr=<bean:write name="producto" property="referencia"/>&amp;idcat=<bean:write name="idcat"/>"><bean:message key="app.listado.0"/></a> | <a href="listado.do?opt=1&amp;idpr=<bean:write name="producto" property="id"/>&amp;refpr=<bean:write name="producto" property="referencia"/>&amp;idcat=<bean:write name="idcat"/>"><bean:message key="app.listado.1"/></a>
										</p>

									</td>
									<td><img src="<bean:write name="urlImg"/>/<bean:write name="producto" property="foto"/>" /></td>
							</table>
						</li>
						<hr/>
</logic:iterate>
					</ol>
				</div>
			</div>