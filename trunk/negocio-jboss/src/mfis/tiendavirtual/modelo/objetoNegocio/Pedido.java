package mfis.tiendavirtual.modelo.objetoNegocio;

import java.io.Serializable;
import java.util.Date;


public class Pedido implements Serializable{
	private static final long serialVersionUID = -6718435133620987646L;
	
	private Long id;
	private String direccion;
	private Date fechaPedido;
	private Date fechaCancelacion;
	private Date fechaDeServicio;
	private Float precioTotal;
	private Date fechaTransient;
	private Operador operador;	
	
	
	@Override
	public boolean equals(Object o){
		if(o==null ||!(o instanceof Pedido)) return false;
		
		Pedido p= (Pedido)o;
		
		return p.getId()!=null && p.getId().equals(this.getId());
	}
	
	
	@Override
	public int hashCode(){
		if(this.getId()==null) return System.identityHashCode(this);
		else return this.getId().hashCode();
	}
	
	
	
	
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}
	
	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
	
	public Date getFechaDeServicio() {
		return fechaDeServicio;
	}
	
	public void setFechaDeServicio(Date fechaDeServicio) {
		this.fechaDeServicio = fechaDeServicio;
	}
	
	public Date getFechaPedido() {
		return fechaPedido;
	}
	
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	
	
	public Operador getOperador() {
		return operador;
	}
	
	public void setOperador(Operador operador) {
		this.operador = operador;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFechaTransient() {
		return fechaTransient;
	}
	
	public void setFechaTransient(Date fechaTransient) {
		this.fechaTransient = fechaTransient;
	}
	
	public Float getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(Float precioTotal) {
		this.precioTotal = precioTotal;
	}


}
