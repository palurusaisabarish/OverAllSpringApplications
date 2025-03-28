package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.EmployeeRepo.EmployeeRepo;

@SpringBootApplication
public class SpringJpaExApplication {

	public static void main(String[] args) {
		
	
		
		ApplicationContext context =  SpringApplication.run(SpringJpaExApplication.class, args);
		
		EmployeeRepo employeeRepo = context.getBean(EmployeeRepo.class);
		
		Employee emp1 = context.getBean(Employee.class);
		Employee emp2 = context.getBean(Employee.class);
		Employee emp3 = context.getBean(Employee.class);
		
//		emp1.setRollno(101);
//		emp1.setName("Sai");
//		emp1.setMarks(100);
//		
//		emp2.setRollno(102);
//		emp2.setName("sabarish");
//		emp2.setMarks(90);
//		
		emp3.setRollno(103);
		emp3.setName("Hari");
		emp3.setMarks(35);
//		
//		employeeRepo.save(emp1);
//		employeeRepo.save(emp2);
//		employeeRepo.save(emp3);
		
		//System.out.println(employeeRepo.findAll());
		//System.out.println(employeeRepo.findById((long) 101));
		
		//Optional<Employee> e = employeeRepo.findById((long) 104);
		//System.out.println(e.orElse(new Employee()));
		
		System.out.println(employeeRepo.findByName("Sai"));
		System.out.println(employeeRepo.findByMarksGreaterThan(90));
		
		//update
		employeeRepo.save(emp3);
		
		//delete
		//employeeRepo.delete(emp3);
		
	}

}
