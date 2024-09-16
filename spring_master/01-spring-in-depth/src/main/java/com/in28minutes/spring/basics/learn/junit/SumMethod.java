package com.in28minutes.spring.basics.learn.junit;

public class SumMethod {
    public  int sum(int[]numbers){
        int sum=0;
        for(int num:numbers){
            sum+=num;
        }
        return sum;
    }
}
