<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

			<div class="menu-listado-workarea">
				<h3>Crear oferta</h3>
				<div class="mini-container">
				<logic:present name="lista">
					<form id="ofertaForm" action="opciones.do">
						<input type="hidden" name="opt" value="2">
						<table class="oferta">
							<tr>
								<th style="text-align: right">Productos más beneficiosos</th>
								<th></th>
								<th></th>
								<th>Productos menos beneficiosos</th>
							</tr>
						<logic:iterate name="lista" id="oferta">
							<tr>
								<td class="productoa">
									<label for="prodA<bean:write name="oferta" property="productoA.referencia"/>">
										<bean:write name="oferta" property="productoA.marca"/> <bean:write name="oferta" property="productoA.modelo"/>
									</label>
								</td>
								<td class="radio-button">
									<input type="radio" name="prodA" checked id="prodA<bean:write name="oferta" property="productoA.referencia"/>" value="<bean:write name="oferta" property="productoA.id"/>"/>
								</td>
								<td class="radio-button">
									<input type="radio" name="prodB" checked id="prodB<bean:write name="oferta" property="productoB.referencia"/>" value="<bean:write name="oferta" property="productoB.id"/>"/>
								</td>
								<td class="productob">
									<label for="prodB<bean:write name="oferta" property="productoB.referencia"/>">
									<bean:write name="oferta" property="productoB.marca"/> <bean:write name="oferta" property="productoB.modelo"/>
									</label>
								</td>
							</tr>
						</logic:iterate>
						</table>
							<table>
								<tr>
									<td class="oferta-submit">
										<input type="submit" name="enviar" value="Crear oferta"/>
									</td>
								</tr>
							</table>
					</form>
					<form id="ofertaForm" action="opciones.do">
						<input type="hidden" name="opt" value="3">
						<table>
							<tr>
								<td class="oferta-submit">
									<input type="submit" name="cancelar" value="Cancelar"/>
								</td>
							</tr>
						</table>
					</form>
				</logic:present>
				</div>
			</div>