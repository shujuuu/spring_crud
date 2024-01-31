package com.example.crud.service;

import java.util.List;

import com.example.crud.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Long id);
	
	Employee saveEmployee(Employee employee);
	
	void deleteEmployeeById(Long id);	
}
