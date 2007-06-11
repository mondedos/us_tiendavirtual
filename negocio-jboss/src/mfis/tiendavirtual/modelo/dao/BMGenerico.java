package mfis.tiendavirtual.modelo.dao;

import java.lang.reflect.Method;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


/**
 * Clase para la realizacion de busquedas y modificaciones de forma generica
 * En esta aplicacion se utilizaran DTO's es decir Data transfer object, de manera que si queremos modificar un determinado
 * objeto de negocio enviaremos un DTO cuyos atributos (aquellos que no sean null) indicaran los atributos del objeto de negocio a modificar
 * Como DTO utilizaremos el propio objeto de negocio.
 * Para realizar busquedas se realizara una operacion parecida
 * 
 * @author Edgar
 *
 */
public class BMGenerico {
	
	private DaoGenerico daoGenerico;
	
	public BMGenerico(){
		daoGenerico= new DaoGenerico();
	}
	
	
	/**
	 * Metodo que modifica las propiedades de un objeto de negocio
	 * 
	 * @param dto objeto de negocio que funciona como dto
	 * @param identificador identificador del objeto de negocio
	 */
	public void modificarObjeto(Object dto, Long identificador){
		
		Class clase= dto.getClass();
		Object objetoNegocio= daoGenerico.buscarPorId(clase, identificador);
		
		for(Method metodo: clase.getMethods()){
			
			String nombreMetodo= metodo.getName();
			if(nombreMetodo.startsWith("get")){
				
				try{
					Object valor= metodo.invoke(dto, new Object[0]);
					if(valor!=null){
						Method modificador= obtenerMetodoModificador(nombreMetodo, clase, valor.getClass());
						
						Object []argumentos= {valor};
						modificador.invoke(objetoNegocio, argumentos);
						
					}
				}catch(Exception e){
					System.err.println("No debio elevarse esta excepcion");
					throw new RuntimeException(e);
				}
			}
		}
		
		daoGenerico.modificarObjeto(objetoNegocio);
	}
	
	private Method obtenerMetodoModificador(String metodoConsultor, Class clase, Class parametro){
		
		String nombreMetodoModificador= "set"+metodoConsultor.substring(3);
		Class []parametros= {parametro};
		
		Method metodo= null;
		try{
			metodo= clase.getMethod(nombreMetodoModificador, parametros);
		}catch(Exception e){
			System.err.println("No debio elevarse esta excepcion");
			throw new RuntimeException(e);
		}
		
		return metodo;
	}
	
	
	
	/**
	 * Metodo para realizar una busqueda
	 * @param dto objeto de negocio que funciona como dto
	 * @return objeto criteria, se le pueden añadir mas criterios de busqueda
	 */
	public Criteria realizarBusqueda(Object dto){
		
		Class clase= dto.getClass();
		Session sesion= HibernateSessionFactory.crearSesion();
		Criteria criteria= sesion.createCriteria(clase);
		
		for(Method metodo: clase.getMethods()){
			
			String nombreMetodo= metodo.getName();
			if(nombreMetodo.startsWith("get")){
				try{
					Object valor= metodo.invoke(dto, new Object[0]);
					if(valor!=null){
						String nombreAtributo= obtenerNombreAtributo(nombreMetodo);
						criteria.add(Restrictions.eq(nombreAtributo, valor));
					}
				}catch(Exception e){
					System.err.println("No debio elevarse esta excepcion");
					throw new RuntimeException(e);
				}
			}
		}
		
		return criteria;
	}
	
	
	private String obtenerNombreAtributo(String nombreMetodo){
		
		String inicio= nombreMetodo.substring(3, 4).toLowerCase();
		return inicio+nombreMetodo.substring(4);
		
	}

}


















