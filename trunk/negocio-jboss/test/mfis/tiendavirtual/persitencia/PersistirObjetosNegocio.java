package mfis.tiendavirtual.persitencia;

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
	
	public static void eliminarObjetosNegocio(List objPersist){
		
		Session sesion = HibernateSessionFactory.crearSesion();
		Transaction tx = sesion.beginTransaction();
		for(Object objpersist: objPersist)
			sesion.delete(objpersist);
		
		tx.commit();
		sesion.close();
	}
	
	public static  List<Beneficio> insertarBeneficios(
			List<Producto> productoPersist, float[] precioProducto,
			float[] gananciaProducto, float[] beneficioAcumulado){
		
		Beneficio beneficio;
		DaoGenerico daoGenerico = new DaoGenerico();
		List<Beneficio> beneficioProducto = new LinkedList<Beneficio>();
		int i =0;
		for(Producto producto: productoPersist){
		
			beneficio = new Beneficio();
			beneficio.setId(producto.getId());
			beneficio.setGanancia(beneficioAcumulado[i]);
			
			producto.setGanancia(gananciaProducto[i]);
			producto.setPrecio(precioProducto[i]);
			
			daoGenerico.persistirObjeto(beneficio);
			
			beneficioProducto.add(beneficio);
			i++;
		}
			
		return beneficioProducto;
	}
}
