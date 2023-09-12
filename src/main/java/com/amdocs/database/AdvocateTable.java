package com.amdocs.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdvocateTable 
{
	DBConnection dbConnection = new DBConnection();
	Connection connection  = dbConnection.connect();
	public void print()
	{
		String sql = "Select * from advocate";
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			DBTablePrinter.printResultSet(resultSet);
		}
		catch(SQLException e)
		{
			System.err.println("Error.. While printing Advocate Table");
		}
	}
}
