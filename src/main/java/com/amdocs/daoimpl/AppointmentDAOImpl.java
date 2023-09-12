package com.amdocs.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.dao.AppointmentDAO;
import com.amdocs.entity.Appointment;
import com.amdocs.database.DBConnection;
import com.amdocs.database.DBTablePrinter;

public class AppointmentDAOImpl implements AppointmentDAO
{
	DBConnection dbConnection = new DBConnection();
	Connection connection  = dbConnection.connect();
	@Override
	public boolean bookAppointment(Appointment appointment) 
	{
		boolean check = false;
		String sql = "INSERT INTO appointment (customer_id,advocate_id,start_time,duration,appointment_type) VALUES (?,?,?,?,?);";
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, appointment.getCustomerId());
			preparedStatement.setInt(2, appointment.getAdvocateId());
			preparedStatement.setTime(3, appointment.getStartTime());
			preparedStatement.setInt(4, appointment.getDuration());
			preparedStatement.setString(5, appointment.getAppointmentType());
			preparedStatement.executeUpdate();
			check = true;
		} 
		catch (SQLException e) 
		{
			System.out.println("Error!! While Booking An Appointment");
		}
		return check;
	}

	@Override
	public boolean modifyAppointment(String columnName, String input, int id) 
	{
		boolean check = false;
		String sql = "UPDATE appointment a SET "+columnName+" = ? WHERE a.id = ?";
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
			System.out.println("Error!! While Modifying An Appointment");
		}
		return check;
	}

	@Override
	public boolean deleteAppointment(int id) 
	{
		boolean check = false;
		String sql = "DELETE FROM appointment a WHERE a.id = ?";
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			check = true;
		}
		catch(SQLException e)
		{
			System.err.println("Error.. While Deleting an Appointment");
		}
		return check;
	}

	@Override
	public Appointment viewOneAppointment(int id) 
	{
		Appointment appointment = new Appointment();
		String sql = "SELECT * FROM appointment a WHERE a.id = ?";
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			DBTablePrinter.printResultSet(resultSet);
		}
		catch(SQLException e)
		{
			System.err.println("Error.. While Viewing One  Appointment");
		}
		return appointment;
	}

	@Override
	public List<Appointment> viewAllAppointment() 
	{
		List<Appointment>  appointmentList = new ArrayList<>();
		String sql = "SELECT * FROM appointment a INNER JOIN customer c ON a.customer_id = c.id INNER JOIN advocate ad ON a.advocate_id = ad.id";
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			DBTablePrinter.printResultSet(resultSet);
		}
		catch(SQLException e)
		{
			System.err.println("Error.. While Viewing All Appointments");
		}
		return appointmentList;
	}

}
