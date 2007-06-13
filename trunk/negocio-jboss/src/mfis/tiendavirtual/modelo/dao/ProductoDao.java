package mfis.tiendavirtual.modelo.dao;

import java.util.List;

import mfis.tiendavirtual.modelo.objetoNegocio.Dvd;
import mfis.tiendavirtual.modelo.objetoNegocio.Frigorifico;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;
import mfis.tiendavirtual.modelo.objetoNegocio.PequenoElectrodomestico;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.modelo.objetoNegocio.Televisor;

/**
 * Dao para el manejo de los productos
 * 
 * @author Edgar
 *
 */
public class ProductoDao {
	
	private DaoGenerico daoGenerico;
	private BMGenerico bmGenerico;
	
	public ProductoDao(){
		daoGenerico= new DaoGenerico();
		bmGenerico= new BMGenerico();
	}

	
	/**
	 * Metodo para obtener un producto a partir de su identificador, en caso de que no exista se devolvera null
	 * @param id
	 * @return
	 */
	public Producto obtenerProductoPorId(Long identificador){
		
		return daoGenerico.buscarPorId(Producto.class, identificador.toString());
		
	}
	
	
	/**
	 * M�todo para agrear un nuevo producto a la base de datos
	 * @param producto
	 * @return identificador del producto creado
	 */
	public  Long agregarProducto(Producto producto){
		return daoGenerico.persistirObjeto(producto);
		
	}
	
	/**
	 * Elimina un producto de la base de datos
	 * @param producto objeto persistente
	 */
	public  void eliminarProducto(Producto producto){
		
		daoGenerico.eliminarObjeto(producto);
		
	}
	
	/**
	 * Elimina un producto de la base de datos
	 * @param idProducto identificador del producto
	 */
	public  void eliminarProducto(Long idProducto){
		Producto producto= daoGenerico.buscarPorId(Producto.class, idProducto.toString());
		if(producto!=null) eliminarProducto(producto);
		
	}
	
	/**
	 * Modifica un producto
	 * @param idProducto identificador del producto
	 * @param dto objeto de negocio que actua como contenedor de datos
	 */
	public void modificarProducto(Long idProducto, Producto dto){
		
		bmGenerico.modificarObjeto(dto, idProducto);
	}
	
	
	
	/**
	 * Devuelve todos los objetos de una determinada categoria
	 * @param categoria
	 * @return
	 */
	public List<Producto> listarProductoCategoria(String categoria){
		List<Producto> productos= null;
		Class clase= null;
		
		if(categoria.matches("DVD")) clase= Dvd.class;
		else if(categoria.matches("Peque�os electrodomesticos")) clase= PequenoElectrodomestico.class;
		else if(categoria.matches("Televisores")) clase= Televisor.class;
		else if(categoria.equals("Frigorificos")) clase= Frigorifico.class;
		else if(categoria.equals("Lavadoras")) clase= Lavadora.class;
		
		productos= daoGenerico.obtenerTodos(clase);
		
		return productos;
	}
}