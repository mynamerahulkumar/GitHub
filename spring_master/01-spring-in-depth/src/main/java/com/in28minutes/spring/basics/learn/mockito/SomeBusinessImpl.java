package com.in28minutes.spring.basics.learn.mockito;

import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;

public class SomeBusinessImpl {

   private DataService dataService;
   public SomeBusinessImpl(DataService dataService){
       super();
       this.dataService=dataService;
   }
   public int greatesofAllData(){
       int[]data=dataService.retrieveAllData();
       int greatest=Integer.MIN_VALUE;
       for(int d:data){
           if(greatest<d){
               greatest=d;
           }
       }
       return  greatest;
   }


}
