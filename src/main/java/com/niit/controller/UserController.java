
package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.User;
import com.niit.userdao.UserDAO;

@Controller
public class UserController
{
	@Autowired
	UserDAO userdao;
	@RequestMapping(value="/SignUp",method=RequestMethod.GET)
	public ModelAndView viewSignUp(@ModelAttribute("SignUp")User user)
	{
		ModelAndView model=new ModelAndView("SignUp");
		return model;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("SignUp")User user)
	{		
		userdao.addUser(user);
		ModelAndView model=new ModelAndView("Login","User",new User());
		return model;
		
	}
}
