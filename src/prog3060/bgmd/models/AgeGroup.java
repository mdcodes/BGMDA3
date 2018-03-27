package prog3060.bgmd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AGEGROUP", schema="APP")
public class AgeGroup {
	
	public AgeGroup() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="AGEGROUPID", nullable=false)
	private int ageGroupId;
	
    @Column(name="DESCRIPTION", nullable=false)
	private String description;

	public int getAgeGroupId() {
		return ageGroupId;
	}

	public void setAgeGroupId(int ageGroupId) {
		this.ageGroupId = ageGroupId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
