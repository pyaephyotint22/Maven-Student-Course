package com.mmit.online.shop.service;

import javax.persistence.EntityManager;

import com.mmit.online.shop.Item;
import com.mmit.online.shop.Sale;
import com.mmit.online.shop.SaleDetail;

public class ItemService {

		private EntityManager em;
		public ItemService(EntityManager em) {
			this.em=em;
		}
		public Item findById(int id) {
			
			return em.find(Item.class,id);
		}
		
}
