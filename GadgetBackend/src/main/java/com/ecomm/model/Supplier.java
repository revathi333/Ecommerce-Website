package com.ecomm.model;

import javax.persistence.*;

@Entity
@Table
public class Supplier
{
	@Id
	@GeneratedValue
	int supplierId;
	
	String supplierName;
	
    int categoryId;
    
	String categoryName;
	
	int productId;  
	
	String productName;
	
	int supplierStock;
	
	int price;
	
	
    public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getSupplierStock() {
		return supplierStock;
	}
	public void setSupplierStock(int supplierStock) {
		this.supplierStock = supplierStock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
