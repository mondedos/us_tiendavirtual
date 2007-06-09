package mfis.tiendavirtual.modelo.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DaoGenerico {
	
	private HibernateTemplate hibernateTemplate;	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
}