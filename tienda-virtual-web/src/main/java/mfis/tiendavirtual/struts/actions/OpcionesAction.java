package mfis.tiendavirtual.struts.actions;

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

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				logout(c);
				layout = MAINPAGE;
				break;
			default:
				break;
		}

        return layout;
    }

    private void logout(WebContext c){
    	c.removeSession("operador");
    }

}
