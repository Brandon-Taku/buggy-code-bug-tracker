package com.brandon.bugtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandon.bugtracker.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Long>{

	
	
}
