package com.example.SecondSpringProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring1.xml");
        
//        Alien obj = (Alien) context.getBean("Alien");
        Alien obj = context.getBean("Alien",Alien.class);
        System.out.println(obj.getAge());
       obj.code();
       
       Computer com = context.getBean(Computer.class);
       
    }
}
