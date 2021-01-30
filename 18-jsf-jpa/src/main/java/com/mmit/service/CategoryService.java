package com.mmit.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mmit.entity.Category;

@Stateless

public class CategoryService {

	@PersistenceContext
	private EntityManager em;
	
	public void saveCategory(Category category) {
		if(category.getId()==0)
		em.persist(category);//persist
		else
			em.merge(category);//edit
	}

	public List<Category> findAll() {
		
		return em.createNamedQuery("Category.getAll",Category.class).getResultList();
	}

	public Category findById(String id) {
		
		return em.find(Category.class, Integer.parseInt(id));
	}

	public void deleteCategory(int id) {
		
		Category c=em.find(Category.class, id);//merger state
		em.remove(c);
		
	}
}
