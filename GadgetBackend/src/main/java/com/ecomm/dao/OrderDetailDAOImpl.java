package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.OrderDetail;


@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean paymentProcess(OrderDetail order)
	{
		try 
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(order);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	
	public boolean updateCartItemStatus(String username,int orderId) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("update Cart set status='P',OrderId=:orderId where username=:UserName and status='NP' ");
			query.setParameter("UserName", username);
			query.setParameter("orderId", orderId);
			int roweffected = query.executeUpdate();

			if(roweffected>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		catch(Exception e)
		{		
			System.out.println(e);
		     return false;
		}		
	}
	
	
}
