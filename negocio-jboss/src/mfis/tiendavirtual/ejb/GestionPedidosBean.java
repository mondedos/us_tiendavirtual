package mfis.tiendavirtual.ejb;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

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
	private PedidosDAO p;

	public GestionPedidosBean() {
		super();
		p= new PedidosDAO();
		
		
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
	public Long registrarPedido(Carrito c, String direccion) {
		registrarVentaProvisional(c, direccion);
		return p.registrarPedido(c, direccion);
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
	 * @throws IlegalChangedStateOrder 
	 * 
	 * @ejb.interface-method view-type = "remote"
	 */
	public void actualizarEstado(Pedido pedido, String estado, Date fecha){
		p.actualizarEstado(pedido, estado, fecha);
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
	
	/**
	 * Obtiene las lineas de pedido asociados a  un determinado pedido
	 * @param idPedido identificador del pedido
	 * @return lineas de pedido
	 */
	public List obtenerLineasPedido(Pedido pedido){
		return p.obtenerLineasPedido(pedido);
	}
	
	public String obtenerEstado(Pedido pedido){
		return p.obtenerEstado(pedido);	
	}
}