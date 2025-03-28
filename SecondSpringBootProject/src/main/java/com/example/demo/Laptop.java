package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

	@Override
	public void complie() {
		System.out.println("Laptop is Compiling....");
	}

}
