package geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import geektic.model.Geek;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GeekDAOTest {

	private static EntityManagerFactory emFactory;
	private EntityManager em;
	private GeekDAO dao;
	
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
		dao = new GeekDAO(em);
		em.getTransaction().begin();
	}
	
	@After
	public void tearDown() throws Exception {
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void findByIdTest() {
		Geek geek = dao.findById(2L);
		assertEquals("tourbilol", geek.getPseudo());
		assertEquals("GAREN", geek.getNom());
	}
	
	@Test
	public void findByCriteriaSexeTest() {
		List<Geek> geeks = dao.findByCriteria(null, null, null, "h");
		assertEquals(6, geeks.size());
	}

	@Test
	public void findByCriteriaMultipleTest() {
		List<Geek> geeks = dao.findByCriteria("&", "h2", null, "-");
		assertEquals(1, geeks.size());
		assertEquals(8, geeks.get(0).getGeekId());
	}
}
