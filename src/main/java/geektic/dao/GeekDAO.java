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
	
	public Geek findByPseudo(String pseudo) {
		return entitymanager.find(Geek.class, pseudo);
	}
	
	/*public List<Geek> findByNom(String nom) {
		String jpql =	"select g from Geek as g " +
						"where g.nom like(:nom)";
		TypedQuery<Geek> query = entitymanager.createQuery(jpql, Geek.class);
		query.setParameter("nom", "%"+nom+"%");
		return query.getResultList();
	}
	
	public List<Geek> findByPrenom(String prenom) {
		String jpql =	"select g from Geek as g " +
						"where g.nom like(:prenom)";
		TypedQuery<Geek> query = entitymanager.createQuery(jpql, Geek.class);
		query.setParameter("prenom", "%"+prenom+"%");
		return query.getResultList();
	}*/
	
	public List<Geek> findBySexe(String sexe) {
		String jpql =	"select g from Geek as g " +
						"where g.sexe = :sexe";
		TypedQuery<Geek> query = entitymanager.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe);
		return query.getResultList();
	}
	
	public List<Geek> findByCriteria(String pseudo, String nom, String prenom, String sexe, int agemin, int agemax, long interet1, long interet2, long interet3) {
		CriteriaBuilder qb = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Geek> cq = qb.createQuery(Geek.class);
		Root<Geek> geek = cq.from(Geek.class);
		
		//TODO prise en compte de la casse !
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(!StringUtils.isEmpty(nom)) {
			predicates.add(qb.like(geek.<String>get("nom"), "%" + nom + "%"));
		}
		if(!StringUtils.isEmpty(prenom)) {
			predicates.add(qb.like(geek.<String>get("prenom"), "%" + prenom + "%"));
		}
		
		cq.select(geek).where(predicates.toArray(new Predicate[]{}));
		return entitymanager.createQuery(cq).getResultList();
	}
	
}
