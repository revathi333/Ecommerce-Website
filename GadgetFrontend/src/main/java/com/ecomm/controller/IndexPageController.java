package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexPageController 
{

	@RequestMapping("/login")
	public String showLoginPage()
	{
		return "Login";
	}
	
	@RequestMapping("/register")
	public String registerUser()
	{
		return "Register";
	}

	@RequestMapping("/home")
	public String home()
	{
		return "Home";
	}
	
	@RequestMapping("/registerSeller")
	public String registerSeller()
	{
		return "SellerRegister";
	}
	
	@RequestMapping("/creditsHomePage")
	public String creditsHomePage()
	{
		return "CreditsHomePage";
	}
	
	@RequestMapping("/CustomerService")
	public String CustomerService()
	{
		return "CustomerService";
	}
}
