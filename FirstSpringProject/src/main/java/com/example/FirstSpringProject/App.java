package com.example.FirstSpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
      // Alien obj = new Alien();
    	
    	//System.out.println(System.getProperty("java.class.path"));

    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");  
//    	Alien obj = (Alien) context.getBean("Alien");
//    	obj.age = 12;
//    	System.out.println(obj.age);
//    	
//    	obj.code();
//    	
//    	Laptop obj1 = (Laptop) context.getBean("lap");
//    	obj1.code();
//    	Alien obj1 = (Alien) context.getBean("Alien");
//    	//obj1.code();
//    	System.out.println(obj1.age);

    	Alien obj = (Alien)context.getBean("Alien");
    	//obj.setAge(12);
    	System.out.println(obj.getAge());
    	obj.code();
    }
}
