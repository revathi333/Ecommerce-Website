package com.ecomm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;

public class SupplierDAOTest 
{
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.ecomm");
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
	
		Supplier supplier = new Supplier();
	
		supplier.setCategoryId(80);
		supplier.setSupplierName("Bajaj Electronics");
		supplier.setCategoryName("Apple Iphone Mobiles");
		supplier.setPrice(45000);
		supplier.setProductId(90);
		supplier.setProductName("iPhone7");
		supplier.setSupplierStock(5);
	
		assertTrue("Problem in Adding Supplier to the DataBase",supplierDAO.addSupplier(supplier));
	}

	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier = supplierDAO.getSupplier(149);
		
		assertTrue("Problem in Deleting Supplier to the DataBase",supplierDAO.deleteSupplier(supplier));

	}
	
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier = supplierDAO.getSupplier(152);
		supplier.setSupplierName("BigC Mobiles");
		
		assertTrue("Problem in Updating Supplier to the DataBase",supplierDAO.updateSupplier(supplier));

	}
	
	
	@Ignore
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> listSuppliers = 	supplierDAO.listSuppliers();
		
		assertTrue("Problem in Retriving Supplier from the DataBase",listSuppliers.size()>0);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getSupplierId()+"  ");
			System.out.print(supplier.getSupplierName()+"  ");
			System.out.print(supplier.getCategoryId()+"  ");
			System.out.print(supplier.getCategoryName()+"  ");
			System.out.print(supplier.getProductId()+"  ");
			System.out.print(supplier.getProductName()+"  ");
			System.out.print(supplier.getPrice()+"  ");
			System.out.println(supplier.getSupplierStock());

		}

	}
	
	@Ignore
	@Test
	public void listSupplierByProductIDTest()
	{
		List<Supplier> listSuppliers = 	supplierDAO.listSupplierByProductID(90);
		
		assertTrue("Problem in Retriving Supplier to the DataBase",listSuppliers.size()>0);
		
		System.out.println("list of Suppliers By ProductID ");

		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getSupplierId()+"  ");
			System.out.print(supplier.getSupplierName()+"  ");
			System.out.print(supplier.getCategoryId()+"  ");
			System.out.print(supplier.getCategoryName()+"  ");
			System.out.print(supplier.getProductId()+"  ");
			System.out.print(supplier.getProductName()+"  ");
			System.out.print(supplier.getPrice()+"  ");
			System.out.println(supplier.getSupplierStock());

		}

	}
	
	@Ignore
	@Test
	public void listSupplierByCategoryIDTest()
	{
		List<Supplier> listSuppliers = 	supplierDAO.listSupplierByCategoryID(80);
		
		assertTrue("Problem in Retriving Supplier to the DataBase",listSuppliers.size()>0);
		
		System.out.println("list of Suppliers By CategoryID ");
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getSupplierId()+"  ");
			System.out.print(supplier.getSupplierName()+"  ");
			System.out.print(supplier.getCategoryId()+"  ");
			System.out.print(supplier.getCategoryName()+"  ");
			System.out.print(supplier.getProductId()+"  ");
			System.out.print(supplier.getProductName()+"  ");
			System.out.print(supplier.getPrice()+"  ");
			System.out.println(supplier.getSupplierStock());

		}

	}

	
	
}
