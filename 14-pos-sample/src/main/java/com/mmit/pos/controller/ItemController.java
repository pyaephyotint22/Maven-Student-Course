package com.mmit.pos.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmit.pos.model.entity.Category;
import com.mmit.pos.model.entity.Item;
import com.mmit.pos.model.service.CategoryService;
import com.mmit.pos.model.service.ItemService;
@WebServlet(urlPatterns = {"/items","/item-add","/item-save","/item-edit"},loadOnStartup = 1)
public class ItemController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private CategoryService catService;
	private ItemService itemService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		EntityManagerFactory emf=(EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory("pos-sample");
			getServletContext().setAttribute("emf", emf);
		}
		catService=new CategoryService(emf.createEntityManager());
		itemService=new ItemService(emf.createEntityManager());
		
	}
	@Override
	public void destroy() {
		EntityManagerFactory emf=(EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf!=null && emf.isOpen())
			emf.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getServletPath();
		if("/items".equals(action)) {
			//retrieve item list from db
			List<Item>list=itemService.findAll();
			//add list to req obj
			req.setAttribute("itemlist", list);
			//invoke other resource to display
			getServletContext().getRequestDispatcher("/items.jsp").forward(req, resp);
		}
		else if("/item-add".equals(action) || "/item-edit".equals(action)) {
			
			String itemid=req.getParameter("id");
			Item i=(itemid !=null &&  !itemid.isEmpty()) ? itemService.findById(Integer.parseInt(itemid)) : new Item();
			req.setAttribute("item", i);
		
			getServletContext().getRequestDispatcher("/item-add.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String expired=req.getParameter("expired");
		String catId=req.getParameter("category");
		String itemid=req.getParameter("itemid");
		
		//create item object
		Item item=(itemid.equals("0") ? new Item() : itemService.findById(Integer.parseInt(itemid)));
		item.setName(name);
		item.setPrice(Integer.parseInt(price));
		item.setExpiredate(expired !=null ? LocalDate.parse(expired) : null);
		item.setCategory(catService.findById(Integer.parseInt(catId)));
		//save it to db
		itemService.save(item);
		//invoke other resource to display
		resp.sendRedirect(req.getContextPath().concat("/items"));
	}

}
