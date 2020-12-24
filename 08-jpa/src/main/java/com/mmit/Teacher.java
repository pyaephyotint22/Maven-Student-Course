package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity

public class Teacher implements Serializable {

	   
	@Id
	private int id;
	private String name;
	private String email;
	
	@Embedded
	private Address address;
	
	private static final long serialVersionUID = 1L;

	public Teacher() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
