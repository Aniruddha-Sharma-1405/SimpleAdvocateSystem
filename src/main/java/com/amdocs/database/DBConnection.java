package com.amdocs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	final String URL = "jdbc:mysql://localhost:3306/mysqladvocatesystem";
	final String USERNAME ="root";
	final String PASSWORD = "";
	public Connection connect()
	{
		Connection con = null;		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection Established successfully");
		}
		catch(SQLException e)
		{
			System.err.println("Failed to Establish a Connection");
		}
		catch(ClassNotFoundException e)
		{
			System.err.println("Class Not Found while Establishing Connection");
		}
		return con;
	}
}
