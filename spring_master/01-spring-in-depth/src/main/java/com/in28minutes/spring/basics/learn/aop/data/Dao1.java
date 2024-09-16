package com.in28minutes.spring.basics.learn.aop.data;

import com.in28minutes.spring.basics.learn.aop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {


    @TrackTime
    public String retrieveSomething(){
        return "Dao1";
    }

}
