package com.mmit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.mmit.entity.Item;
import com.mmit.service.ItemService;

@Named
@RequestScoped
public class ItemBean {

		private Item item;
		private List<Item>itemlist;
		@Inject
		private ItemService service;
		
		@PostConstruct
		public void init() {
			String id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("itemid");
			if(id==null)
				item=new Item();
			else
				item=service.findById(Integer.parseInt(id));
			itemlist=service.findAll();
		}
		public String remove(int id) {
			service.delete(id);
			
			return "items?faces-redirect=true";
		}
		
		public String save() {
			
			service.saveItem(item);
			return "items?faces-redirect=true";
		}
		
		
		public Item getItem() {
			return item;
		}
		public void setItem(Item item) {
			this.item = item;
		}
		public List<Item> getItemlist() {
			return itemlist;
		}
		public void setItemlist(List<Item> itemlist) {
			this.itemlist = itemlist;
		}
		
}
