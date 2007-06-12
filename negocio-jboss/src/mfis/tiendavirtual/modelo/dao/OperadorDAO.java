package mfis.tiendavirtual.modelo.dao;

import java.util.List;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import java.util.ListIterator;

/**
 * DAO para el manejo de los operadores
 * 
 * @author Daniel Vazquez
 *
 */
public class OperadorDAO {

	private DaoGenerico daoGenerico;
	
	public OperadorDAO() {
		daoGenerico = new DaoGenerico();
	}
	
	/**
	 * Metodo para obtener un operador a partir de su numero identificativo
	 * @param id numero de identificación
	 * @return un operador
	 */
	public Operador obtenerOperador(int id){
		return (daoGenerico.buscarPorId(Operador.class, new Long(id)));
	}

	/**
	 * Metodo para obtener un operador a partir de su login de GMail
	 * @param login login de GMail.
	 * @return el operador con el login correspondiente
	 */
	public Operador obtenerOperador(String login){
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
	 * @return pedido asignado al operador
	 */
	public Pedido siguientePedido(int id) {

// Esto hay que hacerlo de modo que no haya conflictos por concurrencia tal y como se comentó
// en clase:  
//  - habia que añadir una columna al pedido con el id del operador 
//  - acto seguido recuperamos el pedidode ese operador 
//  - finalmete asignarle el estado correspondiente 

		Pedido p = new Pedido();
		/*p.setDireccion("Avda. Reina Mercedes, s/n");
		p.setEstado("Served");
		p.setFechaCancelled(null);
		p.setFechaPlaced(null);
		p.setFechaServed(null);
		p.setFechaTransient(null);
		p.setLineasPedido(new ArrayList());
		p.setOp(new Operador("operador1"));
		p.setReferencia("0000012");
		p.setTotal("1000");

		System.out.println("Se ha obtenido el siguiente pedido para el operador " + id);
		*/

		return p;
	}
}