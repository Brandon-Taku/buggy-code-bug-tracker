package com.brandon.bugtracker.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandon.bugtracker.model.Employees;
import com.brandon.bugtracker.repository.EmployeeInterface;
import com.brandon.bugtracker.repository.EmployeeRepository;


@Transactional
@Service
public class EmployeeImpl implements EmployeeInterface  {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	
	@Override
	public void delete(long id) {
		employeeRepo.deleteById(id);
		
	}
	
	@Override
	public Employees getEmployeeById(long id) {
		Optional <Employees> optional = employeeRepo.findById(id);
        Employees employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
	}

	
	@Override
	public void saveEmployee(Employees employee) {
		this.employeeRepo.save(employee);
		
	}

	

}
