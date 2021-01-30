package com.mmit.online.shop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Id;

import com.mmit.online.shop.Category;

public class CategoryService {

	private EntityManager em;
	public CategoryService(EntityManager em) {
		this.em=em;
	}
	public Category findById(int id) {
		
		return em.find(Category.class, id);
	}
	public List<Category> findAll() {
		
		return em.createNamedQuery("Category.getAll",Category.class).getResultList();
	}
	public Category findLatestCategory() {
		
		return em.createNamedQuery("Category.getNewestCategory",Category.class).getSingleResult();
	}
	public List<Category> startWith(String s) {
		
		return em.createNamedQuery("Category.startWith",Category.class)
				.setParameter("start", s.concat("%"))
				.getResultList();
	}
	public void editCategory(int id,String newname)
	{
		Category c=em.find(Category.class, id);
		em.getTransaction().begin();
		c.setName(newname);
		em.getTransaction().commit();
	}
	public void deleteCategory(int id) {
		Category c=em.find(Category.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}
	public void deleteCategoryRange(int from,int to) { 
		em.getTransaction().begin();
		 em.createQuery("DELETE FROM Category c WHERE c.id BETWEEN :val1 AND :val2")
		 .setParameter("val1", from)
		 .setParameter("val2", to)
		 .executeUpdate();
		em.getTransaction().commit();
	}
}
