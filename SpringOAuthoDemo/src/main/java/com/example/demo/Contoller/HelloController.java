package com.example.demo.Contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hii")
	public String greet() {
		System.out.println("Method Called");
		return "Welcome To NextEducation";
	}
}
