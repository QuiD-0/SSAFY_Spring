package com.coffee3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoffeeApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("coffee.xml");
		Coffee coffee = applicationContext.getBean("coffee1",Coffee.class);
		coffee.info();
	}

}
