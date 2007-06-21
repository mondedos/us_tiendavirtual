<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>

	<div class="menu-container">
		Nueva oferta creada correctamente 
		<br><br><br>
		
		<table align="center" cellpadding="10">
			<tr>
				<td>
					<div align="right">
					<img 
						src="gui/images/<bean:write name="prA" property="foto"/>" 
						width="300" height="300"/>
					</div>
				</td>
				<td>
					<div align="left">
					<p><b>Datos de la primera oferta:</b></p>
					<br>
					<p><b>Marca:</b> <bean:write name="prA" property="marca"/> <bean:write name="prA" property="modelo"/></p>
					<p><b>Dimensiones:</b> <bean:write name="prA" property="dimensiones"/></p>
					<p><b>Precio: </b><bean:write name="prA" property="precio"/> &euro;</p>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="right">
					<img  
						src="gui/images/<bean:write name="prB" property="foto"/>" 
						width="75" height="50" />
					</div>
				</td>
				<td>
					<div align="left">
					<p><b>Datos de la segunda oferta:</b></p>
					<br>
					<p><b>Marca:</b> <bean:write name="prB" property="marca"/> <bean:write name="prB" property="modelo"/></p>
					<p><b>Dimensiones:</b> <bean:write name="prB" property="dimensiones"/></p>
					<p><b>Precio:</b> <bean:write name="prB" property="precio"/> &euro;</p>
					</div>
				</td>
			</tr>
		</table>
		
	</div>