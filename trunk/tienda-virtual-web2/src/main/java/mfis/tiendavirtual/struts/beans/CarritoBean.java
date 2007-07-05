package mfis.tiendavirtual.struts.beans;

import java.util.Iterator;
import java.util.List;

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

	public void crearLineaPedido(Item i, int unidades) {


		Long id= i.getId();
		List lineasPedido= carrito.getLineasPedido();
		boolean encontrado= false;

		if(lineasPedido!=null && !lineasPedido.isEmpty()){

			int indice=0;
			Iterator it= lineasPedido.iterator();
			while(it.hasNext()){
				LineaPedido lp= (LineaPedido)it.next();
				if(lp.getCompra().getId().equals(id)){
					carrito.removeLineaPedido(indice);
					lp.setUnidades(lp.getUnidades()+unidades);
					carrito.addLineaPedido(lp, lp.getPrecioUnidad());
					encontrado= true;
					break;
				}
				indice++;

			}
		}

		if(!encontrado){
			LineaPedido linea = new LineaPedido();
			Float precio = i.obtenerPrecio();
			linea.setCompra(i);
			linea.setUnidades(unidades);
			linea.setPrecioUnidad( precio );

			carrito.addLineaPedido(linea, precio);
		}

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
