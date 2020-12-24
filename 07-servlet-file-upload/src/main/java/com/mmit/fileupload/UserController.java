package com.mmit.fileupload;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/register")
@MultipartConfig
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get request data
		
		String username=req.getParameter("name");
		String email=req.getParameter("email");
		Part imgPart=req.getPart("photo");// file data
		
		String imgFileName=imgPart.getSubmittedFileName();// user.jpg
		//System.out.println("imgFileName: "+imgFileName);
		String currentName=imgFileName.substring(0,imgFileName.lastIndexOf("."));//user
		//System.out.println("currentName: "+currentName);
		String newName=""+System.currentTimeMillis();//user123456787654
		//System.out.println("newName: "+newName);
		imgFileName=imgFileName.replace(currentName,newName);// user.jpg=>user123456787654.jpg
		
		//System.out.println("After replace, imgFileName: "+imgFileName);
		// create user object
		Users newUser=new Users();	
		
		// add data to user object
		newUser.setEmail(email);
		newUser.setUsername(username);
		newUser.setProfile(imgFileName);
		
		// add user object to request scope
		req.setAttribute("userinfo", newUser);
		
		// save client upload file in server
		String rootPath=getServletContext().getRealPath("");
		String dirPath=rootPath+File.separator+"imgUploads";
		File rootDir=new File(dirPath);
		if(!rootDir.exists())// check already exist imgUploads folder
			rootDir.mkdirs();
		imgPart.write(rootDir+File.separator+imgFileName);
		//System.out.println("path: "+rootPath);
		//System.out.println("dir: "+rootDir);
		
		// invoke other web resource to display data.
		getServletContext().getRequestDispatcher("/display.jsp").forward(req, resp);
	
	}

}
