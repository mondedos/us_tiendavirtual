package mfis.tiendavirtual.struts.vista;

import java.util.Date;

import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.struts.beans.PedidosBean;
import mfis.tiendavirtual.util.Utilidades;

public class PedidoVista {
	
	private String estado;
	private String estadoM;
	private String fechaPedido;
	private String fechaDeServicio;
	private String precioTotal;
	private String id;
	private String direccion;
	
	

	public PedidoVista(Pedido pedido){
		this.estado= calcularEstado(pedido);
		this.fechaPedido= formatearFecha(pedido.getFechaPedido());
		this.fechaDeServicio= formatearFecha(pedido.getFechaDeServicio());
		this.precioTotal= pedido.getPrecioTotal().toString();
		this.id= pedido.getId().toString();
		this.direccion= pedido.getDireccion();
	}
	
	
	private String calcularEstado(Pedido pedido){
		return PedidosBean.obtenerEstado(pedido);
	}
	
	private String formatearFecha(Date fecha){
		return Utilidades.formatearFecha(fecha);
	}

	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstadoM() {
		return (estado.substring(0, 1).toLowerCase() + estado.substring(1, estado.length()));
	}


	public void setEstadoM(String estado) {
		this.estadoM = estado;
	}
	
	public String getFechaDeServicio() {
		return fechaDeServicio;
	}


	public void setFechaDeServicio(String fechaDeServicio) {
		this.fechaDeServicio = fechaDeServicio;
	}


	public String getFechaPedido() {
		return fechaPedido;
	}


	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}


	public String getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
