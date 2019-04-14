package com.ecomm.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addSupplier(Supplier supplier)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(supplier);
			return true;
	    }
		
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.delete(supplier);
			return true;
	    }
		
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) 
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.update(supplier);
			return true;
	    }
		
		catch(Exception e)
		{
			return false;
		}
	}

	public Supplier getSupplier(int ID) 
	{
		Session session = sessionFactory.openSession();
		Supplier supplier = (Supplier) session.get(Supplier.class, ID);
		session.close();
		return supplier;

	}

	public List<Supplier> listSuppliers() 
	{
		try
		{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		
		List<Supplier> listSuppliers = (List<Supplier>) query.list();
		session.close();
		
		return listSuppliers;
		}
		
		catch(Exception e)
		{
			return null;
		}

	}

	public List<Supplier> listSupplierByProductID(int productID) 
	{
		try
		{
			Session session = sessionFactory.openSession();

			Query query = session.createQuery("from Supplier where productId=:productID");
			query.setParameter("productID", productID);
			List<Supplier> listSuppliers = (List<Supplier>) query.list();
			session.close();
			return listSuppliers;


		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Supplier> listSupplierByCategoryID(int categoryID)
	{
		try
		{
			Session session = sessionFactory.openSession();

			Query query = session.createQuery("from Supplier where categoryId=:categoryID");
			query.setParameter("categoryID", categoryID);
			List<Supplier> listSuppliers = (List<Supplier>) query.list();
			session.close();
			return listSuppliers;


		}
		catch(Exception e)
		{
			return null;
		}
	}

}
