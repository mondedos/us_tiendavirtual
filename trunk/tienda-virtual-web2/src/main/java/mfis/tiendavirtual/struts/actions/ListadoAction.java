package mfis.tiendavirtual.struts.actions;

import java.rmi.RemoteException;
import java.util.List;

import mfis.tiendavirtual.Carrito;
import mfis.tiendavirtual.interfaces.GestionProducto;
import mfis.tiendavirtual.jndi.EJB;
import mfis.tiendavirtual.jndi.ProductoEJB;
import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.LineaPedido;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.struts.actions.CategoriaAction;
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
		"app.listado.1",
		"app.listado.2"
	};

    public ListadoAction() {
    }

    public String execute(WebContext c) {

    	String layout = MENUPAGE;

    	int opt = -1;
    	int idcat = Integer.parseInt(c.getParameter("idcat"));
    	int idpro = Integer.parseInt(c.getParameter("idpr"));

    	//se usa para borrar linea de pedido
    	String lid = c.getParameter("lid");

    	String nombrecat = bundle.getString(CategoriaAction.cats[idcat]);
    	try {
    		opt = Integer.parseInt(c.getParameter("opt"));
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	List listadoCategorias = null;
    	GestionProducto gp = (GestionProducto) new ProductoEJB().getEJB(EJB.PRODUCTOS_JNDI);
    	Carrito carrito = null;
		if(c.getSession("carrito") == null) {
			carrito = new Carrito();
		} else {
			carrito = (Carrito) c.getSession("carrito");
		}
    	switch (opt) {
    		// ver detalle
			case 0:
				Producto p = null;
				try {
					p = (Producto) gp.getProducto(idpro);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				c.setRequest("producto", p);
				layout = PRODUCTO;

				break;
			// añadir a carrito
			case 1:
				LineaPedido linea = new LineaPedido();
				Item i = null;

		    	// TODO en pruebas
		    	try {
		    		i = gp.getProducto( idpro );
		    		listadoCategorias = gp.listarProductosCategoria(nombrecat);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Float precio = ((Producto)i).getPrecio() ;
				linea.setCompra(i);
				linea.setUnidades(1);
				linea.setPrecioUnidad( precio );

				carrito.addLineaPedido(linea, precio);

				c.setSession("carrito", carrito);

				break;
			//borra de carrito
			case 2:

				carrito.removeLineaPedido( Integer.parseInt(lid) );
				try {
					listadoCategorias = gp.listarProductosCategoria(nombrecat);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.setSession("carrito", carrito);
				break;
			default:
				break;
		}
		c.setRequest("idcat", idcat + "");
		c.setRequest("lista", listadoCategorias);
		c.setRequest("titulo", nombrecat);
		c.setRequest("urlImg", bundle.getString("app.imgpath") + CategoriaAction.imgPath[idcat]);
        return layout;
    }

}
