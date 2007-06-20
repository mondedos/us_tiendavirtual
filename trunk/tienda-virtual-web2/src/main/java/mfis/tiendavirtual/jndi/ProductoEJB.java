package mfis.tiendavirtual.jndi;


import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBObject;
import mfis.tiendavirtual.interfaces.GestionProductoHome;

public class ProductoEJB extends ConnectEJB {

	public EJBObject getRemoteEJB() {
		GestionProductoHome gph = null;
		try {
			gph = (GestionProductoHome) home;
			ejb = gph.create();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		}
		
		return (ejb);
	}

}