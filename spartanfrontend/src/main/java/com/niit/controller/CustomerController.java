package com.niit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Customer;
import com.niit.userdao.CustomerDAO;

@Controller
public class CustomerController {
	@Autowired
	private CustomerDAO customerDao;
@RequestMapping(value="/all/registrationform")
public String getRegistrationForm(Model model){
	model.addAttribute("customer",new Customer());
	return "SignUp";
}
@RequestMapping(value="/all/registercustomer")
public String registerCustomer(@ModelAttribute(name="customer") Customer customer,Model model){

	//CHECK if Email is unique
	if(!customerDao.isEmailUnique(customer.getUser().getEmail())){
		model.addAttribute("error","Email id already exists.. please choose different email id");
		return "SignUp";
	}
	
	//Call DAO to persist customer details
	customerDao.registerCustomer(customer);
	return "Login";
}
}