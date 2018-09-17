package com.niit.controller;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.User;
import com.niit.userdao.CartItemDAO;
import com.niit.userdao.ProductDAO;

@Controller
public class CartItemController {
	@Autowired
private CartItemDAO cartItemDao;
	@Autowired
	private ProductDAO productDao;
    @RequestMapping(value="/cart/addtocart/{Id}")//5
	public String addToCart(@PathVariable int Id,@RequestParam int requestedQuantity
			,@AuthenticationPrincipal Principal principal){//in jsp userPrincipal, in controller Principal
    	if(principal==null)
    		return "Login";
		String email=principal.getName();
		Product product=productDao.getProduct(Id);
		User user=cartItemDao.getUser(email);
		List<CartItem> cartItems=cartItemDao.getCart(email);
		for(CartItem cartItem:cartItems){
			if(cartItem.getProduct().getId()==Id){
				cartItem.setQuantity(requestedQuantity);
				cartItem.setTotalPrice(requestedQuantity*product.getProductPrice());
				cartItemDao.addToCart(cartItem);//update the quantity and totalprice
				return "redirect:/cart/getcart";
			}
		}
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(requestedQuantity);
        cartItem.setProduct(product);
        cartItem.setUser(user);
        double totalPrice=requestedQuantity *product.getProductPrice();
        cartItem.setTotalPrice(totalPrice);
        cartItemDao.addToCart(cartItem);
    	return "redirect:/cart/getcart";
	}
    @RequestMapping(value="/cart/getcart")
    public String getCart(@AuthenticationPrincipal Principal principal,Model model,HttpSession session){
    	if(principal==null)
    		return "Login";
    	String email=principal.getName();
    	List<CartItem> cartItems=cartItemDao.getCart(email);
    	model.addAttribute("cartItems",cartItems);
    	session.setAttribute("cartSize", cartItems.size());
    	return "Cart";
    }
    @RequestMapping(value="/cart/removecartitem/{cartItemId}")
    public String removeCartItem(@PathVariable int cartItemId){
    	cartItemDao.removeCartItem(cartItemId);
    	//delete from cartItem where cartitemid=?
    	return "redirect:/cart/getcart";
    	
    	//select * from cartitem where user_email=? - to execute the query redirect /cart/getcart
    }
    @RequestMapping(value="/cart/clearcart")
    public String clearCart(@AuthenticationPrincipal Principal principal){
    	//Get list of cartItems 
    	List<CartItem> cartItems=cartItemDao.getCart(principal.getName());
    	for(CartItem cartItem:cartItems){
    		cartItemDao.removeCartItem(cartItem.getCartItemId());
    		//delete from cartItem where cartItemid=?
    	}
    	return "redirect:/cart/getcart";
    }
    @RequestMapping(value="/cart/shippingaddressform")
    public String getShippingAddressForm(@AuthenticationPrincipal Principal principal,Model model){
    	if(principal==null)
    		return "Login";
    	String email=principal.getName();
    	User user=cartItemDao.getUser(email);
    	Customer customer=user.getCustomer();
    	ShippingAddress shippingAddress=customer.getShippingaddress();
    	model.addAttribute("shippingaddress",shippingAddress);
    	return "ShippingAddress";
    }
    @RequestMapping(value="/cart/createorder")
    public String createCustomerOrder(@ModelAttribute ShippingAddress shippingaddress,
    		Model model,
    		@AuthenticationPrincipal Principal principal,HttpSession session){
    	String email=principal.getName();
    	User user=cartItemDao.getUser(email);
    	
    	Customer customer=user.getCustomer();
    	customer.setShippingaddress(shippingaddress);//customer.shippingaddress -> updated shippingaddress obj
    	customer.setUser(user);
    	user.setCustomer(customer);//user.customer -> updated customer references
    	
    	
    	List<CartItem> cartItems=cartItemDao.getCart(email);
    	
    	for(CartItem cartItem:cartItems){
    		Product product=cartItem.getProduct();
    		if((product.getProductQuantity()-cartItem.getQuantity())<0){
    			cartItemDao.removeCartItem(cartItem.getCartItemId());
    			model.addAttribute("productNA",product);
    			return "productnotavailable";
    		}
    	}
    	
    	//Calculate grandTotal
    	
    	double grandTotal=0;
    	for(CartItem cartItem:cartItems){//for(T o:collection)
    		grandTotal=grandTotal+cartItem.getTotalPrice();
    	}
    	
    	//create CustomerOrder object
    	CustomerOrder customerOrder=new CustomerOrder();
    	customerOrder.setPurchaseDate(new Date());
    	customerOrder.setUser(user);//customerOrder -> user -> customer -> shippingaddress
    	customerOrder.setGrandTotal(grandTotal);
    	if(cartItems.size()>0)
    	 customerOrder=cartItemDao.createCustomerOrder(customerOrder);
    	 
    	 
    	//Remove all cartitems from the cartItem table
    	//decrement the quantity of the product
    	//add customerorder and List<CartItem> to an model attributes and return "orderdetails"
    	 
    	for(CartItem cartItem:cartItems){
    		Product product=cartItem.getProduct();
    		//In stock =30
    		//requested quantity=20
    		//update product quantity=30-20 where id=?
    		product.setProductQuantity(product.getProductQuantity() - cartItem.getQuantity());//decrement the product quantity
    		productDao.updateProduct(product );//update product set quantity=7 where id=38
    		cartItemDao.removeCartItem(cartItem.getCartItemId());
    	}
    	model.addAttribute("customerorder",customerOrder);//order=[orderId,purchaseDate,grandTotal,User]
    	model.addAttribute("cartItems",cartItems);
    	session.setAttribute("cartSize", 0);
    	return "OrderDetails";
    }
}
