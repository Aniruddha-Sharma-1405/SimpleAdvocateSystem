package com.amdocs.entity;

public class Customer 
{
	int id;
	String firstName;
	String LastName;
	String phoneNumber;
	String pincode;
	String casetype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCasetype() {
		return casetype;
	}
	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", phoneNumber="
				+ phoneNumber + ", pincode=" + pincode + ", casetype=" + casetype + "]";
	}
	
	
}
