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
				</div>
			</div>
		</div>
