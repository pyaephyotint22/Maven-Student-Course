package com.mmit;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.FetchType.EAGER;


/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
@Table(name= "students")
public class Student implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name= "student_name")
	private String name;
	@Column(unique = true)
	@Basic(optional = false)
	private int rno;
	@ElementCollection
	@Column(name="phone")
	@CollectionTable(joinColumns = @JoinColumn(name = "student_id"), name="phone_tb")
	private List<String> phones;
	public Student() {
		super();
	}
   
}
