package mfis.tiendavirtual.persitencia;


import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.objetoNegocio.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


public class PruebaMapeosTest {
	
	@BeforeClass
	public void before(){
		
		 
	}
	
	@Test
	public void saveFrigorifico(){
		
		Frigorifico frigorifico = 
			CreateObjetosNegocio.getInstance().createFrigorifico();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(frigorifico);
		sesion.delete(frigorifico);
		tx.commit();
		sesion.close();
	}
	
	@Test
	public void saveLavadora(){
		
		Lavadora lavadora = 
			CreateObjetosNegocio.getInstance().creatLavadora();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(lavadora);
		sesion.delete(lavadora);
		tx.commit();
		sesion.close();
	}
	
	@Test
	public void saveDdv(){
		
		Dvd dvd = CreateObjetosNegocio.getInstance().createDvd();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(dvd);
		sesion.delete(dvd);
		tx.commit();
		sesion.close();
	}
	
	@Test
	public void saveTelevisor(){
		
		Televisor televisor = 
			CreateObjetosNegocio.getInstance().createTelevisor();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(televisor);
		sesion.delete(televisor);
		tx.commit();
		sesion.close();
	}
	
	@Test
	public void savePequenoElectrodomestico(){
		
		PequenoElectrodomestico pE = 
			CreateObjetosNegocio.getInstance().createPequenoElectrodomestico();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(pE);
		sesion.delete(pE);
		tx.commit();
		sesion.close();
	}
	
	@Test
	public void saveOperador(){
		
		Operador operador = 
			CreateObjetosNegocio.getInstance().createOperador();
		
			
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(operador);
		sesion.delete(operador);
		tx.commit();
		sesion.close();
	}
	
	
	@Test
	public void savePedido(){
		
		Pedido pedido = CreateObjetosNegocio.getInstance().createPedido();
		Item item1 = CreateObjetosNegocio.getInstance().createItem();
		Item item2 = CreateObjetosNegocio.getInstance().createItem();
		
		LineaPedido lineaPedido1 = 
			CreateObjetosNegocio.getInstance().createLineaPedido(pedido, item1);
		
		LineaPedido lineaPedido2 = 
			CreateObjetosNegocio.getInstance().createLineaPedido(pedido, item2);
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(lineaPedido1);
		sesion.save(lineaPedido2);
		
		sesion.delete(lineaPedido1);
		sesion.delete(lineaPedido2);
		tx.commit();
		sesion.close();
	}
}
