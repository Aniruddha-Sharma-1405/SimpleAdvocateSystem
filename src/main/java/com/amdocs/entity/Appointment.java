package com.amdocs.entity;

import java.sql.Time;
import java.time.LocalTime;

public class Appointment 
{
	int id;
	int customerId;
	int advocateId;
	java.sql.Time startTime;
	int duration;
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", customerId=" + customerId + ", advocateId=" + advocateId + ", startTime="
				+ startTime + ", duration=" + duration + ", appointmentType=" + appointmentType + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAdvocateId() {
		return advocateId;
	}
	public void setAdvocateId(int advocateId) {
		this.advocateId = advocateId;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time time) {
		this.startTime = time;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	String appointmentType;
}
