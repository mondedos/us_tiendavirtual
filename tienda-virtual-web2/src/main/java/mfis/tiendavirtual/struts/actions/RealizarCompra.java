package mfis.tiendavirtual.struts.actions;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import mfis.tiendavirtual.ejb.Carrito;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.struts.beans.PedidosBean;
import mfis.tiendavirtual.struts.forms.PedidoForm;
import mfis.tiendavirtual.struts.vista.PayPal;
import struts.MyTilesAction;
import struts.WebContext;

public class RealizarCompra extends MyTilesAction{

	public String execute(WebContext c) throws Exception {
		
		
		int opt= Integer.parseInt((String)c.getParameter("opt"));
		String layout= null;
		
		switch(opt){
		case 1: layout= paypal(c); break;
		case 2: layout= persistirCompra(c); break;
		case 3: layout= cancelarCompra(c); break;
		}
		
		return layout;
		
	}
	
	private String cancelarCompra(WebContext c){
		c.removeSession("carrito");
		StartAction.obtenerOfertas(c);
		return MAINPAGE;
	}
	
	
	private String persistirCompra(WebContext c){
		
		Carrito carrito= (Carrito)c.getSession("carrito");
		PedidoForm formulario= (PedidoForm) c.getForm();
		String direccionUsuario = formulario.getDireccionUsuario();
			
		PedidosBean.registrarPedido(carrito, direccionUsuario);
		StartAction.obtenerOfertas(c);
			
		return COMPRA_REALIZADA;
		
		
		
	}
	
	
	private String paypal(WebContext c){
		
		PedidoForm formulario= (PedidoForm) c.getForm();
		String direccionUsuario = formulario.getDireccionUsuario();
		String layout = null;

		if ((direccionUsuario != null) && (!(direccionUsuario.trim().equals("")))) {
			
			Carrito carrito= (Carrito)c.getSession("carrito");
			List lineasPedido= carrito.getLineasPedido();
			List lista= new ArrayList(lineasPedido.size());
			
			for(int indice=1; indice<=lineasPedido.size(); indice++){
				LineaPedido lineaPedido= (LineaPedido)lineasPedido.get(indice-1);
				Producto producto= (Producto)lineaPedido.getCompra();
				
				String item= "item_name_"+indice;
				String amount= "amount_"+indice;
				String number= "quantity_"+indice;
				
				String nombreArticulo= producto.getModelo();
				String precioArticulo= lineaPedido.getPrecioUnidad().toString();
				String numeroUnidades= ""+lineaPedido.getUnidades();
				
				
				lista.add(new PayPal(nombreArticulo, precioArticulo, numeroUnidades, item, amount, number));
			}
			
			
			c.setRequest("listaPedido", lista);
			c.setSession("direccionUsuario", direccionUsuario);
			c.setRequest("idcat", "");
			
			layout= ".paypal";
		}else{
			//En caso de que el usuario no haya introducido ninguna direccion o haya introducido una direccion
			// incorrecta...
			String mensajeError = "Debe introducir una dirección a la cual le podamos enviar su pedido.";
			c.setRequest("mensajeError", mensajeError);
			c.setRequest("direccionRetorno", "listado.do?opt=3&lid=0&idcat=0&idpr=0");
			layout = ERROR_USUARIO;
			
		}
		
		return layout;
		
	}
	
	
	
	
	private String redirectCompraPayPal(Carrito carrito){
		String url = "https://www.paypal.com/cgi-bin/webscr?";
		url += "businesss=mfisg16@gmail.com";
		url += "&rm=2";
		url += "&undefined_quantity=1";
		url += "&charset=utf-8";
		url += "&no_shipping=1";
		
		//TODO hacer la pagina de cancelar
		//url +="cancel_return=pagina error";
		
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