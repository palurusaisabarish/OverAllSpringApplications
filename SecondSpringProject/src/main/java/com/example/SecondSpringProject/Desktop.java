package com.example.SecondSpringProject;

public class Desktop implements Computer {

	public Desktop() {
		System.out.println("Desktop object is created...");
	}
	@Override
	public void complie() {
		System.out.println("Desktop is selected");
	}

}
