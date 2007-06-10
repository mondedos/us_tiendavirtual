package mfis.tiendavirtual.jndi;

import javax.ejb.EJBObject;

public interface EJB {

	/** Nombre JNDI asignado a los ejb */
	public static final String PRODUCTOS_JNDI	= "ejb/GestionProducto";
	public static final String PEDIDOS_JNDI 	= "ejb/GestionPedidos";
	public static final String OFERTAS_JNDI 	= "ejb/GestionOfertas";
	public static final String OPERADOR_JNDI 	= "ejb/GestionOperador";

	public EJBObject getRemoteEJB();

}