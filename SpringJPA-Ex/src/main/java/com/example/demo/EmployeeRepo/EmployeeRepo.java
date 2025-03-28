package com.example.demo.EmployeeRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	//@Query("select s from Employee s where s.name= :name")
	List<Employee> findByName(String name);

	List<Employee> findByMarksGreaterThan(int i);
}
