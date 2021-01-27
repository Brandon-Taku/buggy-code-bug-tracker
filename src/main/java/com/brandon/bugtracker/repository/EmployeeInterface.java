package com.brandon.bugtracker.repository;

import com.brandon.bugtracker.model.Employees;

public interface EmployeeInterface {
	
	public void delete(long id);
	
	public Employees getEmployeeById(long id);
	
	void saveEmployee(Employees employee);

}
