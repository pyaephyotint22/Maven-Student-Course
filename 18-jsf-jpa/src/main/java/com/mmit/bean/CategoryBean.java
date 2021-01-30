package com.mmit.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.mmit.entity.Category;
import com.mmit.service.CategoryService;

@Named
@RequestScoped
public class CategoryBean {
	
	private Category category;
	private List<Category> categorylist;
	
	@EJB
	private CategoryService service;
	@PostConstruct
	private void init() {
			ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
			Map<String, String>	params=context.getRequestParameterMap();
			String id=params.get("categoryid");
			if(id==null)
		category=new Category();
			else
				category=service.findById(id);
		categorylist=service.findAll();
	}
	
	public String save() {
		System.out.println("name"+category.getName());
		service.saveCategory(category);
		return "home?faces-redirect=true";
	}
	
	public String delete(int id) {
		
		service.deleteCategory(id);
		return "home?faces-redirect=true";
	}
	
	public Category getCategory() {
		return category;
	}
	
	public List<Category> getCategorylist() {
		return categorylist;
	}
	public void setCategorylist(List<Category> categorylist) {
		this.categorylist = categorylist;
	}
	

}
