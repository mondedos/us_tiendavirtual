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
		float gananciaActual;
		float nuevaGanancia;
		
		// Para cada producto insertar o actualizar el beneficio.
		for(Producto producto: listaProducto){
			
			// Obtenemos la ganacia actual en porcentajes.
			gananciaActual = producto.getGanancia();
			
			nuevaGanancia = (gananciaActual*producto.getPrecio())/100;
			
			// Obtenemos el beneficio actual.
			beneficioActual = daoGenerico.buscarPorId(Beneficio.class, 
					producto.getId());
			
			// Ya existe el objeto beneficio.
			if(beneficioActual != null){
				
				// Acumulamos el beneficio con el que ya teniamos. 
				nuevaGanancia += beneficioActual.getGanancia();
				
				// Actualizamos el beneficio acumulado.
				beneficioActual.setGanancia(nuevaGanancia);
				daoGenerico.persistirObjeto(beneficioActual);
			}
			else{
				// Nuevo beneficio.
				nuevoBeneficio = new Beneficio();
				nuevoBeneficio.setId(producto.getId());
				nuevoBeneficio.setGanancia(nuevaGanancia);
				daoGenerico.persistirObjeto(nuevoBeneficio);
			}
		}
	}
}
