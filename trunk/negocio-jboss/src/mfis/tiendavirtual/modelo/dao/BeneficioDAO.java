package mfis.tiendavirtual.modelo.dao;

import java.util.List;

import mfis.tiendavirtual.modelo.objetoNegocio.Beneficio;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

public class BeneficioDAO {

	private static DaoGenerico daoGenerico;
	
	public BeneficioDAO(){
		daoGenerico = new DaoGenerico();
	}
	
	/**
	 * 
	 * @param pedido Pedido que ha sido servido (no puede cancelarse).
	 */
	public void actualizarBeneficioPedido(List<Producto> listaProducto){
		
		Beneficio beneficioActual, nuevoBeneficio;
		int ganancia;
		
		// Para cada producto insertar o actualizar el beneficio.
		for(Producto producto: listaProducto){
			
			// Obtenemos el beneficio actual.
			beneficioActual = daoGenerico.buscarPorId(Beneficio.class, 
					producto.getId());
			
			
			// Ya existe el objeto beneficio.
			if(beneficioActual != null){
				ganancia = beneficioActual.getGanancia()+producto.getGanancia();
				beneficioActual.setGanancia(ganancia);
				daoGenerico.persistirObjeto(beneficioActual);
			}
			else{
				// Nuevo beneficio.
				nuevoBeneficio = new Beneficio();
				nuevoBeneficio.setId(producto.getId());
				nuevoBeneficio.setGanancia(producto.getGanancia());
				daoGenerico.persistirObjeto(nuevoBeneficio);
			}
		}
	}
}
