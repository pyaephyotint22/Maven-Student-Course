package com.mmit.shop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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

import com.mmit.online.shop.Category;
import com.mmit.online.shop.Item;
import com.mmit.online.shop.service.CategoryService;
@TestMethodOrder(OrderAnnotation.class)

class CategoryService_test {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private CategoryService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf=Persistence.createEntityManagerFactory("jpa-entityRelationship");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}
	@BeforeEach
	void setUp() throws Exception {
		em=emf.createEntityManager();
		service=new CategoryService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	@Test
	@Order(1)
	void test_findById() {
		Category c=service.findById(3);
		assertNotNull(c);
		System.out.println("Name: "+c.getName());
		System.out.println("==============");
//		List<Item> list=c.getItemList();
//		assertNotNull(list);
//		System.out.println("size:"+list.size());
		Item item=em.find(Item.class, 1);
		assertNotNull(item);
		Category cat=item.getCategory();
		System.out.println("Cat Name of item id 1:"+cat.getName());
	}
	@Test
	@Order(2)
	void test_categoryreport() {
		List<Category> list=service.findAll();
		list.forEach(c->System.out.println(c.getName()));
	}
	@Test
	@Order(3)
	void test_findLatestCategory() {
		Category c=service.findLatestCategory();
		System.out.println(String.format("Id - %d, Name - %s", c.getId(),c.getName()));
	}
	@Test
	@Order(4)
	void test_startwith() {
		List<Category> list=service.startWith("s");
		list.forEach(c->System.out.println(String.format("Id - %d, Name - %s", c.getId(),c.getName())));
	}
	@Test
	@Order(5)
	void test_updatecategory() {
		service.editCategory(1, "Clothes");
		Category c=service.findById(1);
		assertEquals("Clothes",c.getName());
	}
	//@Test
	@Order(6)
	void test_removeById() {
		service.deleteCategory(5);
		Category c=service.findById(5);
		assertNull(c);
	}
	@Test
	@Order(7)
	void test_removeByIds() {
		service.deleteCategoryRange(2, 4);
		Category c=service.findById(3);
		assertNull(c);
	}
}
