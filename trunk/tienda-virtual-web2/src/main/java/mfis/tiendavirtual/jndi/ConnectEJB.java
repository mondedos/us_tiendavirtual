package mfis.tiendavirtual.jndi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class ConnectEJB implements EJB{

	public InitialContext initc = null;
	EJBHome home = null;
	EJBObject ejb = null;

	String jndi = null;

	public EJBObject getEJB(String jndi) {

    	Hashtable propiedades = new Hashtable();
    	propiedades.put("java.naming.factory.initial",
    	    				"org.jnp.interfaces.NamingContextFactory");
    	propiedades.put("java.naming.factory.url.pkgs",
    	    				"org.jboss.naming:org.jnp.interfaces");
    	propiedades.put("java.naming.provider.url",
    	    				"localhost");

		this.jndi = jndi;
		try {
			if (initc == null) {
				initc = new InitialContext(propiedades);
			}
			home = (EJBHome) initc.lookup(this.jndi);

			ejb = this.getRemoteEJB();

		} catch (NamingException e) {
			e.printStackTrace();
		}

		return ejb;
	}

	public abstract EJBObject getRemoteEJB();

}