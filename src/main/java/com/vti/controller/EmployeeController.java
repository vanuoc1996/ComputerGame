package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vti.entity.Employee;
import com.vti.service.Interface.IEmployeeService;

@RestController
@Component
@RequestMapping(value = "api/v1/persons/employees")
@CrossOrigin(origins = "*")
@Validated
public class EmployeeController {
	@Autowired
	IEmployeeService employeeService;

	@GetMapping
	public ResponseEntity<?> getAllEmployees() {
		List<Employee> entity = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(entity, HttpStatus.OK);
	}
}
