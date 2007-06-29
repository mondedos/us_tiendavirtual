package mfis.tiendavirtual.struts.actions;

import java.util.List;

import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.struts.beans.PedidosBean;
import mfis.tiendavirtual.struts.forms.DetallePedidoFrm;
import mfis.tiendavirtual.struts.vista.PedidoVista;
import mfis.tiendavirtual.util.Utilidades;
import struts.MyTilesAction;
import struts.WebContext;

public class DetallesPedido extends MyTilesAction{

	public String execute(WebContext c) throws Exception {
		
		String layout= null;
		
		
		DetallePedidoFrm formulario= (DetallePedidoFrm)c.getForm();
		String nuevoEstado= formulario.getNuevoEstado();
		String id= (String)c.getParameter("id");
		Pedido pedido= PedidosBean.obtenerPedido(id);
		
		if(Utilidades.cadenaVacia(nuevoEstado)) layout= mostrarDetalles(c, pedido);
		else layout= cambiarEstado(c, nuevoEstado, pedido);
		
		c.setRequest("id", id);
		
		return layout;
	}
	
	
	private String cambiarEstado(WebContext c, String nuevoEstado, Pedido pedido){
		
		String paginaRetorno;
		String mensajeInformativo;
		String mensajeAceptar;
		
		try{
			PedidosBean.cambiarEstado(pedido, nuevoEstado);
			mensajeInformativo= "El estado del pedido ha sido modificado correctamente";
		}catch(RuntimeException e){
			//no se puede cambiar el estado
			mensajeInformativo= "No se puede modificar el estado a el pedido. El pedido está servido";
		}
		
		mensajeAceptar= "Volver a la página de detalles";
		paginaRetorno= "detallesPedido.do?id="+pedido.getId().toString();
		
		c.setRequest("paginaRetorno", paginaRetorno);
		c.setRequest("mensajeInformativo", mensajeInformativo);
		c.setRequest("mensajeRetorno", mensajeAceptar);
		
		
		return ".operacionRealizada";
		
	}
	
	private String mostrarDetalles(WebContext c, Pedido pedido){
	
		PedidoVista pedidoVista= new PedidoVista(pedido);
		List lineasPedido = PedidosBean.obtenerLineasPedido(pedido);
		c.setRequest("lineasPedido", lineasPedido);
		c.setRequest("pedido", pedidoVista);
		System.out.println(pedidoVista.getEstado());
		
		return ".detallesPedido";
	}
	

}
