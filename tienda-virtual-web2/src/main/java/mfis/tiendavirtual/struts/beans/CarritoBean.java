package mfis.tiendavirtual.struts.beans;

import mfis.tiendavirtual.ejb.Carrito;
import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import struts.WebContext;

public class CarritoBean {

	Carrito carrito = null;

	public CarritoBean(WebContext c) {
		if(c.getSession("carrito") == null) {
			this.carrito = new Carrito();
		} else {
			this.carrito = (Carrito) c.getSession("carrito");
		}
	}

	public void crearLineaPedido(Item i, String categoria, int unidades) {
		LineaPedido linea = new LineaPedido();

		Float precio = ((Producto)i).getPrecio() ;
		linea.setCompra(i);
		linea.setUnidades(unidades);
		linea.setPrecioUnidad( precio );

		this.carrito.addLineaPedido(linea, precio);
	}

	public void borrarLineaPedido(int linea) {
		this.carrito.removeLineaPedido(linea);
		if(this.carrito.getLineasPedido().isEmpty() ) {
			this.carrito = null;
		}
	}

	public Carrito getCarrito() {
		return this.carrito;
	}

}
