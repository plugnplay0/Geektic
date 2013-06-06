package geektic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private long id;
	private String type;
	private String libelle;
	
}
