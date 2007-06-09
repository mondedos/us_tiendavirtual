package mfis.tiendavirtual.modelo.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonSpringContainer {

	private static SingletonSpringContainer factoria;

	private static ApplicationContext contenedor;

	private static String xmlConf = "SpringHibernate.xml";

	/**
	 * Inicializa el contenedor de objetos de Spring a partir del fichero
	 * configuración SpringHibernate.xml.
	 */
	private SingletonSpringContainer() {
		SingletonSpringContainer.contenedor = new ClassPathXmlApplicationContext(
				SingletonSpringContainer.xmlConf);
	}

	/**
	 * El contenedor de objetos de Spring se generán una única vez.
	 * 
	 * @return SingletonSpringContainer
	 */
	public static SingletonSpringContainer getInstance() {
		if (SingletonSpringContainer.factoria == null)
			SingletonSpringContainer.factoria = new SingletonSpringContainer();

		return SingletonSpringContainer.factoria;
	}

	/**
	 * Se encarga de obtener los beans que se han creado.
	 */
	public Object getBean(String idBeans) {

		return SingletonSpringContainer.contenedor.getBean(idBeans);
	}
}
