package mfis.tiendavirtual.struts.beans;

import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

public class OfertaBean {

	Producto productoA;
	Producto productoB;

	public OfertaBean(Producto a, Producto b) {
		this.productoA = a;
		this.productoB = b;
	}

	public Producto getProductoA() {
		return productoA;
	}

	public void setProductoA (Producto productoA) {
		this.productoA = productoA;
	}

	public Producto getProductoB() {
		return productoB;
	}

	public void setProductoB(Producto productoB) {
		this.productoB = productoB;
	}



}
