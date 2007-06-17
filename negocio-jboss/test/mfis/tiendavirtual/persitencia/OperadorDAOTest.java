package mfis.tiendavirtual.persitencia;

import mfis.tiendavirtual.modelo.dao.OperadorDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OperadorDAOTest {

	private OperadorDAO operadorDao;

	@BeforeClass
	public void inicializar() {
		operadorDao = new OperadorDAO();
	}

	@Test
	public void pruebaObtenerOperador() {

		String login = "cuvere@gmail.com";
		Operador operador = operadorDao.obtenerOperador(login);

		assert operador != null && operador.getId().equals(new Long(2)) : "Busqueda erronea";

	}

}
