package mfis.tiendavirtual.ejb;

import java.io.Serializable;
import java.util.List;

import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;

public class Carrito implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1282127809357789898L;

	private String totalSinIVA;
	private String totalConIVA;
	private List<LineaPedido> lineasPedido;

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}
	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	public String getTotalConIVA() {
		return totalConIVA;
	}
	public void setTotalConIVA(String totalConIVA) {
		this.totalConIVA = totalConIVA;
	}
	public String getTotalSinIVA() {
		return totalSinIVA;
	}
	public void setTotalSinIVA(String totalSinIVA) {
		this.totalSinIVA = totalSinIVA;
	}

}
