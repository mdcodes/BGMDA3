/**
 * Names: Michal Drahorat, Brody Gartner
 * Description: The temporary connection class
 * 
 * Date: 2/16/18
 */

package prog3060.bgmd.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import prog3060.bgmd.beans.*;

public class ConnectionStuff {
	
	public static Connection conn;
	private static final String CONNECTION_STRING="jdbc:derby://localhost:1527/CensusDB;";
	
	public static Boolean OpenConnection(String username, String password) throws SQLException
	{	
		Properties connProps = new Properties();
		connProps.setProperty("user", username);
		connProps.setProperty("password", password);
		Connection connection = DriverManager.getConnection(CONNECTION_STRING, connProps);
		connection.createStatement().executeUpdate("SET SCHEMA APP");
		
		if(connection.isValid(10000)) {
			conn = connection;
			return true;
		}
		else {
			return false;
		}	
	}

}
