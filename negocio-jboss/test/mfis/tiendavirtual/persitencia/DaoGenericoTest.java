package mfis.tiendavirtual.persitencia;


import java.util.List;

import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class DaoGenericoTest {

	private DaoGenerico daoGenerico;

	@BeforeClass
	public void inicializar(){
		daoGenerico= new DaoGenerico();
	}
	
	
	@Test
	public void pruebaObtenerTodos(){
		
		List<Lavadora> l= daoGenerico.obtenerTodos(Lavadora.class);
		assert l.size()==5 : "El numero de elementos es incorrecto";
		
	}

}
