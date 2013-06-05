package geektic.model;

import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the SPECTACLE database table.
 * 
 */
@Entity
public class Geek {
	
	@Id
	@SequenceGenerator(name="SPECTACLE_ID_GENERATOR", initialValue=1, sequenceName="ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SPECTACLE_ID_GENERATOR")
	private long id;
	private String pseudo;
	private String nom;
	private String prenom;
	private char sexe;
	private Date dtnaiss;
	private String mail;
	
}
