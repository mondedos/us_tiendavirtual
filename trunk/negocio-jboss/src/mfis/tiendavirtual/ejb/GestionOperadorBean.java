package mfis.tiendavirtual.ejb;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.ejb.CreateException;

import mfis.tiendavirtual.mocks.dao.OperadorDAO;
import mfis.tiendavirtual.mocks.persistence.Operador;
import mfis.tiendavirtual.mocks.persistence.Pedido;

/**
 * @ejb.bean name="GestionOperador"
 *           display-name="Name for GestionOperador"
 *           description="Description for GestionOperador"
 *           jndi-name="ejb/GestionOperador"
 *           type="Stateless"
 *           view-type="remote"
 */
public class GestionOperadorBean implements SessionBean {

	/**
	 *
	 */
	private static final long serialVersionUID = -4631672726696710373L;
	public GestionOperadorBean() {
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
	public Operador getOperador(int id) {
		return OperadorDAO.getOperador(id);
	}
	/**
	 * Business method
	 * @ejb.interface-method  view-type = "remote"
	 */
	public Operador getOperador(String login) {
		return OperadorDAO.getOperador(login);
	}
	/**
	 * Business method
	 * @ejb.interface-method  view-type = "remote"
	 */
	public Pedido siguientePedido(int id) {
		return OperadorDAO.siguientePedido(id);
	}
}
