package mfis.tiendavirtual.persitencia;

import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


public class DaoGenericoTest {
	
	@BeforeClass
	public void before(){
		
		 
	}
	
	@Test
	public void saveOperador(){
		
		Operador op = new Operador();
		op.setLogin("prueba@gmail.com");		
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(op);
		tx.commit();
		sesion.close();
	}
}
