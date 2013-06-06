package geektic.model;

import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the GEEK database table.
 * 
 */
@Entity
public class Geek {
	
	@Id
	@SequenceGenerator(name="GEEK_ID_GENERATOR", initialValue=1, sequenceName="ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GEEK_ID_GENERATOR")
	private long id;
	private String pseudo;
	private String nom;
	private String prenom;
	private char sexe;
	private Date dtnaiss;
	private String mail;
	
}
