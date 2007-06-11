package mfis.tiendavirtual.modelo.dao;

import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

public class ProductoDao {
	
	private DaoGenerico daoGenerico;
	
	public ProductoDao(){
		daoGenerico= new DaoGenerico();
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
	 * Método para agrear un nuevo producto a la base de datos
	 * @param producto
	 * @return identificador del producto creado
	 */
	public Long agregarProducto(Producto producto){
		return daoGenerico.persistirObjeto(producto);
		
	}
	
	/**
	 * Elimina un producto de la base de datos
	 * @param producto objeto persistente
	 */
	public void eliminarProducto(Producto producto){
		
		daoGenerico.eliminarObjeto(producto);
		
	}
	
	/**
	 * Elimina un producto de la base de datos
	 * @param idProducto identificador del producto
	 */
	public void eliminarProducto(Long idProducto){
		Producto producto= daoGenerico.buscarPorId(Producto.class, idProducto.toString());
		if(producto!=null) eliminarProducto(producto);
		
	}
	
	

}
