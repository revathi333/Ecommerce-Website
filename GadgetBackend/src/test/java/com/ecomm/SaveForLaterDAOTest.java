package com.ecomm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SaveForLaterDAO;
import com.ecomm.model.SaveForLater;


public class SaveForLaterDAOTest 
{
	 static SaveForLaterDAO saveForLaterDAO;
	   
	   @BeforeClass
	   public static void initialize()
	   {
	        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.ecomm");
	   
	        saveForLaterDAO = (SaveForLaterDAO) context.getBean("saveForLaterDAO"); 
	   }
	   
	   @Ignore
	   @Test
	   public void addSavedItem()
	   {
		   SaveForLater savedItem=new SaveForLater();
		   savedItem.setPrice(36999);
		   savedItem.setProductId(158);
		   savedItem.setProductName("iPhone6S");
		   savedItem.setUsername("revti");
		   assertTrue("Problem in adding savedItem to DataBase",saveForLaterDAO.addSavedItem(savedItem));
	   }
	   
	   @Ignore
	   @Test
	   public void deleteCategoryTest()
	   {
		   SaveForLater savedItem=saveForLaterDAO.getSavedItem(241);
		   assertTrue("Problem in Deleting savedItem from DataBase",saveForLaterDAO.deleteSavedItem(savedItem));
	   }
	   
	 
	 
	   @Ignore
	   @Test
	   public void listCategoriesTest()
	   {
		   List<SaveForLater> savedItemsList =  saveForLaterDAO.savedItemsList("revti");
		   assertTrue("Problem in Listing savedItems from DataBase",savedItemsList.size()>0);
		   
		   for(SaveForLater item:savedItemsList)
		   {
			   System.out.print(item.getSavedItemId()+"  ");
			   System.out.print(item.getProductName()+"   ");
			   System.out.print(item.getProductId()+"   ");
			   System.out.print(item.getPrice()+"   ");
			   System.out.println(item.getUsername()+"   ");
		   }
	   
	   }

}
