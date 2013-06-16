package geektic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the TYPE database table.
 * 
 */
@Entity
public class Type {

	@Id
	@SequenceGenerator(name="TYPE_ID_GENERATOR", initialValue=1, sequenceName="ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TYPE_ID_GENERATOR")
	private long typeId;
	
	private String libelle;
	
	@OneToMany(mappedBy="type")
	private List<Interet> interets = new ArrayList<Interet>();

	public long getTypeId() {
		return typeId;
	}

	public String getLibelle() {
		return libelle;
	}

	public List<Interet> getInterets() {
		return interets;
	}
	
}
