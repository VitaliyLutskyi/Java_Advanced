package shared;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.xml.DOMConfigurator;

public class FactoryManager {
	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager getEntityManager() {
		if (entityManager == null)
			entityManager = getEntityManagerfactory().createEntityManager();
		return entityManager;
	}
	
	public static EntityManagerFactory getEntityManagerfactory() {
		if (entityManagerFactory == null)
			entityManagerFactory = Persistence.createEntityManagerFactory("magazetkaPersistence");
		DOMConfigurator.configure("loggerConfig.xml");
		return entityManagerFactory;
	}
}

