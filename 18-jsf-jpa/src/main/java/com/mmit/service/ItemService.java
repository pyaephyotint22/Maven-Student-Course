package com.mmit.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mmit.entity.Item;

@Stateless
public class ItemService {
	
	@PersistenceContext
	private EntityManager em;

	public List<Item> findAll() {
		
		return em.createNamedQuery("Item.getAll",Item.class).getResultList();
	}

	public void saveItem(Item item) {
		
		if(item.getId()==0)
			em.persist(item);
		else
			em.merge(item);
		
	}

	public void delete(int id) {
		Item i=em.find(Item.class, id);
		 em.remove(i);
		
	}

	public Item findById(int id) {
		
		return em.find(Item.class, id);
	}
}
