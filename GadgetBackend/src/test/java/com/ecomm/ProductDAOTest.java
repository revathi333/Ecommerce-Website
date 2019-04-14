package com.ecomm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest 
{
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.ecomm");
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product = new Product();
		product.setCategoryId(79);
		product.setPrice(60000);
		product.setProductDesc("With AI Technology");
		product.setStock(10);
		product.setProductName("Samsung Note 8"); 
		product.setSupplierId(1003);
		
		assertTrue("Problem in adding Product to Database",productDAO.addProduct(product));
		
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product = productDAO.getProduct(91);
		
		assertTrue("Problem in deleting Product from Database",productDAO.deleteProduct(product));
		
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product = productDAO.getProduct(92);
		product.setSupplierId(151);

		assertTrue("Problem in deleting Product to Database",productDAO.updateProduct(product));
		
	}
	
	@Ignore
	@Test
	public void listProducts()
	{
		List<Product> listProducts = productDAO.listProducts();
		
		assertTrue("Problem in Listing Products from Database",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getProductId()+ "  ");
			System.out.print(product.getProductName()+ "  ");
			System.out.print(product.getPrice()+ "  ");
			System.out.print(product.getProductDesc()+ "  ");
			System.out.print(product.getStock()+ "  ");
			System.out.print(product.getCategoryId()+ "  ");
			System.out.println(product.getSupplierId());
		}
	}

	@Ignore
	@Test
	public void listProductsByCategoryID()
	{
		List<Product> listProducts = productDAO.getProductsByCategoryID(80);
		
		assertTrue("Problem in Listing Products based on CategoryID from Database",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getProductId()+ "  ");
			System.out.print(product.getProductName()+ "  ");
			System.out.print(product.getPrice()+ "  ");
			System.out.print(product.getProductDesc()+ "  ");
			System.out.print(product.getStock()+ "  ");
			System.out.print(product.getCategoryId()+ "  ");
			System.out.println(product.getSupplierId());
		}
	}
	
	
}
