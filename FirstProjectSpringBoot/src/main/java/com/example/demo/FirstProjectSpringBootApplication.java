package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstProjectSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstProjectSpringBootApplication.class, args);
		
//		Aliens obj = new Aliens();
//		obj.code();
		
		//Aliens obj = context.getBean(Aliens.class);
		//obj.code();
		
		//Aliens obj1 = context.getBean(Aliens.class);
		//obj.code();
		
		//System.out.println(obj);
		//System.out.println(obj1);
		
		Aliens obj = context.getBean(Aliens.class);
		obj.code();
	}

}




