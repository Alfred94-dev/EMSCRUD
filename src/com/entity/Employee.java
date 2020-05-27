package com.entity;

import java.util.Date;

public class Employee {

	private int empId;
	private String eName;
	private String password;
	private String email;
	private Date Dob;
	@Override

	public String toString() {
		return "Employee [empId=" + empId + ", eName=" + eName + ", password=" + password + ", email=" + email
				+ ", Country=" + Country + "]";
	}


	public Date getDob() {
		return Dob;
	}


	public void setDob(Date dob) {
		Dob = dob;
	}


	public Employee(int empId, String eName, String password, String email, Date dob, String country) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.password = password;
		this.email = email;
		Dob = dob;
		Country = country;
	}


	public Employee() {
		// TODO Auto-generated constructor stub
	}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	private String Country;
}
