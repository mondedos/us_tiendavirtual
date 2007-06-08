package mfis.tiendavirtual.mocks.persistence;

public class Oferta extends Item{

	/**
	 *
	 */
	private static final long serialVersionUID = -5103854322299164602L;

	private Producto productoA;
	private Producto productoB;

	public Oferta(Producto a, Producto b){
		this.productoA = a;
		this.productoB = b;
	}

	public Producto getProductoA() {
		return productoA;
	}
	public void setProductoA(Producto productoA) {
		this.productoA = productoA;
	}
	public Producto getProductoB() {
		return productoB;
	}
	public void setProductoB(Producto productoB) {
		this.productoB = productoB;
	}


}

