package mfis.tiendavirtual.struts.actions;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import mfis.tiendavirtual.interfaces.GestionOferta;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.OfertaEJB;
import mfis.tiendavirtual.modelo.objetoNegocio.Oferta;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.util.Utilidades;

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
    	// Eliminamos el operador si existe.
    	c.removeSession("operador");
    	obtenerOfertas(c);
    	construyeMigas(c);

        return (MAINPAGE);
    }

    public static void construyeMigas(WebContext c) {
    	List l = new ArrayList();
    	l.add(new LabelValueBean("Inicio", ""));

    	c.setRequest("migas", l);
    }

    public static void obtenerOfertas(WebContext c){
    	GestionOferta go = (GestionOferta) new OfertaEJB().getEJB(EJB.OFERTAS_JNDI);
    	Producto prA = null;
    	Producto prB = null;
    	String auxiliar = null;
    	
    	try {
			Oferta o = go.getOferta();
			prA = o.getPrincipal();
			prB = o.getSecundario();
			auxiliar= o.obtenerPrecio().toString();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		} String precioFinal= Utilidades.obtenerPrecio(auxiliar);
		c.setRequest("prA", prA);
		c.setRequest("prB", prB);
		c.setRequest("precioFinal", precioFinal);
		c.setRequest("precioPrA", Utilidades.obtenerPrecio(prA.getPrecio().toString()));
		c.setRequest("precioPrB", Utilidades.obtenerPrecio(prB.getPrecio().toString()));
    	c.setRequest("lista", new ArrayList());
    }
}