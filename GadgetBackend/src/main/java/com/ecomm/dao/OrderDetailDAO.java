package com.ecomm.dao;

import com.ecomm.model.OrderDetail;

public interface OrderDetailDAO 
{
	public boolean paymentProcess(OrderDetail order);
	public boolean updateCartItemStatus(String username,int orderId);
}
