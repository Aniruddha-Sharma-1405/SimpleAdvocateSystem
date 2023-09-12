package com.amdocs.dao;

import java.util.List;

import com.amdocs.entity.Appointment;

public interface AppointmentDAO 
{
	boolean bookAppointment(Appointment appointment);
	
	boolean modifyAppointment(String columnName, String input, int id);
	
	boolean deleteAppointment(int id);
	
	Appointment viewOneAppointment(int id);
	
	List<Appointment> viewAllAppointment();
}
