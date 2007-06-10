package mfis.tiendavirtual.struts.actions;

import java.rmi.RemoteException;
import java.util.List;
import mfis.tiendavirtual.interfaces.GestionProducto;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.ProductoEJB;
import struts.MyTilesAction;
import struts.WebContext;

/**
 * @author DVF
 */

// En este caso no podemos usar XDoclets porque nuestras acciones hereadan
// de MyTilesAction y no de Action. En su lugar, las acciones se mapean en el fichero
// src/main/assembly/struts-actions.xml

// Esta clase no se usa de momento, esta de ejemplo
public class CategoriaAction extends MyTilesAction {

	private static String[] cats = {
		"Televisores",
		"Lavadoras",
		"Videos/DVD",
		"Frigoríficos",
		"Pequeños eletrodomésticos"
	};

    public CategoriaAction() {
    }

    public String execute(WebContext c) {

    	int idcategoria = Integer.parseInt( c.getParameter("categoria") );
    	List listadoCategorias = null;

    	GestionProducto gp = (GestionProducto) new ProductoEJB().getEJB(EJB.PRODUCTOS_JNDI);

    	//TODO en pruebas
    	try {
    		listadoCategorias = gp.get10ProductosMasBeneficiosos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		c.setRequest("lista", listadoCategorias);
		c.setRequest("titulo", "Listado de " +cats[idcategoria]);

        return ".listadoCategoriaLayout";
    }

}
