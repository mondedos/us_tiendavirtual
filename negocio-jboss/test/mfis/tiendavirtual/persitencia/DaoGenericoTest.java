package mfis.tiendavirtual.persitencia;

import java.util.List;

import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.dao.SingletonSpringContainer;
import mfis.tiendavirtual.modelo.objetoNegocio.Dvd;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class DaoGenericoTest {
	
	private DaoGenerico daoGenerico;
	
	@BeforeClass
	public void inicializar(){
		
		daoGenerico= (DaoGenerico)SingletonSpringContainer.getBean(SingletonSpringContainer.DAO_GENERICO); 
	}
	
	@Test
	public void pruebaObtenerPorId(){
		
		
	}
	
	@Test
	public void pruebaObtenerTodos(){
		
		List<Dvd> lista= daoGenerico.obtenerTodos(Dvd.class);
		
		
	}

}
