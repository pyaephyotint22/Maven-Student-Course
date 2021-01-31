package com.mmit.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mmit.entity.Courses;
import com.mmit.entity.Student;

@Stateless
public class StudentService {
	
	
	@PersistenceContext
	private EntityManager em;

	

	public List<Student> findAll() {
		return em.createNamedQuery("Student.getAll", Student.class).getResultList();
	}

	public Student findById(int id) {
		return em.find(Student.class, id);
		
	}

	public void delete(int id) {
		Student i=em.find(Student.class, id);
		 em.remove(i);
		
	}

	public void saveStudent(Student student) {
	
		if(student.getId()==0)
			em.persist(student);
		else
			em.merge(student);
		
		
	}
	
	

}
