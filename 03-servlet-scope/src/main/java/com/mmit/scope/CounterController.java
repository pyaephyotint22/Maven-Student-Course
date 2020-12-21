package com.mmit.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/count")
public class CounterController extends HttpServlet {
	
	
	private static final String COUNTER="counter";
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//request scope
			Object reqObj=req.getAttribute(COUNTER);
			Counter reqCounter=null;
			if(reqObj!=null) {
				reqCounter=(Counter)reqObj;
				}else {
					reqCounter=new Counter();
				}
				reqCounter.increateCount();
				req.setAttribute(COUNTER, reqCounter);
				
				
				//session scope
				HttpSession session=req.getSession(true);
				Object sessionObj=session.getAttribute(COUNTER);
				Counter sessionCounter=null;
				if(sessionObj!=null)
					sessionCounter=(Counter) sessionObj;
				else
					sessionCounter=new Counter();
				sessionCounter.increateCount();
				session.setAttribute(COUNTER, sessionCounter);
				
				//application scope web context scope
					ServletContext app=req.getServletContext();
					Object appObj=app.getAttribute(COUNTER);
					Counter appCounter=null;
					if(appObj!=null)
						appCounter=(Counter)appObj;
					else
						appCounter=new Counter();
					appCounter.increateCount();
					app.setAttribute(COUNTER, appCounter);
					
					//resp.sendRedirect("index.jsp");
					getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
					
		
	}

}
