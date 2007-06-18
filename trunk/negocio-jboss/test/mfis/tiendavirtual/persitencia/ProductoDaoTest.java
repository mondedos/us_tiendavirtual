package mfis.tiendavirtual.persitencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mfis.tiendavirtual.modelo.dao.Categoria;
import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.dao.ProductoDao;
import mfis.tiendavirtual.modelo.objetoNegocio.Beneficio;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductoDaoTest {
	
	private ProductoDao productoDao;
	private final int numProductos = 5;
	
	@BeforeClass
	public void inicializar(){
		
		this.productoDao = new ProductoDao();
	}
	
	//@Test
	public void agregarProducto_eliminarProductoTest(){
		
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
	
	//@Test
	public void listarProductosPorCategoriaTest(){
		
// 		Persistimos cinco lavadoras
		List <Producto> lavadoraPersit = 
			PersistirObjetosNegocio.insertarProductos(Categoria.LAVADORA,
					this.numProductos);
		
//		 Persistimos cinco televisores
		List <Producto>  televisorPersist = 
			PersistirObjetosNegocio.insertarProductos(Categoria.TELEVISOR,
					this.numProductos);
		
//		 Persistimos cinco dvd
		List <Producto>  dvdPersit = 
			PersistirObjetosNegocio.insertarProductos(Categoria.DVD,
					this.numProductos);
		
//		 Persistimos cinco frigorificos
		List <Producto>  frigorificosPersit = 
			PersistirObjetosNegocio.insertarProductos(Categoria.FRIGORIFICO,
					this.numProductos);
		
//		 Persistimos cinco frigorificos
		List <Producto>  pEPersit = 
			PersistirObjetosNegocio.insertarProductos(
					Categoria.PEQUENIO_ELECTRODOMESTICO, this.numProductos);
		
		
		
//		Obtenemos las lavadoras persistidas.
		List <Producto> lavadorasListadas = 
			this.productoDao.listarProductoCategoria(Categoria.LAVADORA);
		assert(lavadorasListadas.size() == this.numProductos);
		assert(lavadorasListadas.containsAll(lavadoraPersit));
		

//		Obtenemos los televisores persistidos.
		List <Producto> televisorListados = 
			this.productoDao.listarProductoCategoria(Categoria.TELEVISOR);
		assert(televisorListados.size() == this.numProductos);
		assert(televisorListados.containsAll(televisorPersist));
		
//		Obtenemos los dvd persistidos.
		List <Producto> dvdListados = 
			this.productoDao.listarProductoCategoria(Categoria.DVD);
		assert(dvdListados.size() == this.numProductos);
		assert(dvdListados.containsAll(dvdPersit));
		
//		Obtenemos los frigorificos persistidos.
		List <Producto> frigorificoListados = 
			this.productoDao.listarProductoCategoria(Categoria.FRIGORIFICO);
		assert(frigorificoListados.size() == this.numProductos);
		assert(frigorificoListados.containsAll(frigorificosPersit));
		
//		Obtenemos los pequeños electrodomesticos persistidos.
		List <Producto> pEListados = 
			this.productoDao.listarProductoCategoria(
					Categoria.PEQUENIO_ELECTRODOMESTICO);
		assert(pEListados.size() == this.numProductos);
		assert(pEListados.containsAll(pEPersit));
		
		// Eliminamos los objetos persistidos.
		PersistirObjetosNegocio.eliminarObjetosNegocio(lavadoraPersit);
		PersistirObjetosNegocio.eliminarObjetosNegocio(televisorPersist);
		PersistirObjetosNegocio.eliminarObjetosNegocio(dvdPersit);
		PersistirObjetosNegocio.eliminarObjetosNegocio(frigorificosPersit);
		PersistirObjetosNegocio.eliminarObjetosNegocio(pEPersit);
	}
	
	@Test
	public void getDiezProductosBeneficiosTest() throws Exception{
		
		// Insertamos 5 frigorificos.
		float[] beneficioAcumulado=
		{100,200,300,400,500,1000, 700, 800, 300, 1000,0,60, 400, 500, 0};
		
		float[] precioProducto = 
		{600,500,200,800,900,200,700,200,1000,1500, 500, 700, 350, 120, 450};
		
		float[] gananciaProducto = 
		{25,50,20,10,40, 40, 15, 40, 50, 30, 10, 21, 34, 56, 20};
		
		
		List<Float[]> beneficioProductos = calcularBeneficio(
				beneficioAcumulado, precioProducto, gananciaProducto);
		
		List<Producto> frigorificoPersist = 
			PersistirObjetosNegocio.insertarProductos(Categoria.FRIGORIFICO, 15);
		assert(frigorificoPersist.size()==15);
			
		List<Beneficio> beneficios =
		PersistirObjetosNegocio.insertarBeneficios(frigorificoPersist,
					precioProducto,	gananciaProducto, beneficioAcumulado);
		assert(beneficios.size() == 15);
			
		try{
			List<Producto> masBeneficios =
				this.productoDao.getDiezProductosBeneficios(true);
			System.err.print(masBeneficios.size());
			assert(masBeneficios.size() == 10);
			
			this.comprobarProductos(masBeneficios,beneficioProductos, true,
					frigorificoPersist);
			
			List<Producto> menosBenefios =
				this.productoDao.getDiezProductosBeneficios(false);
			assert(menosBenefios.size() == 10);
			this.comprobarProductos(masBeneficios,beneficioProductos, false,
					frigorificoPersist);
		}
		catch(Exception e){
			throw new  Exception(e.getLocalizedMessage().toString());
		}
		finally{
			PersistirObjetosNegocio.eliminarObjetosNegocio(beneficios);
			PersistirObjetosNegocio.eliminarObjetosNegocio(frigorificoPersist);
		}
	}
	
	private List<Float[]> calcularBeneficio(float[] beneficioAcumulado, 
			float[] precioProducto, float[] gananciaProducto){
	
		List<Float> nuevoBeneficio = new LinkedList<Float>();
		for(int i =0; i < beneficioAcumulado.length; i++){
			nuevoBeneficio.add(beneficioAcumulado[i]+
			(precioProducto[i]*gananciaProducto[i])/100);
		}
		
		List<Float[]> parBebefAcuPos = new LinkedList<Float[]>();
		
		int posMayor;
		Float[] par;
		while(!nuevoBeneficio.isEmpty()){
			
			posMayor = this.posMayor(nuevoBeneficio);
			
			par = new Float[2]; 
			par[0] = (float)posMayor;
			par[1] = nuevoBeneficio.get(posMayor);
			nuevoBeneficio.remove(posMayor);
				
			parBebefAcuPos.add(par);
		}
		
		
		return parBebefAcuPos;
	}
	
	private int posMayor(List<Float>nuevoBeneficio){
		
		int posMayor = 0;
		int posActual = 0;
		float mayorBene = Float.MIN_VALUE;
		
		for(float b: nuevoBeneficio){
			
			if(b > mayorBene){
				
				posMayor = posActual;
				mayorBene = b;
			}
		}
		
		
		return posMayor;
	}
	
	/**
	 * 
	 * @param masBeneficios
	 * @param beneficioProductos
	 * @param masMenos
	 */
	private void comprobarProductos(List<Producto> masBeneficios,
			List<Float[]> beneficioProductos, boolean masMenos,
			List<Producto> productosPersist){
		System.err.print("HOLA HOLA ");
		
		int i;
		Float[] par;
		int pos;
		if(masMenos){
		
			i = 0;
			while(i <= 9 && i < beneficioProductos.size()){
					
				par = beneficioProductos.get(i);
				pos = par[0].intValue();
				assert(masBeneficios.contains(productosPersist.get(pos)));
				i++;
			}
		}
		else{
			i = 9;
			while(i >= 0 && i < beneficioProductos.size()){
				
				par = beneficioProductos.get(i);
				pos = par[0].intValue();
				assert(masBeneficios.contains(productosPersist.get(pos)));
				i--;
			}	
		}
	}
}