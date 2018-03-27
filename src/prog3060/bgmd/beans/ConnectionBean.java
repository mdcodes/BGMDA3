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
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

public class ConnectionBean implements Serializable
{
	private static final long serialVersionUID = -1059017970416601343L;
	
	private static final String CONNECTION_STRING="jdbc:derby://localhost:1527/CensusDB;user=user;password=123;";
	
	private static Connection connection;

	public ConnectionBean() {
		super();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Boolean OpenConnection(String username, String password) throws SQLException
	{	
		Properties connProps = new Properties();
		connProps.setProperty("user", username);
		connProps.setProperty("password", password);
		Connection connection = DriverManager.getConnection(CONNECTION_STRING, connProps);
		connection.createStatement().executeUpdate("SET SCHEMA APP");
		
		if(connection.isValid(10000)) {
			setConnection(connection);
			return true;
		}
		else {
			return false;
		}	
	}

	public static Connection OpenConnection() throws SQLException
	{	
		Connection connection = DriverManager.getConnection(CONNECTION_STRING);
		connection.createStatement().executeUpdate("SET SCHEMA APP");
		
		ConnectionBean.setConnection(connection);
		
		return connection;
	}
	
	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		ConnectionBean.connection = connection;
	}
	
	

}
