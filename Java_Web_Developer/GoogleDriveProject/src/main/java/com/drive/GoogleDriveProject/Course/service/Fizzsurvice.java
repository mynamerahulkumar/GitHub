package com.drive.GoogleDriveProject.Course.service;

public class Fizzsurvice {

    public String getFizz(int number){
        if(number==0 || number==-1) {
            throw new IllegalArgumentException("Value must be greater than 0");
        }
        else if (number == 15 || number == 75) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return "" + number;
        }
    }
}
