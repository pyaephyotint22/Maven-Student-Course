package com.mmit.online.shop;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity

public class Item implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	private LocalDate expiredate;
	@ManyToOne(optional = false, fetch = LAZY, cascade = REMOVE)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;
	
	
	public Item() {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(LocalDate expiredate) {
		this.expiredate = expiredate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
   
}
