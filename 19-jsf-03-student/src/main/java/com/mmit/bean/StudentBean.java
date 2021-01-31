package com.mmit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


import com.mmit.entity.Student;
import com.mmit.service.StudentService;

@Named
@RequestScoped
public class StudentBean {

	private Student student;
	private List<Student>studentlist;
	
	@Inject
	private StudentService service;
	
	
	@PostConstruct
	public void init() {
		String id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("studentid");
		if(id==null)
			student=new Student();
		else
			student=service.findById(Integer.parseInt(id));
		studentlist=service.findAll();
	}
	
	public String save() {
		
		service.saveStudent(student);
		return "students?faces-redirect=true";
	}
	
	public String remove(int id) {
		service.delete(id);
		return "students?faces-redirect=true";
		
	}
	
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Student> getStudentlist() {
		return studentlist;
	}
	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}
	
	
}
