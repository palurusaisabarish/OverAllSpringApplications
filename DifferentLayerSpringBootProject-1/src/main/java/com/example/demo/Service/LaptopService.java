package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Module.Laptop;
import com.example.demo.repo.LaptopRepository;

@Service
public class LaptopService {

	@Autowired
	private LaptopRepository repo;
	
	public void addLaptop(Laptop lap) {
		
		//bussiness logic
		System.out.println("method Called..");
		//accessing the database Class
		repo.save(lap);
	
	}
}
