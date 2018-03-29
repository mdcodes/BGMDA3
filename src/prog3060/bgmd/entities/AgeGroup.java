/***
 * Name: Michal Drahorat
 * Description: The AgeGroup class for the exercise
 * Date Created: February 19th, 2018
 */

package prog3060.bgmd.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity @Table(name="AGEGROUP", schema="APP")
public class AgeGroup {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AGEGROUPID", nullable=false)
	private int ageGroupID;
	
	@Column(name="DESCRIPTION", nullable=false)
	private String description;
	
	@OneToMany(targetEntity=Age.class, mappedBy="ageGroup")
	private Set<Age> ages;

	public Set<Age> getAges() {
		return ages;
	}

	public void setAges(Set<Age> ages) {
		this.ages = ages;
	}

	public AgeGroup() {
		// TODO Auto-generated constructor stub
	}

	public int getAgeGroupID() {
		return ageGroupID;
	}

	public void setAgeGroupID(int ageGroupID) {
		this.ageGroupID = ageGroupID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
