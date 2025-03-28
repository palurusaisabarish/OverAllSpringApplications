package com.example.FirstSpringProject;

import java.beans.ConstructorProperties;

public class Alien {

	private int age;
	private Laptop lap;
	
	Alien(){
		System.out.println("Object is Created");
	}
	
	@ConstructorProperties({"age","lap"})
	Alien(int age,Laptop lap){
		System.out.println("para Constructor is called");
		this.age=age;
		this.lap=lap;
	}
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	

	public Laptop getLap() {
		return lap;
	}


	public void setLap(Laptop lap) {
		this.lap = lap;
	}


	public void code() { 
		System.out.println("coding...");
		lap.complie();
	}
}
