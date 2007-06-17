package mfis.tiendavirtual.struts.actions;

import java.rmi.RemoteException;
import java.util.List;

import mfis.tiendavirtual.interfaces.GestionProducto;
import mfis.tiendavirtual.modelo.dao.Categoria;
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

	public final static String[] cats = {
		"app.categoria.0",
		"app.categoria.1",
		"app.categoria.2",
		"app.categoria.3",
		"app.categoria.4"
	};
	public final static String[] imgPath = {
		"Televisores",
		"Lavadoras",
		"DVD",
		"Frigorificos",
		"PequenosElectrodomesticos"
	};


	public static Categoria obtenerCategoria(int idCategoria){
		Categoria categoria= null;

		switch(idCategoria){
    		case 0: categoria= Categoria.TELEVISOR; break;
    		case 1: categoria= Categoria.LAVADORA; break;
    		case 2: categoria= Categoria.DVD; break;
    		case 3: categoria= Categoria.FRIGORIFICO; break;
    		case 4: categoria= Categoria.PEQUENIO_ELECTRODOMESTICO; break;
		}

		return categoria;

	}

    public CategoriaAction() {
    }

    public String execute(WebContext c) {

    	String layout = MENUPAGE;
    	int idcategoria = Integer.parseInt( c.getParameter("idcat") );
    	List listadoCategorias = null;

    	GestionProducto gp = (GestionProducto) new ProductoEJB().getEJB(EJB.PRODUCTOS_JNDI);

    	try {
    		listadoCategorias = gp.listarProductosCategoria( obtenerCategoria(idcategoria) );
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
/*
    	listadoCategorias = new ArrayList();
    	Producto p = new Producto();
    	p.setDimensiones("120x123");
    	p.setMarca("marca");
    	p.setModelo("modelo");
    	listadoCategorias.add(p);

    	*/
		c.setRequest("idcat", idcategoria + "");
		c.setRequest("lista", listadoCategorias);
		c.setRequest("titulo", bundle.getString(cats[idcategoria]));
		c.setRequest("urlImg", bundle.getString("app.imgpath") + imgPath[idcategoria]);

		if(c.getSession("operador") != null) {
			layout = OPERADOR;
		}

        return layout;
    }

}
