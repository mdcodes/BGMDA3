/*
 * Name: Michal Drahorat, Brody Gartner
 * Description: The Age Data Bean
 * Date: February 11th, 2018
 */

package prog3060.bgmd.beans;

import java.io.Serializable;

public class AgeDataBean implements Serializable{
	private static final long serialVersionUID = -445914988260860720L;
	
	private String groupName;
	private Integer malePopulation;
	private Integer femalePopulation;
	private Integer year;
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public AgeDataBean() {}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getMalePopulation() {
		return malePopulation;
	}

	public void setMalePopulation(Integer malePopulation) {
		this.malePopulation = malePopulation;
	}

	public Integer getFemalePopulation() {
		return femalePopulation;
	}

	public void setFemalePopulation(Integer femalePopulation) {
		this.femalePopulation = femalePopulation;
	}
	

}
