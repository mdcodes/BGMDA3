/**
 * Names: Michal Drahorat, Brody Gartner
 * Description: The DAO for the Geographic Areas
 * 
 * Date: 2/16/18
 */
package prog3060.bgmd.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prog3060.bgmd.beans.ConnectionBean;
import prog3060.bgmd.entities.GeographicArea;

public class GeographicAreaDAO {
	
	/***
	 * Retrieves the corresponding Geographic areas based on a code passed from a radio button
	 */
	public List<GeographicArea> getGeoAreasByLevel(int level) throws SQLException
	{
		List<GeographicArea> gabList = new ArrayList<GeographicArea>();
		
		try(Connection connection = ConnectionBean.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT DISTINCT NAME FROM GEOGRAPHICAREA "
						+ "JOIN AGE "
						+ "ON GEOGRAPHICAREA.geographicAreaID = AGE.geographicArea "
						+ "WHERE LEVEL= " + level)){
			while(resultSet.next()) {
				GeographicArea gab = new GeographicArea();
//				gab.setName(resultSet.getString("NAME"));
				
				gabList.add(gab);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gabList;
	}
	
	/***
	 * Gets the details of the specific geographic area you clicked
	 * @param searchName the name of the geographic area
	 * @return the list of data
	 * @throws SQLException
	 */
	public List<GeographicArea> getSingleGeoArea(String searchName) throws SQLException
	{
		List<GeographicArea> gabList = new ArrayList<GeographicArea>();
		
		try(Connection connection = ConnectionBean.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT NAME, CODE, LEVEL, COMBINED FROM GEOGRAPHICAREA "
						+ "JOIN AGE "
						+ "ON GEOGRAPHICAREA.geographicAreaID = AGE.geographicArea "
						+ "WHERE NAME= " + "'" + searchName + "'")){
			while(resultSet.next()) {
//				GeographicArea gab = new GeographicArea();
//				gab.setName(resultSet.getString("NAME"));
//				gab.setCode(resultSet.getInt("CODE"));
//				gab.setLevel(resultSet.getInt("LEVEL"));
//				gab.setTotalPopulation(resultSet.getInt("COMBINED"));
//				gabList.add(gab);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gabList;
	}
}
