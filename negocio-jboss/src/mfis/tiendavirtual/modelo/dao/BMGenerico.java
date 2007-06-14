package mfis.tiendavirtual.modelo.dao;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
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
			if(nombreMetodo.startsWith("get") && !nombreMetodo.equals("getClass")){
				
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
	
	@SuppressWarnings("unchecked")
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
	 * esta es la busqueda que se hace generalmente, donde se tienen que cumplir todos los atributos
	 * 
	 * @param dto objeto de negocio que funciona como dto
	 * @return objeto criteria, se le pueden añadir mas criterios de busqueda
	 */
	public Criteria realizarBusqueda(Object dto){
		
		return realizarBusqueda(dto, true);
	}
	
	/**
	 * Permite realizar una busqueda
	 * @param dto objeto de negocio que funciona como dto
	 * @param and si es cierto indica que los atributos del dto se añadiran como and a la busqueda, en caso contrario como or
	 * @return
	 */
	public Criteria realizarBusqueda(Object dto, boolean and){
		
		if(and) return realizarBusquedaAnd(dto);
		else return realizarBusquedaOr(dto);
		
	}
	
	private Criteria realizarBusquedaAnd(Object dto){
		
		Class clase= dto.getClass();
		Session sesion= HibernateSessionFactory.crearSesion();
		Criteria criteria= sesion.createCriteria(clase);
		
		for(Method metodo: clase.getMethods()){
			
			String nombreMetodo= metodo.getName();
			if(nombreMetodo.startsWith("get") && !nombreMetodo.equals("getClass")){
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
	
	private Criteria realizarBusquedaOr(Object dto){
		
		Class clase= dto.getClass();
		Session sesion= HibernateSessionFactory.crearSesion();
		Criteria criteria= sesion.createCriteria(clase);
		List<Criterion> criterios= new LinkedList<Criterion>();
		
		for(Method metodo: clase.getMethods()){
			
			String nombreMetodo= metodo.getName();
			if(nombreMetodo.startsWith("get") && !nombreMetodo.equals("getClass")){
				try{
					Object valor= metodo.invoke(dto, new Object[0]);
					if(valor!=null){
						String nombreAtributo= obtenerNombreAtributo(nombreMetodo);
						criterios.add(Restrictions.eq(nombreAtributo, valor));
					}
				}catch(Exception e){
					System.err.println("No debio elevarse esta excepcion");
					throw new RuntimeException(e);
				}
			}
		}
		
		if(criterios.size()>1){
			
			Criterion criterion= criterios.get(0);
			for(int i=1; i<criterios.size(); i++)
				criterion= Restrictions.or(criterion, criterios.get(i));
			
			criteria.add(criterion);
			
		}else if(criterios.size()==1){
			
			criteria.add(criterios.get(0));
			
		}
		
		
		return criteria;
		
	}
	
	
	
	private String obtenerNombreAtributo(String nombreMetodo){
		
		String inicio= nombreMetodo.substring(3, 4).toLowerCase();
		return inicio+nombreMetodo.substring(4);
		
	}
	
	
	
	
	/**
	 * Agrega un criterio and
	 * @param criteria
	 * @param propiedad
	 * @param valor
	 */
	public void agregarAnd(Criteria criteria, String propiedad, Object valor){
		
		if(valor!=null)
			criteria.add(Restrictions.eq(propiedad, valor));
		
	}
	
	/**
	 * Agrega una cadena a la busqueda, el criterio de busqueda sera de tal forma que dara cierto si la cadena
	 * se encuentra en parte y sin tener en cuenta mayusculas y minusculas
	 * 
	 * @param criteria
	 * @param propiedad
	 * @param valor
	 */
	public void agregarCadena(Criteria criteria, String propiedad, String valor){
		
		if(valor!=null){
			String valorBusqueda= "%"+valor+"%";
			Criterion criterion= Restrictions.like(propiedad, valorBusqueda).ignoreCase();
			criteria.add(criterion);
			
		}
		
	}
	
	
	/**
	 * Metodo para agregar un criterio or
	 * @param criteria
	 * @param propiedad
	 * @param valor
	 */
	public void agregarOr(Criteria criteria, String propiedad, Object valor){
		
		//TODO
		
	}
	
	
	/**
	 * Agrega un criterio de que la propiedad dada tiene que estar dentro de un rango determinado. Es decir:
	 * 
	 * menor <= propiedad <= mayor
	 * 
	 * @param criteria
	 * @param propiedad
	 * @param menor 
	 * @param mayor
	 */
	public void agregarRango(Criteria criteria, String propiedad, Float menor, Float mayor){
		
		if(menor!=null && mayor!=null){
			criteria.add(Restrictions.ge(propiedad, menor));
			criteria.add(Restrictions.le(propiedad, mayor));
		}
		
	}
	
	/**
	 * Crea un objeto criteria vacio
	 * @param clase
	 * @return
	 */
	public Criteria crearCriteriaVacio(Class clase){
		
		return HibernateSessionFactory.crearSesion().createCriteria(clase);
		
	}
	

}


















