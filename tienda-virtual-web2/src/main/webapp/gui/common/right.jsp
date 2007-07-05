<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
		<div id="center">
			<div id="oferton">
				<h3>El ofertón</h3>
				<div class="mini-container wrap300">
					<table class="menu-listado-workarea" align="center">
						<tr>
							<td class="drcha"><img class="oferton" src="gui/images/<bean:write name="prA" property="foto"/>" width="75" height="50"/>
								<br>
								<p><bean:write name="prA" property="marca"/> <bean:write name="prA" property="modelo"/></p>
								<p><big><bean:write name="precioPrA"/> &euro;</big></p>
							</td>
							<td valign="center" ="2" style="text-align: center; font-size: 2em">+</td>
							<td class="izda"><img class="oferton" src="gui/images/<bean:write name="prB" property="foto"/>" width="75" height="50"/>
								<br>
								<p><bean:write name="prB" property="marca"/> <bean:write name="prB" property="modelo"/></p>
								<p><big><bean:write name="precioPrB"/> &euro;</big></p>
							</td>
						</tr>
					</table>
					<br>
					<p class="letra-grande">por tan solo <big><bean:write name="precioFinal"/> &euro;</big></p>
					<form id="form<bean:write name="oferta" property="id"/>" action="listado.do">
						<input type="hidden" name="oferton" value="1"/>
						<input type="hidden" name="idpr" value="<bean:write name="oferta" property="id"/>"/>
						<input type="hidden" name="refpr" value="<bean:write name="oferta" property="referencia"/>"/>
						<p style="padding: 15px; text-align: center">
							<input class="minienlace minicarrito" type="submit" name="opt" value="<bean:message key="app.listado.1"/>"></input> <input type="text" name="unidades" size="1" maxlength="3" value="1"/> ud/s
						</p>
					</form>
				</div>




			</div>
		</div>
