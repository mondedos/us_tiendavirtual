package mfis.tiendavirtual.jndi;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBObject;

import mfis.tiendavirtual.interfaces.GestionOperadorHome;

public class OperadorEJB extends ConnectEJB{

	public EJBObject getRemoteEJB() {
		GestionOperadorHome gph = null;
		try {
			gph = (GestionOperadorHome) home;
			ejb = gph.create();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		}
		return ejb;
	}
}
