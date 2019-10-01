package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.CartItem;
import com.niit.userdao.CartItemDAO;
import com.niit.userdao.ProductDAO;

@Controller
public class HomeController
{
	@Autowired
	private ProductDAO productDao;	
	   @Autowired
		private CartItemDAO cartItemDao;
	public HomeController(){
		System.out.println("HomeController bean is instantiated");
	}
	//http://localhost:8080/project1frontend/home - This request will be handled
	//by this handler method homePage()
	@RequestMapping(value="/")
	public String homePage(HttpSession session,@AuthenticationPrincipal Principal principal){
		session.setAttribute("category",productDao.findAllCategory());
		if(principal!=null){
		String email=principal.getName();
		List<CartItem> cartItems=cartItemDao.getCart(email);
		session.setAttribute("cartSize",cartItems.size());
		}
		return "Home";
	}
	
	@RequestMapping(value="/Login")

	public String getLoginPage()
	{
		return"Login";
	}
	@RequestMapping(value="/loginerror")
	public String loginFailed(Model model){
		model.addAttribute("error","Invalid credentials..");
		return "Login";
	}
	@RequestMapping(value="/logout")
	public String logout(Model model){
		model.addAttribute("msg","Loggedout successfully...");
		return "Login";
	}
	@RequestMapping(value="/AboutUs")

	public String getAboutPage()
	{
		return"AboutUs";
	}
	@RequestMapping(value="/ContactUs")

	public String getContactUsPage()
	{
		return"ContactUs";
	}
	@RequestMapping(value="/Footer")

	public String getFooterPage()
	{
		return"Footer";
	}
	@RequestMapping(value="/Header")

	public String getHeaderPage()
	{
		return"Header";
	}
	
	
}
