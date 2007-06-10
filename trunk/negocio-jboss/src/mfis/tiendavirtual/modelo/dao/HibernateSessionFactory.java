package mfis.tiendavirtual.modelo.dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html}.
 */
public class HibernateSessionFactory {

    /** 
     * Location of hibernate.cfg.xml file.
     * NOTICE: Location should be on the classpath as Hibernate uses
     * #resourceAsStream style lookup for its configuration file. That
     * is place the config file in a Java package - the default location
     * is the default Java package.<br><br>
     * Examples: <br>
     * <code>CONFIG_FILE_LOCATION = "/hibernate.conf.xml". 
     * CONFIG_FILE_LOCATION = "/com/foo/bar/myhiberstuff.conf.xml".</code> 
     */
    private static String CONFIG_FILE_LOCATION = "resources/hibernate.cfg.xml";

   
    /** The single instance of hibernate configuration */
    private static final Configuration cfg = new Configuration();

    /** The single instance of hibernate SessionFactory */
    private static org.hibernate.SessionFactory sessionFactory;

    

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
     * Default constructor.
     */
    private HibernateSessionFactory() {
    }

}
