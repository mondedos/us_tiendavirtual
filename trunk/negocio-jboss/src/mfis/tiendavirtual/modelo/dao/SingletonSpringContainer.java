package mfis.tiendavirtual.modelo.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonSpringContainer {

	//Beans declarados en el archivo SpringHibernate.xml
	public static final String DAO_GENERICO= "DaoGenerico";
	
	
	private static SingletonSpringContainer factoria;
	private static ApplicationContext contenedor;
	private static String xmlConf = "resources/SpringHibernate.xml";

	/**
	 * Inicializa el contenedor de objetos de Spring a partir del fichero
	 * configuración SpringHibernate.xml.
	 */
	private SingletonSpringContainer() {
		
		try{
		SingletonSpringContainer.contenedor = new ClassPathXmlApplicationContext(
				SingletonSpringContainer.xmlConf);
		}
		catch(Exception ej)
		{
			System.out.println(ej.getCause());
		}
	}

	/**
	 * El contenedor de objetos de Spring se generán una única vez.
	 * 
	 * @return SingletonSpringContainer
	 */
	private static SingletonSpringContainer getInstance() {
		if (SingletonSpringContainer.factoria == null)
			SingletonSpringContainer.factoria = new SingletonSpringContainer();

		return SingletonSpringContainer.factoria;
	}

	/**
	 * Se encarga de obtener los beans que se han creado.
	 */
	public static Object getBean(String idBeans) {
		
		getInstance();
		return SingletonSpringContainer.contenedor.getBean(idBeans);
	}
}
