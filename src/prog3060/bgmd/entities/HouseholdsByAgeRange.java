package prog3060.bgmd.entities;
import java.util.Set;

import javax.persistence.*;

@Entity @Table(name="HOUSEHOLDSBYAGERANGE", schema="APP")
public class HouseholdsByAgeRange {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Household> getHouses() {
		return houses;
	}

	public void setHouses(Set<Household> houses) {
		this.houses = houses;
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private int id;
	
	@Column(name="DESCRIPTION", nullable=false)
	private String description;
	
	@OneToMany(targetEntity=Household.class, mappedBy="householdsByAgeRange")
	private Set<Household> houses;
	
	public HouseholdsByAgeRange() {
		// TODO Auto-generated constructor stub
	}

}
