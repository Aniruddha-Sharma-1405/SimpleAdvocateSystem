package com.amdocs.service.customer;

import java.util.Scanner;

import com.amdocs.exception.InvalidPhoneNumber;
import com.amdocs.exception.InvalidServiceChoice;

public class CustomerChoices 
{
	Scanner sc = new Scanner(System.in);
	CustomerService customerService = new CustomerService();
	public void customerChoices() throws InvalidPhoneNumber, InvalidServiceChoice
	{
		boolean flag = true;
		while(flag)
		{
			System.out.println("--------------------------Customer Page--------------------------");
			System.out.println("Please Select an option from below");
			System.out.println("1. Register Customer ");
			System.out.println("2. Modify Customer details");
			System.out.println("3. Delete Customer record");
			System.out.println("4. View single record");
			System.out.println("5. View all records");
			System.out.println("0. Exit");
			try
			{
				int ch = Integer.parseInt(sc.nextLine());
				switch(ch)
				{
					case 1:
						customerService.registerCustomer();
						break;
					case 2:
						customerService.modifyCustomer();
						break;
					case 3:
						customerService.deleteCustomer();
						break;
					case 4:
						customerService.viewOneCustomer();
						break;
					case 5:
						customerService.viewAllCustomer();
						break;
					case 0:
						System.out.println("Returning to Home Page.....");
						flag = false;
					default:
						System.out.println("Please Try Again");
				}
			
			}
			catch(NumberFormatException e)
			{
				System.err.println("Please Enter Integer as Input");
			}
		}
		
		}
}
