package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Employee;
import com.vti.repository.IEmployeeRepository;
import com.vti.service.Interface.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService{
	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	
}
