package mfis.tiendavirtual.struts.beans;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import mfis.tiendavirtual.interfaces.GestionOperador;
import mfis.tiendavirtual.interfaces.GestionPedidos;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.OperadorEJB;
import mfis.tiendavirtual.jndi.PedidosEJB;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;

public class PedidosBean {
	
	private static GestionPedidos gp;
	private static GestionOperador go;
	
	static{
		gp= (GestionPedidos)new PedidosEJB().getEJB(EJB.PEDIDOS_JNDI);
		go = (GestionOperador) new OperadorEJB().getEJB(EJB.OPERADOR_JNDI);
	}
	
	
	public static Pedido obtenerPedido(String id){
		
		Pedido pedido= null;
		
		try{
			int identificador= Integer.parseInt(id);
			pedido= gp.getPedido(identificador);
		}catch(RemoteException e){
			throw new RuntimeException(e);
		}
		
		return pedido;
		
		
	}
	
	public static List obtenerLineasPedido(Pedido pedido){

		List lineasPedido= null;
		try{
			lineasPedido= gp.obtenerLineasPedido(pedido);
		}catch(RemoteException e){
			throw new RuntimeException(e);
		}
		
		return lineasPedido;
	}
	
	public static void cambiarEstado(Pedido pedido, String nuevoEstado){
		
		Date fechaActual= new Date(System.currentTimeMillis());
		
		try{
			gp.actualizarEstado(pedido, nuevoEstado, fechaActual);
		}catch(RemoteException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static Pedido asignarPedido(int idOperador){
		
		Pedido pedido= null;
		try{
			pedido = go.siguientePedido(idOperador);
		}catch(RemoteException e){
			throw new RuntimeException(e);
		}
		
		return (pedido);	
	}
	
	public static String obtenerEstado(Pedido pedido){
		String estado= null;
		try{
			estado= gp.obtenerEstado(pedido);
		}catch(RemoteException e){
			throw new RuntimeException(e);
		}
		
		return estado;
	}
}