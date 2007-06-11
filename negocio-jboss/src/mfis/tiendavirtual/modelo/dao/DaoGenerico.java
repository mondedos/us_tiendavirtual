package mfis.tiendavirtual.modelo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Clase para realizar metodos de acceso/modificacion de la base de datos
 * de forma generica
 * 
 * @author Edgar
 *
 */
public class DaoGenerico {
	
	
	/**
	 * Obtiene todos los elementos de una clase persistente dada en la base de datos
	 * @param <T>
	 * @param clasePersistente
	 * @return
	 */
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
	
	
	/**
	 * Convierte un objeto en persistente
	 * @param objetoNoPersistente
	 * @return devuelve el identificador del objeto creado en la base de datos
	 */
	public Long persistirObjeto(final Object objetoNoPersistente){
		
		HibernateSessionFactory hsf= new HibernateSessionFactory(){
			public Object operacionesBaseDatos(Session sesion){
				return sesion.save(objetoNoPersistente);
			}
		};
		
		return (Long)hsf.sessionPerRequest();
		
	}
	
	/**
	 * Elimina un objeto de la base de datos
	 * @param objetoPersistente
	 */
	public void eliminarObjeto(final Object objetoPersistente){
		
		HibernateSessionFactory hsf= new HibernateSessionFactory(){
			public Object operacionesBaseDatos(Session sesion){
				sesion.delete(objetoPersistente);
				return null;
			}
		};
		
		hsf.sessionPerRequest();
		
	}
	
	/**
	 * Modifica un objeto de la base de datos
	 * @param objetoPersistente
	 */
	public void modificarObjeto(final Object objetoPersistente){
		
		HibernateSessionFactory hsf= new HibernateSessionFactory(){
			public Object operacionesBaseDatos(Session sesion){
				sesion.update(objetoPersistente);
				return null;
			}
		};
		
		hsf.sessionPerRequest();
		
	}
	
	
	/**
	 * Busca el objeto en la base de datos, cuyo identificador se le pasa como parametro, en caso de no existir se devolvera null
	 * @param <T>
	 * @param clasePersistente
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T buscarPorId(final Class clasePersistente, final String id){
		
		HibernateSessionFactory hsf= new HibernateSessionFactory(){
			public Object operacionesBaseDatos(Session sesion){
				
				Long identificador= null;
				Object resultado= null;
				
				try{
					identificador= Long.parseLong(id);
				}catch(NumberFormatException e){
					System.err.println("\nEl identificador no es un identificador correcto: "+id+"\n");
					return null;
				}
				
				Criteria c= sesion.createCriteria(clasePersistente);
				c.add(Restrictions.idEq(identificador));
				
				resultado= c.uniqueResult();
				
				return resultado;
			}
		};
		
		return (T)hsf.sessionPerRequest();
		
	}
	
	/**
	 * Metodo para realizar una busqueda por identificador
	 * @param <T>
	 * @param clasePersistente
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T buscarPorId(final Class clasePersistente, final Long id){
		
		HibernateSessionFactory hsf= new HibernateSessionFactory(){
			public Object operacionesBaseDatos(Session sesion){
				
				Object resultado= null;
				
				Criteria c= sesion.createCriteria(clasePersistente);
				c.add(Restrictions.idEq(id));
				
				resultado= c.uniqueResult();
				
				return resultado;
			}
		};
		
		return (T)hsf.sessionPerRequest();
		
	}
}