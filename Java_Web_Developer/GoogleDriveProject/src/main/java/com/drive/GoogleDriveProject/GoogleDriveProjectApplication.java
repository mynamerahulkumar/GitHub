package com.drive.GoogleDriveProject;

import com.drive.GoogleDriveProject.Messages.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GoogleDriveProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleDriveProjectApplication.class, args);
	}
	@Bean
	public String message(){
		System.out.println("Creating message bin");
		return "Hello String";
	}
	@Bean
	public String uppercaseMessage(MessageService messageService){
		System.out.println("Creating message uppercase bin");
		return  messageService.upperCase();
	}
	@Bean
	public String lowercaseMessage(MessageService messageService){
		System.out.println("Creating message lowercase bin");
		return messageService.lowerCase();
	}

}
