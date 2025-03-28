package com.example.demo.Module;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Laptop implements Computer {

	@Override
	public void complie() {
		System.out.println("Laptop is Compiling....");
	}

}
