package geektic.dao;

import geektic.model.Audit;
import geektic.model.Geek;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


@Repository
public class GeekDAO {

	@PersistenceContext
	private EntityManager entitymanager;
	
	public GeekDAO() {
		
	}
	
	public GeekDAO(EntityManager em) {
		entitymanager = em;
	}
	
	public void persist(Geek geek) {
		entitymanager.persist(geek);
	}
	
	public Geek findById(long geekId) {
		return entitymanager.find(Geek.class, geekId);
	}
	
	public void majConsultation(long geekId) throws UnknownHostException {
		// MAJ du compteur dans la table Geek
		Geek geek = findById(geekId);
		geek.incrementerConsult();
		entitymanager.merge(geek);
		// Ajout d'une ligne dans la table Audit
		DateTime dt = DateTime.now();
		Timestamp ts = new Timestamp(dt.getMillis());
		Audit audit = new Audit();
		audit.setDateHeure(ts);
		audit.setGeek(geek);
		audit.setIp(InetAddress.getLocalHost().getHostAddress());
		entitymanager.persist(audit);
	}
	
	public List<Geek> findByCriteria(String pseudo, String nom, String prenom, String sexe) {
		CriteriaBuilder qb = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Geek> cq = qb.createQuery(Geek.class);
		Root<Geek> geek = cq.from(Geek.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		// Empêcher la sélection du geek 'flag'
		predicates.add(qb.notEqual(geek.<Long>get("geekId"), 0));
		// Les pseudos sont des valeurs sans doublons, mais on peut ne rechercher qu'une partie du pseudo
		if(!StringUtils.isEmpty(pseudo)) {
			predicates.add(qb.like(qb.lower(geek.<String>get("pseudo")), "%" + pseudo.toLowerCase() + "%"));
		}
		// Nom
		if(!StringUtils.isEmpty(nom)) {
			predicates.add(qb.like(qb.lower(geek.<String>get("nom")), "%" + nom.toLowerCase() + "%"));
		}
		// Prénom
		if(!StringUtils.isEmpty(prenom)) {
			predicates.add(qb.like(qb.lower(geek.<String>get("prenom")), "%" + prenom.toLowerCase() + "%"));
		}
		// Sexe
		if(!sexe.equals("-")) {
			predicates.add(qb.equal(geek.<String>get("sexe"), sexe));
		}
		
		cq.select(geek).where(predicates.toArray(new Predicate[]{}));
		return entitymanager.createQuery(cq).getResultList();
	}
	
}
