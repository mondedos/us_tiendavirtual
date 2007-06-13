package mfis.tiendavirtual.struts.actions;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import mfis.tiendavirtual.interfaces.GestionOferta;
import mfis.tiendavirtual.interfaces.GestionProducto;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.OfertaEJB;
import mfis.tiendavirtual.jndi.ProductoEJB;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
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

/*
    	//TODO en pruebas
    	try {
    		listadoCategorias = gp.listarProductosCategoria(cats[idcategoria]);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
    	listadoCategorias = new ArrayList();
    	Producto p = new Producto();
    	p.setDimensiones("120x123");
    	p.setMarca("marca");
    	p.setModelo("modelo");
    	listadoCategorias.add(p);
		c.setRequest("lista", listadoCategorias);
		c.setRequest("titulo", "Listado de " +cats[idcategoria]);

        return ".menuLayout";
    }

}
