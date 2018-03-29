package prog3060.bgmd.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="HOUSEHOLDSIZE", schema="APP")
public class HouseholdSize {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private int id;
	
	@Column(name="DESCRIPTION", nullable=false)
	private String description;
	
	@OneToMany(targetEntity=Household.class, mappedBy="householdSize")
	private Set<Household> houses;
	
	public Set<Household> getHouses() {
		return houses;
	}
	public void setHouses(Set<Household> houses) {
		this.houses = houses;
	}
	public HouseholdSize() {
		// TODO Auto-generated constructor stub
	}
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

}
