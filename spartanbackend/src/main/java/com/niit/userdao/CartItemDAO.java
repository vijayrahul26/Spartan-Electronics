package com.niit.userdao;

import java.util.List;

import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;
import com.niit.model.User;

public interface CartItemDAO {
	void addToCart(CartItem cartItem);
	User getUser(String email);
	List<CartItem>  getCart(String email);//select * from cartitem where user_email=?
	void removeCartItem(int cartItemId);
	CustomerOrder createCustomerOrder(CustomerOrder customerOrder);

}
