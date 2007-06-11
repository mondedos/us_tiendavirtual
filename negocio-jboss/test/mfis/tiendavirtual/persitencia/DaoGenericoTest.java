package mfis.tiendavirtual.persitencia;


import java.util.List;

import org.hibernate.ObjectNotFoundException;

import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.dao.HibernateSessionFactory;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;

import org.hibernate.Session;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class DaoGenericoTest {

	private DaoGenerico daoGenerico;

	@BeforeClass
	public void inicializar(){
		daoGenerico= new DaoGenerico();
	}
	
	
	@Test
	public void pruebaObtenerTodos(){
		
		List<Lavadora> l= daoGenerico.obtenerTodos(Lavadora.class);
		assert l.size()==5 : "El numero de elementos es incorrecto";
		
		for(Lavadora lavadora : l){
			try{
				lavadora.getId();
			}catch(Exception e){
				assert false : "No se ha podido acceder a la propiedad id";
			}
			
		}
	}
	
	@Test
	public void pruebaCrearEliminarObjeto(){
		
		//creacion del objeto
		Lavadora lavadora= new Lavadora();
		lavadora.setDescripcion("descripcion lavadora");
		lavadora.setSecadora(false);
		
		Long o= daoGenerico.persistirObjeto(lavadora);
		
		Session sesion= HibernateSessionFactory.crearSesion();
		Lavadora prueba= (Lavadora)sesion.load(Lavadora.class, o);
		
		assert prueba.getDescripcion().equals("descripcion lavadora") : "La descripcion es incorrecta";
		
		sesion.close();
		
		//eliminacion del objeto
		
		daoGenerico.eliminarObjeto(lavadora);
		
		sesion= HibernateSessionFactory.crearSesion();
		prueba= (Lavadora)sesion.load(Lavadora.class, o);
		
		try{
			prueba.getDescripcion();
			assert false : "El objeto aun existe en la base de datos, no ha sido borrado";
		}catch(Exception e){
			if(!(e instanceof ObjectNotFoundException)){
				//se ha elevado una excepcion incorrecta
				throw new RuntimeException(e);
			}
			
			//correcto el objeto no ha sido encontrado en la base de datos
		}
		
		
		sesion.close();
		
	}
	
	
	@Test
	public void pruebaEncontrarPorId(){
		
		Lavadora lavadora= daoGenerico.buscarPorId(Lavadora.class, "2");
		
		assert lavadora!=null : "El resultado no puede ser null";
		
		try{
			Long id= lavadora.getId();
			assert id.equals(new Long(2));
		}catch(Exception e){
			assert false : "no ha sido posible acceder a la propiedad id de la lavadora";
		}
		
	}
	
	@Test
	public void pruebaEncontrarPorIdNegativo(){

		//prueba con un id que no sea numerico
		Lavadora lavadora= daoGenerico.buscarPorId(Lavadora.class, "id errorneo");
		assert lavadora==null : "La lavadora deberia ser nula";
		
		//prueba con un id que no exista en la base de datos
		lavadora= daoGenerico.buscarPorId(Lavadora.class, "1");
		assert lavadora==null : "La lavadora deberia ser nula";
		
	}

	@Test
	public void pruebaModificarObjeto(){
		
		Lavadora lavadora= new Lavadora();
		lavadora.setDescripcion("descripcion inicial");
		lavadora.setSecadora(false);
		
		Long id= daoGenerico.persistirObjeto(lavadora);
		
		Lavadora lavadoraDos= daoGenerico.buscarPorId(Lavadora.class, id.toString());;
		lavadoraDos.setDescripcion("descripcion actualizada");
		daoGenerico.modificarObjeto(lavadoraDos);
		
		Lavadora lavadoraTres= daoGenerico.buscarPorId(Lavadora.class, id);
		
		assert lavadoraTres.getDescripcion().equals("descripcion actualizada") : "La descripcion es incorrecta";
		
		daoGenerico.eliminarObjeto(lavadoraTres);
		
	}
	


}
