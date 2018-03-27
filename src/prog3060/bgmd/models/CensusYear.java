package prog3060.bgmd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CENSUSYEAR", schema="APP")
public class CensusYear {
	
	public CensusYear() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CENSUSYEARID", nullable=false)
	private int censusYearId;
	
    @Column(name="CENSUSYEAR", nullable=false)
	private String CENSUSYEAR;

	public int getCensusYearId() {
		return censusYearId;
	}

	public void setCensusYearId(int censusYearId) {
		this.censusYearId = censusYearId;
	}

	public String getCENSUSYEAR() {
		return CENSUSYEAR;
	}

	public void setCENSUSYEAR(String cENSUSYEAR) {
		CENSUSYEAR = cENSUSYEAR;
	}

}
