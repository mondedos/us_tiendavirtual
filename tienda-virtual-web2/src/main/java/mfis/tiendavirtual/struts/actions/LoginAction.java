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

// Esta clase no se usa de momento, est√° de ejemplo
public class LoginAction extends MyTilesAction {
    public LoginAction() {
    }

    public String execute(WebContext c) {
    	
    	//borramos el operador
    	c.removeSession("operador");
    	
    	//borramos el carrito
    	c.removeSession("carrito");
    	

    	String layout = LOGIN;

    	LoginForm loginForm = (LoginForm) c.getForm();
    	String login= loginForm.getUsuario();

    	if(login != null && !login.trim().equals("")) {
    		
        	GoogleService gs = new GoogleService("mail", "authSample");
        	try {
    			gs.setUserCredentials(loginForm.getUsuario(), loginForm.getClave());
    			c.setSession("operador", login);
    			layout = OPERADOR;
    		} catch (AuthenticationException e) {
    			//Error en autentificacion
    			
    			String mensajeError= "No se ha podido autentificar contra Google, por favor intentelo m·s tarde";
    			c.setRequest("mensajeError", mensajeError);
    			layout= ".error";
    		}
    	} 
    	
        return layout;
    }

}
