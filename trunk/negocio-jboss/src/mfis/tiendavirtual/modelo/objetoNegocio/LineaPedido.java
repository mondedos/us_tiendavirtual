package mfis.tiendavirtual.modelo.objetoNegocio;

import java.io.Serializable;



public class LineaPedido implements Serializable{
	private static final long serialVersionUID = 8658031675807484674L;
	
	private Long id;
	private Item compra;
	private Float precioUnidad;
	private int unidades;
	private Pedido pedido;
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof LineaPedido)) return false;
		
		LineaPedido lp= (LineaPedido)o;
		
		return lp.getId()!=null && lp.getId().equals(this.getId());
	}
	
	@Override
	public int hashCode(){
		if(this.getId()==null) return System.identityHashCode(this);
		else return this.getId().hashCode();
	}
	
	public Float getPrecioTotal(){
		return unidades*precioUnidad;
	}
	  
	  
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Item getCompra() {
		return compra;
	}
	public void setCompra(Item compra) {
		this.compra = compra;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(Float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	public String toString() {
		String res = "";
		
		res += "\r\nProducto: " + this.getCompra().toString();
		res += "Unidades: " + this.getUnidades() + "\r\n";
		res += "Precio por unidad: " + this.getPrecioUnidad() + "\r\n";
		
		return res;
	}
}