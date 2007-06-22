<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
		<div id="right">
			<div id="oferton">
				<h3>El ofertón</h3>
				<div class="mini-container wrap300">
					<table class="oferton" align="center">
						<tr>
							<td>
								<p><bean:write name="prA" property="marca"/> <bean:write name="prA" property="modelo"/></p>
								<p><big><bean:write name="prA" property="precioFormateado" format="#,##0.00"/> &euro;</big></p>

							</td>
							<td class="drcha"><img class="oferton" src="gui/images/<bean:write name="prA" property="foto"/>" width="75" height="50"/></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center; font-size: 2em">+</td>
						</tr>
						<tr>
							<td class="izda"><img class="oferton" src="gui/images/<bean:write name="prB" property="foto"/>" width="75" height="50"/></td>
							<td >
								<p><bean:write name="prB" property="marca"/> <bean:write name="prB" property="modelo"/></p>
								<p><big><bean:write name="prB" property="precioFormateado" format="#,##0.00"/> &euro;</big></p>

							</td>
						</tr>
					</table>
					<p class="letra-grande">por tan solo <big><bean:write name="precioFinal" format="#,##0.00"/> &euro;</big></p>
				</div>
			</div>
		</div>
