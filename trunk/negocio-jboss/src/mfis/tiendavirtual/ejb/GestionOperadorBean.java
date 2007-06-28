package mfis.tiendavirtual.ejb;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.ejb.CreateException;

import mfis.tiendavirtual.modelo.dao.OperadorDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Operador;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;

/**
 * @ejb.bean name="GestionOperador"
 *           display-name="Name for GestionOperador"
 *           description="Description for GestionOperador"
 *           jndi-name="ejb/GestionOperador"
 *           type="Stateless"
 *           view-type="remote"
 */
public class GestionOperadorBean implements SessionBean {

	
	private static final long serialVersionUID = -4631672726696710373L;
	private OperadorDAO operadorDao;
	
	public GestionOperadorBean() {
		super();
		
		operadorDao= new OperadorDAO();
	}

	public void setSessionContext(SessionContext ctx)
		throws EJBException,
		RemoteException {
	}

	public void ejbRemove() throws EJBException, RemoteException {
	}

	public void ejbActivate() throws EJBException, RemoteException {
	}

	public void ejbPassivate() throws EJBException, RemoteException {
	}

	/**
	 * Default create method
	 *
	 * @throws CreateException
	 * @ejb.create-method
	 */
	public void ejbCreate() throws CreateException {
	}

	/**
	 * Business method
	 * @ejb.interface-method  view-type = "remote"
	 */
	public Operador getOperador(int id) {
		return operadorDao.obtenerOperador(id);
	}
	/**
	 * Business method
	 * @ejb.interface-method  view-type = "remote"
	 */
	public Operador getOperador(String login) {
		return operadorDao.obtenerOperador(login);
	}
	/**
	 * Business method
	 * @ejb.interface-method  view-type = "remote"
	 */
	public Pedido siguientePedido(int id) {
		return operadorDao.siguientePedido(id);
	}
	
	public List obtenerPedidosOperador(String login){
		return operadorDao.obtenerPedidosOperador(login);
	}
}