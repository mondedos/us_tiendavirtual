package mfis.tiendavirtual.struts.beans;

import java.rmi.RemoteException;
import java.util.List;

import mfis.tiendavirtual.interfaces.GestionOferta;
import mfis.tiendavirtual.interfaces.GestionProducto;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.OfertaEJB;
import mfis.tiendavirtual.jndi.ProductoEJB;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

public class OperadoresBean {



	public OperadoresBean() {

	}

	public static List obtenerProductosMasBeneficiosos(){
		GestionProducto gp = (GestionProducto) new ProductoEJB().getEJB(EJB.PRODUCTOS_JNDI);

		List productos = null;
		try{
			productos= gp.get10ProductosMasBeneficiosos();
		} catch (RemoteException e){
			throw new RuntimeException(e);
		}

		return productos;

	}

	public static List obtenerProductosMenosBeneficiosos(){
		GestionProducto gp = (GestionProducto) new ProductoEJB().getEJB(EJB.PRODUCTOS_JNDI);

		List productos = null;
		try{
			productos= gp.get10ProductosMenosBeneficiosos();
		} catch (RemoteException e){
			throw new RuntimeException(e);
		}
		return productos;
	}

	public static void crearOferta(int idProdA, int idProdB){
		GestionProducto gp = (GestionProducto) new ProductoEJB().getEJB(EJB.PRODUCTOS_JNDI);
		GestionOferta 	go = (GestionOferta) new OfertaEJB().getEJB(EJB.OFERTAS_JNDI);

		try {
			Producto prodA = (Producto) gp.getProducto(idProdA);
			Producto prodB = (Producto) gp.getProducto(idProdB);
			go.nuevaOferta(prodA, prodB);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
