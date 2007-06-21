package mfis.tiendavirtual.struts.actions;

import java.util.ArrayList;
import java.util.List;

import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.struts.beans.OfertaBean;
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
public class OpcionesAction extends MyTilesAction {

	private static String[] opciones = {
		"app.opciones.0",
		"app.opciones.1",
		"app.opciones.2",
		"app.opciones.3",
		"app.opciones.4"
	};

    public OpcionesAction() {
    }

    public String execute(WebContext c) {

    	String layout = OPERADOR;

    	int opt = -1;
    	try {
    		opt = Integer.parseInt(c.getParameter("opt"));
    	} catch (Exception e) {
			e.printStackTrace();
		}


    	switch (opt) {
			case 0:

				break;
			case 1:
				// crear oferta

				// obtener productos mas beneficiosos
 				List listaMas = OperadoresBean.obtenerProductosMasBeneficiosos();
				//c.setRequest("listaMas", listaMas);
				// obtener productos menos beneficiosos
				List listaMenos = OperadoresBean.obtenerProductosMenosBeneficiosos();
				//c.setRequest("listaMenos", listaMenos);

				List listaOfertas = new ArrayList();
				for(int i = 0; i < listaMas.size() ; i++) {
					listaOfertas.add( new OfertaBean((Producto)listaMas.get(i), (Producto)listaMenos.get(i)) );
				}

				c.setRequest("lista", listaOfertas);

				layout = OFERTA;
				break;
			case 2:
				// guardar oferta en base de datos
				String prodA = c.getParameter("prodA");
				String prodB = c.getParameter("prodB");

				OperadoresBean.crearOferta(Integer.parseInt(prodA) , Integer.parseInt(prodB));

				//mostramos la nueva oferta creada
				StartAction.obtenerOfertas(c);
				layout = ".ofertaCreada";

				break;
			case 3:

				break;
			case 4:
				logout(c);
				StartAction.obtenerOfertas(c);
				StartAction.construyeMigas(c);
				layout = MAINPAGE;
				break;
			default:
				break;
		}

        return layout;
    }

    private void logout(WebContext c){
    	c.removeSession("operador");
    	c.setRequest("lista", new ArrayList());
    }

}
