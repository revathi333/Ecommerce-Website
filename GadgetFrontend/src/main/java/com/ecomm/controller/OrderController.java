package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.CreditsDAO;
import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.UserDetail;

@Controller
public class OrderController
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO; 
	
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@Autowired
	CreditsDAO creditsDAO;
	
	@RequestMapping("/checkout")
	public String checkout(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");

		List<Cart> listCartItems = cartDAO.listCartItems(username);
	    m.addAttribute("listCartItems", listCartItems);
	    m.addAttribute("CartValue", this.CartValue(listCartItems));
		session.setAttribute("cartsize", listCartItems.size());

		return "CheckoutPage";
	}
	
	@RequestMapping(value="/confirmAddress",method=RequestMethod.POST)
	public String confirmAddress(HttpSession session,Model m,@RequestParam("Name")String Name,@RequestParam("Number")String Number,@RequestParam("PinCode")String PinCode,@RequestParam("HouseAddress")String HouseAddress,@RequestParam("City")String City,@RequestParam("State")String State)
	{
		String username=(String)session.getAttribute("username");

		String Address = Name+" ,"+HouseAddress+" ,"+Number+" ,"+City+" ,"+State+" ,"+PinCode;
		
		UserDetail userdetail = userDetailDAO.getUser(username);
		userdetail.setAddress(Address);
		userDetailDAO.updateUser(userdetail);
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
	    m.addAttribute("CartValue", this.CartValue(listCartItems));
	    
		return "PaymentPage";
	}

	@RequestMapping(value="/confirmPayment",method=RequestMethod.POST)
	public String confirmPayment(Model m,@RequestParam("paymentMode")String paymentMode,HttpSession session)
	{
		String username=(String)session.getAttribute("username");

		List<Cart> listCartItems = cartDAO.listCartItems(username);
	    int Order_Total =  this.CartValue(listCartItems);
	    
		OrderDetail newOrder = new OrderDetail();
		newOrder.setPaymentMode(paymentMode);
		newOrder.setUsername(username);
		newOrder.setOrderTotal(Order_Total);
		newOrder.setOrderDate(new java.util.Date());
		orderDetailDAO.paymentProcess(newOrder);
		
		orderDetailDAO.updateCartItemStatus(username, newOrder.getOrderId());
		
		UserDetail userdetail = userDetailDAO.getUser(username);
		
		String Address = userdetail.getAddress();
		
	    m.addAttribute("listCartItems", listCartItems);
	    m.addAttribute("Address", Address);
	    m.addAttribute("CartValue", this.CartValue(listCartItems));
	    
	    m.addAttribute("orderId", newOrder.getOrderId());
	    m.addAttribute("orderDate", newOrder.getOrderDate());
	    m.addAttribute("orderTotal", newOrder.getOrderTotal());
	    m.addAttribute("orderPayment", newOrder.getPaymentMode());
	      
	    
	    // delete items in Cart after Receipt is done
		List<Cart> listCartItems2 = cartDAO.listCartItems(username);
	    for(Cart cartItem:listCartItems2)
	    {
	    	cartDAO.deleteCartItem(cartItem);
	    }
	    
	    session.setAttribute("cartsize",0);
	    return "Receipt";
	}
	

	public int CartValue(List<Cart> listCartItems)
	{
		int total=0;
		for(Cart item:listCartItems)
		{
			total=total+(item.getQuantity()*item.getPrice());
		}
		return total;
	}
}
