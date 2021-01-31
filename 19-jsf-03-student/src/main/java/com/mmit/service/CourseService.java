package com.mmit.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mmit.entity.Courses;


@Stateless
public class CourseService {

	@PersistenceContext
	private EntityManager em;
	

	public Courses findById(int id) {
		
		return em.find(Courses.class, id);
	}

	public List<Courses> findAll() {
		
		return em.createNamedQuery("Course.getAll", Courses.class).getResultList();
	}

	public void saveCourse(Courses course) {
		
		if(course.getId()==0)
			em.persist(course);
		else
			em.merge(course);
		
	}

	public void delete(int id) {
		Courses i=em.find(Courses.class, id);
		 em.remove(i);
		
	}

	
}
