package com.example.demo.Module;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{

	@Override
	public void complie() {
		System.out.println("Desktop is Compiling...");
	}

	
}
