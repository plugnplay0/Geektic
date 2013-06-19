package geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import geektic.model.Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TypeDAOTest {

	private static EntityManagerFactory emFactory;
	private EntityManager em;
	private TypeDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emFactory = Persistence.createEntityManagerFactory("Typetic");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emFactory.close();
	}
	
	@Before
	public void setUp() throws Exception {
		em = emFactory.createEntityManager();
		dao = new TypeDAO(em);
		em.getTransaction().begin();
	}
	
	@After
	public void tearDown() throws Exception {
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void findAllTest() {
		List<Type> types = dao.findAll();
		assertEquals(3, types.size());
	}
}
