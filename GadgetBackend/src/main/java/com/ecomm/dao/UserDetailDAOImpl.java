package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.UserDetail;

@Repository("userDetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean registerUser(UserDetail userdetail)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(userdetail);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateUser(UserDetail userdetail)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.update(userdetail);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	
	public UserDetail getUser(String username) 
	{
		Session session = sessionFactory.openSession();
		UserDetail userdetail = session.get(UserDetail.class,username);
		session.close();
		return userdetail;
		
	}

}
