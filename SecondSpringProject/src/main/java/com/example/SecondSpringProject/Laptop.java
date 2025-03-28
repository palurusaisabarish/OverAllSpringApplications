package com.example.SecondSpringProject;

public class Laptop implements Computer{

	public Laptop() {
		System.out.println("Laptop object is created..");
	}
	@Override
	public void complie() {
		System.out.println("Laptop is selected");
	}

}
