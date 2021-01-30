package com.mmit.service;

import java.util.List;

import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mmit.entity.Course;

public class CourseService {
	private EntityManager em;
	
	public CourseService(EntityManager em) {
		this.em=em;
	}

	public void saveCourse(Course course) {
		
		
		em.getTransaction().begin();
		if(em.contains(course))
			em.merge(course);
		else 
			em.persist(course);
		em.getTransaction().commit();
		
	}

	public List<Course> findAll() {
		TypedQuery<Course>query=em.createQuery("SELECT c FROM Course c",Course.class);
		List<Course>list=query.getResultList();
		return list;
	}

	public void delete(int id) {
		//find entity
		Course c=em.find(Course.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
	}

	public Course findById(int id) {
		
		return em.find(Course.class, id);
	}

}
