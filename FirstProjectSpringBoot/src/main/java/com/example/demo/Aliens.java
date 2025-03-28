package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Aliens {

	//public void code() { System.out.println("Coding..."); }
	
	@Autowired
	Laptop laptop;
	
	public void code() {
		
		laptop.complie();
	}

}
