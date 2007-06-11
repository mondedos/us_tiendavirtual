package mfis.tiendavirtual.persitencia;

import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

public class DeleteUpdateTest {

	
	@Test
	public void deleteOperador(){
		
		Operador operador = 
			CreateObjetosNegocio.getInstance().createOperador();
		
			
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		sesion.save(operador);
		tx.commit();
		sesion.close();
		
		Operador operador1 = 
			CreateObjetosNegocio.getInstance().createOperador();
		Session sesion1 = HibernateSessionFactory.crearSesion();
		Transaction tx1 = sesion1.beginTransaction();
		sesion1.delete(operador1);
		tx1.commit();
		sesion1.close();
	}
}
