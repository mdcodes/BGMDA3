/*
 * Name: Michal Drahorat, Brody Gartner
 * Description: The Age Data DAO
 * Date: February 11th, 2018
 */

package prog3060.bgmd.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prog3060.bgmd.beans.AgeDataBean;
import prog3060.bgmd.beans.ConnectionBean;

public class AgeDataDAO {
	
	public List<AgeDataBean> getAgeData(){
		List<AgeDataBean> ageData = new ArrayList<>();
		
		try(Connection connection = ConnectionBean.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT DISTINCT AGEGROUP, GEOGRAPHICAREA, DESCRIPTION, MALE, FEMALE, CENSUSYEAR.CENSUSYEAR "
						+ "FROM AGE "
						+ "JOIN AGEGROUP "
						+ "ON AGE.ageGroup = AGEGROUP.ageGroupId "
						+ "JOIN CENSUSYEAR "
						+ "ON AGE.censusYear = CENSUSYEAR.censusYearID "
						+ "JOIN GEOGRAPHICAREA "
						+ "ON AGE.geographicArea = GEOGRAPHICAREA.geographicAreaId "
						+ "WHERE AGEGROUP IN (3, 9, 15, 22, 28, 34, 40, 46, 52, 58, 64, 70, 76, 83, 89, 95, 101, 108, 114, 120, 126) "
						+ "AND GEOGRAPHICAREA = 1 "
						+ "ORDER BY AGEGROUP, CENSUSYEAR.CENSUSYEAR")){
			while(resultSet.next()) {
				AgeDataBean adb = new AgeDataBean();
				adb.setGroupName(resultSet.getString("DESCRIPTION"));
				adb.setMalePopulation(resultSet.getInt("MALE"));
				adb.setFemalePopulation(resultSet.getInt("FEMALE"));
				adb.setYear(resultSet.getInt("CENSUSYEAR"));
				
				ageData.add(adb);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ageData;
	}

}
