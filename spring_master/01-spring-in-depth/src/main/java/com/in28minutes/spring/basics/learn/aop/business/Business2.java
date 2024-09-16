package com.in28minutes.spring.basics.learn.aop.business;

import com.in28minutes.spring.basics.learn.aop.data.Dao1;
import com.in28minutes.spring.basics.learn.aop.data.Dao2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Dao2 dao2;

    public String calculateSomething(){
        //business logic
        String value=dao2.retrieveSomething();
        logger.info("In Business-{}",value);
        return value;
    }
}
