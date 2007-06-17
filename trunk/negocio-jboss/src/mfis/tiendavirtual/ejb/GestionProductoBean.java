package mfis.tiendavirtual.ejb;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.ejb.CreateException;

import org.hibernate.Criteria;

import mfis.tiendavirtual.modelo.dao.BMGenerico;
import mfis.tiendavirtual.modelo.dao.ProductoDao;
import mfis.tiendavirtual.modelo.objetoNegocio.Dvd;
import mfis.tiendavirtual.modelo.objetoNegocio.Frigorifico;
import mfis.tiendavirtual.modelo.objetoNegocio.Item;
import mfis.tiendavirtual.modelo.objetoNegocio.Lavadora;
import mfis.tiendavirtual.modelo.objetoNegocio.PequenoElectrodomestico;
import mfis.tiendavirtual.modelo.objetoNegocio.Producto;
import mfis.tiendavirtual.modelo.objetoNegocio.Televisor;
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
	@SuppressWarnings("unchecked")
	public List listarProductosBusqueda(Float precioMinimo, Float precioMaximo, Categoria categoria, List<String> palabrasClave) {
		List l = new ArrayList();
		BMGenerico bM = new BMGenerico();
		Criteria c;
		Class clase = null;
		
		if (categoria.equals(Categoria.DVD))
			clase = Dvd.class;
		else if (categoria.equals(Categoria.PEQUENIO_ELECTRODOMESTICO))
			clase = PequenoElectrodomestico.class;
		else if (categoria.equals(Categoria.TELEVISOR))
			clase = Televisor.class;
		else if (categoria.equals(Categoria.FRIGORIFICO))
			clase = Frigorifico.class;
		else if (categoria.equals(Categoria.LAVADORA))
			clase = Lavadora.class;
		c = bM.agregarMarcaOr(clase, palabrasClave);
		if (!(precioMinimo == null)) {
			if (precioMaximo == null) {
				bM.agregarRango(c, "precio", precioMinimo, new Float(Float.MAX_VALUE));
			} else {
				bM.agregarRango(c, "precio", precioMinimo, precioMaximo);
			}
		} else {
			if (!(precioMaximo == null)) {
				bM.agregarRango(c, "precio", new Float(Float.MIN_VALUE), precioMaximo);
			} // En la otra rama no habria restricciones de precio por lo que no
			// añadiriamos restriccion alguna sobre "bM".
		} 
		Collections.addAll(l, (c.scroll()).get());
		
		return (l);
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
	public List get10ProductosMenosBeneficiosos() {
		ProductoDao p = new ProductoDao();
		
		return (p.getDiezProductosBeneficios(false));
	}
	
	/**
	 * Business method
	 *
	 * @ejb.interface-method view-type = "remote"
	 */
	public List get10ProductosMasBeneficiosos() {
		ProductoDao p = new ProductoDao();
		
		return (p.getDiezProductosBeneficios(true));
	}
}