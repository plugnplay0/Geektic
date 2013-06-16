package geektic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the INTERET database table.
 * 
 */
@Entity
public class Interet {

	@Id
	@SequenceGenerator(name="INTERET_ID_GENERATOR", initialValue=1, sequenceName="ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INTERET_ID_GENERATOR")
	private long interetId;
	
	@ManyToOne
	@JoinColumn(name="typeId")
	private Type type;
	
	private String libelle;
	
	@ManyToMany(mappedBy="interets")
	private List<Geek> geeks = new ArrayList<Geek>();
	
	public long getInteretId() {
		return interetId;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public List<Geek> getGeeks() {
		return geeks;
	}
	
	
	
}
