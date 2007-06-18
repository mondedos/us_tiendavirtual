package mfis.tiendavirtual.ejb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.ejb.CreateException;

import mfis.tiendavirtual.modelo.dao.PedidosDAO;
import mfis.tiendavirtual.modelo.objetoNegocio.Pedido;

/**
 * @ejb.bean name="GestionPedidos" display-name="Name for GestionPedidos"
 *           description="Description for GestionPedidos"
 *           jndi-name="ejb/GestionPedidos" type="Stateless" view-type="remote"
 */
public class GestionPedidosBean implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8301107721106977850L;

	public GestionPedidosBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setSessionContext(SessionContext ctx) throws EJBException,
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
	 * 
	 * @ejb.interface-method view-type = "remote"
	 */
	public void registrarPedido(Carrito c, String direccion) {
		PedidosDAO p = new PedidosDAO();

		p.registrarPedido(c, direccion);
		// TODO Eliminar esto cuando se haga la venta con PayPal.
		registrarVentaProvisional(c, direccion);
	}

	private void registrarVentaProvisional(Carrito c, String direccion) {
		String cad = "";

		cad += "Pedido  asignado a la direccion " + direccion;

		cad += "=================================================================";

		// cad += c.toString();
		generarArchivoLog(cad);
	}

	private void generarArchivoLog(String cad) {
		try {
			java.io.FileOutputStream fichero = new FileOutputStream(
					"ventas.txt", false);
			fichero.write(cad.getBytes());
			fichero.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Business method
	 * 
	 * @ejb.interface-method view-type = "remote"
	 */
	public void actualizarEstado(Pedido p, String estado, Date fecha) {
		PedidosDAO p2 = new PedidosDAO();

		p2.actualizarEstado(p, estado, fecha);
	}

	/**
	 * Business method
	 * 
	 * @ejb.interface-method view-type = "remote"
	 */
	public Pedido getPedido(int id) {
		PedidosDAO p = new PedidosDAO();

		return p.obtenerPedido(id);
	}
}