package mfis.tiendavirtual.struts.actions;

import mfis.tiendavirtual.struts.forms.LoginForm;

import com.google.gdata.client.GoogleService;
import com.google.gdata.util.AuthenticationException;

import struts.MyTilesAction;
import struts.WebContext;

/**
 * @author DVF
 */

// En este caso no podemos usar XDoclets porque nuestras acciones hereadan
// de MyTilesAction y no de Action. En su lugar, las acciones se mapean en el fichero
// src/main/assembly/struts-actions.xml

// Esta clase no se usa de momento, está de ejemplo
public class LoginAction extends MyTilesAction {
    public LoginAction() {
    }

    public String execute(WebContext c) {

    	String layout = MAINPAGE;

    	LoginForm loginForm = (LoginForm) c.getForm();

    	if(loginForm.getUsuario() != null && !loginForm.getUsuario().equals("")) {
        	boolean auth = true;
        	GoogleService gs = new GoogleService("mail", "authSample");
        	try {
    			gs.setUserCredentials(loginForm.getUsuario(), loginForm.getClave());
    		} catch (AuthenticationException e) {
    			auth = false;
    			//e.printStackTrace();
    		}
    		if(auth){
    			//System.out.println("Autenticaci�n contra google correcta");
    			// se introduce una variable de sesi�n que indica que el operador est� logado
    			c.setSession("operador", loginForm.getUsuario());
    			layout = OPERADOR;
    		} else {
    			System.out.println("Error en la autenticaci�n contra google");
    		}
    	} else {
    		layout = LOGIN;
    	}

        return layout;
    }

}
