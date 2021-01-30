package com.mmit.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mmit.entity.Course;
import com.mmit.entity.Student;

public class StudentService {
	private EntityManager em;

	public StudentService(EntityManager em) {
		this.em=em;
	}

	public void saveStudent(Student student) {
		em.getTransaction().begin();
		if(em.contains(student)) {
			em.merge(student);
			
		}else
		em.persist(student);
		em.getTransaction().commit();
		
	}

	public List<Student> findAll() {
		TypedQuery<Student>query=em.createQuery("SELECT s FROM Student s",Student.class);
		List<Student>list=query.getResultList();
		return list;
	}

	public void delete(int id) {
		//find entity
	Student s=em.find(Student.class, id);
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
	}

	public Student findById(int id) {
			
			return em.find(Student.class, id);
	}

}
