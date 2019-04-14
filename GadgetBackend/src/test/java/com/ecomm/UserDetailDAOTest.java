package com.ecomm;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.UserDetail;

public class UserDetailDAOTest 
{
	static UserDetailDAO userDetailDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.ecomm");
		   
		userDetailDAO = (UserDetailDAO) context.getBean("userDetailDAO"); 
	}

	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail userdetail = new UserDetail();
		userdetail.setUsername("geetha");
		userdetail.setPassword("well234");
		userdetail.setRole("Customer");
		userdetail.setCustomerName("Geetha Govind");
		userdetail.setAddress("Mumbai");
		userdetail.setEnabled(true);
	
		assertTrue("Problem in Registering UserDetail in Database",userDetailDAO.registerUser(userdetail));
	}
	
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		UserDetail userdetail = userDetailDAO.getUser("geetha");
		userdetail.setEnabled(false);;
		assertTrue("Problem in Updating UserDetails in Database",userDetailDAO.updateUser(userdetail));
    }
	
}
