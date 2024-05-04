package com.niharku.dao;

import com.niharku.dto.Employee;

public interface IDao {
	
	String insertEmployee(String id, String name, String dept, int salary, String email);
	Employee searchEmployee(String id);
	String updateEmployee(String id, String name, String dept, int salary, String email);
	String deleteEmployee(String id);

}
