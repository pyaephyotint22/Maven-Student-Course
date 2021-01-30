package com.mmit.pos.controller;

import java.io.IOException;
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
import com.mmit.pos.model.entity.Sale;
import com.mmit.pos.model.entity.SaleDetail;
import com.mmit.pos.model.service.CategoryService;
import com.mmit.pos.model.service.ItemService;
import com.mmit.pos.model.service.SaleService;

@WebServlet(urlPatterns = {"/home","/add-to-card","/cart-action"},loadOnStartup = 1)
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private CategoryService catService;
	private ItemService itemService;
	private SaleService saleService;
	
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
		saleService=new SaleService(emf.createEntityManager());
		//get category list from db
		List<Category>list=catService.findAll();
		getServletContext().setAttribute("categories", list);
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
		if("/add-to-card".equals(action)){
			addToCart(req);
		}
		
		getAllItems(req);
		
		getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
	}

	private void getAllItems(HttpServletRequest req) {
		//get item list from db
		List<Item> list=itemService.findAll();
		//add to req
		req.setAttribute("itemlist", list);
		
	}

	private void addToCart(HttpServletRequest req) {
		//get current item added to cart
		String itemid=req.getParameter("id");
		int currentitemId=Integer.parseInt(itemid);
		
		HttpSession session=req.getSession(true);
		Sale sale=(Sale) session.getAttribute("cart");
		if(sale==null)
			sale=new Sale();
		
		//verify currentitem is new or not?
		List<SaleDetail> saleitemlist=sale.getDetailList();
		boolean already_exist=false;
		for(SaleDetail sd: saleitemlist) {
			if(sd.getItem().getId()== currentitemId) {
				sd.setSubQty(sd.getSubQty()+1);
				already_exist=true;
				break;
			}
		}
		//new sale item
		if(!already_exist) {
			Item item=itemService.findById(currentitemId);
			SaleDetail  newsaleitem=new SaleDetail();
			newsaleitem.setItem(item);
			newsaleitem.setSubQty(1);
			sale.addSaleItem(newsaleitem);
		}
		session.setAttribute("cart", sale);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action=req.getParameter("btnAction");
		HttpSession session=req.getSession(true);
		if("Paid".equals(action)) {
			Sale sale=(Sale) session.getAttribute("cart");
			if(sale !=null && !sale.getDetailList().isEmpty())
			{
				//save to db
				saleService.save(sale);
				
			}		
		}
		//clear sale item from sale-record(cart)
		session.removeAttribute("cart");
		resp.sendRedirect(req.getContextPath().concat("/home"));
	}
}
