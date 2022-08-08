package com.telusko.learning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory=new AnnotationConfigApplicationContext("MobConfi.class");
		Samsung s7=factory.getBean(Samsung.class);
		s7.config();

	}

}
