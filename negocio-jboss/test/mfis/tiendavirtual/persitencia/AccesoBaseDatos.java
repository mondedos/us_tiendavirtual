package mfis.tiendavirtual.persitencia;

import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.dao.SingletonSpringContainer;

import org.testng.annotations.Test;

/**
 * Pruebas que comprueban la carga de los mapas e inicializacion de los beans en spring
 * @author Edgar
 *
 */
public class AccesoBaseDatos {
	
	@Test
	public void pruebaConexionStatica(){
		
		DaoGenerico daoGenerico= (DaoGenerico)SingletonSpringContainer.getBean(SingletonSpringContainer.DAO_GENERICO);
		System.out.println("Configuracion de Spring-Hibernate OK");
	}
}
