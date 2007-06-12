package mfis.tiendavirtual.modelo.dao;

import java.util.Date;

import mfis.tiendavirtual.ejb.Carrito;
import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import java.util.List;
import java.util.Iterator;

/**
 * DAO para el manejo de los pedidos
 * 
 * @author Daniel Vazquez Gomez
 *
 */
public class PedidosDAO {
	
	private DaoGenerico daoGenerico;
	
	public PedidosDAO() {
		daoGenerico = new DaoGenerico();
	}
	
	/**
	 * Metodo para crear un pedido a partir de un carro de la compra
	 * @param c carro de la compra
	 * @param direccion direccion de envio del pedido
	 */
	public void registrarPedido(Carrito c, String direccion){
		/* Hay que generar el pedido a mano */
		Pedido p = null;
		List<LineaPedido> lineasPedido = null;
		Iterator li = null;
		LineaPedido lP = null;
		float precioTotal = 0.0f;
		
		p = new Pedido();
		p.setDireccion(direccion);
		p.setFechaCancelacion(null);
		p.setFechaDeServicio(null);
		p.setFechaPedido(new Date(System.currentTimeMillis()));
		p.setFechaTransient(null);
		p.setOperador(null);
		p.setPrecioTotal(new Float(0.0));
		p.setId(daoGenerico.persistirObjeto(p));
		lineasPedido = c.getLineasPedido();
		li = lineasPedido.listIterator();
		while (li.hasNext()) {	
		lP = (LineaPedido) li.next();
			lP.setPedido(p);
			// Persistimos una linea de pedido del carro de la compra.
			daoGenerico.persistirObjeto(lP);
			// Vamos calculando el precio total del carro de la compra...
			precioTotal += lP.getPrecioUnidad().floatValue() * lP.getUnidades();
		} // ...y lo asignamos al pedido en cuestion.
		p.setPrecioTotal(new Float(precioTotal));
		// Persistimos el carro de la compra como un pedido.
		daoGenerico.persistirObjeto(p);
	}

	/**
	 * Metodo para obtener un pedido a partir de su identificador
	 * @param id
	 * @return pedido correspondiente al identificador "id" y "null" en caso de que no exista
	 */
	public Pedido obtenerPedido(int id){
		return (daoGenerico.buscarPorId(Pedido.class, new Long(id)));
	}

	/**
	 * Metodo para actualizar el estado de un pedido y asignarle una determinada fecha a dicho estado
	 * @param p
	 * @param estado
	 * @param fecha
	 */
	public void actualizarEstado(Pedido p, String estado, Date fecha) {
		if (estado.matches("Placed")) {
				p.setFechaDeServicio(fecha);
		} else if (estado.matches("Cancelled")) {
			p.setFechaCancelacion(fecha);
		} else if (estado.matches("Transient")) {
			p.setFechaTransient(fecha);
		} else {
			p.setFechaDeServicio(fecha);
		} daoGenerico.modificarObjeto(p);
	}
}
