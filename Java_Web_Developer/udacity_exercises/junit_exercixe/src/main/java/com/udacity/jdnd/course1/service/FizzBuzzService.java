package com.udacity.jdnd.course1.service;

import org.junit.Test;
import org.junit.Assert;
public class FizzBuzzService {

    /**
     * If number is divisible by 3, return "Fizz". If divisible by 5,
     * return "Buzz", and if divisible by both, return "FizzBuzz". Otherwise,
     * return the number itself.
     *
     * @Throws IllegalArgumentException for values < 1
     */

    public String fizzBuzz(int number) {
        if(number<1){
            throw  new IllegalArgumentException("Number is less than 1");
        }
        if(number %3==0 && number %5==0){
            return "FizzBuzz";
        }
        if(number%3==0){
            return "Fizz";
        }
        if(number%5==0){
            return "Buzz";
        }
        else{
            return String.valueOf(number);
        }
    }
    @Test
    public void testBuzz(){
        Assert.assertEquals("Fizz",fizzBuzz(0));
        Assert.assertEquals("Buzz",fizzBuzz(5));
        Assert.assertEquals("FizzBuzz",fizzBuzz(15));
    }


}
