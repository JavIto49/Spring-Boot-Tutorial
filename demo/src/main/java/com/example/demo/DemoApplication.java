package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication bundles:
// - @Configuration (class can declare @Bean methods)
// - @EnableAutoConfiguration (Spring Boot auto-configures beans based on classpath)
// - @ComponentScan (scans this package and subpackages for @Component/@Service/@Repository/@Controller)
@SpringBootApplication
public class DemoApplication {

	// Entry point. Starts embedded Tomcat, loads the Spring ApplicationContext,
	// applies auto-configuration, and begins listening on port 8080 by default.
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}