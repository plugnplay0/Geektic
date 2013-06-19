package geektic.dao;

import static org.junit.Assert.assertEquals;
import geektic.model.Interet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InteretDAOTest {

	private static EntityManagerFactory emFactory;
	private EntityManager em;
	private InteretDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emFactory = Persistence.createEntityManagerFactory("geektic");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emFactory.close();
	}
	
	@Before
	public void setUp() throws Exception {
		em = emFactory.createEntityManager();
		dao = new InteretDAO(em);
		em.getTransaction().begin();
	}
	
	@After
	public void tearDown() throws Exception {
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void findByIdTest() {
		Interet interet = dao.findById(4L);
		assertEquals(1, interet.getType().getTypeId());
		assertEquals("Diablo", interet.getLibelle());
	}
}
