package com.niit.userdao;

import com.niit.model.Customer;

public interface CustomerDAO {
void registerCustomer(Customer customer);
boolean isEmailUnique(String email);
}
