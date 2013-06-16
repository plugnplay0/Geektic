package geektic.dao;


import geektic.model.Interet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


@Repository
public class InteretDAO {

	@PersistenceContext
	private EntityManager entitymanager;
	
	public void persist(Interet interet){
		entitymanager.persist(interet);
	}
	
	public List<Interet> findAll() {
		String jpql = "select i from Interet as i order by i.interetId asc";
		TypedQuery<Interet> query = entitymanager.createQuery(jpql, Interet.class);
		return query.getResultList();
	}
	
	public Interet findById(long interetId) {
		return entitymanager.find(Interet.class, interetId);
	}
	
}
