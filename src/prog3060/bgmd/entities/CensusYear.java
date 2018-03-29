/***
 * Name: Michal Drahorat
 * Description: The CensusYear class for the exercise
 * Date Created: February 19th, 2018
 */

package prog3060.bgmd.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="CENSUSYEAR", schema="APP")
public class CensusYear {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CENSUSYEARID", nullable=false)
	private int censusYearID;
	
	@Column(name="CENSUSYEAR", nullable=false)
	private int censusYear;
	
	@OneToMany(targetEntity=Age.class, mappedBy="censusYear")
	private Set<Age> ages;
	
	@OneToMany(targetEntity=Household.class, mappedBy="censusYear")
	private Set<Household> houses;

	public Set<Household> getHouses() {
		return houses;
	}

	public void setHouses(Set<Household> houses) {
		this.houses = houses;
	}

	public Set<Age> getAges() {
		return ages;
	}

	public void setAges(Set<Age> ages) {
		this.ages = ages;
	}

	public CensusYear() {
		// TODO Auto-generated constructor stub
	}

	public int getCensusYearID() {
		return censusYearID;
	}

	public void setCensusYearID(int censusYearID) {
		this.censusYearID = censusYearID;
	}

	public int getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(int censusYear) {
		this.censusYear = censusYear;
	}
	

}
