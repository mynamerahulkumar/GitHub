package com.udacity.jwdnd.c1.review;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	public String message(){
		System.out.println("Inside message");
		return "Hello spring";
	}
	@Bean
	public String uppercaseBean(MessageService messageService){
		System.out.println("Uppercase bean created");
		return messageService.upperCase();
	}
	@Bean
	public String lowerCaseBean(MessageService messageService){
		System.out.println("Lowercase bean created");
		return messageService.lowercase();
	}

}
