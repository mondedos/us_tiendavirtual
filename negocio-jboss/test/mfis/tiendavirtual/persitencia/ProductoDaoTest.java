package mfis.tiendavirtual.persitencia;

import java.util.ArrayList;
import java.util.List;
import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.dao.ProductoDao;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductoDaoTest {
	
	private ProductoDao productoDao;
	
	@BeforeClass
	public void inicializar(){
		
		this.productoDao = new ProductoDao();
	}
	
	@Test
	public void pruebaEliminarAgregarProducto(){
		
		//creamos diez productos para luego eliminarlo
	
		List<Long> listaProductos= new ArrayList<Long>(10);
		for(int i=0; i<10; i++){
			Producto producto= new Producto();
			Long id= productoDao.agregarProducto(producto);
			listaProductos.add(id);
		}
		
		Session sesion= HibernateSessionFactory.crearSesion();
		Transaction tx= sesion.beginTransaction();
		
		for(Long id: listaProductos){
			Producto producto= (Producto)sesion.load(Producto.class, id);
			try{
				producto.getId();
			}catch(ObjectNotFoundException e){
				assert false : "el producto "+id+" no ha sido creado";
			}
			
		}
		tx.commit();
		sesion.close();
		
		for(Long id: listaProductos)
			productoDao.eliminarProducto(id);
		
		sesion= HibernateSessionFactory.crearSesion();
		tx= sesion.beginTransaction();
		
		for(Long id: listaProductos){
			Producto producto= (Producto)sesion.get(Producto.class, id);
			try{
				producto.getId();
				assert false : "el producto "+id+" no ha sido borrado";
			}catch(NullPointerException e){
				//el producto ha sido borrado
			}
		}
		
		tx.commit();
		sesion.close();
	}
}