package com.mmit;

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


@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		if("/register".equals(path)) {
			
			//get parameter data
			String username=req.getParameter("uname");
			String phoneno=req.getParameter("phone");
			String email=req.getParameter("email");
			
			//create object
			Employee emp=new Employee();
			emp.setEmail(email);
			emp.setLoginName(username);
			emp.setPhone(phoneno);
			
			//create session
			
			HttpSession session=req.getSession(true);
			
			//get data from session scope
			List<Employee>list=(ArrayList<Employee>)session.getAttribute("employeeList");
			if(list==null)
				list=new ArrayList<Employee>();
				
			//add emp obj list to session
			list.add(emp);
			session.setAttribute("employeeList", list);
			//invoke other web resource to display data
			//getServletContext().getRequestDispatcher("/display.jsp").forward(req, resp);
			
			resp.sendRedirect("display.jsp");
		
		}
		}
}