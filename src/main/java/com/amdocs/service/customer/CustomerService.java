package com.amdocs.service.customer;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.amdocs.entity.Customer;
import com.amdocs.dao.CustomerDAO;
import com.amdocs.daoimpl.CustomerDAOImpl;
import com.amdocs.exception.InvalidPhoneNumber;
import com.amdocs.exception.InvalidServiceChoice;
public class CustomerService 
{
	Scanner sc = new Scanner(System.in);
	CustomerDAO customerDAO = new CustomerDAOImpl();
	private static final String PHONE_REGEX = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
	public void registerCustomer() throws InvalidPhoneNumber
	{
		Customer customer = new Customer();
		System.out.println("Please Enter your First Name:");
		String firstName = sc.nextLine();
		customer.setFirstName(firstName);
		System.out.println("Please Enter your Last Name:");
		String lastName = sc.nextLine();
		customer.setLastName(lastName);
		System.out.println("Please Enter your Phone Number");
		String phoneNumber = sc.nextLine();
		if(phoneNumber.length()<10)
		{
			throw new InvalidPhoneNumber("Please see that the phone number is 10 digits long");
		}
		if(!Pattern.matches(PHONE_REGEX, phoneNumber))
		{
			throw new InvalidPhoneNumber("Please see that the phone number NUMERICAL");
		}
		customer.setPhoneNumber(phoneNumber);
		System.out.println("Please Enter your pincode");
		String pincode = sc.nextLine();
		customer.setPincode(pincode);
		System.out.println("Please Enter the Type of Case you have");
		String caseType = sc.nextLine();
		customer.setCasetype(caseType);
		boolean flag = customerDAO.registerCustomer(customer);
		if(flag)
		{
			System.out.println("Customer Registered!");
		}
		else
		{
			System.out.println("Customer Registeration Failed");
		}
	}
	
	public void modifyCustomer() throws InvalidServiceChoice
	{
		String columnName = "";
		String input;
		System.out.println("Please Enter your Customer ID");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Please Select an Option from below, for the feild you want to make changes in:");
		System.out.println("1. First Name");
		System.out.println("2. Last Name ");
		System.out.println("3. Phone Number");
		System.out.println("4. Pincode");
		System.out.println("5. Case Type");
		try 
		{
			int ch = Integer.parseInt(sc.nextLine());
			switch (ch) 
			{
				case 1:
					columnName = "first_name";
					break;
				case 2:
					columnName = "last_name";
					break;
				case 3:
					columnName = "phone_number";
					break;
				case 4:
					columnName = "pincode";
					break;
				case 5:
					columnName = "case_type";
					break;
				default:
					throw new InvalidServiceChoice("Please Select a valid Service choice");
					
				}
		}
		catch (NumberFormatException e) 
		{
			System.err.println("Please check that the input is an integer");
		}
		System.out.println("Please Enter the Change you want to make: ");
		input = sc.nextLine();
		boolean flag = customerDAO.modifyCustomer(columnName, input, id);
		if(flag)
		{
			System.out.println("Customer Details Modified");
		}
		else
		{
			System.out.println("No Modifications were made");
		}
	}
	
	public void deleteCustomer()
	{
		System.out.println("Please Enter the Customer Id you want to delete:");
		int id = Integer.parseInt(sc.nextLine());
		boolean flag = customerDAO.deleteCustomer(id);
		if(flag)
		{
			System.out.println("Customer Deleted");
		}
		else
		{
			System.out.println("NO Customer was deleted");
		}
	}
	
	public void viewOneCustomer()
	{
		System.out.println("Please Enter the Customer ID that you want to view");
		int id = Integer.parseInt(sc.nextLine());
		customerDAO.viewOneCustomer(id);
	}
	
	public void viewAllCustomer()
	{
		customerDAO.viewAllCustomer();
	}
}
