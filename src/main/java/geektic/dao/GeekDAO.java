package geektic.dao;

import geektic.model.Geek;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


@Repository
public class GeekDAO {

	@PersistenceContext
	private EntityManager entitymanager;
	
	public void persist(Geek geek){
		entitymanager.persist(geek);
	}
	
	public List<Geek> findAll() {
		String jpql = "select g from Geek as g";
		TypedQuery<Geek> query = entitymanager.createQuery(jpql, Geek.class);
		return query.getResultList();
	}
	
	public Geek findById(long geekId) {
		return entitymanager.find(Geek.class, geekId);
	}
	
	/*public List<Geek> findByInteret(long interet) {
		System.out.println("INTERET : " + interet);
		List<Geek> liste = new ArrayList<Geek>();
		String jpql =	"select Geek_Interet.geekId " +
						"from Geek_Interet " +
						"where Geek_Interet.interetId = :interet";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("interet", interet);
		List<Long> geekIds = query.getResultList();
		for(long id : geekIds) {
			liste.add(findById(id));
		}
		return liste;
	}*/
	
	public List<Geek> findByCriteria(String pseudo, String nom, String prenom, String sexe) {
		CriteriaBuilder qb = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Geek> cq = qb.createQuery(Geek.class);
		Root<Geek> geek = cq.from(Geek.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
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
