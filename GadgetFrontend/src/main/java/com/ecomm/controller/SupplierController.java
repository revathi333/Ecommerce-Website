package com.ecomm.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Supplier;

@Controller
public class SupplierController
{
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/supplier")
	public String displaySupplier(Model m)
	{	

        Supplier supplier = new Supplier();
		m.addAttribute("supplier",supplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		
		List<Category> listOfCategories = categoryDAO.listCategories();		
		m.addAttribute("listOfCategories", this.getCategory(listOfCategories));

		return "Supplier";
	}
	
	@RequestMapping(value="/InsertSupplier",method=RequestMethod.POST)
	public String addSupplier(Model m,@ModelAttribute("supplier")Supplier supplier)
	{
		supplierDAO.addSupplier(supplier);
		
        Supplier emptysupplier = new Supplier();
		m.addAttribute("supplier", emptysupplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		
		List<Category> listOfCategories = categoryDAO.listCategories();		
		m.addAttribute("listOfCategories", this.getCategory(listOfCategories));
		
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(Model m,@PathVariable("supplierId")int supplierId)
	{
		Supplier supplier = supplierDAO.getSupplier(supplierId);
        supplierDAO.deleteSupplier(supplier);
		
        Supplier emptysupplier = new Supplier();
		m.addAttribute("supplier", emptysupplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
			
		return "Supplier";
	}
	
	
	@RequestMapping(value="/editSupplier/{supplierId}")
	public String editSupplier(Model m,@PathVariable("supplierId")int supplierId)
	{
		Supplier ediatblesupplier = supplierDAO.getSupplier(supplierId);
		
		m.addAttribute("ediatblesupplier", ediatblesupplier);	
		
		List<Category> listOfCategories = categoryDAO.listCategories();		
		m.addAttribute("listOfCategories", this.getCategory(listOfCategories));

		return "updateSupplier";
	}

	
	@RequestMapping(value="/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(Model m,@ModelAttribute("ediatblesupplier")Supplier ediatblesupplier)
	{		
		supplierDAO.updateSupplier(ediatblesupplier);
		
		Supplier emptysupplierobj = new Supplier();
		m.addAttribute("supplier", emptysupplierobj);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		
		List<Category> listOfCategories = categoryDAO.listCategories();		
		m.addAttribute("listOfCategories", this.getCategory(listOfCategories));
			
		return "Supplier";
	}
	
	
	public LinkedHashMap<Integer,String> getCategory(List<Category> listCategories)
	{
		LinkedHashMap<Integer,String> listOfCategories = new LinkedHashMap<Integer,String>();
		
		for(Category category:listCategories)
		{
			listOfCategories.put(category.getCategoryId(), category.getCategoryName());
		}
		return listOfCategories;
	}

	
}
