package mfis.tiendavirtual.persitencia;

import java.util.List;
import mfis.tiendavirtual.modelo.dao.BMGenerico;
import mfis.tiendavirtual.modelo.dao.BeneficioDAO;
import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.dao.PedidosDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Beneficio;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.modelo.objetoNegocio.Televisor;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeneficioDAOTest {

	private BeneficioDAO beneficioDao;

	private PedidosDAO pedidoDao;

	private BMGenerico bmGenerico;

	@BeforeClass
	public void inicializar() {

		this.pedidoDao = new PedidosDAO();
		this.beneficioDao = new BeneficioDAO();
		this.bmGenerico = new BMGenerico();
	}

	@Test
	public void actualizarBeneficioPedidoTest() {

		// Creamos un pedido.
		Pedido pedido = CreateObjetosNegocio.getInstance().createPedido();
		Operador operador = pedido.getOperador();

		Lavadora lavadora = CreateObjetosNegocio.getInstance().createLavadora();
		Televisor televisor = CreateObjetosNegocio.getInstance()
				.createTelevisor();
		
		// Modificamos la ganancias y precio de la lavadora.
		lavadora.setGanancia(new Float(50));
		lavadora.setPrecio(new Float(500));

		// Insertamos un suspuesto beneficio previo para la lavadora.
		Beneficio beneficio = new Beneficio();
		beneficio.setGanancia(new Float(250));

		// El televisor no tiene beneficios acumulados
		// Modificamos la ganancias y precio del televisor.
		televisor.setGanancia(new Float(25));
		televisor.setPrecio(new Float(200));

		LineaPedido lineaPedido1 = CreateObjetosNegocio.getInstance()
				.createLineaPedido(pedido, lavadora);

		LineaPedido lineaPedido2 = CreateObjetosNegocio.getInstance()
				.createLineaPedido(pedido, televisor);

		// Hacemos persistente los productos.
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(operador);
		sesion.save(lavadora);
		sesion.save(televisor);
		sesion.save(pedido);
		sesion.save(lineaPedido1);
		sesion.save(lineaPedido2);
		beneficio.setId(lavadora.getId());
		sesion.save(beneficio);
		tx.commit();
		sesion.close();

		List<Producto> productosPedido = this.pedidoDao
				.obtenerProductosPedido(pedido);

		//Actualizamos los beneficios de los productos.
		this.beneficioDao.actualizarBeneficioPedido(productosPedido);

		Criteria criteria = this.bmGenerico.crearCriteriaVacio(Beneficio.class);
		this.bmGenerico.agregarAnd(criteria, "id", televisor.getId());
		Beneficio beneTelevisor = (Beneficio)criteria.uniqueResult();
		assert(beneTelevisor.getGanancia() == 50);
		
		Criteria criteria1 = this.bmGenerico
				.crearCriteriaVacio(Beneficio.class);
		this.bmGenerico.agregarAnd(criteria1, "id", lavadora.getId());
		Beneficio beneLavadora = (Beneficio)criteria.uniqueResult();
		assert(beneLavadora.getGanancia() == 500);

		Session sesion1 = HibernateSessionFactory.crearSesion();
		Transaction tx1 = sesion1.beginTransaction();
		sesion1.delete(lineaPedido1);
		sesion1.delete(lineaPedido2);
		sesion1.delete(beneTelevisor);
		sesion1.delete(beneLavadora);
		sesion1.delete(beneficio);
		sesion1.delete(pedido);
		sesion1.delete(lavadora);
		sesion1.delete(televisor);
		sesion1.delete(operador);
		tx1.commit();
		sesion1.close();
	}
}
