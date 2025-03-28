package com.example.demo.studentRep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.student;

public interface studentRepo extends JpaRepository<student, Integer>{

}
