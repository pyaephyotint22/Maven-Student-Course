package com.mmit.pos.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.mmit.pos.model.entity.Category;

public class CategoryService {
	
	private EntityManager em;
	public CategoryService(EntityManager em) {
		this.em=em;
	}
	public List<Category> findAll() {
		
		return em.createNamedQuery("Category.getAll",Category.class).getResultList();
	}
	public Category findById(int id) {
		
		return em.find(Category.class, id);
	}
}
