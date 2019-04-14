package com.ecomm;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.model.OrderDetail;


public class OrderDetailDAOTest 
{
   static OrderDetailDAO orderDetailDAO;
   
   @BeforeClass
   public static void initialize()
   {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.ecomm");
   
        orderDetailDAO = (OrderDetailDAO) context.getBean("orderDetailDAO"); 
   }
   
   
   @Ignore
   @Test
	public void paymentProcessTest()
	{
	   OrderDetail order = new OrderDetail();
	   order.setUsername("latha");
	   order.setOrderTotal(1500);
	   order.setOrderDate(new Date());
	   order.setPaymentMode("CC/DC");
	   
	   assertTrue("Problem in adding OrderDetail to Database",orderDetailDAO.paymentProcess(order));
	}

   @Ignore
   @Test
	public void updateCartItemStatusTest() 
	{
	   assertTrue("Problem in Updating OrderDetail to Database",orderDetailDAO.updateCartItemStatus("revti",119));

	}

}  