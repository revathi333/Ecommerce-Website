package com.ecomm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest 
{
   static CategoryDAO categoryDAO;
   
   @BeforeClass
   public static void initialize()
   {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.ecomm");
   
        categoryDAO = (CategoryDAO) context.getBean("categoryDAO"); 
   }
   
   @Ignore
   @Test
   public void addCategoryTest()
   {
	   Category category=new Category();
	   category.setCategoryName("Lenovo Mobiles");
	   category.setCategoryDesc("All Models of Lenovo Smart Phones");
	   
	   assertTrue("Problem in adding Category to DataBase",categoryDAO.addCategory(category));
   }
   
   @Ignore
   @Test
   public void deleteCategoryTest()
   {
	   Category category=categoryDAO.getCategory(93);
	   assertTrue("Problem in Deleting Category from DataBase",categoryDAO.deleteCategory(category));
   }
   
   @Ignore
   @Test
   public void updateCategoryTest()
   {
	   Category category=categoryDAO.getCategory(80);
	   category.setCategoryDesc("All Models of Apple iPhones");
	   assertTrue("Problem in Deleting Category from DataBase",categoryDAO.updateCategory(category));
   }
   
   @Ignore
   @Test
   public void listCategoriesTest()
   {
	List<Category> listCategories  =   categoryDAO.listCategories();
	assertTrue("Problem in Listing Categories from DataBase",listCategories.size()>0);
	
	for(Category category:listCategories)
	{
		System.out.print(category.getCategoryId()+ "   ");
		System.out.print(category.getCategoryName()+ "   ");
		System.out.println(category.getCategoryDesc());
		
	}
   
   }
   
   
}   
