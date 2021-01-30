package com.mmit.online.shop;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@NamedQuery(name="Category.getAll",query="SELECT c FROM Category c ORDER BY c.name DESC")
@NamedQuery(name="Category.getNewestCategory", query="SELECT c FROM Category c WHERE c.id= (SELECT MAX(d.id) FROM Category d)")
@NamedQuery(name="Category.startWith",query="SELECT c FROM Category c WHERE c.name LIKE :start")
@Table(name="categories")
public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="category_name")
	private String name;
	@OneToMany(mappedBy = "category")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Item> itemList;
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
