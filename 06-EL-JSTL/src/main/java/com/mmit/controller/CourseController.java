package com.mmit.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmit.entity.Course;
@WebServlet({"/add-course"})
public class CourseController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", "addcourse");
		getServletContext().getRequestDispatcher("/course-add.jsp").forward(req, resp);
	} 
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get parameter data
		String name=req.getParameter("courseName");
		String price=req.getParameter("price");
		String level=req.getParameter("level");
		String duration=req.getParameter("duration");
		String date=req.getParameter("date");
	
		//create object
		Course course=new Course();
		course.setDuration(Integer.parseInt(duration));
		course.setLevel(level);
		course.setName(name);
		course.setPrice(Integer.parseInt(price));
		course.setStartDate(LocalDate.parse(date));
		//get session object
		HttpSession session=req.getSession(true);
		List<Course> list=(ArrayList<Course>)session.getAttribute("courselist");
		if(list==null)
			list=new ArrayList<Course>();
		//add new course object to session object
		list.add(course);
		//add list object to session object
		session.setAttribute("courselist", list);
			
		//invoke other web page(for display)
		//System.out.println("path :"+req.getContextPath());
		resp.sendRedirect(req.getContextPath());
	}

}