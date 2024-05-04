package com.niharku.serviceFactory;

import com.niharku.service.EmployeeServiceImpl;
import com.niharku.service.IEmployeeService;

public class ServiceFactory {
	
	static IEmployeeService empService = null;
	
	public static IEmployeeService serviceFactory() {
		if(empService == null)
			empService = new EmployeeServiceImpl();
		
		return empService;
	}
	

}
