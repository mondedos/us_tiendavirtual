package mfis.tiendavirtual.jndi;


import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBObject;
import mfis.tiendavirtual.interfaces.GestionPedidosHome;

public class PedidosEJB extends ConnectEJB {

	public EJBObject getRemoteEJB() {
		GestionPedidosHome gph = null;
		try {
			gph = (GestionPedidosHome) home;
			ejb = gph.create();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		}
		return ejb;
	}

}