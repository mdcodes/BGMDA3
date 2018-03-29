/*
 * Name: Michal Drahorat, Brody Gartner
 * Description: The Connection bean
 * Date: February 11th, 2018
 */

package prog3060.bgmd.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import prog3060.bgmd.entities.GeographicArea;

public class ConnectionBean implements Serializable
{
	private static final long serialVersionUID = -1059017970416601343L;
	
	String username;
	String password;
	String message;
	static boolean isConnected;
	
	public ConnectionBean() {
		super();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static boolean isConnected() {
		return isConnected;
	}

	public static void setConnected(boolean isConnected) {
		ConnectionBean.isConnected = isConnected;
	}

	public void OpenConnnection() throws SQLException
	{	try {
		EntityManager em = createEntityManager();
		setConnected(true);
		}
		catch(Exception e) {
			setConnected(false);
		}
	}
	
	private EntityManager createEntityManager() {
		Map<String, String> args = new HashMap<>();
		args.put("hibernate.connection.username", getUsername());
		args.put("hibernate.connection.password", getPassword());
		
		EntityManager em = EntityManagerFactoryListener.createEM(args);
		
		return em;
	}
	
	public List<GeographicArea> getAllGeoAreas() throws SQLException{
		
		List<GeographicArea> list = new ArrayList<>();
		
		if(isConnected) {
			EntityManager em = null;
			String queryString = "FROM GeographicArea ga";
			
			try {
				em = createEntityManager();
				em.getTransaction().begin();
				
				Query query = em.createQuery(queryString);
				
				list = query.getResultList();
				
				em.getTransaction().rollback();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				if(em != null && em.isOpen()) {
					em.getTransaction().rollback();
				}
				e.printStackTrace();
			}
			finally {
				if(em != null && em.isOpen()) {
					em.close();
				}
			}
			
			return list;
		}
		else {
			return list;
		}
		
		
	}
}
