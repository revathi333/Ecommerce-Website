package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Credits;
import com.ecomm.model.OrderDetail;

public interface CreditsDAO 
{
	public boolean generateCredits(OrderDetail order,Credits order_credits);
	public OrderDetail getOrder(int OrderId);
	public List<Credits> listCredits(String username);
	public Credits getCredits(int creditsId);

}
