package com.udacity.jdnd.JavaWebCourse.message.core;

import com.udacity.jdnd.JavaWebCourse.message.Services.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class,args);
    }
    @Bean
    public String message(){
        System.out.println("Creating message bin");
        return "Hello String";
    }
    @Bean
    public String uppecaseMessage(MessageService messageService){
        System.out.println("Creating message uppercase bin");
        return  messageService.upperCase();
    }
    @Bean
    public String lowercaseMessage(MessageService messageService){
        System.out.println("Creating message lowercase bin");
        return messageService.lowerCase();
    }
}
