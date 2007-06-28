package mfis.tiendavirtual.persitencia;

import java.util.List;

import mfis.tiendavirtual.modelo.dao.OperadorDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;

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
	
	@Test
	public void pruebaObtenerPedidosOperador(){
		
		String login= "danird1982@hotmail.com";
		
		List<Pedido> resultado= operadorDao.obtenerPedidosOperador(login);
		
		assert resultado!=null && !resultado.isEmpty() : "Resultado incorrecto";
		assert resultado.size()==2 : "numero de elementos incorrectos";
		
	}

}
