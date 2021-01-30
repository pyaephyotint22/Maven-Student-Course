package com.mmit.pos.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.mmit.pos.model.entity.Item;

public class ItemService {
	
	private EntityManager em;
	public ItemService (EntityManager em) {
		this.em=em;
	}
	public void save(Item item) {
		
		em.getTransaction().begin();
		if(item.getId()==0)
			em.persist(item);
		else
			em.merge(item);
		em.getTransaction().commit();
	}
	public List<Item> findAll() {
	
		return em.createNamedQuery("Item.getAll",Item.class).getResultList();
	}
	public Item findById(int id) {
		
		return em.find(Item.class, id);
	}

}
