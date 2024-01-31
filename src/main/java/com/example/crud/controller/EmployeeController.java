package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeService;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "/employee-list",produces="application/json")
	public ResponseEntity<Employee> getListofEmployee(){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
		List<Employee> emp = employeeService.getAllEmployee();
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}
	
	@GetMapping("/employee-byId/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id){
		System.out.println(employeeService.getEmployeeById(id));
		return employeeService.getEmployeeById(id);		
	}
	
	@PostMapping("/save-employee")
	public Employee saveEmployee(@RequestBody() Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping("/delete-employee/{id}")
	public void deleteEmployee(@PathVariable("id") Long id) {		
		 employeeService.deleteEmployeeById(id);
	}
}
