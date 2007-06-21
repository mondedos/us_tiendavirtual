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
		

		if(direccionUsuario!=null && !direccionUsuario.trim().equals("")){

			try{
				gp.registrarPedido(carrito, direccionUsuario);
				
				// Borramos el carrito de compra.
				c.setSession("carrito", null);
			
			}catch(RemoteException e){
				throw new RuntimeException(e);
			}

			// Actualizamos la oferta y otros campos necesarios.
			StartAction.obtenerOfertas(c);
			
			//TODO ENLACE A LA PAGINA DE PAYPAL, DE MOMENTO VOLVEMOS A LA PRINCIPAL
			return ".compraRealizada";
			
		}else{

			//TODO ENLACE A LA PAGINA DE PAYPAL, DE MOMENTO VOLVEMOS A LA PRINCIPAL.
			return (MAINPAGE);
		}
	}
}