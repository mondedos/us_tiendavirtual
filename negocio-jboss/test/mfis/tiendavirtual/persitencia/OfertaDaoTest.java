package mfis.tiendavirtual.persitencia;

import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.dao.OfertasDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Oferta;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OfertaDaoTest {
	
	private OfertasDAO ofertaDao;
	private DaoGenerico daoGenerico;
	
	@BeforeClass
	public void inicializar(){
		ofertaDao= new OfertasDAO();
		DaoGenerico daoGenerico= new DaoGenerico();
	}
	
	@Test
	public void pruebaObtenerOferta(){
		
		Oferta ofertaActual= ofertaDao.obtenerOferta();
		
		assert ofertaActual.getId().equals(new Long(17)) : "Oferta actual incorrecta";
	}
	
}
