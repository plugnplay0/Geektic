package geektic.dao;


import geektic.model.Type;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


@Repository
public class TypeDAO {

	@PersistenceContext
	private EntityManager entitymanager;
	
	public TypeDAO() {
		
	}
	
	public TypeDAO(EntityManager em) {
		entitymanager = em;
	}
	
	public void persist(Type type){
		entitymanager.persist(type);
	}
	
	public List<Type> findAll() {
		String jpql = "select t from Type as t order by t.typeId asc";
		TypedQuery<Type> query = entitymanager.createQuery(jpql, Type.class);
		return query.getResultList();
	}
	
}
