package com.niharku.service;

import com.niharku.dto.Employee;

public interface IEmployeeService {
	
	String insertEmployee(String id, String name, String dept, int salary, String email);
	Employee searchEmployee(String id);
	String updateEmployee(String id, String name, String dept, int salary, String email);
	String deleteEmployee(String id);

}
