package com.sg.emp.model;

import lombok.Builder;

import java.io.Serializable;

public class EmployeeModel implements Serializable {
	
	
	private static final long serialVersionUID = -6916776338925402993L;
	
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String dept;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
