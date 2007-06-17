package mfis.tiendavirtual.persitencia;


import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.objetoNegocio.*;
import mfis.tiendavirtual.modelo.objetoNegocio.Deprecated;

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
		Lavadora lavadora = CreateObjetosNegocio.getInstance().creatLavadora();
		Televisor televisor = CreateObjetosNegocio.getInstance().createTelevisor();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(lavadora);
		sesion.save(televisor);
		sesion.save(pedido);
		tx.commit();
		sesion.close();
		
		LineaPedido lineaPedido1 = 
			CreateObjetosNegocio.getInstance().createLineaPedido(pedido, lavadora);
		
		LineaPedido lineaPedido2 = 
			CreateObjetosNegocio.getInstance().createLineaPedido(pedido, televisor);
		
		Session sesion1 = HibernateSessionFactory.crearSesion();
		Transaction tx1 = sesion1.beginTransaction();
		sesion1.save(lineaPedido1);
		sesion1.save(lineaPedido2);
		
		tx1.commit();
		sesion1.close();
		
		
		Session sesion2 = HibernateSessionFactory.crearSesion();
		Transaction tx2 = sesion2.beginTransaction();
		sesion2.delete(lineaPedido1);
		sesion2.delete(lineaPedido2);
		tx2.commit();
		sesion2.close();
		
		
		Session sesion3 = HibernateSessionFactory.crearSesion();
		Transaction tx3 = sesion3.beginTransaction();
		
		sesion3.delete(pedido);
		sesion3.delete(lavadora);
		sesion3.delete(televisor);
		tx3.commit();
		sesion3.close();
	}
	
	@Test
	public void saveBeneficio(){
		
		Dvd dvd = CreateObjetosNegocio.getInstance().createDvd();
		
		Beneficio beneficio = 
			CreateObjetosNegocio.getInstance().createBeneficio();
					
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(dvd);
		dvd = (Dvd)sesion.get(Dvd.class, dvd.getId());
		tx.commit();
		sesion.close();
		
		// Asignamos "id" de beneficio manualmente asociado a un producto.
		beneficio.setId(dvd.getId());
		
		Session sesion1 = HibernateSessionFactory.crearSesion();
		Transaction tx1 = sesion1.beginTransaction();
		sesion1.save(beneficio);
		sesion1.delete(beneficio);
		sesion1.delete(dvd);
		tx1.commit();
		sesion1.close();
	}
	
	
	@Test
	public void saveDeprecated(){
		
		Dvd dvd = CreateObjetosNegocio.getInstance().createDvd();
		
		Deprecated deprecated = 
			CreateObjetosNegocio.getInstance().createDeprecated();
					
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(dvd);
		dvd = (Dvd)sesion.get(Dvd.class, dvd.getId());
		tx.commit();
		sesion.close();
		
		// Asignamos "id" manualmente al producto que se va a descatalogar.
		deprecated.setId(dvd.getId());
		
		Session sesion1 = HibernateSessionFactory.crearSesion();
		Transaction tx1 = sesion1.beginTransaction();
		sesion1.save(deprecated);
		sesion1.delete(deprecated);
		sesion1.delete(dvd);
		tx1.commit();
		sesion1.close();
	}
}
