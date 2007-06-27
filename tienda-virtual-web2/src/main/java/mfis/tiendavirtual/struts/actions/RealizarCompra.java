package mfis.tiendavirtual.struts.actions;

import java.rmi.RemoteException;

import mfis.tiendavirtual.ejb.Carrito;
import mfis.tiendavirtual.interfaces.GestionPedidos;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.PedidosEJB;
import mfis.tiendavirtual.struts.forms.PedidoForm;
import struts.MyTilesAction;
import struts.WebContext;

public class RealizarCompra extends MyTilesAction{

	public String execute(WebContext c) throws Exception {
		Carrito carrito= (Carrito)c.getSession("carrito");
		GestionPedidos gp = (GestionPedidos) new PedidosEJB().getEJB(EJB.PEDIDOS_JNDI);
		PedidoForm formulario= (PedidoForm) c.getForm();
		String direccionUsuario = formulario.getDireccionUsuario();
		String layout = null;
		
		if ((direccionUsuario != null) && (!(direccionUsuario.trim().equals("")))) {
			try {
				gp.registrarPedido(carrito, direccionUsuario);
				// Borramos el carrito de compra.
				c.setSession("carrito", null);
			} catch (RemoteException e){
				throw new RuntimeException(e);
			} // Actualizamos la oferta y otros campos necesarios.
			StartAction.obtenerOfertas(c);
			//TODO Enlace a la página de PayPal. De momento volvemos a la página principal.
			layout = COMPRA_REALIZADA;
		} else {
			// En caso de que el usuario no haya introducido ninguna direccion o haya introducido una direccion
			// incorrecta...
			String mensajeError = "Debe introducir una dirección a la cual le podamos enviar su pedido.";
			c.setRequest("mensajeError", mensajeError);
			c.setRequest("idcat", "");
			layout = ERROR_USUARIO;
		}
		
		return (layout);
	}
}