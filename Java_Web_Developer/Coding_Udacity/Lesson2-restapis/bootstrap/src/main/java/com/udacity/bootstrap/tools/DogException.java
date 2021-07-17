package com.udacity.bootstrap.tools;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason="Dog not found")
public class DogException extends RuntimeException{
    public DogException(){

    }
    public DogException(String message){
        super(message);
    }
}
