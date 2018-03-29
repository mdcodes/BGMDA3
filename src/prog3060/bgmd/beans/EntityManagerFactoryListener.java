package prog3060.bgmd.beans;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EntityManagerFactoryListener implements ServletContextListener {
	
	private static final String persistenceUnitName = "Assignment2BGMD";
	private static EntityManagerFactory emf;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		emf.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	}
	
	public static EntityManager createEM(Map<String, String> props) {
		if(emf == null || !emf.isOpen()) {
			throw new IllegalStateException("Context is not initialized");
		}
		emf = Persistence.createEntityManagerFactory(persistenceUnitName, props);
		return emf.createEntityManager(props);
	}

}
