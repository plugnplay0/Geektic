package geektic.dao;


import geektic.model.Interet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


@Repository
public class InteretDAO {

	@PersistenceContext
	private EntityManager entitymanager;
	
	public InteretDAO() {
		
	}
	
	public InteretDAO(EntityManager em) {
		entitymanager = em;
	}
	
	public void persist(Interet interet){
		entitymanager.persist(interet);
	}
	
	public Interet findById(long interetId) {
		return entitymanager.find(Interet.class, interetId);
	}
	
}
