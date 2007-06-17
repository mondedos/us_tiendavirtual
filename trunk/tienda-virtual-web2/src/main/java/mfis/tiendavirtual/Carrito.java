package mfis.tiendavirtual;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

public class Carrito implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1282127809357789898L;

	private String totalSinIVA = "0";
	private String totalConIVA = "0";
	private List lineasPedido = null;

	public List getLineasPedido() {
		return lineasPedido;
	}
	public void setLineasPedido(List lineasPedido) {
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

	public void addLineaPedido(LineaPedido lp, Float precio) {
		if(lineasPedido == null) {
			lineasPedido = new ArrayList();
		}
		lineasPedido.add(lp);
		float totalNoIva = Float.parseFloat(this.totalSinIVA);
		this.totalSinIVA = "" + (totalNoIva + precio.floatValue());
		this.totalConIVA = "" + ((totalNoIva + precio.floatValue()) * 1.16f);
	}
	public void removeLineaPedido(int id) {
		Producto p = (Producto) ((LineaPedido) lineasPedido.get(id)).getCompra();
		lineasPedido.remove(id);
		float totalNoIva = Float.parseFloat(this.totalSinIVA);
		this.totalSinIVA = "" + (totalNoIva - p.getPrecio().floatValue());
		this.totalConIVA = "" + ((totalNoIva + p.getPrecio().floatValue()) * 1.16f);


	}

}

