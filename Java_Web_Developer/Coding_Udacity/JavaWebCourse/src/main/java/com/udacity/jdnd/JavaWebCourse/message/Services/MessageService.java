package com.udacity.jdnd.JavaWebCourse.message.Services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageService {
    private String message;
    public  MessageService(String message){
        this.message=message;
    }
    public String upperCase(){
        return this.message.toUpperCase();
    }
    public  String lowerCase(){
        return this.message.toLowerCase();
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating message bean");
    }
}
