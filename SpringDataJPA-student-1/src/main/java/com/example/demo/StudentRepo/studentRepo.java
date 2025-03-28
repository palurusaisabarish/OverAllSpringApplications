package com.example.demo.StudentRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.student;


public interface studentRepo extends JpaRepository<student, Integer> {

}
