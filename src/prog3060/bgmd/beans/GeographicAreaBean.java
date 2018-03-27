/**
 * Names: Michal Drahorat, Brody Gartner
 * Description: The Geographic Area bean
 * 
 * Date: 2/16/18
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

public class GeographicAreaBean implements Serializable
{
	private static final long serialVersionUID = -6100677911558918963L;
	
	private String name;
	private Integer code;
	private Integer level;
	private Integer totalPopulation;
	
	public GeographicAreaBean() {}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Integer getCode() 
	{
		return code;
	}

	public void setCode(int code) 
	{
		this.code = code;
	}

	public Integer getLevel() 
	{
		return level;
	}

	public void setLevel(int level) 
	{
		this.level = level;
	}

	public Integer getTotalPopulation() 
	{
		return totalPopulation;
	}

	public void setTotalPopulation(int totalPopulation) 
	{
		this.totalPopulation = totalPopulation;
	}
}
