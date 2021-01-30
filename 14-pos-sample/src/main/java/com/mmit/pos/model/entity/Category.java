package com.mmit.pos.model.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@NamedQuery(name="Category.getAll",query="SELECT c FROM Category c ORDER BY c.name DESC")
@Table(name="category")
public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
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
