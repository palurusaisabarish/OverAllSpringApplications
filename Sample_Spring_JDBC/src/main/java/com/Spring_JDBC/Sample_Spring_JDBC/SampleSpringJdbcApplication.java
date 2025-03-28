package com.Spring_JDBC.Sample_Spring_JDBC;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Spring_JDBC.Sample_Spring_JDBC.service.studentService;

@SpringBootApplication
public class SampleSpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SampleSpringJdbcApplication.class, args);
		
		student s = context.getBean(student.class);
		s.setId(101);
		s.setName("sai");
		s.setMarks(80);
		
		studentService st = context.getBean(studentService.class);
		st.addStudent(s);
		
		List<student> students = st.getStudents();
		System.out.println(students);
	}

}
