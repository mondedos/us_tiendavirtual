package mfis.tiendavirtual.modelo.dao;

import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Clase que gestiona la creacion de sesiones de hibernate
 * 
 * mas informacion en: http://hibernate.org/42.html
 * 
 * @author Edgar
 *
 */
public abstract class HibernateSessionFactory {

    private static final String CONFIG_FILE_LOCATION = "resources/hibernate.cfg.xml";
    private static final String DEFAULT_USER_TRANSACTION_NAME = "java:comp/UserTransaction";

   
    /** The single instance of hibernate configuration */
    private static final Configuration cfg = new Configuration();

    /** The single instance of hibernate SessionFactory */
    private static SessionFactory sessionFactory;

    

    /**
     * Metodo encargado de crear un session factory en caso de no existir uno actual.
     */
    private static void creaSessionFactory() {
        if (sessionFactory == null) {
            try {
                cfg.configure(CONFIG_FILE_LOCATION);
                sessionFactory = cfg.buildSessionFactory();
            }
            catch (Exception e) {
                System.err.println("%%%% Error Creating SessionFactory %%%%");
                e.printStackTrace();
            }
        }
    }

    
    /**
     * Metodo encargado de crear una nueva sesion de hibernate
     */
    public static Session crearSesion(){
        creaSessionFactory();
        return sessionFactory.openSession();
    }
    
    /**
     * Metodo encargado de obtener la session actual, esto se puede hacer si utilizamos transacciones jta
     */
    public static Session obtenerSesionActual(){
    	creaSessionFactory();
    	return sessionFactory.getCurrentSession();
    }
    
    /**
     * Estrategia para la apertura de sesiones utilizando un patron session-per-request
     * Para el manejo de transacciones utilizaremos JDBC: Transaction demarcation with plain JDBC
     */
    public abstract Object operacionesBaseDatos(Session sesion);
    
    public Object sessionPerRequest(){
    	
    	Session session = crearSesion();
    	Transaction tx = null;
    	Object resultado= null;
    	try {
    	    tx = session.beginTransaction();

    	    //operaciones a realizar: metodo hook
    	    resultado= operacionesBaseDatos(session);

    	    //actualizamos base de datos
    	    tx.commit();
    	}
    	catch (RuntimeException e) {
    		//en caso de error desacemos cambios en la base de datos
    		
    	    tx.rollback();
    	    throw e; 
    	}
    	finally {
    	    session.close();
    	}
    	return resultado;
    }
    
    /**
     * Estrategia para la apertura de sesiones utilizando un patron session-per-request
     * Para el manejo de las transacciones utilizaremos JTA: Transaction demarcation with JTA
     */
    public Object sessionPerRequestJTA(){
    	
    	Object resultado= null;
    	UserTransaction tx= null;
    	
    	try {
    	    tx = (UserTransaction)new InitialContext().lookup(DEFAULT_USER_TRANSACTION_NAME);
    	                            
    	    tx.begin();
    	    
    	    Session sesionActual= obtenerSesionActual();

    	    // Do some work
    	    operacionesBaseDatos(sesionActual);

    	    tx.commit();
    	}
    	catch (Exception e) {
    		try{
    			System.err.println("\nNose se pudo realizar la operacion a la base de datos\n");
	    	    if(tx!=null) tx.rollback();
	    	    throw new RuntimeException(e); // or display error message
    		}catch(Exception e1){
    			System.err.println("\nNo se pudo llevar a cavo el rollback\n");
    			throw new RuntimeException(e1);
    		}
    	}
    	
    	return resultado;
    	
    }

}


















