package mfis.tiendavirtual.mocks.persistence;

import java.io.Serializable;

public class LineaPedido implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6272366511392441591L;
	private String cantidad;
	private String precioUnitario;
	private Item item;

	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(String precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
