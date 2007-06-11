package mfis.tiendavirtual.mocks.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @deprecated usar mfis.tiendavirtual.modelo.objetoNegocio.Pedido
 */
@Deprecated
public class Pedido implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 5241377673737267204L;
	private String referencia;
	private String estado;
	private String direccion;
	private Date fechaPlaced;
	private Date fechaTransient;
	private Date fechaServed;
	private Date fechaCancelled;
	private String total;
	private List   lineasPedido;
	private Operador op;


	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaCancelled() {
		return fechaCancelled;
	}
	public void setFechaCancelled(Date fechaCancelled) {
		this.fechaCancelled = fechaCancelled;
	}
	public Date getFechaPlaced() {
		return fechaPlaced;
	}
	public void setFechaPlaced(Date fechaPlaced) {
		this.fechaPlaced = fechaPlaced;
	}
	public Date getFechaServed() {
		return fechaServed;
	}
	public void setFechaServed(Date fechaServed) {
		this.fechaServed = fechaServed;
	}
	public Date getFechaTransient() {
		return fechaTransient;
	}
	public void setFechaTransient(Date fechaTransient) {
		this.fechaTransient = fechaTransient;
	}
	public List getLineasPedido() {
		return lineasPedido;
	}
	public void setLineasPedido(List lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	public Operador getOp() {
		return op;
	}
	public void setOp(Operador op) {
		this.op = op;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

}
