package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

@Controller
public class CategoryController
{

	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/category")
	public String showCategory(Model m)
	{
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		return "Category";
	}
	
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String InsertCategory(@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		
		categoryDAO.deleteCategory(category);
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		return "Category";	
		
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		
		Category category = categoryDAO.getCategory(categoryId);
		m.addAttribute("editablecategory", category);
		
		return "updateCategory";
		
	}
	
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catId")int categoryId,@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		category.setCategoryDesc(categoryDesc);
		category.setCategoryName(categoryName);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categories",listCategories);
		return "Category";	
		
	}
	
}
