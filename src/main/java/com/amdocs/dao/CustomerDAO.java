package com.amdocs.dao;

import java.util.List;

import com.amdocs.entity.Customer;

public interface CustomerDAO 
{
	boolean registerCustomer(Customer customer);
	
	boolean modifyCustomer(String columnName, String input, int id);
	
	boolean deleteCustomer(int id);
	
	Customer viewOneCustomer(int id);
	
	List<Customer> viewAllCustomer();
}
