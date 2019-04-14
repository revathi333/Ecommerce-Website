package com.ecomm;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralDBConfigTest
{
	public static void main(String[] args)
	{
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.ecomm");
	
	  SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");

	  boolean state=sessionFactory.isClosed();
	
	  System.out.println("Is SessionFactory closed?"+"  "+state);

	}
}
