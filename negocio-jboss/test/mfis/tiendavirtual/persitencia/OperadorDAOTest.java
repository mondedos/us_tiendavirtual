package mfis.tiendavirtual.persitencia;

import java.util.List;
import mfis.tiendavirtual.modelo.dao.OperadorDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.persitencia.asignacionPedido.AsignacionPedidoConcurrente;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OperadorDAOTest {

	private OperadorDAO operadorDao;

	@BeforeClass
	public void inicializar() {
		this.operadorDao = new OperadorDAO();
	}

	// @Test
	public void pruebaObtenerOperador() {

		String login = "cuvere@gmail.com";
		Operador operador = operadorDao.obtenerOperador(login);

		assert operador != null && operador.getId().equals(new Long(2)) : "Busqueda erronea";
	}

	// @Test
	public void siguientePedidoTest() {
		Operador operador1 = this.operadorDao
				.obtenerOperador("danird@gmail.com");
		Operador operador2 = this.operadorDao
				.obtenerOperador("dvazquezgomez@gmail.com");

		Pedido p1 = this.operadorDao.siguientePedido(operador1.getId());
		Pedido p2 = this.operadorDao.siguientePedido(operador2.getId());
		assert (p1 != null && p2 != null);
		assert (!p1.getId().equals(p2.getId()));
	}

	@Test
	public void siguientePedidoConcurenteTest() {

		Operador operador1 = this.operadorDao
				.obtenerOperador("danird@gmail.com");
		assert (operador1 != null);
		Operador operador2 = this.operadorDao
				.obtenerOperador("dvazquezgomez@gmail.com");
		assert (operador2 != null);

		AsignacionPedidoConcurrente apc1 = new AsignacionPedidoConcurrente(
				this.operadorDao, operador1.getId(), 1);

		AsignacionPedidoConcurrente apc2 = new AsignacionPedidoConcurrente(
				this.operadorDao, operador2.getId(), 1);

		// Espera a que acabe.
		while (apc1.isAlive() || apc2.isAlive());

		Pedido p1 = apc1.getPedido();
		assert (p1 != null);

		Pedido p2 = apc2.getPedido();
		assert (p2 != null);
		assert (!p1.getId().equals(p2.getId()));
	}

	// @Test
	public void pruebaObtenerPedidosOperador() {

		String login = "danird1982@hotmail.com";

		List<Pedido> resultado = operadorDao.obtenerPedidosOperador(login);

		assert resultado != null && !resultado.isEmpty() : "Resultado incorrecto";
		assert resultado.size() == 2 : "numero de elementos incorrectos";

	}
}
