package com.mmit.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.Category;
import com.mmit.Item;

class Relationship_test {
private static EntityManagerFactory emf;
private  EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf=Persistence.createEntityManagerFactory("jpa-relationship");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
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

	@Test
	void test() {
		em.getTransaction().begin();
		
//		Category c=new Category();
//		c.setName("fruit");
//		em.persist(c);
//		
//		Item item1=new Item();
//		item1.setName("apple");
//		item1.setPrice(500);
//		item1.setCategory(c);
//		
//		em.persist(item1);
//		
//		Item item2=new Item();
//		item2.setName("orange");
//		item2.setPrice(300);
//		item2.setCategory(c);
//		em.persist(item2);
//		
		em.getTransaction().commit();
		//System.out.println("id: "+item1.getId());
		//System.out.println("id: "+item2.getId());
	}

}
