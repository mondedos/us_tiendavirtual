package mfis.tiendavirtual.persitencia;

import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.dao.SingletonSpringContainer;

import org.testng.annotations.Test;

public class AccesoBaseDatos {
	
	@Test
	public void pruebaConexion(){
		
		
		SingletonSpringContainer contenedor =  SingletonSpringContainer.getInstance();
		DaoGenerico daoConcreto = (DaoGenerico)contenedor.getBean("DaoGenerico");		
		
		System.out.print("Configuracion de Spring-Hibernate OK");
	}
}
