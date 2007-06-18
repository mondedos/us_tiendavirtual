package mfis.tiendavirtual.struts.actions;

import java.util.ArrayList;

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

    	c.setRequest("lista", new ArrayList());

        return MAINPAGE;
    }

}
