package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpAstudentApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringDataJpAstudentApplication.class, args);
		
		student s1 = context.getBean(student.class);
		
	}

}
