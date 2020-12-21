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

import com.mmit.entity.Student;
@WebServlet({"/add-student","/students"})
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", "addstudent");
		getServletContext().getRequestDispatcher("/student-add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get parameter data
				String name=req.getParameter("sname");
				String email=req.getParameter("email");
				String year=req.getParameter("year");
				String age=req.getParameter("age");
				String address =req.getParameter("address");
				String dateofbirth=req.getParameter("date");
			
				//create object
				Student student=new Student();
				student.setName(name);
				student.setEmail(email);
				student.setAge(Integer.parseInt(age));
				student.setYear(year);
				student.setAddress(address);
				student.setDateOfBirth(LocalDate.parse(dateofbirth));
				//get session object
				HttpSession session=req.getSession(true);
				List<Student> list=(ArrayList<Student>)session.getAttribute("studentlist");
				if(list==null)
					list=new ArrayList<Student>();
				//add new course object to session object
				list.add(student);
				//add list object to session object
				session.setAttribute("studentlist", list);
					
				//invoke other web page(for display)
				//System.out.println("path :"+req.getContextPath());
				//resp.sendRedirect(req.getContextPath());
				//getServletContext().getRequestDispatcher("/student.jsp").forward(req, resp);
				resp.sendRedirect("students.jsp");
	
	}

}

