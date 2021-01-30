package com.mmit.controller;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mmit.entity.Course;
import com.mmit.entity.Student;
import com.mmit.service.CourseService;
import com.mmit.service.StudentService;
@WebServlet(urlPatterns = {"/edit-student","/add-student","/students","/remove-student"},loadOnStartup = 1)
@MultipartConfig
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf;
	private StudentService service;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		Object object=getServletContext().getAttribute("entitymanagerfactory");

		if(object==null){
			emf=Persistence.createEntityManagerFactory("10-em-jsp");
			getServletContext().setAttribute("entitymanagerfactory", emf);
		}else {
			emf=(EntityManagerFactory) object;
		}
		service=new StudentService(emf.createEntityManager());
	}
	 @Override
		public void destroy() {
			if(emf!=null && emf.isOpen())
			emf.close();
		}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	     String action=req.getServletPath();
		
		if("/add-student".equals(action)) {
			req.setAttribute("title", "addstudent");
			getServletContext().getRequestDispatcher("/students.jsp");
		}
		else if("/students".equals(action))	{
			//get course list from db
			List<Student> list=service.findAll();
			
			//add list to request object
			req.setAttribute("studentlist",list);
			//invoke index.jsp to display data
			getServletContext().getRequestDispatcher("/students.jsp").forward(req, resp);
		}
		else if("/remove-student".equals(action)) {
			//get parameter
			String id=req.getParameter("studentId");
			//remove entity
			service.delete(Integer.parseInt(id));
			//invoke display
			resp.sendRedirect(req.getContextPath().concat("/students"));
			
		}
		else if("/edit-student".equals(action)) {
			
			int id=Integer.parseInt(req.getParameter("id"));
			
			//retrieve course entity from db
			Student s=service.findById(id);
			
			//radd course entity to request object
			req.setAttribute("studentlist",s );
			
			//invoke other web page
			req.setAttribute("title", "addstudent");
			getServletContext().getRequestDispatcher("/student-add.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get parameter data
	
		String id=req.getParameter("studentid");
				Part imgPart=req.getPart("photo");
				String name=req.getParameter("sname");
				String email=req.getParameter("email");
				String year=req.getParameter("year");
				String age=req.getParameter("age");
				String address =req.getParameter("address");
				String dateofbirth=req.getParameter("date");
				
				String imgFileName=imgPart.getSubmittedFileName();// user.jpg
				//System.out.println("imgFileName: "+imgFileName);
				String currentName=imgFileName.substring(0,imgFileName.lastIndexOf("."));//user
				//System.out.println("currentName: "+currentName);
				String newName=""+System.currentTimeMillis();//user123456787654
				//System.out.println("newName: "+newName);
				imgFileName=imgFileName.replace(currentName,newName);// user.jpg=>user123456787654.jpg
				
			
				//create object
				
				Student student=(id !=null && !id.isEmpty()? service.findById(Integer.parseInt(id)):new Student());

				student.setProfile(imgFileName);
				student.setName(name);
				student.setEmail(email);
				student.setAge(Integer.parseInt(age));
				student.setYear(year);
				student.setAddress(address);
				student.setDateOfBirth(LocalDate.parse(dateofbirth));
				
				
				// save client upload file in server
				String rootPath=getServletContext().getRealPath("");
				String dirPath=rootPath+File.separator+"imgUploads";
				File rootDir=new File(dirPath);
				if(!rootDir.exists())// check already exist imgUploads folder
					rootDir.mkdirs();
				imgPart.write(rootDir+File.separator+imgFileName);
				//System.out.println("path: "+rootPath);
				//System.out.println("dir: "+rootDir);
				
				//invoke other web page(for display)
				//System.out.println("path :"+req.getContextPath());
				//resp.sendRedirect(req.getContextPath());
				//getServletContext().getRequestDispatcher("/student.jsp").forward(req, resp);
				
				service.saveStudent(student);
				
				resp.sendRedirect(req.getContextPath().concat("/students"));

	
	}

}

