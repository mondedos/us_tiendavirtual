package mfis.tiendavirtual.ejb;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.ejb.CreateException;

import mfis.tiendavirtual.mocks.dao.ProductosDAO;
import mfis.tiendavirtual.mocks.persistence.Item;
import mfis.tiendavirtual.mocks.persistence.Producto;

/**
 * @ejb.bean name="GestionProducto" display-name="Name for GestionProducto"
 *           description="Description for GestionProducto"
 *           jndi-name="ejb/GestionProducto" type="Stateless" view-type="remote"
 */
public class GestionProductoBean implements SessionBean {

	/**
	 *
	 */
	private static final long serialVersionUID = -1547402712721829410L;

	public GestionProductoBean() {
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
	public List listarProductosBusqueda(float precioMinimo,
			float precioMaximo, String categoria, List<String> palabrasClave) {
		// TODO Auto-generated method stub
		return ProductosDAO.listarProductosBusqueda(precioMinimo,precioMaximo,categoria, palabrasClave);
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public List listarProductosCategoria(String categoria) {

		return ProductosDAO.listarProductosCategoria(categoria);
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public Item getProducto(int id) {
		return ProductosDAO.getProducto(id);
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public void anadirProducto(Producto p) {
		ProductosDAO.anadirProducto(p);
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public void modificarProducto(int id, Producto p) {
		ProductosDAO.modificarProducto(id, p);
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public void eliminarProducto(int id) {
		ProductosDAO.eliminarProducto(id);
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public List get10ProductosMasBeneficiosos() {
		return ProductosDAO.get10ProductosMasBeneficiosos();
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public List get10ProductosMenosBeneficiosos() {
		return ProductosDAO.get10ProductosMenosBeneficiosos();
	}
}
