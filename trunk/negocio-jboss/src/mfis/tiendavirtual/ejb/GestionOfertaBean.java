package mfis.tiendavirtual.ejb;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.ejb.CreateException;

import mfis.tiendavirtual.mocks.dao.OfertasDAO;
import mfis.tiendavirtual.mocks.persistence.Oferta;
import mfis.tiendavirtual.mocks.persistence.Producto;

/**
 * @ejb.bean name="GestionOferta"
 *           display-name="Name for GestionOferta"
 *           description="Description for GestionOferta"
 *           jndi-name="ejb/GestionOferta"
 *           type="Stateless"
 *           view-type="remote"
 */
public class GestionOfertaBean implements SessionBean {

	/**
	 *
	 */
	private static final long serialVersionUID = -6546078935309483841L;
	public GestionOfertaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setSessionContext(SessionContext ctx)
		throws EJBException,
		RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * Default create method
	 *
	 * @throws CreateException
	 * @ejb.create-method
	 */
	public void ejbCreate() throws CreateException {
		// TODO Auto-generated method stub
	}

	/**
	 * Business method
	 * @ejb.interface-method  view-type = "remote"
	 */
	public void nuevaOferta(Producto productoA, Producto productoB) {
		OfertasDAO.nuevaOferta(productoA, productoB);
	}
	/**
	 * Business method
	 * @ejb.interface-method  view-type = "remote"
	 */
	public Oferta getOferta() {
		return OfertasDAO.getOferta();
	}
}
