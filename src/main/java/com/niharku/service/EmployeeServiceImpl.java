package com.niharku.service;

import com.niharku.dao.IDao;
import com.niharku.daoFactory.DaoFactory;
import com.niharku.dto.Employee;

public class EmployeeServiceImpl implements IEmployeeService{
	
	DaoFactory daoFactory = null;
	IDao idao = null;

	@Override
	public String insertEmployee(String id, String name, String dept, int salary, String email) {
		if(idao == null)
			idao = DaoFactory.daoFactory();
		String result = idao.insertEmployee(id, name, dept, salary, email);
		if(result == null)
			return "An error occurred while inserting record";
		return result;
	}

	@Override
	public Employee searchEmployee(String id) {
		if(idao == null)
			idao = DaoFactory.daoFactory();
		Employee result = idao.searchEmployee(id);
		return result;
	}

	@Override
	public String updateEmployee(String id, String name, String dept, int salary, String email) {
		if(idao == null)
			idao = DaoFactory.daoFactory();
		String result = idao.updateEmployee(id, name, dept, salary, email);
		if(result == null)
			return "An error occurred while updating record";
		return result;
	}

	@Override
	public String deleteEmployee(String id) {
		if(idao == null)
			idao = DaoFactory.daoFactory();
		String result = idao.deleteEmployee(id);
		if(result == null)
			return "An error occurred while deleting record";
		return result;
	}

}
