package org.mfis.tiendaVirtual.persistencia.utilidades;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * Clase con utilidades para el maneje de la persistencia con Hibernate
 * 
 * @author Edgar
 */
@Name(UtilidadesPersistencia.UTILIDADES_PERSISTENCIA)
@Scope(ScopeType.CONVERSATION)
public class UtilidadesPersistencia implements Serializable{

	private static final long serialVersionUID = 8832446903497854511L;
	public static final String UTILIDADES_PERSISTENCIA= "utilidadesPersistencia";
	
	@In Session mfisDataBase;
	
	
	//*** METODOS ****
	
	@SuppressWarnings("unchecked")
	public <T> List<T> encontrarTodos(Class clasePersistente){
		
		Criteria criteria = mfisDataBase.createCriteria(clasePersistente);
		return criteria.list();
	}
	
	/**
	 * Método para realizar una búsqueda en la base de datos por identificador
	 * 
	 * En caso de no encontrar ninguna correspondencia devolverá null
	 * 
	 * @param identificador clave primaria de la clase persistente
	 * @param clasePersistente representa la clase persistente de la cual se desea realizar la busqueda
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public <T> T buscarPorId(String identificador, Class clasePersistente){
		
		Integer id = Integer.parseInt(identificador);
		Criteria criteria= mfisDataBase.createCriteria(clasePersistente);
		criteria.add(Restrictions.eq("id", id));
		
		List<T> resultado= criteria.list();
		
		if(resultado.isEmpty()) return null;
		else return resultado.get(0);
		
	}
	
	
	
	
	
	public void borrarObjeto(Object objetoPersistente){
		mfisDataBase.delete(objetoPersistente);
	}
	
	public void crearObjeto(Object objetoNoPersistente){
		mfisDataBase.persist(objetoNoPersistente);
	}
	

	
	//*** GETTERS AND SETTERS ****
	
	public Session getMfisDataBase() {
		return mfisDataBase;
	}


	public void setMfisDataBase(Session mfisDataBase) {
		this.mfisDataBase = mfisDataBase;
	}
	
	
	

}
