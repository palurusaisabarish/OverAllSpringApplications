package com.Spring_JDBC.Sample_Spring_JDBC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring_JDBC.Sample_Spring_JDBC.student;
import com.Spring_JDBC.Sample_Spring_JDBC.Repositry.studentRepository;

@Service
public class studentService {

	@Autowired
	studentRepository repo;
	
	public void addStudent(student s) {
		//System.out.println("Added");
		repo.save(s);
	}

	public List<student> getStudents() {
		return repo.findAll();
	}

	


}
