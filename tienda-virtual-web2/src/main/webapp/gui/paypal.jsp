<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>

	<div class="menu-container">
<!--		<form action="https://www.paypal.com/cgi-bin/websrc" method="post" id="formulario">-->
			<form action="https://www.sandbox.paypal.com/cgi-bin/websrc" method="post" id="formulario">
			
			<input type="hidden" name="business" value="seller@hotmail.com"/>
			<input type="hidden" name="cmd" value="_cart"/>
			<input type="hidden" name="cancel_return" value="http://localhost:8081/tiendavirtual/realizarCompra.do?opt=3"/>
			<input type="hidden" name="charset" value="utf-8"/>
			<input type="hidden" name="currency_code" value="EUR"/>
			<input type="hidden" name="upload" value="1"/>
			<input type="hidden" name="return" value="http://localhost:8081/tiendavirtual/realizarCompra.do?opt=2"/>
			<input type="hidden" name="undefined_quantity" value="0"/>
			
			<input type="hidden" name="address1" value="<bean:write name="direccionUsuario"/>"/>
			
			<logic:iterate name="listaPedido" id="pedido">
				<input type="hidden" 
					name="<bean:write name="pedido" property="item"/>"
					value="<bean:write name="pedido" property="nombreArticulo"/>"
					/>
				<input type="hidden"
					name="<bean:write name="pedido" property="amount"/>"
					value="<bean:write name="pedido" property="precioArticulo"/>"
				/>
				<input type="hidden"
					name="<bean:write name="pedido" property="number"/>"
					value="<bean:write name="pedido" property="numeroUnidades"/>"
				/>
			</logic:iterate>
			
			Redirigiendo a la página de Paypal. Espere por favor
			<br><br><br>
			
			En caso de no actualizarse la página pulsar el siguiente botón
			<br><br>

			<div align="center">
				<input type="image" 
					src="https://www.paypal.com/es_ES/i/btn/x-click-but5.gif" 
					border="0" name="submit" alt="Realice pagos con PayPal: es rápido, gratis y seguro."/>
			</div>
			
		</form>
	</div>
	



	