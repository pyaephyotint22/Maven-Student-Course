package com.mmit.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Item item;
	
	private List<Item> itemList;
	
	@PostConstruct
	private void init() {
		item=new Item();
		itemList=new ArrayList<>();
	}
	
	public void save() {
		itemList.add(item);
		System.out.println("name: "+item.getName());
		item=new Item();
		
		//return "index?faces-redirect=true";
		}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
}
