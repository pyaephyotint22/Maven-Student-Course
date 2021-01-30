package com.mmit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CategoryBean {
	private List<String> categories=new  ArrayList<>();

	public List<String> getCategories() {
		return categories;
	}
	@PostConstruct
	private void initialize() {
		categories.add("FOODS");
		categories.add("JUCIES");
		categories.add("SNACKS");
		categories.add("FRUITS");
		categories.add("NOODLES");
	}
	public CategoryBean() {
		categories=new ArrayList<>();
		
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
}
