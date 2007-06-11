package mfis.tiendavirtual.modelo.dao;

import java.util.List;

import mfis.tiendavirtual.modelo.objetoNegocio.Oferta;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

/**
 * DAO para el manejo de las ofertas
 * 
 * @author Daniel Vázquez
 *
 */
public class OfertasDAO {

	/**
	 * Metodo para crear una nueva oferta a partir de dos productos
	 * @param productoA objeto persistente
	 * @param productoB objeto persistente
	 */
	public void nuevaOferta(Producto productoA, Producto productoB){
		Oferta o = new Oferta();
		o.setPrincipal(productoA);
		o.setSecundario(productoB);
		DaoGenerico d = new DaoGenerico();
		d.persistirObjeto(o);
	}

	/**
	 * Método para obtener la actual oferta de la tienda
	 * @return oferta vigente
	 */
	public Oferta obtenerOferta(){
		DaoGenerico d = new DaoGenerico();
		List l = null;
		
		l = d.obtenerTodos(Oferta.class);
		
		return ((Oferta) l.get(0));
	}
}