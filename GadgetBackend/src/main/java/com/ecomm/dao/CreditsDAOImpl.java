package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Credits;
import com.ecomm.model.OrderDetail;

@Repository("creditsDAO")
@Transactional
public class CreditsDAOImpl implements CreditsDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean generateCredits(OrderDetail order,Credits order_credits) 
	{
		try
		{
			
			order_credits.setOrderDate(order.getOrderDate());
			order_credits.setOrderTotal(order.getOrderTotal());
			order_credits.setOrderId(order.getOrderId());
			order_credits.setUsername(order.getUsername());

			int points = (order.getOrderTotal())/10;
			order_credits.setCredits(points);
			
			sessionFactory.getCurrentSession().save(order_credits);
			return true;
		}
		
		catch(Exception e)
		{
		return false;
		}
		
	}	

	public OrderDetail getOrder(int OrderId)
	{
		Session session = sessionFactory.openSession();
		OrderDetail order = (OrderDetail) session.get(OrderDetail.class,OrderId);
		session.close();
		return order;
	}

	public List<Credits> listCredits(String username)
	{
		try
		{
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Credits where username=:username");
			query.setParameter("username", username);
			
            List<Credits> listCredits = (List<Credits>) query.list();
            session.close();
			return listCredits;
		}
		
		catch(Exception e)
		{
			return null;
		}
	}

	public Credits getCredits(int creditsId)
	{
		Session session = sessionFactory.openSession();
		Credits credits = (Credits) session.get(Credits.class,creditsId);
		session.close();
		return credits;
	}

}
