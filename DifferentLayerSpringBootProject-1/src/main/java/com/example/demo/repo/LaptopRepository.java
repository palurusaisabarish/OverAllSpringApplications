package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.Module.Laptop;

@Repository
public class LaptopRepository {

	public void save(Laptop lap) {
		System.out.println("Saved in database...");
	}
}
