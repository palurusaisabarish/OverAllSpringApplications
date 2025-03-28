package com.Main_Spring_JDBC;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Main_Spring_JDBC.EmployeeService.EmployeeService;

@SpringBootApplication
public class MainSpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(MainSpringJdbcApplication.class, args);
		
		Employee emp = context.getBean(Employee.class);
		emp.setEmpId(901911);
		emp.setEmpName("MotorReddy");
		emp.setEmpAddress("NarasareddyPalem");
		
		EmployeeService serivce = context.getBean(EmployeeService.class);
		//serivce.addEmployeeDetails(emp);
		
		List<Employee> emps = serivce.getAllEmployeesDetails(emp);
		
		for(Employee list : emps) {
			System.out.println(list.getEmpId() + " "+ list.getEmpName()+" "+list.getEmpAddress());
		}
	}

}
