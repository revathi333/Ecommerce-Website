package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SaveForLaterDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;
import com.ecomm.model.SaveForLater;

@Controller
public class CartController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SaveForLaterDAO saveForLaterDAO;
	
	@RequestMapping("/Cart")
	public String DisplayCart(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("cartsize", listCartItems.size());
		m.addAttribute("CartValue", this.CartValue(listCartItems));
		
		List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
		m.addAttribute("count", savedItemsList.size());
		m.addAttribute("savedItemsList", savedItemsList);
		session.setAttribute("cartsize", listCartItems.size());
			
		return "CartDisplay";
	}
	
	//Add to Cart from Total Product Display Page
	
	@RequestMapping(value="/addToCart/{productId}")
	public String addToCart(Model m,@PathVariable("productId")int productID,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		Product product =productDAO.getProduct(productID);
		
		Cart cartItem = new Cart();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setStatus("NP");
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(1);
		cartItem.setUsername(username);
		
		cartDAO.addCartItem(cartItem);
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("cartsize", listCartItems.size());
		m.addAttribute("CartValue", this.CartValue(listCartItems));
		
		List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
		m.addAttribute("count", savedItemsList.size());
		m.addAttribute("savedItemsList", savedItemsList);
		session.setAttribute("cartsize", listCartItems.size());

		return "CartDisplay";
	}
	
	//Calculating Total Cart Value
	
	public int CartValue(List<Cart> listCartItems)
	{
		int total=0;
		for(Cart item:listCartItems)
		{
			total=total+(item.getQuantity()*item.getPrice());
		}
		return total;
	}

	
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");

		Cart cartItem = cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("cartsize", listCartItems.size());
		m.addAttribute("CartValue", this.CartValue(listCartItems));
		
		List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
		m.addAttribute("count", savedItemsList.size());
		m.addAttribute("savedItemsList", savedItemsList);
		session.setAttribute("cartsize", listCartItems.size());

		
		return "CartDisplay";
 
	}
	
	
	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,Model m,@RequestParam("quantity")int quantity,HttpSession session)
	{
		String username=(String)session.getAttribute("username");

		Cart cartItem = cartDAO.getCartItem(cartItemId);
		cartItem.setUsername(username);
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);
		
		List<Cart> listCartItems = cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", listCartItems);
		m.addAttribute("cartsize", listCartItems.size());
		m.addAttribute("CartValue", this.CartValue(listCartItems));
		
		List<SaveForLater> savedItemsList = saveForLaterDAO.savedItemsList(username);
		m.addAttribute("count", savedItemsList.size());
		m.addAttribute("savedItemsList", savedItemsList);
		session.setAttribute("cartsize", listCartItems.size());

		return "CartDisplay";
 
	}
	
	
	
}
