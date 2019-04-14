package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addProduct(Product product)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(product);
			return true;
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		    return false;
		}
	}	

	public boolean updateProduct(Product product)
	{
		try
	    {
			Session session = sessionFactory.getCurrentSession();
			session.update(product);

		    return true;
	    }
	
	    catch(Exception e)
	    {
	        return false;
	    }
		
	}

	public boolean deleteProduct(Product product)
	{
		try
	    {
		    Session session=sessionFactory.getCurrentSession();
		    session.delete(product);
		    return true;
	    }
	
	    catch(Exception e)
	    {
	        return false;
	    }		
	}

	
	public Product getProduct(int productID)
	{
        Session session = sessionFactory.openSession();
        Product product = (Product) session.get(Product.class,productID);
		session.close();
		return product;
	}

	
	public List<Product> getProductsByCategoryID(int categoryID) 
	{
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Product where categoryId=:categoryID");
        query.setParameter("categoryID", categoryID);
        List<Product> listProducts = (List<Product>) query.list();
        session.close();
		return listProducts;
	}

	
	public List<Product> listProducts()
	{
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Product");
        List<Product> listProducts = (List<Product>) query.list();
        session.close();
		return listProducts;
	}

}
