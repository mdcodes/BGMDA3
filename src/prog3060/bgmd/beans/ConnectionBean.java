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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import prog3060.bgmd.entities.Age;
import prog3060.bgmd.entities.AgeGroup;
import prog3060.bgmd.entities.GeographicArea;
import prog3060.bgmd.entities.Household;

public class ConnectionBean implements Serializable
{
	private static final long serialVersionUID = -1059017970416601343L;
	
	String username;
	String password;
	static String message;
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

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		ConnectionBean.message = message;
	}

	public static boolean isConnected() {
		return isConnected;
	}

	public static void setConnected(boolean isConnected) {
		ConnectionBean.isConnected = isConnected;
	}

	public void OpenConnnection(String user, String pass) throws SQLException
	{	try {
		EntityManager em = createEntityManager(user, pass);
		setConnected(true);
		}
		catch(Exception e) {
			setConnected(false);
		}
	}
	
	static EntityManager createEntityManager(String username, String password) {
		Map<String, String> args = new HashMap<>();
		args.put("hibernate.connection.username", username);
		args.put("hibernate.connection.password", password);
		
		EntityManager em = EntityManagerFactoryListener.createEM(args);
		
		return em;
	}
	
	public List<GeographicArea> getAllGeoAreas(String user, String pass) throws SQLException{
		
		List<GeographicArea> list = new ArrayList<>();
		
		if(isConnected) {
			EntityManager em = null;
			String queryString = "FROM GeographicArea ga "
					+ "ORDER BY ga.level, ga.name";
			
			try {
				em = createEntityManager(user, pass);
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
	
	public List<GeographicArea> getGeoInfo(String username, String password, String areaId) throws SQLException{
		
		List<GeographicArea> listGeo = new ArrayList<>();

		
		if(isConnected) {
			EntityManager em = null;
			String queryStringGeo = "FROM GeographicArea ga "
					+ "WHERE ga.geographicAreaID = :areaId";
			
			
			try {
				em = createEntityManager(username, password);
				em.getTransaction().begin();
				
				Query queryGeo = em.createQuery(queryStringGeo)
						.setParameter("areaId", Integer.parseInt(areaId));
				
				listGeo = queryGeo.getResultList();
				
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
			
			return listGeo;
		}
		else {
			return listGeo;
		}
		
		
	}
	
	public List<Age> getAgeInfo(String user, String pass, String areaId) throws SQLException{
		
		List<Age> listAge = new ArrayList<>();

		
		if(isConnected) {
			EntityManager em = null;
			
			String queryStringAge = "FROM Age a "
					+ "WHERE a.geographicArea.geographicAreaID = :areaId AND a.ageGroup.ageGroupID = 1";
			
			try {
				em = createEntityManager(user, pass);
				em.getTransaction().begin();
				
				Query queryAge = em.createQuery(queryStringAge)
						.setParameter("areaId", Integer.parseInt(areaId));
								 
				listAge = queryAge.getResultList();

				
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
			
			return listAge;
		}
		else {
			return listAge;
		}
		
		
	}

	public List<Household> getHouseholdInfo(String user, String pass, String areaId) throws SQLException{
		
		List<Household> listHousehold = new ArrayList<>();
		int censusYear = 2016;
		int houseType = 4;
		int houseSize = 3;
		int houseEarners = 3;
		int totalIncome = 15;
		int ageRange = 7;
	
		
		if(isConnected) {
			EntityManager em = null;
			
			String queryStringHousehold = "FROM Household h "
					+ "WHERE h.geographicArea.geographicAreaID = :areaId "
					+ "AND h.censusYear.censusYear = :censusYear "
					+ "AND h.householdType.id = :householdType "
					+ "AND h.householdSize.id = :householdSize "
					+ "AND h.householdEarners.id = :householdEarners "
					+ "AND h.totalIncome.id = :totalIncome "
					+ "AND h.householdsByAgeRange.id = :ageRange";
			
			try {
				em = createEntityManager(user, pass);
				em.getTransaction().begin();
				
				Query queryHousehold = em.createQuery(queryStringHousehold)
						.setParameter("areaId", Integer.parseInt(areaId))
						.setParameter("censusYear", censusYear)
						.setParameter("householdType", houseType)
						.setParameter("householdSize", houseSize)
						.setParameter("householdEarners", houseEarners)
						.setParameter("totalIncome", totalIncome)
						.setParameter("ageRange", ageRange);
								 
				listHousehold = queryHousehold.getResultList();
	
				
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
			
			return listHousehold;
		}
		else {
			return listHousehold;
		}
		
		
	}
	
	public List<GeographicArea> getSubCountry(String user, String pass) throws SQLException{
		
		List<GeographicArea> listSubLevel = new ArrayList<>();
		int level = 1;
		
		if(isConnected) {
			EntityManager em = null;
			
			String queryStringGeo = "FROM GeographicArea ga "
					+ "WHERE ga.level = :level ";
			
			try {
				em = createEntityManager(user, pass);
				em.getTransaction().begin();
				
				Query queryGeo = em.createQuery(queryStringGeo)
						.setParameter("level", level);
					
								 
				listSubLevel = queryGeo.getResultList();
	
				
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
			
			return listSubLevel;
		}
		else {
			return listSubLevel;
		}
		
		
	}
	
	public List<GeographicArea> getSubProvince(String user, String pass) throws SQLException{
		
		List<GeographicArea> listSubLevel = new ArrayList<>();
		int level = 2;

		
		if(isConnected) {
			EntityManager em = null;
			
			String queryString = "FROM GeographicArea ga "
					+ "WHERE ga.level = :level";
			
			try {
				em = createEntityManager(user, pass);
				em.getTransaction().begin();
				
				Query queryGeo = em.createQuery(queryString)
						.setParameter("level", level);
								 
				listSubLevel = queryGeo.getResultList();
	
				
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
			
			return listSubLevel;
		}
		else {
			return listSubLevel;
		}
		
		
	}

	public List<GeographicArea> getSubCity(String user, String pass) throws SQLException{
		
		List<GeographicArea> listSubLevel = new ArrayList<>();
		int level = 3;
	
		
		if(isConnected) {
			EntityManager em = null;
			
			String queryString = "FROM GeographicArea ga "
					+ "WHERE ga.level = :level";
			
			try {
				em = createEntityManager(user, pass);
				em.getTransaction().begin();
				
				Query queryGeo = em.createQuery(queryString)
						.setParameter("level", level);
								 
				listSubLevel = queryGeo.getResultList();
	
				
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
			
			return listSubLevel;
		}
		else {
			return listSubLevel;
		}
		
		
	}
	
	public List<Age> getAgeGroups(String user, String pass) throws SQLException{
		
		List<Age> list = new ArrayList<>();
		
		if(isConnected) {
			EntityManager em = null;
			String queryString = "SELECT DISTINCT(a) "
					+ "FROM Age a "
					+ "WHERE a.ageGroup.ageGroupID IN (:nums) AND a.geographicArea.level = :levelCode ";
			List<Integer> nums = Arrays.asList(3, 9, 15, 22, 28, 34, 40, 46, 52, 58, 64, 70, 76, 83, 89, 95, 101, 108, 114, 120, 126);
			try {
				em = createEntityManager(user, pass);
				em.getTransaction().begin();
				
				Query query = em.createQuery(queryString);
				query.setParameter("nums", nums);
				query.setParameter("levelCode", 0);
				
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
	
	/**
	 * Part D for Assignment 2
	 * @return a list of data
	 */
	public List<Household> getHouseholdData(String user, String pass) throws SQLException{
		List<Household> list = new ArrayList<>();
		if(isConnected) {
			EntityManager em = null;
			String queryString = "FROM Household h "
					+ "WHERE h.censusYear.censusYear = :cenYear "
					+ "AND h.householdType.id = :houseType "
					+ "AND h.householdSize.id = :numPerson "
					+ "AND h.householdEarners.id = :houseEarn "
					+ "AND h.householdsByAgeRange.id = :hbar "
					+ "AND h.geographicArea.level = :geoLevel "
					+ "AND h.totalIncome.id = :totalInc "
					+ "ORDER BY h.numberReported DESC";
			
			try {
				em = createEntityManager(user, pass);
				em.getTransaction().begin();
				
				Query query = em.createQuery(queryString);
				query.setParameter("cenYear", 2016);
				query.setParameter("houseType", 4);
				query.setParameter("numPerson", 3);
				query.setParameter("houseEarn", 3);
				query.setParameter("hbar", 9);
				query.setParameter("geoLevel", 1);
				query.setParameter("totalInc", 22);
				
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
