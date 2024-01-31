package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList = employeeRepo.findAll();
		System.out.println(empList);
		return empList;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		return emp.get();
	}

	@Override
	public Employee saveEmployee(Employee employee) {		
		return employeeRepo.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteById(id);
	}

}
