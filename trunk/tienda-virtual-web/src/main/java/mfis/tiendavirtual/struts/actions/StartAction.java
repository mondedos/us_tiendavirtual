package mfis.tiendavirtual.struts.actions;

import struts.MyTilesAction;
import struts.WebContext;


/**
* @author DVF
*/

// En este caso no podemos usar XDoclets porque nuestras acciones hereadan
// de MyTilesAction y no de Action. En su lugar, las acciones se mapean en el fichero
// src/main/assembly/struts-actions.xml
public class StartAction extends MyTilesAction {

    public StartAction() {
    }

    public String execute(WebContext c) {

        return MAINPAGE;
    }

}
