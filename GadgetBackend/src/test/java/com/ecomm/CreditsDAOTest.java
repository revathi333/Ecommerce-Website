package com.ecomm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CreditsDAO;
import com.ecomm.model.Credits;
import com.ecomm.model.OrderDetail;

public class CreditsDAOTest 
{
	   static CreditsDAO creditsDAO;

	   @BeforeClass
	   public static void initialize()
	   {
	        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.ecomm");
	   
	        creditsDAO = (CreditsDAO) context.getBean("creditsDAO"); 
	   }
	   
	   @Ignore
	   @Test
	   public void generateCredits()
	   {
		   OrderDetail order = creditsDAO.getOrder(378);
		   Credits order_credits = new Credits();
		   assertTrue("Problem in Generating Credits",creditsDAO.generateCredits(order,order_credits));
	   }
	   
	   
	   
	   @Test
	   public void listCategoriesTest()
	   {
		List<Credits> listCredits  =   creditsDAO.listCredits("revti");
		assertTrue("Problem in Listing Credits from DataBase",listCredits.size()>0);
		
		   for(Credits credits:listCredits)
		    {
			     System.out.print(credits.getOrderTotal()+ "   ");
			     System.out.println(credits.getCredits());
			
		    }
	   }	
	   
}
