<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

			<div class="menu-listado-workarea">
				<h3><bean:message key="app.listado"/> <bean:write name="titulo"/></h3>
				<div class="mini-container">
					<ol>
						<logic:present name="lista">
							<logic:iterate name="lista" id="producto">
								<li>
									<form id="form<bean:write name="producto" property="id"/>" action="listado.do">
										<input type="hidden" name="idpr" value="<bean:write name="producto" property="id"/>"/>
										<input type="hidden" name="refpr" value="<bean:write name="producto" property="referencia"/>"/>

										<logic:present name="idcat">
											<input type="hidden" name="idcat" value="<bean:write name="idcat"/>"/>
										</logic:present>
										<logic:notPresent name="idcat">
											<input type="hidden" name="pmin" value="<bean:write name="pmin"/>"/>
											<input type="hidden" name="pmax" value="<bean:write name="pmax"/>"/>
											<input type="hidden" name="marca" value="<bean:write name="marca"/>"/>
											<input type="hidden" name="categoria" value="<bean:write name="categoria"/>"/>
										</logic:notPresent>


										<table  border="0" align="center">
											<tr>
												<td>
													<p>
														<span><bean:message key="app.producto.0"/>:</span> <br/>
														<bean:write name="producto" property="marca"/> <bean:write name="producto" property="modelo"/>
													</p>
													<p>
														<span><bean:message key="app.producto.3"/>:</span> <br/>
														<big><bean:write name="producto" property="precioFormateado"/></big> &euro;
													</p>
													<br/>
													<p>
														<input class="minienlace minidetalle" type="submit" name="opt" value="<bean:message key="app.listado.0"/>">
														&nbsp;
														<input class="minienlace minicarrito" type="submit" name="opt" value="<bean:message key="app.listado.1"/>"></input> <input type="text" name="unidades" size="1" maxlength="3" value="1"/> ud/s

<%/*
														<img class="minienlace" src="gui/styles/default-style/img/lupa.gif"/> <input class="minienlace" type="submit" name="opt" value="<bean:message key="app.listado.0"/>">
														&nbsp;
														<img class="minienlace" src="gui/styles/default-style/img/cart.gif"/> <input class="minienlace" type="submit" name="opt" value="<bean:message key="app.listado.1"/>"></input> <input type="text" name="unidades" size="1" maxlength="3" value="1"/> ud/s
*/%>
													</p>
												</td>
												<td><img src="<bean:write name="urlImg"/>/<bean:write name="producto" property="foto"/>" /></td>
										</table>
									</form>
							</li>
							<hr class="h4"/>
						</logic:iterate>
					</logic:present>
					<logic:notPresent name="lista">
						No se han encontrado elementos
					</logic:notPresent>
					</ol>
				</div>
			</div>