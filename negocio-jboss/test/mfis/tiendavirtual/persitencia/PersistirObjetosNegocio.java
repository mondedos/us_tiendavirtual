package mfis.tiendavirtual.persitencia;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mfis.tiendavirtual.modelo.dao.Categoria;
import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.objetoNegocio.Beneficio;
import mfis.tiendavirtual.modelo.objetoNegocio.Dvd;
import mfis.tiendavirtual.modelo.objetoNegocio.Frigorifico;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;
import mfis.tiendavirtual.modelo.objetoNegocio.PequenoElectrodomestico;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.modelo.objetoNegocio.Televisor;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class PersistirObjetosNegocio {

	/**
	 * 
	 * @param categoria
	 * @param numProductos
	 * @return
	 */
	public static List<Producto> insertarProductos(Categoria categoria,
			int numProductos){
		List <Producto> productos = new LinkedList<Producto>();
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		
		for(int i =0; i < numProductos; i++){
			if(categoria.equals(Categoria.LAVADORA)){
				Lavadora lavadora = 
					CreateObjetosNegocio.getInstance().createLavadora();
				
				sesion.save(lavadora);
				productos.add(lavadora);
			}
			else if(categoria.equals(Categoria.FRIGORIFICO)){
				Frigorifico frigorifico =
					CreateObjetosNegocio.getInstance().createFrigorifico();
					
				sesion.save(frigorifico);
				productos.add(frigorifico);
			}
			else if(categoria.equals(Categoria.DVD)){
				Dvd dvd = CreateObjetosNegocio.getInstance().createDvd();
				
				sesion.save(dvd);
				productos.add(dvd);
			}
			else if(categoria.equals(Categoria.TELEVISOR)){
				Televisor televisor = 
					CreateObjetosNegocio.getInstance().createTelevisor();
				
				sesion.save(televisor);
				productos.add(televisor);
			}
			else if(categoria.equals(Categoria.PEQUENIO_ELECTRODOMESTICO)){
				PequenoElectrodomestico pE = 
					CreateObjetosNegocio.getInstance().createPequenoElectrodomestico();
				
				sesion.save(pE);
				productos.add(pE);
			}
			else
				throw new IllegalArgumentException("Categoria no valida");
		}
		
		tx.commit();
		sesion.close();
		
		return productos;
	}
	
	/**
	 * 
	 * @param objPersist
	 */
	public static void eliminarObjetosNegocio(List objPersist){
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		
		Iterator it = objPersist.iterator();
		while(it.hasNext()){
			sesion.delete(it.next());
		}
		
		tx.commit();
		sesion.close();
	}
	
	/**
	 * 
	 * @param beneficioAcumulado
	 * @param idProd
	 */
	private static Beneficio insertaBeneficio(float beneficioAcumulado,
			long idProd){
		Beneficio beneficio = new Beneficio();
		beneficio.setGanancia(beneficioAcumulado);
		beneficio.setId(idProd);
		
		DaoGenerico daoGenerico = new DaoGenerico();
		daoGenerico.persistirObjeto(beneficio);
		
		return beneficio;
	}
	
	/**
	 * 
	 * @param productos
	 * @param beneficioAcumulado
	 * @param precioProducto
	 * @param gananciaProducto
	 * @return
	 */
	public static List<Beneficio> insertarBeneficios(
			List<Producto> productos, float[] beneficioAcumulado,
			float[] precioProducto,	float[] gananciaProducto){
		
		List<Beneficio> beneficios = new LinkedList<Beneficio>();
		DaoGenerico daoGenerico = new DaoGenerico();
		int i = 0;
		
		for(Producto producto: productos){
			beneficios.add(PersistirObjetosNegocio.insertaBeneficio(
					beneficioAcumulado[i],
					producto.getId()));
			
			producto.setGanancia(gananciaProducto[i]);
			producto.setPrecio(precioProducto[i]);
			daoGenerico.modificarObjeto(producto);
			i++;
		}
		
		return beneficios;
	}
}
