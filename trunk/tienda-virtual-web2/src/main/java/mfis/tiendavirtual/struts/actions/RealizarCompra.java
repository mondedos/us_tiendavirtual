package mfis.tiendavirtual.struts.actions;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
			
			String url= redirectCompraPayPal(carrito);
			c.getResponse().sendRedirect(url);
			
			//realizarCompraPayPal(carrito);
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
	
	private String redirectCompraPayPal(Carrito carrito){
		
		String url = "https://www.paypal.com/cgi-bin/webscr?";
		url += "businesss=mfisg16@gmail.com";
		url += "&rm=2";
		url += "&undefined_quantity=1";
		url += "&charset=utf-8";
		url += "&no_shipping=1";
		
		//TODO hacer la pagina de cancelar
//		url +="cancel_return=pagina error";
		
		url += "&no_note=0";
		url += "&item_name=Compra MFIS";
		url += "&amount=" +carrito.getTotalSinIVA();
		url += "&quantity=1";
		
		return url;
		
	}
	
	private void realizarCompraPayPal(Carrito carrito){
		

		
		HttpURLConnection p = null;
		BufferedOutputStream bos = null;
		URL url = null;
		InputStream is = null;
		
		try {
			url = new URL("https://www.paypal.com/cgi-bin/webscr");
			
			p = (HttpURLConnection) url.openConnection();
			p.setRequestMethod("POST");
			p.addRequestProperty("businesss", "mfisg16@gmail.com");
			p.addRequestProperty("rm", "2");
			p.addRequestProperty("undefined_quantity", "1");
			p.addRequestProperty("charset", "utf-8");
			p.addRequestProperty("no_shipping", "1");
			
			//TODO hacer la pagina de cancelar
//			p.addRequestProperty("cancel_return", "pagina error");
			
			p.addRequestProperty("no_note", "0");
			p.addRequestProperty("item_name", "Compra MFIS");
			p.addRequestProperty("amount", carrito.getTotalSinIVA());
			p.addRequestProperty("quantity", "1");
			
			p.connect();
			
			int code = p.getResponseCode();
			
			is = p.getInputStream();
			int k = 0 ;
			byte[] buffer = new byte[256];
			while( (k = is.read(buffer, 0, buffer.length)) != -1 ) {
//				bos.write(buffer, 0 , k);
			}
			
			System.out.println(bos);
			System.out.println(code);
			
			p.disconnect();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}