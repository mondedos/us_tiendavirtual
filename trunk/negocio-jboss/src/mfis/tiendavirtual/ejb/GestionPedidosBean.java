package mfis.tiendavirtual.ejb;

import java.io.FileNotFoundException;
import java.io.FileWriter;
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
	}

	public void setSessionContext(SessionContext ctx) throws EJBException,
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

		cad += "Enviar el pedido a " + direccion + "\r\n\r\n";

		cad += "=================================================================";

		cad += "\r\n" + c.toString();
		generarArchivoLog(cad);
	}

	public void generarArchivoLog(String cad) {
		try {
			FileWriter fichero = new FileWriter(
					"c:\\ventas.txt", true);
			fichero.append("\r\n\r\n"+cad);
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