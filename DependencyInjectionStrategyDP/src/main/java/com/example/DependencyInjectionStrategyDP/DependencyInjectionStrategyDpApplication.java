package com.example.DependencyInjectionStrategyDP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyInjectionStrategyDpApplication {

	public static void main(String[] args) {

		//get IOC container
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionStrategyDpApplication.class, args);

		//get target bean class
		Vehicle vehicle = ctx.getBean("vehicle", Vehicle.class);

		vehicle.move("pune","Goa");

		//close IOC container
		((ConfigurableApplicationContext)ctx).close();
	}



}
