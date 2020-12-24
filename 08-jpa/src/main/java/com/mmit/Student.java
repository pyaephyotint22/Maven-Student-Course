package com.mmit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import static javax.persistence.AccessType.PROPERTY;
import javax.persistence.Basic;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
@Entity
@Table(name= "students")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	
	@Column(name= "student_name")
	private String username;
	
	@Column(name= "mail", unique = true, nullable = true, length = 30)
	private String email;
	
	@Column(name="dateofBirth")
	@Temporal(DATE)
	private Date dob;
	
	
    @Transient
	private boolean is_active;
    
    @Embedded
    private Address address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
