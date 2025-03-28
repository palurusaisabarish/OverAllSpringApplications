package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.Module.Alien;
import com.example.demo.Module.Laptop;
import com.example.demo.Service.LaptopService;

@SpringBootApplication
public class DifferentLayerSpringBootProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DifferentLayerSpringBootProjectApplication.class, args);
		
		LaptopService service = context.getBean(LaptopService.class);
		
		Laptop lap = context.getBean(Laptop.class);
		service.addLaptop(lap);
		
		
	}

}
