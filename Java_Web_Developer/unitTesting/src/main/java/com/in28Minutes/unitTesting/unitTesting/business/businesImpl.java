package com.in28Minutes.unitTesting.unitTesting.business;

import com.in28Minutes.unitTesting.unitTesting.data.DataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class businesImpl {

    private DataService dataService;
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public  int calculateSum(int []arr){
        OptionalInt number= Arrays.stream(arr).reduce(Integer::sum);
       return number.orElse(0);
    }
    public int calculateSumDataRetrieval(){
        int []arr= dataService.dataRetrieval();
        return Arrays.stream(arr).reduce(Integer::sum).orElse(0);

    }
}
