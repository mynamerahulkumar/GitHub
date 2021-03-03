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
	@Primary
	@Bean
	public String basicMessage(){
		System.out.println("Inside basic message");
		return "Hello ";
	}
	@Bean
	public String compoundMessage(String basicMessage){
		System.out.println("Inside compound message -"+basicMessage);
		return "Inside compound message with basicmessage"+basicMessage;
	}
	@Bean
	public int characterCount(String message){	// receive basic message because of primary
		System.out.println("character count-"+message);
		return message.length();
	}

}
