package mfis.tiendavirtual.modelo.dao;

import java.util.Date;

import mfis.tiendavirtual.ejb.Carrito;
import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.Oferta;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import java.util.ArrayList;
import java.util.LinkedList;
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
	private static ProductoDao productoDao;
	private static BeneficioDAO beneficioDao;
	
	private static final String estadoCancelled = "Cancelled";
	private static final String estadoTransient = "Transient";
	private static final String estadoServed   = "Served";
	private static final String estadoPlaced = "Placed";
	private static final String estadoPrePaypal= "PrePaypal";

	public PedidosDAO() {
		daoGenerico = new DaoGenerico();
		bmGenerico = new BMGenerico();
		productoDao = new ProductoDao();
		beneficioDao = new BeneficioDAO();
	}

	/**
	 * Metodo para crear un pedido a partir de un carro de la compra
	 * 
	 * @param c
	 *            carro de la compra
	 * @param direccion
	 *            direccion de envio del pedido
	 */
	public Long registrarPedido(Carrito c, String direccion) {
		/* Hay que generar el pedido a mano */
		
		Long idPedido;
		List<LineaPedido> lineasPedido = null;
		Iterator<LineaPedido> li = null;
		LineaPedido lP = null;
		float precioTotal = 0.0f;

		Pedido p = new Pedido();
		p.setDireccion(direccion);
		p.setFechaCancelacion(null);
		p.setFechaDeServicio(null);
		p.setFechaPedido(null);
		p.setFechaTransient(null);
		p.setOperador(null);
		p.setPrecioTotal(new Float(0.0));
		
		List <Item> productos = new LinkedList<Item>();
		
		// Persistimos el carro de la compra como un pedido.
		idPedido= daoGenerico.persistirObjeto(p);	
		lineasPedido = c.getLineasPedido();
		li = lineasPedido.listIterator();
		
		while (li.hasNext()) {
			lP = li.next();
			// Vamos a comprobar si la línea del pedido es una oferta.
			System.out.println(lP.getCompra());
			Item item = lP.getCompra();
			if(item instanceof Oferta){
				Producto a = ((Oferta)item).getPrincipal();
				Producto b =  ((Oferta)item).getSecundario();
				LineaPedido l1 = new LineaPedido();
				l1.setCompra(a);
				l1.setId(a.getId());
				l1.setPedido(p);
				l1.setPrecioUnidad(a.getPrecio());
				l1.setUnidades(lP.getUnidades());
				this.daoGenerico.persistirObjeto(l1);
				
				LineaPedido l2 = new LineaPedido();
				l2.setCompra(b);
				l2.setId(b.getId());
				l2.setPedido(p);
				l2.setPrecioUnidad(b.getPrecio());
				l2.setUnidades(lP.getUnidades());
				this.daoGenerico.persistirObjeto(l2);
				
				precioTotal += l1.getPrecioUnidad().floatValue() * lP.getUnidades() +
				l2.getPrecioUnidad().floatValue() * lP.getUnidades();
			}
			else{
			
				productos.add(lP.getCompra());
				lP.setPedido(p);
				// Persistimos una linea de pedido del carro de la compra.
				daoGenerico.persistirObjeto(lP);
				// Vamos calculando el precio total del carro de la compra...
				precioTotal += lP.getPrecioUnidad().floatValue() * lP.getUnidades();
			}
		} // ...y lo asignamos al pedido en cuestion.
		
		p.setPrecioTotal(new Float(precioTotal));
		//Actualizamos el pedido con el precio total. 
		daoGenerico.modificarObjeto(p);
		beneficioDao.actualizarBeneficioPedido(productos);
		
		return idPedido;
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
	 * @throws IlegalChangedStateOrder 
	 */
	public void actualizarEstado(Pedido pedido, String nuevoEstado, Date fecha){
		
		// Obtenemos el estado del pedido.
		String estadoActualp = this.obtenerEstado(pedido);
		
		if (estadoActualp.equals(estadoPrePaypal) && nuevoEstado.equals(estadoPlaced)) {
			pedido.setFechaPedido(fecha);
		} else {
			if(estadoActualp.equals(estadoCancelled))
				throw new IllegalArgumentException("No se puede cancelar el estado de un pedido ya cancelado");
			else if (estadoActualp.equals(estadoPlaced)){
				if(nuevoEstado.equals(estadoTransient) || 
						nuevoEstado.equals(estadoCancelled))
					pedido.setFechaPedido(fecha);
				else
					throw new IllegalArgumentException("No se puede modificar el estado a "+nuevoEstado);
			}else if (estadoActualp.equals(estadoTransient)){
				if(nuevoEstado.equals(estadoServed)){
					pedido.setFechaDeServicio(fecha);
					
	//				 Lista de productos del pedido.
					List<Item> productosPedido = this.obtenerProductosPedido(pedido);
					/* 		
					 * 	Una vez que el pedido ha sido servido podemos actualizar con seguridad
					 * el beneficio pues el usuario no puede cancelar el pedido.
					 */
					beneficioDao.actualizarBeneficioPedido(productosPedido);
				}
				else
					throw new IllegalArgumentException("No se puede modificar el estado a "+nuevoEstado);
			} else if (estadoActualp.matches(estadoServed)) {
				throw new IllegalArgumentException("No se puede modificar el estado a el pedido esta servido");
			}
		}
		// Modificamos el pedido que ya existe en la BD.
		daoGenerico.modificarObjeto(pedido);
	}
	
	/**
	 * Metodo para obtener el estado de un pedido
	 * 
	 * @param p
	 * @return el estado asociado al pedido parametro
	 */
	public String obtenerEstado(Pedido p) {
		String res = null;
		
		if(p.getFechaCancelacion()==null && p.getFechaDeServicio()==null && p.getFechaPedido()==null && p.getFechaTransient()==null)
			res=estadoPrePaypal;
		else if ((p.getFechaTransient() == null) && (p.getFechaDeServicio() == null) && (p.getFechaCancelacion() == null)) {
			res = "Placed";
		} else if ((p.getFechaTransient() != null) && (p.getFechaDeServicio() == null) && (p.getFechaCancelacion() == null)) {
			res = "Transient";
		} else if ((p.getFechaTransient() != null) && (p.getFechaDeServicio() != null) && (p.getFechaCancelacion() == null)) {
			res = "Served";
		} else {
			res = "Cancelled";
		}
		
		return (res);
	}

	/**
	 * 
	 * @param p Pedido
	 * @return List con las líneas del pedido p.
	 */
	@SuppressWarnings("unchecked")
	public List<LineaPedido> obtenerLineasPedido(Pedido pedido){
		
		// Creamos un Criteria vacio.
		Criteria criteria = bmGenerico.crearCriteriaVacio(LineaPedido.class);
		
		/*
		 *  Añadimos el cirterio de búsqueda 
		 * Buscamos las líneas de pedido del pedido que se corresponden
		 * con el "id" del pedido "p".
		 */ 
		bmGenerico.agregarAnd(criteria, "pedido", pedido);
		List<LineaPedido> lineasPedido = criteria.list(); // Obtenemos las líneas del pedido.
		
		return lineasPedido;
	}
	
	/**
	 * 
	 * @param pedido
	 * @return Lista con los productos del pedido.
	 */
	@SuppressWarnings("unchecked")
	public List<Item> obtenerProductosPedido(Pedido pedido){
		
		// Obtenemos las líneas del pedido.
		List<LineaPedido> lineasPedido = this.obtenerLineasPedido(pedido);
		
		List<Item> productosPedido = new ArrayList();
		Item item;
		Producto producto;
		
		for(LineaPedido lineaPedido: lineasPedido){
			
			// Obtenemos el "Item" correspondiente
			item = lineaPedido.getCompra();
			producto = productoDao.obtenerProductoPorId(item.getId());
			productosPedido.add(producto);
		}
		
		return productosPedido;
	}
}