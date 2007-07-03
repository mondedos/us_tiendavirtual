package mfis.tiendavirtual.modelo.dao;

import org.hibernate.Criteria;

import mfis.tiendavirtual.modelo.objetoNegocio.Oferta;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

/**
 * DAO para el manejo de las ofertas
 * 
 * @author Daniel Vazquez Gomez
 *
 */
public class OfertasDAO {
	
	private BMGenerico bmGenerico;
	private DaoGenerico daoGenerico;
	
	
	public OfertasDAO(){
		bmGenerico= new BMGenerico();
		daoGenerico= new DaoGenerico();
	}

	/**
	 * Metodo para crear una nueva oferta a partir de dos productos
	 * @param productoA objeto persistente
	 * @param productoB objeto persistente
	 */
	public Long nuevaOferta(Producto productoA, Producto productoB){
		

		
		//creamos la nueva oferta
		Oferta ofertaNueva= new Oferta();
		ofertaNueva.setPrincipal(productoA);
		ofertaNueva.setSecundario(productoB);
		ofertaNueva.setOfertaActual(true);
		
		//hacemos persistente la nueva oferta
		Long id= daoGenerico.persistirObjeto(ofertaNueva);
		
		
//		//obtenemos la oferta actual
//		Oferta ofertaActual= obtenerOferta();
//		//modificamos la oferta actual pues ya no lo es
//		Oferta dto= new Oferta();
//		dto.setOfertaActual(false);
//		bmGenerico.modificarObjeto(dto, ofertaActual.getId());
		
		return id;
	}

	/**
	 * Método para obtener la actual oferta de la tienda
	 * @return oferta vigente
	 */
	public Oferta obtenerOferta(){
		Criteria criteria= bmGenerico.crearCriteriaVacio(Oferta.class);
		bmGenerico.agregarAnd(criteria, "ofertaActual", true);
		
		Oferta ofertaActual= (Oferta)criteria.uniqueResult();
		
		return ofertaActual;
	}
}