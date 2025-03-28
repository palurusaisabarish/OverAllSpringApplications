package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SecondSpringBootProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SecondSpringBootProjectApplication.class, args);
		
		Alien al = context.getBean(Alien.class);
		al.code();
	}

}
