package com.mmit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.mmit.entity.Courses;
import com.mmit.service.CourseService;



@Named
@RequestScoped
public class CourseBean {

	private Courses course;
	private List<Courses>courselist;
	@Inject
	private CourseService service;
	
	@PostConstruct
	public void init() {
		String id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("courseid");
		if(id==null)
			course=new Courses();
		else
			course=service.findById(Integer.parseInt(id));
		courselist=service.findAll();
	}
	
	public String save() {
		
		service.saveCourse(course);
		return "index?faces-redirect=true";
	}
	
	public String remove(int id) {
		service.delete(id);
		return "index?faces-redirect=true";
		
	}
	
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	public List<Courses> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<Courses> courselist) {
		this.courselist = courselist;
	}
	
	
}
