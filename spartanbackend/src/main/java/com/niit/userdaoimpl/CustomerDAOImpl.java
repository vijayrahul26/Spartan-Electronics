package com.niit.userdaoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Authorities;
import com.niit.model.Customer;
import com.niit.model.User;
import com.niit.userdao.CustomerDAO;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
private SessionFactory sessionFactory;
	public void registerCustomer(Customer customer) {
	   Session session=sessionFactory.getCurrentSession();
	   
	   //SET ENABLED property in USER as true
	   customer.getUser().setEnabled(true);
	   
	   System.out.println(customer.getUser().getAuthorities());
	   
	   //CREATE new AUTHORITIES OBJECT AND SET THE ROLE AS ROLE_USER
	   Authorities authorities=new Authorities();
	   authorities.setRole("ROLE_USER");
	   //AUTHORITIES PROPERTY IN USER REFERS TO AUTHORITIES OBJECT
	   customer.getUser().setAuthorities(authorities);
	   
	   //MAKE USER PROPERTY IN AUTHORITIES TO REFER USER OBJECT
	   authorities.setUser(customer.getUser());
	   
	   
	   session.save(customer);
	   //has to insert into customer table
	}
	public boolean isEmailUnique(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		if(user==null)//email is unique
			return true;
			else
				return false;//email is not unique.
	}

}

