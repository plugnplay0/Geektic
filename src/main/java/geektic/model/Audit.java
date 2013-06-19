package geektic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import java.sql.Timestamp;


/**
 * The persistent class for the AUDIT database table.
 * 
 */
@Entity
public class Audit {

	@Id
	@SequenceGenerator(name="AUDIT_ID_GENERATOR", initialValue=1, sequenceName="audit_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUDIT_ID_GENERATOR")
	private long auditId;
	
	private Timestamp dateHeure;
	private String ip;
	
	@ManyToOne(targetEntity=Geek.class)
	@JoinColumn(name="geekId", referencedColumnName="geekId")
	private Geek geek;

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public Timestamp getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(Timestamp dateHeure) {
		this.dateHeure = dateHeure;
	}

	public Geek getGeek() {
		return geek;
	}

	public void setGeek(Geek geek) {
		this.geek = geek;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
