/***
 * Name: Michal Drahorat
 * Description: The GeographicArea class for the exercise
 * Date Created: February 19th, 2018
 */

package prog3060.bgmd.entities;

import java.util.HashSet;
import javax.persistence.*;
import java.util.Set;

@Entity @Table(name="GEOGRAPHICAREA", schema="APP")
public class GeographicArea {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GEOGRAPHICAREAID")
	private int geographicAreaID;
	
	@Column(name="CODE", nullable=false)
	private int code;
	
	@Column(name="LEVEL", nullable=false)
	private int level;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="ALTERNATIVECODE", nullable=false)
	private int alternativeCode;
	
	@OneToMany(targetEntity=Age.class, mappedBy="geographicArea")
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

	public GeographicArea() {
		// TODO Auto-generated constructor stub
	}

	public int getGeographicAreaID() {
		return geographicAreaID;
	}

	public void setGeographicAreaID(int geographicAreaID) {
		this.geographicAreaID = geographicAreaID;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlternativeCode() {
		return alternativeCode;
	}

	public void setAlternativeCode(int alternativeCode) {
		this.alternativeCode = alternativeCode;
	}
}
