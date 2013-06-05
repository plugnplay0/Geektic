package geektic.dao;

import geektic.model.Geek;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


@Repository
public class GeekDAO {

	@PersistenceContext
	private EntityManager entitymanager;
	
	public void persist(Geek geek){
		entitymanager.persist(geek);
	}
	
	public Geek findById(long id) {
		return entitymanager.find(Geek.class, id);
	}
	
	public Geek findByPseudo(String pseudo) {
		return entitymanager.find(Geek.class, pseudo);
	}
	
	public List<Geek> findBySexe(char sexe) {
		String jpql = "select g from GEEK as g " +
						"where  g.sexe = :sexe ";
		TypedQuery<Geek> query = entitymanager.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe);
		return query.getResultList();
	}
	
}
