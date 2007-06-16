package mfis.tiendavirtual.persitencia;

import java.util.List;

import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.dao.PedidosDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Beneficio;
import mfis.tiendavirtual.modelo.objetoNegocio.Dvd;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.modelo.objetoNegocio.Televisor;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PedidosDAOTest {

	private PedidosDAO pedidoDao;

	@BeforeClass
	public void inicializar() {

		this.pedidoDao = new PedidosDAO();
	}

	@Test
	public void obtener_Lineas_Productos_Pedido() {

		// Creamos un pedido.
		Pedido pedido = CreateObjetosNegocio.getInstance().createPedido();
		
		Lavadora lavadora = CreateObjetosNegocio.getInstance()
				.creatLavadora();
		/*Televisor televisor = CreateObjetosNegocio.getInstance()
				.createTelevisor();
		Dvd dvd = CreateObjetosNegocio.getInstance().createDvd();*/
		
		// Hacemos persistente los productos.
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(lavadora);
		//sesion.save(televisor);
		//sesion.save(dvd);
		sesion.save(pedido);
		tx.commit();
		sesion.close();

		LineaPedido lineaPedido1 = CreateObjetosNegocio.getInstance()
				.createLineaPedido(pedido, lavadora);

		/*LineaPedido lineaPedido2 = CreateObjetosNegocio.getInstance()
				.createLineaPedido(pedido, televisor);

		LineaPedido lineaPedido3 = CreateObjetosNegocio.getInstance()
				.createLineaPedido(pedido, dvd);*/

		// Hacemos persistente el pedido.
		Session sesion1 = HibernateSessionFactory.crearSesion();
		Transaction tx1 = sesion1.beginTransaction();
		sesion1.save(lineaPedido1);
		//sesion1.save(lineaPedido2);
		//sesion1.save(lineaPedido3);
		tx1.commit();
		sesion1.close();

		List<LineaPedido> lineasPedido = this.pedidoDao
				.obtenerLineasPedido(pedido);

		/*assert (lineasPedido.size() == 3);
		assert (lineasPedido.get(0).equals(lineaPedido1));
		assert (lineasPedido.get(1).equals(lineaPedido2));
		assert (lineasPedido.get(2).equals(lineaPedido3));
		for (LineaPedido lPedido : lineasPedido) {
			assert (lPedido.getPedido().equals(pedido));
		}*/

		/*List<Producto> productosPedido = this.pedidoDao
				.obtenerProductosPedido(pedido);
		assert (productosPedido.contains(lavadora));
		assert (productosPedido.contains(televisor));
		assert (productosPedido.contains(dvd));*/
		
		// Eliminamos el pedido.
		Session sesion2 = HibernateSessionFactory.crearSesion();
		Transaction tx2 = sesion2.beginTransaction();
		sesion2.delete(lineaPedido1);
		//sesion2.delete(lineaPedido2);
		//sesion2.delete(lineaPedido3);
		sesion2.delete(pedido);
		tx2.commit();
		sesion2.close();

		// Eliminamos los productos.
		Session sesion3 = HibernateSessionFactory.crearSesion();
		Transaction tx3 = sesion3.beginTransaction();
		sesion3.delete(lavadora);
		//sesion3.delete(televisor);
		//sesion3.delete(dvd);
		tx3.commit();
		sesion3.close();
	}
}
