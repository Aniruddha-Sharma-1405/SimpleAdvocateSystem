package com.amdocs.service.advocate;

import java.util.Scanner;

import com.amdocs.database.AdvocateTable;
import com.amdocs.entity.Appointment;
import com.amdocs.exception.InvalidServiceChoice;
import com.amdocs.exception.InvalidTimeException;
import com.amdocs.dao.AppointmentDAO;
import com.amdocs.daoimpl.AppointmentDAOImpl;

public class AdvocateService {
	Scanner sc = new Scanner(System.in);
	AdvocateTable advocateTable = new AdvocateTable();
	AppointmentDAO appointmentDAo = new AppointmentDAOImpl();

	public void bookAppointment() throws InvalidTimeException 
	{
		Appointment appointment = new Appointment();
		System.out.println("Please Enter your Customer Id");
		int customerId = Integer.parseInt(sc.nextLine());
		appointment.setCustomerId(customerId);
		advocateTable.print();
		System.out.println("Please Enter the Advocate Id you want to book an appointment with");
		int advocateId = Integer.parseInt(sc.nextLine());
		appointment.setAdvocateId(advocateId);
		System.out.println("Please Enter the start time in (HH:MM:SS) format");
		String startTime = sc.nextLine();
		try 
		{
			java.sql.Time time = java.sql.Time.valueOf(startTime);
			appointment.setStartTime(time);
		} 
		catch (Exception e) 
		{
			throw new InvalidTimeException("Please Enter Time in HH:MM:SS Format");
		}
		System.out.println("Please Enter the duration of appointment");
		int duration = Integer.parseInt(sc.nextLine());
		appointment.setDuration(duration);
		System.out.println("Please Enter the Appointment Type (Offline/Online)");
		String appointmentType = sc.nextLine();
		appointment.setAppointmentType(appointmentType);
		boolean flag = appointmentDAo.bookAppointment(appointment);
		if(flag)
		{
			System.out.println("Appointment Booked!!");
		}
		else
		{
			System.out.println("No Appointment Booked");
		}
	}

	public void modifyAppointment() throws InvalidServiceChoice {
		String columnName = "";
		String input;
		System.out.println("Please Enter your Appointment ID");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Please Select an Option from below, for the feild you want to make changes in:");
		System.out.println("1. Start Time");
		System.out.println("2. Duration ");
		System.out.println("3. Appointment Type");
		try {
			int ch = Integer.parseInt(sc.nextLine());
			switch (ch) 
				{
				case 1:
					columnName = "start_time";
					break;
				case 2:
					columnName = "duration";
					break;
				case 3:
					columnName = "appointment_type";
					break;
				default:
					throw new InvalidServiceChoice("Please Select a valid Service choice!");
					
				}
		}
		catch (NumberFormatException e) 
		{
			System.err.println("Please check that the input is an integer");
		}
		System.out.println("Please Enter the Change you want to make: ");
		input = sc.nextLine();
		boolean flag = appointmentDAo.modifyAppointment(columnName, input, id);
		if(flag)
		{
			System.out.println("Modifications Made");
		}
		else
		{
			System.out.println("NO Modifications Made");
		}
	}

	public void deleteAppointment() 
	{
		System.out.println("Please Enter the Appointment Id you want to delete:");
		int id = Integer.parseInt(sc.nextLine());
		boolean flag = appointmentDAo.deleteAppointment(id);
		if(flag)
		{
			System.out.println("Appointment Deleted!");
		}
		System.out.println("No Appointment Deleted");
	}

	public void viewOneAppointment() 
	{
		System.out.println("Please Enter the Appointment Id you want to View:");
		int id = Integer.parseInt(sc.nextLine());
		appointmentDAo.viewOneAppointment(id);
	}

	public void viewAllAppointment() 
	{
		appointmentDAo.viewAllAppointment();
	}
}
