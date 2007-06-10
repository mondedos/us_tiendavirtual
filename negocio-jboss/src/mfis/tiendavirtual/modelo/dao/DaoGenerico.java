package mfis.tiendavirtual.modelo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DaoGenerico {
	
	/**
	 * Para instanciar esta clase utilizamos SingletonSpringContainer.getBean();
	 */
	private DaoGenerico(){}
	
	
	protected HibernateTemplate hibernateTemplate;
	protected SessionFactory sessionFactory;
	
	
	
	@SuppressWarnings("unchecked")
	public <T> T buscarPorId(Class clase, String id){
		
		Integer identificador= Integer.parseInt(id);
		T resultado= null;
		try{
			resultado= (T)hibernateTemplate.load(clase, identificador);
		}catch(ObjectRetrievalFailureException e){
			//no se ha encontrado el objeto
			//devolvemos null
		}
			
		return resultado;
	}
	
	/**
	 * Metodo para obtener todos los elementos de la base de datos
	 * @param <T>
	 * @param clase
	 * @return
	 */
	public List obtenerTodos(Class clase){
		
		return hibernateTemplate.loadAll(clase);
		
	}
	
	
	
	
	public HibernateTemplate getHibernateTemplate(){
		return this.hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
		this.hibernateTemplate= hibernateTemplate;
	}
	
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory= sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
}