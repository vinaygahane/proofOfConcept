package com.example.Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

     @Bean(name="ld")
	 public LocalDate  createDate(){
		 return LocalDate.now();
	 }

	public static void main(String[] args) {

		 //get IOC container
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

	//get target bean class
	SeasonFinder finder = ctx.getBean("sf", SeasonFinder.class);

	String season = finder.findSeason();

		System.out.println(season);

		//close IOC container
		((ConfigurableApplicationContext)ctx).close();
	}

}
