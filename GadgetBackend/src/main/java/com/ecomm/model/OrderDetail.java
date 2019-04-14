package com.ecomm.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class OrderDetail 
{
	@Id
	@GeneratedValue
	int OrderId;
	
	String username;
	Date OrderDate;
	int OrderTotal;	
	String paymentMode;
	
	
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	
	public int getOrderTotal() {
		return OrderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		OrderTotal = orderTotal;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
}
