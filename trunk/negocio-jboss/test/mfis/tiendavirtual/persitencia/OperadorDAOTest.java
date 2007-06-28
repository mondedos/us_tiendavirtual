package mfis.tiendavirtual.persitencia;

import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import java.util.List;
import mfis.tiendavirtual.modelo.dao.OperadorDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.persitencia.asignacionPedido.AsignacionPedidoConcurrente;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OperadorDAOTest {

	private OperadorDAO operadorDao;
	private DaoGenerico daoGenerico; 
	
	@BeforeClass
	public void inicializar() {
		this.operadorDao = new OperadorDAO();
		this.daoGenerico = new DaoGenerico();
		
	}

	@Test
	public void pruebaObtenerOperador() {

		String login = "cuvere@gmail.com";
		Operador operador = operadorDao.obtenerOperador(login);

		assert operador != null && operador.getId().equals(new Long(2)) : "Busqueda erronea";
	}

	
	public void siguientePedidoTest(){
		Operador operador1 = this.operadorDao.obtenerOperador("danird@gmail.com");
		Pedido pedido = CreateObjetosNegocio.getInstance().createPedido();
		
	
		Pedido p = this.operadorDao.siguientePedido(operador1.getId());
		assert(p != null);
	}
	
	/*@Test
	public void siguientePedidoConcurenteTest(){
		
		Operador operador1 = this.operadorDao.obtenerOperador("danird@gmail.com");
		Operador operador2 = this.operadorDao.obtenerOperador("dvazquezgomez@gmail.com");
		
		AsignacionPedidoConcurrente apc1 = new AsignacionPedidoConcurrente(
				this.operadorDao,operador1.getId());
		
		AsignacionPedidoConcurrente apc2 = new AsignacionPedidoConcurrente(
				this.operadorDao,operador2.getId());
		
		// Espera a que acabe.
		while(!apc1.isAlive() || !apc2.isAlive());
		
		Pedido p1 = apc1.getPedido();
		Pedido p2 = apc1.getPedido();
		
		assert(p1.getId() != p2.getId());
	}*/
	
	/*@Test
	public void pruebaObtenerPedidosOperador(){
		
		String login= "danird1982@hotmail.com";
		
		List<Pedido> resultado= operadorDao.obtenerPedidosOperador(login);
		
		assert resultado!=null && !resultado.isEmpty() : "Resultado incorrecto";
		assert resultado.size()==2 : "numero de elementos incorrectos";
		
	}*/
}
