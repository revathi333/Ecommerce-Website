package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/product")
	public String displayProduct(Model m)
	{	
		Product product = new Product();
		m.addAttribute("product",product);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		List<Category> listOfCategories = categoryDAO.listCategories();		
		m.addAttribute("listOfCategories", this.getCategory(listOfCategories));
		
		List<Supplier> listSuppliers =supplierDAO.listSuppliers();
		m.addAttribute("listOfSuppliers", this.getSupplier(listSuppliers));
		
		return "Product";
	}
	
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String addProduct(Model m,@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile image)
	{
		productDAO.addProduct(product);
		
		// Adding Image to file System
		
		int ProductId = product.getProductId();
		
		String path = "C:\\Users\\user\\eclipse-workspace\\GadgetFrontend\\src\\main\\webapp\\resources\\images\\";
		
		path = path+String.valueOf(ProductId)+".jpg";
		
		File myImageFile = new File(path);
		
		if(!image.isEmpty())
		{
			try
			{
				byte buff[] = image.getBytes();
				FileOutputStream fos = new FileOutputStream(myImageFile);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				bos.write(buff);
				bos.close();
			}
			
			catch(Exception e)
			{
				m.addAttribute("Error", "Error Occured during Image Uploading::"+e.getMessage());
			}
		}
		
		else
		{
			System.out.println("Error Occured While Uploading File");
			m.addAttribute("Error", "Error Occured during Image Uploading");
		}		
		
		// Adding Image Done
		
		Product emptyProductobj = new Product();
		m.addAttribute("product",emptyProductobj);
		
        List<Category> listOfCategories = categoryDAO.listCategories();		
		m.addAttribute("listOfCategories", this.getCategory(listOfCategories));
		
		List<Supplier> listSuppliers =supplierDAO.listSuppliers();
		m.addAttribute("listOfSuppliers", this.getSupplier(listSuppliers));
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		return "Product";
	}
	
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(Model m,@PathVariable("productId")int productId)
	{
		Product product = productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
        Product emptyProductobj = new Product();
		m.addAttribute("product",emptyProductobj);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		List<Category> listOfCategories = categoryDAO.listCategories();		
		m.addAttribute("listOfCategories", this.getCategory(listOfCategories));
		
		List<Supplier> listSuppliers =supplierDAO.listSuppliers();
		m.addAttribute("listOfSuppliers", this.getSupplier(listSuppliers));
			
		return "Product";
		
	}	
		

	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(Model m,@PathVariable("productId")int productId)
	{
		Product editableProduct = productDAO.getProduct(productId);

		m.addAttribute("editableProduct", editableProduct);		

		List<Category> listOfCategories = categoryDAO.listCategories();	
		m.addAttribute("listOfCategories", this.getCategory(listOfCategories));
		
		List<Supplier> listSuppliers =supplierDAO.listSuppliers();
		m.addAttribute("listOfSuppliers", this.getSupplier(listSuppliers));
		
		return "updateProduct";
	}

		
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)		
	public String updateProduct(Model m,@ModelAttribute("editableProduct")Product editableProduct)	
	{
		productDAO.updateProduct(editableProduct);
		
		Product emptyProductobj = new Product();
		m.addAttribute("product",emptyProductobj);
		
        List<Category> listOfCategories = categoryDAO.listCategories();
		m.addAttribute("listOfCategories", this.getCategory(listOfCategories));
		
		List<Supplier> listSuppliers =supplierDAO.listSuppliers();
		m.addAttribute("listOfSuppliers", this.getSupplier(listSuppliers));
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		return "Product";
	}
	
	
	@RequestMapping("/productsDisplay")
	public String displayProducts(Model m)
	{
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		return "ProductsDisplay";
	}
	
	
	@RequestMapping(value="/detailProductDisplay/{productId}")
	public String detailProductDisplay(@PathVariable("productId")int productId,Model m)
	{
		Product product = productDAO.getProduct(productId);	
		m.addAttribute("product",product);		
		return "TotalProductDisplay";
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
	
	
	public LinkedHashMap<Integer,String> getSupplier(List<Supplier> listSuppliers)
	{
		LinkedHashMap<Integer,String> listOfSuppliers = new LinkedHashMap<Integer,String>();
		
		for(Supplier supplier:listSuppliers)
		{
			listOfSuppliers.put(supplier.getSupplierId(), supplier.getSupplierName());
		}
		return listOfSuppliers;
	}
}
