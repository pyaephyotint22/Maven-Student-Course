import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mmit.entities.course;
import com.mmit.entities.course.Level;
@TestMethodOrder(OrderAnnotation.class)
class EntityManager_Test {

	private static EntityManagerFactory emf;
	private EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf=Persistence.createEntityManagerFactory("09-jpa-em");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if(emf!=null && emf.isOpen())
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em=emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Order(1)
	@Test
	//persist entity
	public void entity_state_test() {
		//create entity instance
		course c=new course();//new state (transient)
		c.setCourseName("Java EE");
		c.setFees(300000);
		c.setLevel(Level.Advanced);
		c.setStartDate(Date.valueOf(LocalDate.now()));
		
		em.getTransaction().begin();
		em.persist(c);//managed state
			em.getTransaction().commit();
			
			assertEquals(1,c.getId());
		
	}
	@Order(2)
	@Test
	public void test5() {
		course c=em.find(course.class, 1);//managed
		
		em.getTransaction().begin();
		em.remove(c);//remove
		em.getTransaction().commit();
		
		course c1=em.find(course.class,1);
		
		assertNull(c1);
	}
	
	//@Order(2)
	//@Test
	public void test4() {//remove un-managed entity
		course c=em.find(course.class, 1);
		em.clear();//un-managed
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}
	
	//@Order(2)
	//@Test
	public void test3() {
		course c=em.find(course.class,1);
		em.clear();//un-managed
		
		em.getTransaction().begin();
		course c1=em.merge(c);
		c1.setFees(400000);
		em.getTransaction().commit();
	}
		
	
	
	//@Order(2)
	//@Test
	public void test2() {
		course c=em.find(course.class, 1);
		em.detach(c);//detach (un-manage)
		
		em.getTransaction().begin();
		c.setFees(400000);
		em.getTransaction().commit();
		
		course c1=em.find(course.class,1);
		assertEquals(400000,c.getFees());
		
	}
	
	
	
	//@Order(2)
	//@Test
	public void entity_find() {
		course c=em.find(course.class,1); //managed
		assertNotNull(c);
	}
	
	//@Order(3)
	//@Test
	public void test1() {
		course c=em.find(course.class,1);//managed
		em.getTransaction().begin();
		c.setFees(40000);
		em.getTransaction().commit();
		assertEquals(40000, c.getFees());
	}
}
