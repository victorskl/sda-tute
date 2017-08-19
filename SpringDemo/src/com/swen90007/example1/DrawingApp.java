package com.swen90007.example1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class DrawingApp {
    
    public static void main(String[] args) {
        
        // Activity 1: Creating objects using the Spring Bean Factory and ApplicationContext
        // Step 3
        Triangle triangle = new Triangle();
        //Triangle triangle = new Triangle("equilateral"); // normal way of using constructor, in contrast to Activity 2.2: Constructor Injection in Spring 
        //triangle.setType("equilateral"); // normal way of using setter, in contrast to Activity 2.1 : Setter Injection in Spring
        triangle.draw("using new keyword");
        
        // Step 4 (b) using BeanFactory
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml")); // this will look in project root i.e. SpringDemo/spring.xml
        Triangle triangle1 = (Triangle) factory.getBean("triangle1");
        triangle1.draw("using BeanFactory");
        
        // Step 4 (c) using ApplicationContext
        // Step 4 (d) Move the configuration file spring.xml to the src directory. 
        // Note: instead of moving, I created a copy and differentiate it by bean ID. 
        // So it won't break with previous activity exercise.
        // I will continue use ApplicationContext configuration then on activities.
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // this will look in classpath i.e. SpringDemo/src/spring.xml
        Triangle triangle2 = (Triangle) context.getBean("triangle2");
        triangle2.draw("using ApplicationContext");
        
        // Activity 3: Using the Spring Dependency Injection feature to inject objects
        Point p1 = triangle2.getP1();
        Point p2 = triangle2.getP2();
        Point p3 = triangle2.getP3();
        System.out.println("x values are " + p1.getX() + ":" + p2.getX() + ":" + p3.getX());
    }
}
