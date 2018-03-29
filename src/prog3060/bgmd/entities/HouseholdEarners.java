package prog3060.bgmd.entities;

import java.util.Set;

import javax.persistence.*;

@Entity @Table(name="HOUSEHOLDEARNERS", schema="APP")
public class HouseholdEarners {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private int id;
	
	@Column(name="DESCRIPTION", nullable=false)
	private String description;
	
	@OneToMany(targetEntity=Household.class, mappedBy="householdEarners")
	private Set<Household> houses;

	public HouseholdEarners() {
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
