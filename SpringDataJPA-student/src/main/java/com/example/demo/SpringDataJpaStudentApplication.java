package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.studentRep.studentRepo;



@SpringBootApplication
public class SpringDataJpaStudentApplication {

	public static void main(String[] args) {
		ApplicationContext context = 	SpringApplication.run(SpringDataJpaStudentApplication.class, args);
		
		student s1 = context.getBean(student.class);
		student s2 = context.getBean(student.class);
		student s3 = context.getBean(student.class);
		
		s1.setRollNo(101);
		s1.setName("sai");
		s1.setMarks(90);
	
		s2.setRollNo(102);
		s2.setName("sabarish");
		s2.setMarks(80);
		
		
		s3.setRollNo(103);
		s3.setName("vivek");
		s3.setMarks(35);
		
		studentRepo repo = context.getBean(studentRepo.class);
		
		repo.save(s1);
	}

}
