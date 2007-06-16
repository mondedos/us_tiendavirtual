package mfis.tiendavirtual.persitencia;

import java.util.List;

import mfis.tiendavirtual.modelo.dao.BMGenerico;
import mfis.tiendavirtual.modelo.dao.DaoGenerico;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

import org.hibernate.Criteria;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BMGenericoTest {
	
	private BMGenerico bmGenerico;
	private DaoGenerico daoGenerico;
	
	@BeforeClass
	public void inicializar(){
		bmGenerico= new BMGenerico();
		daoGenerico= new DaoGenerico();
	}
	
	@Test
	public void modificarObjeto(){
		
		
		//creamos un objeto en la base de datos
		Producto producto= new Producto();
		producto.setDescripcion("descripcion inicial");
		producto.setDimensiones("dimensiones inicial");
		producto.setFoto("foto inicial");
		
		Long id= daoGenerico.persistirObjeto(producto);
		
		
		//realizamos una modificacion utilizando un dto
		//modificamos solo la descripcion y las dimensiones
		Producto dto= new Producto();
		dto.setDescripcion("descripcion actualizada");
		dto.setDimensiones("dimensiones actualizada");
		
		bmGenerico.modificarObjeto(dto, id);
		
		
		//recuperamos de la base de datos y observamos si el objeto sigue estando en el mismo estado
		Producto pRecuperado= daoGenerico.buscarPorId(Producto.class, id);
	
		assert pRecuperado.getDescripcion().equals("descripcion actualizada") : "La descripcion es incorrecta";
		assert pRecuperado.getDimensiones().equals("dimensiones actualizada") : "Las dimensiones son incorrectas";
		assert pRecuperado.getFoto().equals("foto inicial") : "La foto es incorrecta";
		
		
		//eliminamos el objeto creado en la base de datos
		daoGenerico.eliminarObjeto(pRecuperado);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void busquedaUno(){
		
		//realizamos una busqueda de todos los productos de marca FAGOR
		
		Producto dto= new Producto();
		dto.setMarca("Fagor");
		
		Criteria c= bmGenerico.realizarBusqueda(dto);
		
		List<Producto> l= c.list();
		
		assert l.size()==4 : "El resultado es incorrecto";
		for(Producto p: l)
			assert p.getMarca().equals("Fagor") : "El resultado es incorrecto";
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void busquedaDos(){
		//realizamos una busqueda de todos los productos por marca Fagor y por id
		//solo deberia devolvernos un elemento
		
		Producto dto= new Producto();
		dto.setMarca("Fagor");
		dto.setId(new Long(2));
		
		Criteria c= bmGenerico.realizarBusqueda(dto);
		
		List<Producto> l= c.list();
		assert l.size()==1 : "El resultado es incorrecto";
		assert l.get(0).getMarca().equals("Fagor") : "El resultado es incorrecto";
		assert l.get(0).getId().equals(new Long(2)) : "El resultaod es incorrecto";
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void busquedaTres(){
		
		//vamos a realizar una busqueda por marca, pero ademas que las dimensiones sean de una determinada forma
		
		Producto dto= new Producto();
		dto.setMarca("Fagor");
		
		Criteria c= bmGenerico.realizarBusqueda(dto);
		
		bmGenerico.agregarCadena(c, "dimensiones", "Alto 185");
		
		List<Producto>l= c.list();
		assert l.size()==1 : "El resultado es incorrecto";
		assert l.get(0).getMarca().equals("Fagor") : "El resultado es incorrecto";
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void busquedaOr(){
		
		//Realizamos una busqueda donde decimos que la marca sea Fagor o que el id sea 1
		//nos devolvera 5 elementos uno de ellos de marca sony
		
		Producto dto= new Producto();
		dto.setMarca("Fagor");
		dto.setId(new Long(1));
		
		Criteria c= bmGenerico.realizarBusqueda(dto, false);
		
		List<Producto> l= c.list();
		assert l.size()==5 : "El resultado es incorrecto";
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void buscarRango(){
		
		//buscamos todos los productos que se encuentren dentro de un determinado rango
		
		Float menor= new Float(20);
		Float mayor= new Float(100);
		
		Criteria c= bmGenerico.crearCriteriaVacio(Producto.class);
		bmGenerico.agregarRango(c, "precio", menor, mayor);
		
		List<Producto> l= c.list();
		assert l.size()==6 : "El resultado es incorrecto";
		
		
		
	}
}
