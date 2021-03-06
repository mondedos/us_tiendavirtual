package mfis.tiendavirtual.ejb;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
	public List listarProductosBusqueda(Float precioMinimo, Float precioMaximo,
			Categoria categoria, List<String> palabrasClave) {

		List productos= null;

		if(categoria==null){
			productos= obtenerProductosPorCategoria(palabrasClave, precioMinimo, precioMaximo, Producto.class);
		}else if (categoria.equals(Categoria.DVD)) {
			productos= this.obtenerProductosPorCategoria(palabrasClave,
					precioMinimo, precioMaximo, Dvd.class);
		}else if (categoria.equals(Categoria.PEQUENIO_ELECTRODOMESTICO)) {
			productos= this.obtenerProductosPorCategoria(palabrasClave, precioMinimo,
							precioMaximo, PequenoElectrodomestico.class);
		}else if (categoria.equals(Categoria.TELEVISOR)) {
			productos= this.obtenerProductosPorCategoria(
					palabrasClave, precioMinimo, precioMaximo, Televisor.class);
		}else if (categoria.equals(Categoria.FRIGORIFICO)) {
			productos= this.obtenerProductosPorCategoria(
					palabrasClave, precioMinimo, precioMaximo,
					Frigorifico.class);
		}else if (categoria.equals(Categoria.LAVADORA)) {
			productos= this.obtenerProductosPorCategoria(
					palabrasClave, precioMinimo, precioMaximo, Lavadora.class);
		}


		return productos;
	}

	private List obtenerProductosPorCategoria(List<String> palabrasClave,
			Float precioMinimo, Float precioMaximo, Class clase) {
		Criteria c = null;
		BMGenerico bM = new BMGenerico();

		if (palabrasClave != null)
			c = bM.agregarMarcaOr(clase, palabrasClave);
		else
			c = bM.crearCriteriaVacio(clase);

		if (!(precioMinimo == null)) {
			if (precioMaximo == null) {
				bM.agregarRango(c, "precio", precioMinimo, new Float(
						Float.MAX_VALUE));
			} else {
				bM.agregarRango(c, "precio", precioMinimo, precioMaximo);
			}
		} else {
			if (!(precioMaximo == null)) {
				bM.agregarRango(c, "precio", new Float(Float.MIN_VALUE),
						precioMaximo);
			} // En la otra rama no habria restricciones de precio por lo que
			// no
			// aņadiriamos restriccion alguna sobre "bM".
		}

		return c.list();
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
	@SuppressWarnings("unchecked")
	public List get10ProductosMenosBeneficiosos() {
		ProductoDao p = new ProductoDao();
		List mas = p.getDiezProductosBeneficios(true);
		List menos = p.getDiezProductosBeneficios(false);
		ListIterator li = menos.listIterator();
		Producto prod = null;
		List res = new ArrayList<Producto>();

		while (li.hasNext()) {
			prod = (Producto) li.next();
			if (!(mas.contains(prod))) {
				res.add(prod);
			}
		}

		return (res);
	}

	/**
	 * Business method
	 * 
	 * @ejb.interface-method view-type = "remote"
	 */
	@SuppressWarnings("unchecked")
	public List get10ProductosMasBeneficiosos() {
		ProductoDao p = new ProductoDao();
		List mas = p.getDiezProductosBeneficios(true);
		List menos = p.getDiezProductosBeneficios(false);
		ListIterator li = mas.listIterator();
		Producto prod = null;
		List res = new ArrayList<Producto>();

		while (li.hasNext()) {
			prod = (Producto) li.next();
			if (!(menos.contains(prod))) {
				res.add(prod);
			}
		}

		return (res);
	}
}