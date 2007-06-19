package mfis.tiendavirtual.modelo.dao;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Clase para la realizacion de busquedas y modificaciones de forma generica En
 * esta aplicacion se utilizaran DTO's es decir Data transfer object, de manera
 * que si queremos modificar un determinado objeto de negocio enviaremos un DTO
 * cuyos atributos (aquellos que no sean null) indicaran los atributos del
 * objeto de negocio a modificar Como DTO utilizaremos el propio objeto de
 * negocio. Para realizar busquedas se realizara una operacion parecida
 * 
 * @author Edgar
 * 
 */
public class BMGenerico {

	private DaoGenerico daoGenerico;

	public BMGenerico() {
		daoGenerico = new DaoGenerico();
	}

	/**
	 * Metodo que modifica las propiedades de un objeto de negocio
	 * 
	 * @param dto
	 *            objeto de negocio que funciona como dto
	 * @param identificador
	 *            identificador del objeto de negocio
	 */
	public void modificarObjeto(Object dto, Long identificador) {

		Class clase = dto.getClass();
		Object objetoNegocio = daoGenerico.buscarPorId(clase, identificador);

		for (Method metodo : clase.getMethods()) {

			String nombreMetodo = metodo.getName();
			if (nombreMetodo.startsWith("get")
					&& !nombreMetodo.equals("getClass")) {

				try {
					Object valor = metodo.invoke(dto, new Object[0]);
					if (valor != null) {
						Method modificador = obtenerMetodoModificador(
								nombreMetodo, clase, valor.getClass());

						Object[] argumentos = { valor };
						modificador.invoke(objetoNegocio, argumentos);

					}
				} catch (Exception e) {
					System.err.println("No debio elevarse esta excepcion");
					throw new RuntimeException(e);
				}
			}
		}

		daoGenerico.modificarObjeto(objetoNegocio);
	}

	/**
	 * Obtiene el metodo modificador correspondiente a cierto metodo consultor
	 * con los parametro descritos
	 * 
	 * @param metodoConsultor
	 * @param clase
	 * @param parametro
	 * @return el metodo modificador correspondiente a cierto metodo consultor
	 */
	@SuppressWarnings("unchecked")
	private Method obtenerMetodoModificador(String metodoConsultor,
			Class clase, Class parametro) {

		String nombreMetodoModificador = "set" + metodoConsultor.substring(3);
		Class[] parametros = { parametro };

		Method metodo = null;
		try {
			metodo = clase.getMethod(nombreMetodoModificador, parametros);
		} catch (Exception e) {
			System.err.println("No debio elevarse esta excepcion");
			throw new RuntimeException(e);
		}

		return metodo;
	}

	/**
	 * Metodo para realizar una busqueda esta es la busqueda que se hace
	 * generalmente, donde se tienen que cumplir todos los atributos
	 * 
	 * @param dto
	 *            objeto de negocio que funciona como dto
	 * @return objeto criteria, se le pueden añadir mas criterios de busqueda
	 */
	public Criteria realizarBusqueda(Object dto) {

		return realizarBusqueda(dto, true);
	}

	/**
	 * Permite realizar una busqueda
	 * 
	 * @param dto
	 *            objeto de negocio que funciona como dto
	 * @param and
	 *            si es cierto indica que los atributos del dto se añadiran como
	 *            and a la busqueda, en caso contrario como or
	 * @return
	 */
	public Criteria realizarBusqueda(Object dto, boolean and) {
		if (and) {
			return (realizarBusquedaAnd(dto));
		} else {
			return (realizarBusquedaOr(dto));
		}
	}

	/**
	 * Realiza una busqueda en base al DTO parametro de forma que los resultados
	 * de busqueda coincidan con todos los campos del objeto DTO
	 * 
	 * @param objeto
	 *            DTO que contiene en sus atributos los valores por los que se
	 *            quiere buscar.
	 * @return un objeto Criteria que formaliza la definicion anterior
	 */
	private Criteria realizarBusquedaAnd(Object dto) {
		Class clase = dto.getClass();
		Session sesion = HibernateSessionFactory.crearSesion();
		Criteria criteria = sesion.createCriteria(clase);

		for (Method metodo : clase.getMethods()) {
			String nombreMetodo = metodo.getName();
			if (nombreMetodo.startsWith("get")
					&& !nombreMetodo.equals("getClass")) {
				try {
					Object valor = metodo.invoke(dto, new Object[0]);
					if (valor != null) {
						String nombreAtributo = obtenerNombreAtributo(nombreMetodo);
						criteria.add(Restrictions.eq(nombreAtributo, valor));
					}
				} catch (Exception e) {
					System.err.println("No debio elevarse esta excepcion");
					throw new RuntimeException(e);
				}
			}
		}

		return (criteria);
	}

