package com.mmit.bean;

import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.mmit.entity.Category;
import com.mmit.service.CategoryService;

@Named
@Dependent
public class CategoryConverter implements Converter<Category>{
	@Inject
	private CategoryService service;
	//String->object
	@Override
	public Category getAsObject(FacesContext context, UIComponent component, String value) {
		if(value!=null)
			return service.findById(value);
		return null;
	}
	//object=>String(id,1,2,3....) (client display)
	@Override
	public String getAsString(FacesContext context, UIComponent component, Category value) {
		if(value!=null)
		
		return String.valueOf(value.getId());
		return null;
	}

}
