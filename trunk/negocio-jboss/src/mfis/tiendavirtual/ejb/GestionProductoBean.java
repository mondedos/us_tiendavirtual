package mfis.tiendavirtual.ejb;

import java.rmi.RemoteException;
import java.util.List;
import java.util.ArrayList;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.ejb.CreateException;

import mfis.tiendavirtual.modelo.dao.ProductoDao;
import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.modelo.dao.Categoria;

/**
 * @ejb.bean name="GestionProducto" display-name="Name for GestionProducto"
 *           description="Description for GestionProducto"
 *           jndi-name="ejb/GestionProducto" type="Stateless" view-type="remote"
 */
public class GestionProductoBean implements SessionBean {
	private static final long serialVersionUID = -1547402712721829410L;

	public GestionProductoBean() {
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
	public List listarProductosBusqueda(float precioMinimo,
			float precioMaximo, String categoria, List<String> palabrasClave) {
		/* ProductoDao p = new ProductoDao(); */
		List l = new ArrayList();
		
		return (l);
		/* return p.listarProductosBusqueda(precioMinimo,precioMaximo,categoria, palabrasClave); */
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public List listarProductosCategoria(Categoria categoria) {
		ProductoDao p = new ProductoDao();
		
		return (p.listarProductoCategoria(categoria));
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public Item getProducto(int id) {
		ProductoDao p = new ProductoDao();
		
		return p.obtenerProductoPorId(new Long(id));
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public void anadirProducto(Producto p) {
		ProductoDao p2 = new ProductoDao();
		
		p2.agregarProducto(p);
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public void modificarProducto(int id, Producto p) {
		ProductoDao p2 = new ProductoDao();
		
		p2.modificarProducto(new Long(id), p);
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public void eliminarProducto(int id) {
		ProductoDao p = new ProductoDao();
		
		p.eliminarProducto(new Long(id));
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public List get10ProductosMasBeneficiosos() {
		List l = new ArrayList();
		
		/* return ProductoDao.get10ProductosMasBeneficiosos(); */
		return (l);
	}

	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public List get10ProductosMenosBeneficiosos() {
		List l = new ArrayList();
		
		/* return ProductoDao.get10ProductosMenosBeneficiosos(); */
		return (l);
	}
}