package mfis.tiendavirtual.struts.beans;

import java.rmi.RemoteException;
import java.util.List;

import mfis.tiendavirtual.interfaces.GestionProducto;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.ProductoEJB;
import mfis.tiendavirtual.modelo.dao.Categoria;

public class ProductosBean {
	
	private static GestionProducto gp;
	
	static{
		gp = (GestionProducto) new ProductoEJB().getEJB(EJB.PRODUCTOS_JNDI);
	}
	
	public static List listarProductosBusqueda(Float min, Float max, Categoria categoria, List palabrasClave){
		
		List resultado= null;
		try{
			resultado= gp.listarProductosBusqueda(min, max, categoria, palabrasClave);
		}catch(RemoteException e){
			throw new RuntimeException(e);
		}
		
		return resultado;
		
	}

}
