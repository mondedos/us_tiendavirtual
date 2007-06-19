package mfis.tiendavirtual.struts.actions;

import java.rmi.RemoteException;
import java.util.ArrayList;

import mfis.tiendavirtual.interfaces.GestionOferta;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.OfertaEJB;
import mfis.tiendavirtual.modelo.objetoNegocio.Oferta;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;

import struts.MyTilesAction;
import struts.WebContext;


/**
* @author DVF
*
*/

// En este caso no podemos usar XDoclets porque nuestras acciones hereadan
// de MyTilesAction y no de Action. En su lugar, las acciones se mapean en el fichero
// src/main/assembly/struts-actions.xml
public class StartAction extends MyTilesAction {

    public StartAction() {
    }

    public String execute(WebContext c) {

    	//Obtenemos los diez productos mas beneficiosos

    	//TODO ARREGLAR EL METODO GET10PRODUCTOSMASBENEFICISOS

//    	GestionProducto gp = (GestionProducto) new ProductoEJB().getEJB(EJB.PRODUCTOS_JNDI);
//
//    	List productos= null;
//
//    	try{
//    		productos= gp.get10ProductosMasBeneficiosos();
//    	}catch(RemoteException e){
//    		throw new RuntimeException(e);
//    	}
//
//    	c.setRequest("lista", productos);

    	//obtenemos la oferta
    	obtenerOfertas(c);

        return MAINPAGE;
    }
    
    
    public static void obtenerOfertas(WebContext c){
    	GestionOferta go = (GestionOferta) new OfertaEJB().getEJB(EJB.OFERTAS_JNDI);
    	Producto prA = null;
    	Producto prB = null;
    	try {
			Oferta o = go.getOferta();
			prA = o.getPrincipal();
			prB = o.getSecundario();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}

		float precioFinal = 0.0f;

		precioFinal = (prA.getPrecio().floatValue() + prB.getPrecio().floatValue());

		//aplicamos el descuento del 10%
		precioFinal -= (precioFinal * 0.10f);

		String tmp = "" + precioFinal;

		c.setRequest("prA", prA);
		c.setRequest("prB", prB);
		c.setRequest("precioFinal", tmp.substring(0, (tmp.indexOf(".")+ 3) ));
    	c.setRequest("lista", new ArrayList());
    	
    }

}
