package com.ecomm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;
import com.ecomm.model.Cart;


public class CartDAOTest 
{
   static CartDAO cartDAO;
   
   @BeforeClass
   public static void initialize()
   {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.ecomm");
   
        cartDAO = (CartDAO) context.getBean("cartDAO"); 
   }
   
   @Ignore
   @Test
   public void addCategoryTest()
   {
	   Cart cartItem=new Cart();
	   cartItem.setProductId(90);
	   cartItem.setProductName("Samsung Note 8	");
	   cartItem.setQuantity(1);
	   cartItem.setStatus("Not Purchased");
	   cartItem.setUsername("latha");
	   
	   assertTrue("Problem in adding cartItem to DataBase",cartDAO.addCartItem(cartItem));
   }
   
   @Ignore
   @Test
   public void deleteCategoryTest()
   {
	   Cart cartItem=cartDAO.getCartItem(117);
	   assertTrue("Problem in Deleting cartItem from DataBase",cartDAO.deleteCartItem(cartItem));
   }
   
   @Ignore
   @Test
   public void updateCategoryTest()
   {
	   Cart cartItem=cartDAO.getCartItem(114);
	   cartItem.setStatus("Not Purchased");
	   assertTrue("Problem in updating cartItem from DataBase",cartDAO.updateCartItem(cartItem));
	   
	   Cart cartItem2=cartDAO.getCartItem(115);
	   cartItem2.setStatus("Not Purchased");
	   assertTrue("Problem in updating cartItem from DataBase",cartDAO.updateCartItem(cartItem2));
   }
   
   
   @Ignore
   @Test
   public void listCategoriesTest()
   {
	List<Cart> listCartItems  =   cartDAO.listCartItems("revti");
	assertTrue("Problem in Listing CartItems from DataBase",listCartItems.size()>0);
	
	for(Cart cartItem:listCartItems)
	{
		System.out.print(cartItem.getCartItemId()+ "  ");
		System.out.print(cartItem.getUsername()+ "  ");
		System.out.println(cartItem.getProductName()+ "  ");
	}
   
   }
   
   
}   
