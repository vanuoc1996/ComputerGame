package com.vti.service.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.vti.entity.Employee;

@Service
@Component
public interface IEmployeeService {
	List<Employee> getAllEmployees();
}
