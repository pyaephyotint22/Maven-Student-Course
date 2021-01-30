package com.mmit;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
//	@OneToMany
//	private List<Item> items;
	@OneToMany
	@JoinTable(name = "item_category_tb",
	joinColumns = @JoinColumn(name = "categoryId"),
	inverseJoinColumns = @JoinColumn(name = "itemId"))
	private List<Item> items;
	public Category() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
   
}
