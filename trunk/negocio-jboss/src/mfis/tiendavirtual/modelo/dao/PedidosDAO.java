package mfis.tiendavirtual.modelo.dao;

import java.util.Date;

/* Hay que hacer una clase de Negocio con el carrito, aunque después no sea persistente en la base de datos
import mfis.tiendavirtual.modelo.objetoNegocio.Carrito;
*/
import mfis.tiendavirtual.mocks.persistence.Carrito;

import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;

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
		/* Hay que generar el pedido a mano y crear la clase de negocio Carrito */
		System.out.println("Se ha registrado un nuevo pedido");
	}

	/**
	 * Metodo para obtener un pedido a partir de su identificador
	 * @param id
	 * @return pedido correspondiente al identificador "id" y "null" en caso de que no exista
	 */
	public Pedido obtenerPedido(int id){
		return (daoGenerico.buscarPorId(Pedido.class, new Long(id)));
	}

	public void actualizarEstado(Pedido p, String estado, Date fecha) {
		/* System.out.println("Estado del pedido actualizado"); */
	}
	public void anadeBeneficio(Pedido p) {
		/* System.out.println("Beneficio de Pedido anadido"); */
	}
	public void anadeBeneficio(Item i) {
		/* System.out.println("Beneficio de Item anadido"); */
	}
}
