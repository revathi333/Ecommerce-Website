package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.dao.CreditsDAO;
import com.ecomm.model.Credits;
import com.ecomm.model.OrderDetail;

@Controller
public class CreditsController 
{
	@Autowired
	CreditsDAO creditsDAO;
	
	//Generates 10% credits points on Order Total
	
	@RequestMapping(value="/generateCredits/{orderId}")
	public String generateOrderCredits(@PathVariable("orderId")int OrderId,Model m,HttpSession session)
	{
	    Credits order_credits = new Credits();
		OrderDetail  order = creditsDAO.getOrder(OrderId);		
		creditsDAO.generateCredits(order, order_credits);
		
		String username=(String)session.getAttribute("username");

		List<Credits> listCredits = creditsDAO.listCredits(username);
				
		m.addAttribute("listCredits", listCredits);
		
		//To retrieve the Credits Object created for the latest Order
		
		m.addAttribute("orderCredits", creditsDAO.getCredits(order_credits.getCreditsId()));
		
		m.addAttribute("O_Id",1);
		
		m.addAttribute("size",listCredits.size());
		
		m.addAttribute("totalCredits",this.totalCredits(listCredits));
		
		return "OrderCredits";
	}
	
	
	// To view Credit Statement
	
	@RequestMapping(value="/MyCredits")
	public String MyCredits(Model m,HttpSession session)
	{
	  	String username=(String)session.getAttribute("username");

		List<Credits> listCredits = creditsDAO.listCredits(username);
				
		m.addAttribute("listCredits", listCredits);
		
		m.addAttribute("O_Id",0);
		
		m.addAttribute("size",listCredits.size());
		
		m.addAttribute("totalCredits",this.totalCredits(listCredits));
		
		return "OrderCredits";
	}
	
	
	public int totalCredits(List<Credits> listCredits)
	{
		int total=0;
		for(Credits credits:listCredits)
		{
			total=total+(credits.getCredits());
		}
		return total;
	}
}
