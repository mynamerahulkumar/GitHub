package com.udacity.jwdnd.c1.review;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Service
public class MessageService {
    public String message;
    public MessageService(String message){
        System.out.println("Creating message bin");
        this.message=message;
    }
    public String upperCase(){
        return this.message.toUpperCase();
    }
    public String lowercase(){
        return this.message.toLowerCase();
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating message Service bean");
    }
}
