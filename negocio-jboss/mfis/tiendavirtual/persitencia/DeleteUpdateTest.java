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
		sesion.delete(operador);
		tx.commit();
		sesion.close();
	}
	
	@Test
	public void deleteOperador2(){
		Operador operador = 
			CreateObjetosNegocio.getInstance().createOperador();
		
		//guardamos el objeto en la base de datos
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		Long id= (Long)sesion.save(operador);
		tx.commit();
		sesion.close();
		
		
		//CASO DE USO: recuperacion de objeto para su posterior borrado
		
		//recuperamos el objeto por el id
		Session sesion1 = HibernateSessionFactory.crearSesion();
		Transaction tx1 = sesion1.beginTransaction();
		Operador operador1= (Operador)sesion1.load(Operador.class, id);
		tx1.commit();
		sesion1.close();
		
		//borramos el operador de la base de datos
		Session sesion2= HibernateSessionFactory.crearSesion();
		Transaction tx2= sesion2.beginTransaction();
		sesion2.delete(operador1);
		tx2.commit();
		sesion2.close();
	}
}
