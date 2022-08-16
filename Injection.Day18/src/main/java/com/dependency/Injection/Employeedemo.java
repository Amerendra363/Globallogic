package com.dependency.Injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employeedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("data.xml");

		Employee e = (Employee) context.getBean("constructorDemo");
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e.getAddress());
		System.out.println(e.getMobile());

//		Employee e1 = (Employee) context.getBean("beanDemo");
//		System.out.println(e1);
//		
//		Employee e2 = (Employee) context.getBean("beanDemo1");
//		System.out.println(e2);
//		
//
//		Employee e3 = (Employee) context.getBean("beanDemo2");
//		System.out.println(e3);

	}

}
