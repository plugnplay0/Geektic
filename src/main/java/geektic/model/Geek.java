package geektic.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

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
	private String sexe;
	private Date dtnaiss;
	private String mail;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(	name="geek_interet",
				joinColumns={@JoinColumn(name="geekId")},
				inverseJoinColumns={@JoinColumn(name="interetId")})
	private List<Interet> interets = new ArrayList<Interet>();
	
	public long getId() {
		return id;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getSexe() {
		return sexe;
	}
	
	public Date getDtnaiss() {
		return dtnaiss;
	}
	
	public String getMail() {
		return mail;
	}

	public List<Interet> getInterets() {
		return interets;
	}

	public int getAge() {
		Calendar now = Calendar.getInstance();
		Calendar naiss = Calendar.getInstance();
		naiss.setTime(this.dtnaiss);
		int age = now.get(Calendar.YEAR) - naiss.get(Calendar.YEAR);
		now.add(Calendar.YEAR, -age);
		if(naiss.after(now)) {
			age--;
		}
		return age;
	}
	
}
