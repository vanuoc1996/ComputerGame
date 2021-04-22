package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vti.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
