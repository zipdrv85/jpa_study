package com.inzent.selenium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@ComponentScan({ "com.inzent" })
public class InzentTestModuleApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.main.allow-bean-definition-overriding", "true");
		//System.setProperty("spring.devtools.restart.enabled", "false"); //class가 바뀌어도 리부팅 못하게

		SpringApplication.run(InzentTestModuleApplication.class, args);
	}
}
