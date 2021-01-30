package com.mmit.shop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mmit.online.shop.Customer;
import com.mmit.online.shop.service.CustomerService;
@TestMethodOrder(OrderAnnotation.class)
class CustomerService_test {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private CustomerService service;
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
		service=new CustomerService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	@Test
	void updatCustomerEmail() {
		service.updateEmail("susu@gmail.com", 1);
		String mail=service.findById(1);
		assertEquals("susulay@gmail.com",mail);
	}
	
	//@Test
	void retrieveCustomerName() {
		List<String> list=service.serachwithLikeOperator("g");
		list.forEach(name->System.out.println(name));
	}
	
	//@Test
	void retrieveCustomerEmail() {
		List<String> list=service.findByEmailStartWith("t");
		list.forEach(c->{
			System.out.println(c);
		});
	}
	
	//@Test
	void retrieveCustomerCount() {
		long total=service.getNoOfCustomers();
		System.out.println("Total:"+total);
	}
	
	//@Test
	void retrieveCustomerByIds () {
		List<Customer> list=service.findByIds(2,6);
		list.forEach(c->{
		System.out.println(c.getName()+"\t"+c.getId());
		});
	}
	
	//@Test
	void retrieveCustomers() {
		List<Customer> list=service.findByName("su su");
		if(list!=null) {
			System.out.println(list.get(0).getEmail());
		}
	}
	
	//@Test
	void test_orderby_customer() {
		List<Customer> customerList=service.getCustomerNames();
		for (Customer customer : customerList) {
			System.out.println(customer.getName());
		}
	}

	//@Test
	//@Order(1)
	void test_customers() {
		service.createQueryInterface();
	}

	//@Test
	//@Order(2)
	void test_retrive_data() {
		//Query interface (dynamic query)
		Query query1=em.createQuery("SELECT c FROM Customer c");//not recommend
		//Customer c=(Customer) query1.getSingleResult();
		//TypedQuery<Customer> query2=
		//List<Customer> list=query1.getResultList();
		TypedQuery<Customer> query2=em.createQuery("SELECT c FROM Customer c",Customer.class);
		//List<Customer>list=query2.getResultList();
		
		TypedQuery<Customer> query3=em.createQuery("SELECT c FROM Customer c WHERE c.id=2",Customer.class);
		Customer c=query3.getSingleResult();//1
		
		List<Customer>list=query3.getResultList();//
		System.out.println("list"+list.size());
		Customer c1=list.get(0);
		
		assertEquals("12345678", c1.getPassword());
		//assertEquals(7,list.size());
	}
}
