package com.ecomm;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.Cart;
import com.ecomm.model.Category;
import com.ecomm.model.Credits;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.Product;
import com.ecomm.model.SaveForLater;
import com.ecomm.model.Supplier;
import com.ecomm.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")
public class DBConfig 
{

	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("revathi");
		dataSource.setPassword("revathi");
		
		System.out.println("===========================DataSource Object Created===========================");
		
		return dataSource;	
	}
	
	
	@Bean(name="sessionFactory")
	public SessionFactory getsessionFactory(DataSource dataSource)
	{
		Properties HibernateProp=new Properties();
		HibernateProp.put("hibernate.hbm2ddl.auto","update");
		HibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(dataSource);
		factory.addProperties(HibernateProp);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Cart.class);
		factory.addAnnotatedClass(OrderDetail.class);
		factory.addAnnotatedClass(SaveForLater.class);
		factory.addAnnotatedClass(Credits.class);

		SessionFactory sessionFactory=factory.buildSessionFactory();
	
		System.out.println("===========================SessionFactory Object Created===========================");
		
		return sessionFactory;		
	}
	
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("===========================HibernateTransactionManager Object Created===========================");

		return new HibernateTransactionManager(sessionFactory);
	}
	
	
}
