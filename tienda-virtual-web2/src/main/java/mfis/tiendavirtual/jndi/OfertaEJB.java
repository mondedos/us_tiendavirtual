package mfis.tiendavirtual.jndi;


import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBObject;

import mfis.tiendavirtual.interfaces.GestionOfertaHome;

public class OfertaEJB extends ConnectEJB {

	public EJBObject getRemoteEJB() {
		GestionOfertaHome gph = null;
		try {
			gph = (GestionOfertaHome) home;
			ejb = gph.create();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		}
		
		return (ejb);
	}

}