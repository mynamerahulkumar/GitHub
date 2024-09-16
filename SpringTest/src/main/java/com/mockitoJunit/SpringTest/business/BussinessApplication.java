package com.mockitoJunit.SpringTest.business;

import com.mockitoJunit.SpringTest.business.service.SomeDataService;

import java.util.Arrays;

public class BussinessApplication {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }


    public int getSum(int[]A){
        int sum=0;
        for(int v:A){
            sum+=v;
        }
        return sum;
    }
    public  int getSumByDataService(){
        int[]data=someDataService.retrieveAllData();
        int sum=0;
        for(int v:data){
            sum+=v;
        }
        return  sum;
    }
    public int calculateSum(int[]A){
       int sum= Arrays.stream(A).reduce(Integer::sum).orElse(0);
       return sum;
    }
}
