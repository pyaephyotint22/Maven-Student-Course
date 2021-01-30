package com.mmit.online.shop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.mmit.online.shop.Customer;

public class CustomerService {
	private EntityManager em;
	
	public CustomerService(EntityManager em) {
		this.em=em;
	}
	public void createQueryInterface() {
		//Query Interface(dynamic query)
				Query query=em.createQuery("SELECT c FROM Customer c");//not recommend
				
				//TypeQuery interface (dynamic qry)
				TypedQuery<Customer> query2=em.createQuery("SELECT c FROM Customer c",Customer.class);
				
				//Query Interface (static qry)
				Query query3=em.createNamedQuery("Customer.getAll");//not recommend
				
				//TypeQuery interface (static qry)
				TypedQuery<Customer> query4=em.createNamedQuery("Customer.getAll",Customer.class);
	}
		public List<Customer> getCustomerNames () {
			TypedQuery<Customer> query=em.createQuery("SELECT c FROM Customer c ORDER BY c.name DESC",Customer.class);
			List<Customer> list=query.getResultList();
			return list;
		}
		public List<Customer> findByName(String na) {
			TypedQuery<Customer> query=em.createNamedQuery("Customer.findByName",Customer.class);
			query.setParameter("custName", na);
			return query.getResultList();
		}
		public Long getNoOfCustomers() {
			TypedQuery<Long> query=em.createQuery("SELECT COUNT(c) FROM Customer c",Long.class);
			return query.getSingleResult();
		}
		public List<Customer> findByIds(int i, int j) {
			TypedQuery<Customer> query=em.createQuery("SELECT c FROM Customer c WHERE c.id>= :from AND c.id<= :to", Customer.class);
			query.setParameter("from", i);
			query.setParameter("to", j);
			return query.getResultList();
		}
		public List<String> findByEmailStartWith(String start){
			TypedQuery<String> query=em.createQuery("SELECT c.email FROM Customer c WHERE c.email LIKE:email", String.class);
			System.out.println("start: "+start.concat("%") );
			query.setParameter("email", start.concat("%"));
			return query.getResultList();
		}
		public List<String> serachwithLikeOperator(String keyword){
		return	em.createQuery("SELECT c.name FROM Customer c WHERE c.name LIKE :na",String.class)
				.setParameter("na","%".concat(keyword).concat("%"))
				.getResultList();
		}
		public void updateEmail(String newEmail,int id) {
			em.getTransaction().begin();
		    em.createQuery("UPDATE Customer c SET c.email = :email WHERE c.id= :id")
			.setParameter("email", newEmail)
			.setParameter("id", id)
			.executeUpdate();
			em.getTransaction().commit();
		}
		public String findById(int i) {
			TypedQuery<String> q=em.createQuery("SELECT c.email FROM Customer c WHERE c.id= :id",String.class);
			q.setParameter("id", i);
			return q.getSingleResult();
		}
}
