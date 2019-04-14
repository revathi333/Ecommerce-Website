package com.ecomm.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

@Controller
public class UserController 
{
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	

    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public String addUser(Model m, @RequestParam("username")String username,@RequestParam("customerName")String customerName,@RequestParam("address")String address, @RequestParam("password")String password)
    {
    	    	
    	UserDetail userDetail=new UserDetail();
    	userDetail.setAddress(address);
    	userDetail.setCustomerName(customerName);
    	userDetail.setEnabled(true);
    	userDetail.setRole("ROLE_USER");
    	userDetail.setPassword(password);
    	userDetail.setUsername(username);
    	
    	userDetailDAO.registerUser(userDetail);
				
		return "Login";
    	
	}
    
    @RequestMapping(value="/addSeller",method=RequestMethod.POST)
    public String addSeller(Model m, @RequestParam("username")String username,@RequestParam("sellerName")String customerName,@RequestParam("address")String address, @RequestParam("password")String password)
    {
    	    	
    	UserDetail userDetail=new UserDetail();
    	userDetail.setAddress(address);
    	userDetail.setCustomerName(customerName);
    	userDetail.setEnabled(true);
    	userDetail.setRole("ROLE_ADMIN");
    	userDetail.setPassword(password);
    	userDetail.setUsername(username);
    	
    	userDetailDAO.registerUser(userDetail);
				
		return "Login";
    	
	}
    
    
    
	@RequestMapping(value="/login_success")
	public String loginCheck(Model m,HttpSession session)
	{
		String page="";
		boolean loggedIn=false;
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
			}
			else
			{
                m.addAttribute("pageinfo","User Home");
				
				List<Product> listProducts=productDAO.listProducts();
				m.addAttribute("productList", listProducts);

				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);	
				
				List<Cart> listCartItems = cartDAO.listCartItems(username);
				session.setAttribute("cartsize", listCartItems.size());

				
            }
		}
		return page;
	}

	
}
