package prog3060.bgmd.entities;

import javax.persistence.*;

@Entity @Table(name="HOUSEHOLD", schema="APP")
public class Household {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="GEOGRAPHICAREA")
	private GeographicArea geographicArea;
	
	@ManyToOne
	@JoinColumn(name="CENSUSYEAR")
	private CensusYear censusYear;
	
	@ManyToOne
	@JoinColumn(name="HOUSEHOLDTYPE")
	private HouseholdType householdType;
	
	@ManyToOne
	@JoinColumn(name="HOUSEHOLDSIZE")
	private HouseholdSize householdSize;
	
	@ManyToOne
	@JoinColumn(name="HOUSEHOLDSBYAGERANGE")
	private HouseholdsByAgeRange householdsByAgeRange;
	
	@ManyToOne
	@JoinColumn(name="HOUSEHOLDEARNERS")
	private HouseholdEarners householdEarners;
	
	@ManyToOne
	@JoinColumn(name="TOTALINCOME")
	private TotalIncome totalIncome;
	
	@Column(name="NUMBERREPORTED", nullable=false)
	private int numberReported;
	
	public Household() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GeographicArea getGeographicArea() {
		return geographicArea;
	}

	public void setGeographicArea(GeographicArea geographicArea) {
		this.geographicArea = geographicArea;
	}

	public CensusYear getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(CensusYear censusYear) {
		this.censusYear = censusYear;
	}

	public HouseholdType getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(HouseholdType householdType) {
		this.householdType = householdType;
	}

	public HouseholdSize getHouseholdSize() {
		return householdSize;
	}

	public void setHouseholdSize(HouseholdSize householdSize) {
		this.householdSize = householdSize;
	}

	public HouseholdsByAgeRange getHouseholdsByAge() {
		return householdsByAgeRange;
	}

	public void setHouseholdsByAge(HouseholdsByAgeRange householdsByAgeRange) {
		this.householdsByAgeRange = householdsByAgeRange;
	}

	public HouseholdEarners getHouseholdEarners() {
		return householdEarners;
	}

	public void setHouseholdEarners(HouseholdEarners householdEarners) {
		this.householdEarners = householdEarners;
	}

	public TotalIncome getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(TotalIncome totalIncome) {
		this.totalIncome = totalIncome;
	}

	public int getNumberReported() {
		return numberReported;
	}

	public void setNumberReported(int numberReported) {
		this.numberReported = numberReported;
	}

}
