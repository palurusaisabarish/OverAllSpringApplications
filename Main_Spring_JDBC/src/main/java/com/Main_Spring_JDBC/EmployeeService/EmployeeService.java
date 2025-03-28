package com.Main_Spring_JDBC.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Main_Spring_JDBC.Employee;
import com.Main_Spring_JDBC.EmployeeRepository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public void addEmployeeDetails(Employee emp) {
		repo.save(emp);
	}

	public List<Employee> getAllEmployeesDetails(Employee emp) {
		 return repo.findAll(emp);
	}
	
	
}
