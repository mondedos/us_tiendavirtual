package mfis.tiendavirtual.modelo.dao;

import java.util.List;
import mfis.tiendavirtual.modelo.objetoNegocio.Beneficio;
import mfis.tiendavirtual.modelo.objetoNegocio.Item;

public class BeneficioDAO {

	private static DaoGenerico daoGenerico;
	
	public BeneficioDAO(){
		daoGenerico = new DaoGenerico();
	}
	
	/**
	 * 
	 * @param pedido Pedido que ha sido servido (no puede cancelarse).
	 */
	public void actualizarBeneficioPedido(List<Item> listaProducto){
		Beneficio beneficioActual, nuevoBeneficio;
		float gananciaActual;
		float nuevaGanancia;
		
		// Para cada producto insertar o actualizar el beneficio.
		for(Item item: listaProducto){
			
			// Obtenemos la ganacia actual en porcentajes.
			gananciaActual = item.getGananciaArticulo();
			
			nuevaGanancia = (gananciaActual*item.obtenerPrecio())/100;
			
			// Obtenemos el beneficio actual.
			beneficioActual = daoGenerico.buscarPorId(Beneficio.class, 
					item.getId());
			
			// Ya existe el objeto beneficio.
			if(beneficioActual != null){
				
				// Acumulamos el beneficio con el que ya teniamos. 
				nuevaGanancia += beneficioActual.getGanancia();
				
				// Actualizamos el beneficio acumulado.
				beneficioActual.setGanancia(nuevaGanancia);
				daoGenerico.modificarObjeto(beneficioActual);
			}
			else{
				// Nuevo beneficio.
				nuevoBeneficio = new Beneficio();
				nuevoBeneficio.setId(item.getId());
				nuevoBeneficio.setGanancia(nuevaGanancia);
				daoGenerico.persistirObjeto(nuevoBeneficio);
			}
		}
	}
}
