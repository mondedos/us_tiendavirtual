package mfis.tiendavirtual.modelo.dao;

import java.util.List;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Date;

/**
 * DAO para el manejo de los operadores
 * 
 * @author Daniel Vazquez Gomez
 *
 */
public class OperadorDAO {

	private static DaoGenerico daoGenerico;
	
	public OperadorDAO() {
		daoGenerico = new DaoGenerico();
	}
	
	/**
	 * Metodo para obtener un operador a partir de su numero identificativo
	 * @param id numero de identificación
	 * @return un operador
	 */
	public static Operador obtenerOperador(int id){
		return (daoGenerico.buscarPorId(Operador.class, new Long(id)));
	}

	/**
	 * Metodo para obtener un operador a partir de su login de GMail
	 * @param login login de GMail.
	 * @return el operador con el login correspondiente
	 */
	public static Operador obtenerOperador(String login){
		List<Operador> l = null;
		ListIterator li = null;
		Operador o = null;
		
		l = daoGenerico.obtenerTodos(Operador.class);
		li = l.listIterator();
		while (li.hasNext()) {
			o = (Operador) li.next();
			if (o.getLogin().matches(login)) {
				return (o);
			}
		} return (o);
	}

	/**
	 * Metodo para asignar un pedido a un operador
	 * @param id identificador numerico del operador que quiere que le sea asignado el pedido
	 * @return pedido asignado al operador o null si no hay ningun pedido por ser asignado
	 */
	public static Pedido siguientePedido(int id) {
		// Es necesario realizar el siguiente procedimiento para que no existan problemas de concurrencia a la hora de asignar un
		// pedido a un operador.
		List<Pedido> listaPedidos = null;
		Pedido p = null;
		Pedido res = null;
		Iterator it = null;
		Operador o = null;
		Long idPedido = null;
		boolean enc = false;
		
		// Recuperamos el operador:
		o = daoGenerico.buscarPorId(Operador.class, new Long(id));
		it = listaPedidos.listIterator();
		// Recuperamos el primer pedido mas antiguo no asignado a ningun operador y que no esté cancelado:
		while (it.hasNext() && !(enc)) {
			p = (Pedido) it.next();
			if ((p.getFechaTransient() == null) && (p.getFechaCancelacion() != null)) {
				enc = true;
				res = p;
				// Guardamos el id de pedido para poder recuperarlo despues de la base de datos.
				idPedido = res.getId();
			} 
		} // Cuando ya lo tenemos seguimos buscando a ver si hay alguno mas antiguo que todavia no este asignado a ningun operador y que
		// no haya sido cancelado.
		while (it.hasNext()) {
			p = (Pedido) it.next();
			if ((p.getFechaPedido().before(res.getFechaPedido())) && (p.getFechaTransient() == null) && (p.getFechaCancelacion() != null)) {
				res = p;
				// Guardamos el id de pedido para poder recuperarlo despues de la base de datos.
				idPedido = res.getId();
			}	
		} // Asignamos el id del operador solicitante al pedido si es que existe:
		if (res != null) {
			res.setOperador(o);
			daoGenerico.modificarObjeto(res);
			// Recuperamos el pedido con id idPedido:
			res = daoGenerico.buscarPorId(Pedido.class, idPedido);
			// Cambiamos su estado a "transient" y hacemos que el pedido tenga la fecha actual:
			res.setFechaTransient(new Date(System.currentTimeMillis()));
			daoGenerico.modificarObjeto(res);
		}
	
		return (res);
	}
}