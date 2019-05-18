package com.appcraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppcraftAssignmentTestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppcraftAssignmentTestApplication.class, args);
		System.out.println("AppCraft initialized");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppcraftAssignmentTestApplication.class);
	}
	
	
}
