package mfis.tiendavirtual.modelo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * Clase para realizar metodos de acceso/modificacion de la base de datos
 * de forma generica
 * 
 * @author Edgar
 *
 */
public class DaoGenerico {
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> obtenerTodos(final Class clasePersistente){
		
		HibernateSessionFactory hsf= new HibernateSessionFactory(){
			public Object operacionesBaseDatos(Session sesion){
				
				Criteria c= sesion.createCriteria(clasePersistente);
				return c.list();
				
			}
		};
		
		return (List<T>)hsf.sessionPerRequest();
	}
	

}