	/**
	 * Realiza una busqueda en base al DTO parametro de forma que los resultados
	 * de busqueda coincidan con alguno de los campos del objeto DTO
	 * 
	 * @param objeto
	 *            DTO que contiene en sus atributos los valores por los que se
	 *            quiere buscar.
	 * @return un objeto Criteria que formaliza la definicion anterior
	 */
	private Criteria realizarBusquedaOr(Object dto) {
		Class clase = dto.getClass();
		Session sesion = HibernateSessionFactory.crearSesion();
		Criteria criteria = sesion.createCriteria(clase);
		List<Criterion> criterios = new LinkedList<Criterion>();

		for (Method metodo : clase.getMethods()) {
			String nombreMetodo = metodo.getName();
			if ((nombreMetodo.startsWith("get"))
					&& (!(nombreMetodo.equals("getClass")))) {
				try {
					Object valor = metodo.invoke(dto, new Object[0]);
					if (valor != null) {
						String nombreAtributo = obtenerNombreAtributo(nombreMetodo);
						criterios.add(Restrictions.eq(nombreAtributo, valor));
					}
				} catch (Exception e) {
					System.err.println("No debio elevarse esta excepcion");
					throw new RuntimeException(e);
				}
			}
		}
		if (criterios.size() > 1) {
			Criterion criterion = criterios.get(0);
			for (int i = 1; i < criterios.size(); i++) {
				criterion = Restrictions.or(criterion, criterios.get(i));
			}
			criteria.add(criterion);
		} else if (criterios.size() == 1) {
			criteria.add(criterios.get(0));
		}

		return (criteria);
	}

	/**
	 * Agrega obtiene el nombre de un atributo dado el nombre del metodo que lo
	 * obtiene
	 * 
	 * @param nombreMetodo
	 * @return el nombre del atributo obtenido mediante el uso del metodo
	 *         parametro
	 */
	private String obtenerNombreAtributo(String nombreMetodo) {
		String inicio = nombreMetodo.substring(3, 4).toLowerCase();

		return (inicio + nombreMetodo.substring(4));
	}

	/**
	 * Agrega un criterio and
	 * 
	 * @param criteria
	 * @param propiedad
	 * @param valor
	 */
	public void agregarAnd(Criteria criteria, String propiedad, Object valor) {
		if (valor != null)
			criteria.add(Restrictions.eq(propiedad, valor));
	}

	/**
	 * Agrega una cadena a la busqueda, el criterio de busqueda sera de tal
	 * forma que dara cierto si la cadena se encuentra en parte y sin tener en
	 * cuenta mayusculas y minusculas
	 * 
	 * @param criteria
	 * @param propiedad
	 * @param valor
	 */
	public void agregarCadena(Criteria criteria, String propiedad, String valor) {
		if (valor != null) {
			String valorBusqueda = "%" + valor + "%";
			Criterion criterion = Restrictions.like(propiedad, valorBusqueda)
					.ignoreCase();
			criteria.add(criterion);
		}
	}

	/**
	 * Agrega un criterio de que la propiedad dada tiene que estar dentro de un
	 * rango determinado. Es decir:
	 * 
	 * menor <= propiedad <= mayor
	 * 
	 * @param criteria
	 * @param propiedad
	 * @param menor
	 * @param mayor
	 */
	public void agregarRango(Criteria criteria, String propiedad, Float menor,
			Float mayor) {
		if ((menor != null) && (mayor != null)) {
			criteria.add(Restrictions.ge(propiedad, menor));
			criteria.add(Restrictions.le(propiedad, mayor));
		}
	}

	/**
	 * Crea un objeto de tipo Criteria vacio
	 * 
	 * @param clase
	 * @return
	 */
	public Criteria crearCriteriaVacio(Class clase) {
		return (HibernateSessionFactory.crearSesion().createCriteria(clase));
	}

	/**
	 * Se agregan a un objeto Criteria que despues se devuelve la condicion de
	 * buscar cierto tipo de electrodomestico segun una disyuncion de marcas.
	 * 
	 * @param listString Lista de cadenas.
	 * @return Criteria para buscar los productos entre las distintas marcas
	 * que se pasan en la lista.
	 */
	public Criteria agregarMarcaOr(Class categoria, List <String> listString) {
		Criteria criteria = this.crearCriteriaVacio(categoria);
		criteria.add(Restrictions.disjunction());

		for (String cadena : listString) {
			criteria.add(Restrictions.eq("marca", cadena));
		}

		return criteria;
	}
}