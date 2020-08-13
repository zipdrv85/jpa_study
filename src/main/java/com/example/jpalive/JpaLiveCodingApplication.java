package com.example.jpalive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={ "com.example.jpalive" })
@EnableJpaRepositories("com.example.jpalive.repository")
public class JpaLiveCodingApplication {

	public static void main(String[] args) {		
		SpringApplication.run(JpaLiveCodingApplication.class, args);
	}
}
