package mfis.tiendavirtual.modelo.dao;

import java.util.Date;

import mfis.tiendavirtual.ejb.Carrito;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import java.util.List;
import java.util.Iterator;

import org.hibernate.Criteria;

/**
 * DAO para el manejo de los pedidos
 * 
 * @author Daniel Vazquez Gomez
 * 
 */
public class PedidosDAO {

	private static DaoGenerico daoGenerico;
	private static BMGenerico bmGenerico;

	public PedidosDAO() {
		daoGenerico = new DaoGenerico();
		bmGenerico = new BMGenerico();
	}

	/**
	 * Metodo para crear un pedido a partir de un carro de la compra
	 * 
	 * @param c
	 *            carro de la compra
	 * @param direccion
	 *            direccion de envio del pedido
	 */
	public void registrarPedido(Carrito c, String direccion) {
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
	 * 
	 * @param id
	 * @return pedido correspondiente al identificador "id" y "null" en caso de
	 *         que no exista
	 */
	public Pedido obtenerPedido(int id) {
		return (daoGenerico.buscarPorId(Pedido.class, new Long(id)));
	}

	/**
	 * Metodo para actualizar el estado de un pedido y asignarle una determinada
	 * fecha a dicho estado
	 * 
	 * @param p
	 * @param estado
	 * @param fecha
	 */
	public void actualizarEstado(Pedido p, String estado, Date fecha) {
		
//		Un pedido puede cancelarse si su estado es "Placed" o "Transient".
		if (estado.matches("Placed")) {
			p.setFechaDeServicio(fecha);
		} else if (estado.matches("Cancelled")) {
			p.setFechaCancelacion(fecha);
		} else if (estado.matches("Transient")) {
			p.setFechaTransient(fecha);
		} else if (estado.matches("Served")) {
/* 		
 * 	Una vez que el pedido ha sido servido podemos actualizar con seguridad
 * el beneficio pues el usuario no puede cancelar el pedido.
 */
			
			p.setFechaDeServicio(fecha);
			
			BeneficioDAO benefDao = new BeneficioDAO();
			benefDao.actualizarBeneficio(p);
		} else
			throw new IllegalArgumentException("Estado del pedido no valido "
					+ estado);

		daoGenerico.modificarObjeto(p);
	}
	
	/**
	 * 
	 * @param p Pedido
	 * @return List con las líneas del pedido p.
	 */
	public List obtenerLineasPedido(Pedido p){
		
		// Creamos un Criteria vacio.
		Criteria criteria = bmGenerico.crearCriteriaVacio(LineaPedido.class);
		
		/*
		 *  Añadimos el cirterio de búsqueda 
		 * Buscamos las líneas de pedido del pedido que se corresponden
		 * con el "id" del pedido "p".
		 */ 
		bmGenerico.agregarAnd(criteria, "id", p.getId());
		List lineasPedido = criteria.list(); // Obtenemos las líneas del pedido.
		
		return lineasPedido;
	}
	
	public List obtenerProductosPedido(Pedido p){
		
		Criteria criteria;
		return null;
	}
}