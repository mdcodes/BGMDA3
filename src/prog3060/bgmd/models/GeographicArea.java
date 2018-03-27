package prog3060.bgmd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GEOGRAPHICAREA", schema="APP")
public class GeographicArea {
	
	public GeographicArea() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="GEOGRAPHICAREAID", nullable=false)
	private int geographicAreaId;
	
    @Column(name="CODE", nullable=false)
	private int code;
	
    @Column(name="LEVEL", nullable=false)
	private int level;
	
    @Column(name="NAME", nullable=false)
	private String name;
    
    @Column(name="ALTERNATIVECODE", nullable=false)
	private int alternativeCode;
	
    public int getGeographicAreaId() {
		return geographicAreaId;
	}
    
	public void setGeographicAreaId(int geographicAreaId) {
		this.geographicAreaId = geographicAreaId;
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
