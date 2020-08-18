package com.inzent.selenium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.inzent" })
public class InzentTestModuleApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.main.allow-bean-definition-overriding", "true");
		
		SpringApplication.run(InzentTestModuleApplication.class, args);
	}

}
