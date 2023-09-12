package com.amdocs.app;
import java.util.Scanner;

import com.amdocs.exception.InvalidPhoneNumber;
import com.amdocs.exception.InvalidServiceChoice;
import com.amdocs.exception.InvalidTimeException;
import com.amdocs.service.advocate.AdvocateChoices;
import com.amdocs.service.customer.CustomerChoices;
public class App 
{
	static Scanner sc = new Scanner(System.in);
	static CustomerChoices custChoices = new CustomerChoices();
	static AdvocateChoices advoChoices = new AdvocateChoices();
    public static void main( String[] args ) throws InvalidTimeException, InvalidPhoneNumber, InvalidServiceChoice
    {
    	while(true)
    	{
    		System.out.println("\n-----------------------Home Page-----------------------\n");
    		System.out.println("Please Select an option from below");
    		System.out.println("1. Customer");
    		System.out.println("2. Advocate");
    		System.out.println("0. Exit");
    		try
    		{
    			int ch = Integer.parseInt(sc.nextLine());
        		switch(ch)
        		{
        			case 1:
        				custChoices.customerChoices();
        				break;
        			case 2:
        				advoChoices.advocateChoices();
        				break;
        			case 0:
        				System.exit(0);
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
