package mfis.tiendavirtual.struts.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.struts.actions.CategoriaAction;
import mfis.tiendavirtual.struts.beans.CarritoBean;
import mfis.tiendavirtual.struts.beans.OperadoresBean;
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
    	int idpro = Integer.parseInt(c.getParameter("idpr"));
    	// Se usa para borrar una linea de pedido.
    	String lid = c.getParameter("lid");

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
    		// Ver detalle.
			case 0:
				p = OperadoresBean.getProducto(idpro);
				c.setRequest("producto", p);
				layout = PRODUCTO;
				break;
			// Añade al carrito.
			case 1:
		    	int unidades = Integer.parseInt(c.getParameter("unidades"));
				carritobean = new CarritoBean(c);
				Item i = null;
				if(c.getParameter("oferton") != null) {
					i = OperadoresBean.getOferta();
			    	StartAction.obtenerOfertas(c);
			    	StartAction.construyeMigas(c);
					layout = MAINPAGE;
				} else {
					i = OperadoresBean.getProducto(idpro);
				}
				listadoCategorias= listaProductos(c);
				carritobean.crearLineaPedido(i, unidades);
				break;
			// Borra del carrito (1).
			case 2:
				carritobean = new CarritoBean(c);
				carritobean.borrarLineaPedido( Integer.parseInt(lid) );
				if(c.getParameter("of") != null) {
					StartAction.obtenerOfertas(c);
			    	StartAction.construyeMigas(c);
					layout = MAINPAGE;
				}
				listadoCategorias= listaProductos(c);
				if( c.getParameter("l") != null && COMPRA.startsWith(c.getParameter("l"))) {
					layout = COMPRA;
				}
				break;
			// Borra del carrito (2).
			case 3:
				saveToken(c.getRequest());
				layout = COMPRA;
				break;
			default:
				break;
		}

		if(carritobean != null) {
    		c.setSession("carrito", carritobean.getCarrito());
    	}


    	establecerRequest(c);
		c.setRequest("lista", listadoCategorias);
		c.setRequest("urlImg", "gui/images");

		construyeMigas(c, opt, p);

        return layout;

    }

    public void construyeMigas(WebContext c, int opt, Producto p) {

    	String auxiliar= (String)c.getParameter("idcat");
    	if(!Utilidades.cadenaVacia(auxiliar)){

    		int cat= Integer.parseInt(auxiliar);
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


    private List listaProductos(WebContext c){

    	String idcat= (String)c.getParameter("idcat");

    	List listaProductos= null;

    	if(Utilidades.cadenaVacia(idcat)){
    		String minimo= (String)c.getParameter("pmin");
    		String maximo= (String)c.getParameter("pmax");
    		String marca= (String)c.getParameter("marca");
    		String cadCategoria= (String)c.getParameter("categoria");

    		Float pmin;
    		Float pmax;
    		if(Utilidades.cadenaVacia(minimo)) pmin= null;
    		else pmin= new Float(Float.parseFloat(minimo));
    		if(Utilidades.cadenaVacia(maximo)) pmax= null;
    		else pmax= new Float(Float.parseFloat(maximo));

    		listaProductos= BusquedaAction.realizarBusqueda(pmin, pmax, cadCategoria, marca);

    	}else{
    		listaProductos= OperadoresBean.listarProductosCategoria(Integer.parseInt(idcat));
    	}


    	return listaProductos;
    }

    private void establecerRequest(WebContext c){

    	String idcat= (String)c.getParameter("idcat");
    	if(Utilidades.cadenaVacia(idcat)){

    		c.setRequest("pmin", c.getParameter("pmin"));
    		c.setRequest("pmax", c.getParameter("pmax"));
    		c.setRequest("marca", c.getParameter("marca"));
    		c.setRequest("categoria", c.getParameter("categoria"));
    		c.setRequest("titulo", "Resultado de la busqueda");

    	}else{

    		c.setRequest("idcat", idcat);
    		c.setRequest("titulo", bundle.getString(CategoriaAction.cats[Integer.parseInt(idcat)]));

    	}

    }
}








