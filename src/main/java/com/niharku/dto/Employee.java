package com.niharku.dto;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = -5280431456947109343L;
	
	int id;
	String name;
	String dept;
	int salary;
	String email;
	java.sql.Timestamp createdDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.sql.Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(java.sql.Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	

}
