package com.ecomm.dao;

import java.util.List;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category)
	{
		try
		{		   
			Session session = sessionFactory.getCurrentSession();
		    session.saveOrUpdate(category);
		    return true;
		}
		
		catch(JDBCException e)
		{
			System.out.println(e);	         
			return false;
		}
	}

	
	public Category getCategory(int categoryID)
	{
		Session session = sessionFactory.openSession();
		Category category=(Category) session.get(Category.class,categoryID);
		session.close();
        return category;
		
	}
	

	public boolean deleteCategory(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
		    
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}

	}

	
	public boolean updateCategory(Category category)
	{

		try
		{
			sessionFactory.getCurrentSession().update(category);
		    
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	
	public List<Category> listCategories()
	{

		try
		{
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Category");
			
            List<Category> listCategories =(List<Category>) query.list();
            session.close();
			return listCategories;
		}
		
		catch(Exception e)
		{
			return null;
		}
	}
	
	
}
