package mfis.tiendavirtual.modelo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import mfis.tiendavirtual.modelo.objetoNegocio.Beneficio;
import mfis.tiendavirtual.modelo.objetoNegocio.Dvd;
import mfis.tiendavirtual.modelo.objetoNegocio.Frigorifico;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;
import mfis.tiendavirtual.modelo.objetoNegocio.PequenoElectrodomestico;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.modelo.objetoNegocio.Televisor;
import mfis.tiendavirtual.modelo.objetoNegocio.Deprecated;

/**
 * Dao para el manejo de los productos
 * 
 * @author Edgar
 * 
 */
public class ProductoDao {

	private DaoGenerico daoGenerico;

	private BMGenerico bmGenerico;

	public ProductoDao() {
		daoGenerico = new DaoGenerico();
		bmGenerico = new BMGenerico();
	}

	/**
	 * Metodo para obtener un producto a partir de su identificador, en caso de
	 * que no exista se devolvera null
	 * 
	 * @param id
	 * @return
	 */
	public Producto obtenerProductoPorId(Long identificador) {

		return daoGenerico
				.buscarPorId(Producto.class, identificador.toString());

	}

	/**
	 * Método para agrear un nuevo producto a la base de datos
	 * 
	 * @param producto
	 * @return identificador del producto creado
	 */
	public Long agregarProducto(Producto producto) {
		return daoGenerico.persistirObjeto(producto);

	}

	/**
	 * Elimina un producto de la base de datos
	 * 
	 * @param producto
	 *            objeto persistente
	 */
	public void eliminarProducto(Producto producto) {

		daoGenerico.eliminarObjeto(producto);

	}

	/**
	 * Elimina un producto de la base de datos
	 * 
	 * @param idProducto
	 *            identificador del producto
	 */
	public void eliminarProducto(Long idProducto) {
		Producto producto = daoGenerico.buscarPorId(Producto.class, idProducto
				.toString());
		if (producto != null)
			eliminarProducto(producto);

	}

	/**
	 * Modifica un producto
	 * 
	 * @param idProducto
	 *            identificador del producto
	 * @param dto
	 *            objeto de negocio que actua como contenedor de datos
	 */
	public void modificarProducto(Long idProducto, Producto dto) {
		bmGenerico.modificarObjeto(dto, idProducto);
	}

	/**
	 * Devuelve todos los objetos de una determinada categoria
	 * 
	 * @param categoria
	 * @return
	 */
	public List<Producto> listarProductoCategoria(Categoria categoria) {
		List<Producto> productos = null;
		Class clase = null;

		if (categoria.equals(Categoria.DVD))
			clase = Dvd.class;
		else if (categoria.equals(Categoria.PEQUENIO_ELECTRODOMESTICO))
			clase = PequenoElectrodomestico.class;
		else if (categoria.equals(Categoria.TELEVISOR))
			clase = Televisor.class;
		else if (categoria.equals(Categoria.FRIGORIFICO))
			clase = Frigorifico.class;
		else if (categoria.equals(Categoria.LAVADORA))
			clase = Lavadora.class;

		productos = daoGenerico.obtenerTodos(clase);

		return productos;
	}

	/**
	 * Devuelve los diez productos que actualmente han consechado mas o menos beneficios en funcion del parametro "menosMas"
	 * 
	 * @param menosMas
	 * @return la lista con los diez productos que actualmente han cosechado menos beneficios ordenados desde el que menos beneficios ha obtenido hasta el que mas si
	 * el parametro "menosMas" tiene el valor "false" y la lista con los diez productos que actualmente han cosechado mas beneficios ordenados desde el que mas beneficio
	 * ha obtenido hasta el que menos si el parametro "menosMas" tiene el valor true 
	 */
	public List<Producto> getDiezProductosBeneficios(boolean menosMas) {
		Producto p;
		List<Producto> res = new ArrayList<Producto>();
		List<Beneficio> listaBeneficios;
		DaoGenerico d = new DaoGenerico();
		ListIterator li;
		Long idProducto;
		int i = 0;

		listaBeneficios = d.obtenerTodos(Beneficio.class);
		
		listaBeneficios = ordenarLista(listaBeneficios, menosMas);
		
		li = listaBeneficios.listIterator();
		while ((li.hasNext()) && (i < 10)) {
			idProducto = ((Beneficio) li.next()).getId();
			p = d.buscarPorId(Producto.class, idProducto);
			if (d.buscarPorId(Deprecated.class, idProducto) == null) {
				res.add(p);
				i++;
			}
		}

		return (res);
	}

	/**
	 * Ordena una lista de objetos persistentes "Beneficio" ordenados de mayor a menor o de menor a mayor en cuanto al valor de su atributo "beneficio" en funcion del
	 * parametro descendentementeAscendentemente
	 * @param listaBeneficios
	 * @param descendentementeAscendentemente
	 * @return la lista de entrada ordenada de forma descendente por el valor del atributo "beneficio" de cada objeto "Beneficio" si el parametro
	 * "descendentementeAscendentemente" tiene el valor "false" y ordenada ascendentemente e.c.c. 
	 */
	@SuppressWarnings("unchecked")
	private List<Beneficio> ordenarLista(List<Beneficio> listaBeneficios,
			boolean descendentementeAscendentemente) {
		List res = new ArrayList<Beneficio>();
		Object [] b;
		
		b = listaBeneficios.toArray();
		Arrays.sort(b);
		if (!(descendentementeAscendentemente)) { // Queremos obtener la lista de los productos que han generado menos beneficios ordenados del que menos beneficios ha
			// generado al que más.
			for (int i = (b.length - 1); i >= 0; i--) {
				res.add(b[i]);
			}
		} else { // Queremos obtener la lista de los productos que han generado mas beneficios ordenados del que mas beneficios ha obtenido al que menos.
			res = Arrays.asList(b);
		}
		
		return res;
	}
}