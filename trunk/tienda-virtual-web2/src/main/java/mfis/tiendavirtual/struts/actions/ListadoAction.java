package mfis.tiendavirtual.struts.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.struts.actions.CategoriaAction;
import mfis.tiendavirtual.struts.beans.CarritoBean;
import mfis.tiendavirtual.struts.beans.OperadoresBean;
import struts.MyTilesAction;
import struts.WebContext;

/**
* @author DVF
*
*/

// En este caso no podemos usar XDoclets porque nuestras acciones hereadan
// de MyTilesAction y no de Action. En su lugar, las acciones se mapean en el fichero
// src/main/assembly/struts-actions.xml
public class ListadoAction extends MyTilesAction {

	private static String[] opciones = {
		"app.listado.0",
		"app.listado.1"
	};

    public ListadoAction() {
    }

    public String execute(WebContext c) {

    	String layout = MENUPAGE;

    	CarritoBean carritobean = null;

    	int opt = -1;
    	int idcat = Integer.parseInt(c.getParameter("idcat"));
    	int idpro = Integer.parseInt(c.getParameter("idpr"));

    	//se usa para borrar linea de pedido
    	String lid = c.getParameter("lid");

    	String nombrecat = bundle.getString(CategoriaAction.cats[idcat]);
    	try {
    		opt = Integer.parseInt(c.getParameter("opt"));
    	} catch (Exception e) {
    		for(int i = 0; i < opciones.length ; i++) {
    			if(bundle.getString(opciones[i]).startsWith(c.getParameter("opt").substring(0,6)))
    				opt = i;
    		}
		}

    	List listadoCategorias = null;
    	
    	Producto p = null;

    	switch (opt) {
    		// ver detalle
			case 0:
				p = OperadoresBean.getProducto(idpro);
				c.setRequest("producto", p);
				layout = PRODUCTO;

				break;
			// Añade al carrito.
			case 1:
		    	int unidades = Integer.parseInt(c.getParameter("unidades"));
				carritobean = new CarritoBean(c);

				Item i = OperadoresBean.getProducto(idpro);
				listadoCategorias= OperadoresBean.listarProductosCategoria(idcat);
				
				carritobean.crearLineaPedido(i, nombrecat, unidades);
				break;
			// Borra del carrito.
			case 2:
				carritobean = new CarritoBean(c);
				carritobean.borrarLineaPedido( Integer.parseInt(lid) );
				listadoCategorias= OperadoresBean.listarProductosCategoria(idcat);

				if( c.getParameter("l") != null && COMPRA.startsWith(c.getParameter("l"))) {
					layout = COMPRA;
				}

				break;
				// Borra del carrito.
			case 3:
				layout = COMPRA;
				break;
			default:
				break;
		}
    	if(carritobean != null) {
    		c.setSession("carrito", carritobean.getCarrito());
    	}
    	
    	
    	
		c.setRequest("idcat", idcat + "");
		c.setRequest("lista", listadoCategorias);
		c.setRequest("titulo", nombrecat);
		c.setRequest("urlImg", "gui/images");

		construyeMigas(c, idcat, opt, p);

        return layout;

    }

    public void construyeMigas(WebContext c, int cat, int opt, Producto p) {
    	List l = new ArrayList();
    	l.add(new LabelValueBean("Inicio",c.getRequest().getContextPath()+"/"));

    	if(opt == 0) {
    		l.add(new LabelValueBean(bundle.getString("app.categoria") + ": " + bundle.getString(CategoriaAction.cats[cat]), c.getRequest().getContextPath() + "/categoria.do?idcat=" + cat));
    		l.add(new LabelValueBean(p.getMarca() + " " +p.getModelo(),""));
    	} else {
    		l.add(new LabelValueBean(bundle.getString("app.categoria") + ": " + bundle.getString(CategoriaAction.cats[cat]), ""));
    	}

    	c.setRequest("migas",l);

    }
}
