package mfis.tiendavirtual.jndi;


import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConexionEJB {

	/** Nombre JNDI asignado a los ejb */
	public static final String PRODUCTOSDS	= "ejb/GestionProducto";
	public static final String PEDIDOSDS 	= "ejb/GestionPedidos";
	public static final String OFERTASDS 	= "ejb/GestionOfertas";
	public static final String OPERADORDS 	= "ejb/GestionOperador";

	/** Almacena el InitialContext */
	private static InitialContext initc = null;

	/** Fuente de datos */
	private static Object home;

	private static void init(String ds) {
		if (initc != null && home != null) {
			return;
		}
		try {
			if (initc == null) {
				initc = new InitialContext();
			}
			home = initc.lookup(ds);
		} catch (NamingException e) {
			System.err.println("Error: ConexionEJB.init() - Error al intentar instanciar InitialContext");
			System.out.println("El mensaje de error es: " + e.getMessage());
		}
	}

	/**
	 *
	 *
	 * @return Object
	 */
	public static Object getRemoteDS(String ds) {
		//TODO Esto hay que rematarlo
		init(ds);
		try {
			return initc.lookup(ds);
		} catch (javax.naming.NamingException ne) {
	        ne.printStackTrace();
	    }
		return null;
	}

}