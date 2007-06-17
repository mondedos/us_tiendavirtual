package mfis.tiendavirtual.ejb;

import java.util.ArrayList;
import java.util.List;

import mfis.tiendavirtual.modelo.dao.Categoria;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GestionProductoBeanTest {
	
	private GestionProductoBean gp;
	
	@BeforeClass
	public void inicializar(){
		gp= new GestionProductoBean();
	}
	
	
	
	@Test
	public void pruebaListarProductoCategoriaTodos(){
		
		//todos los atributos
		
		Float min=new Float(200);
		Float max=new Float(300);
		
		List<String> listaPalabras= new ArrayList<String>();
		listaPalabras.add("Sony");
		
		Categoria categoria= Categoria.TELEVISOR;
		
		List lista= gp.listarProductosBusqueda(min, max, categoria, listaPalabras);
		
		assert lista!=null && !lista.isEmpty() : "Error en la busqueda";
		assert lista.size()==1 : "Error en la busqueda";
		
		
	}
	
	@Test
	public void pruebaListarProductoCategoriaSinLimite(){
		
		Float min=new Float(200);
		Float max= null;
		
		List<String> listaPalabras= new ArrayList<String>();
		listaPalabras.add("Philips");
		
		Categoria categoria= Categoria.TELEVISOR;
		
		List lista= gp.listarProductosBusqueda(min, max, categoria, listaPalabras);
		
		assert lista!=null && !lista.isEmpty() : "Error en la busqueda";
		assert lista.size()==1 : "Error en la busqueda";
		
	}
	
	@Test
	public void pruebaListarProductoCategoriaSinLimites(){
		
		Float min=null;
		Float max= null;
		
		List<String> listaPalabras= new ArrayList<String>();
		listaPalabras.add("Philips");
		
		Categoria categoria= Categoria.TELEVISOR;
		
		List lista= gp.listarProductosBusqueda(min, max, categoria, listaPalabras);
		
		assert lista!=null && !lista.isEmpty() : "Error en la busqueda";
		assert lista.size()==2 : "Error en la busqueda";
		
	}
	
	
	@Test
	public void pruebaListarProductosCategoriaSoloCategoria(){
		
		Float min=null;
		Float max= null;
		
		List<String> listaPalabras= null;
		
		Categoria categoria= Categoria.TELEVISOR;
		
		List lista= gp.listarProductosBusqueda(min, max, categoria, listaPalabras);
		
		assert lista!=null && !lista.isEmpty() : "Error en la busqueda";
		assert lista.size()==5 : "Error en la busqueda";
		
		
	}
	
	
	

}
