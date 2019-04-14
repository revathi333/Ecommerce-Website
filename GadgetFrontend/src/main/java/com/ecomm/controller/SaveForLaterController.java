package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SaveForLaterDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;
import com.ecomm.model.SaveForLater;

@Controller
public class SaveForLaterController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SaveForLaterDAO saveForLaterDAO;
	
	//Save for Later from Total Product Display Page
	
	@RequestMapping("/saveForLater/{productId}")
	public String addToSaveForLater(@PathVariable("productId")int productId,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");

		Product product = productDAO.getProduct(productId);

		SaveForLater savedItem = new SaveForLater();
		savedItem.setProductId(productId);
		savedItem.setProductName(product.getProductName());
		savedItem.setPrice(product.getPrice());
		savedItem.setUsername(username);
		
		saveForLaterDAO.addSavedItem(savedItem);
				
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
	
	//Save for Later from Cart Table 
	
		@RequestMapping("/moveTosaveForLater/{cartItemId}")
		public String moveToSaveForLater(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
		{
			String username=(String)session.getAttribute("username");
			
			Cart cartItem = cartDAO.getCartItem(cartItemId);

			Product product = productDAO.getProduct(cartItem.getProductId());

			SaveForLater savedItem = new SaveForLater();
			savedItem.setProductId(product.getProductId());
			savedItem.setProductName(product.getProductName());
			savedItem.setPrice(product.getPrice());
			savedItem.setUsername(username);
			
			saveForLaterDAO.addSavedItem(savedItem);
			
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

	//Move to Cart from Saved Items List
	
			@RequestMapping(value="/moveToCart/{savedItemId}")
			public String moveToCart(Model m,@PathVariable("savedItemId")int savedItemId,HttpSession session)
			{
				String username=(String)session.getAttribute("username");
				
				SaveForLater savedItem =saveForLaterDAO.getSavedItem(savedItemId);
				
				Product product = productDAO.getProduct(savedItem.getProductId());
				
				if(product.getStock()>0)
				{
				Cart cartItem = new Cart();
				cartItem.setProductId(product.getProductId());
				cartItem.setProductName(product.getProductName());
				cartItem.setStatus("NP");
				cartItem.setPrice(product.getPrice());
				cartItem.setQuantity(1);
				cartItem.setUsername(username);
				
				cartDAO.addCartItem(cartItem);
				
				saveForLaterDAO.deleteSavedItem(savedItem);

				}
				
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
		
			
		//Delete from Saved for later list
			
		@RequestMapping(value="/deletesaveditem/{savedItemId}")
		public String deleteSavedItem(@PathVariable("savedItemId")int savedItemId,Model m,HttpSession session)
		{
			String username=(String)session.getAttribute("username");

			SaveForLater savedItem=saveForLaterDAO.getSavedItem(savedItemId);
			saveForLaterDAO.deleteSavedItem(savedItem);
			
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
}
