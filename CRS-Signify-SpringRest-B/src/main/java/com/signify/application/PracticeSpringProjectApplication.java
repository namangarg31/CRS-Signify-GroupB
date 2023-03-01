package com.signify.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Both annotation @Configuration @EnableAuto load internally the dependent spring modules
@Configuration
@EnableAutoConfiguration
//Scans all components like service, dao, bean, etc
@ComponentScan("com.signify.*")
//Model View Controller
@EnableWebMvc
//This @SpringBootApplication is the annotation which is the entry point of Spring App
@SpringBootApplication
public class PracticeSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringProjectApplication.class, args);
		System.out.println("Hello World!");
	}
}
