package com.ecomm.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Credits
{
	@Id
	@GeneratedValue
	int creditsId;
	
	int credits;
	String username;
	int OrderId;
	Date OrderDate;
	int OrderTotal;
	
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public int getCreditsId() {
		return creditsId;
	}
	public void setCreditsId(int creditsId) {
		this.creditsId = creditsId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
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
	
}
