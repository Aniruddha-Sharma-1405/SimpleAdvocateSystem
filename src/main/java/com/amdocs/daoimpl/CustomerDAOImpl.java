package com.amdocs.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.dao.CustomerDAO;
import com.amdocs.database.DBConnection;
import com.amdocs.database.DBTablePrinter;
import com.amdocs.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO
{
	DBConnection dbConnection = new DBConnection();
	Connection connection  = dbConnection.connect();
	@Override
	public boolean registerCustomer(Customer customer) 
	{
		boolean check = false;
		String sql = "INSERT INTO customer  (first_name,last_name,phone_number,pincode,case_type) VALUES (?,?,?,?,?)";
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getPhoneNumber());
			preparedStatement.setString(4, customer.getPincode());
			preparedStatement.setString(5, customer.getCasetype());
			preparedStatement.executeUpdate();
			check = true;
		} 
		catch (SQLException e) 
		{
			System.out.println("Error!! While Registering a customer");
		}
		return check;
	}

	@Override
	public boolean modifyCustomer(String columnName, String input, int id) 
	{
		boolean check = false;
		String sql = "UPDATE customer c SET "+columnName+" = ? WHERE c.id = ?";
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, input);
			preparedStatement.setInt(2, id);
			int execute = preparedStatement.executeUpdate();
			if(execute>0)
			{
				check = true;
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("Error!! While Modifying Customer Details");
		}
		return check;
	}

	@Override
	public boolean deleteCustomer(int id) 
	{
		boolean check = false;
		String sql = "DELETE FROM customer c WHERE c.id = ?";
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			check = true;
		}
		catch(SQLException e)
		{
			System.err.println("Error.. While Deleting customer details");
		}
		return check;
	}

	@Override
	public Customer viewOneCustomer(int id) 
	{
		Customer customer = new Customer();
		String sql = "SELECT * FROM customer c WHERE c.id = ?";
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			DBTablePrinter.printResultSet(resultSet);
		}
		catch(SQLException e)
		{
			System.err.println("Error.. While Viewing One Customer");
		}
		return customer;
	}

	@Override
	public List<Customer> viewAllCustomer() 
	{
		List<Customer>  customerList = new ArrayList<>();
		String sql = "SELECT * FROM customer";
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			DBTablePrinter.printResultSet(resultSet);
		}
		catch(SQLException e)
		{
			System.err.println("Error.. While Viewing All Customers");
		}
		return customerList;
	}

}
