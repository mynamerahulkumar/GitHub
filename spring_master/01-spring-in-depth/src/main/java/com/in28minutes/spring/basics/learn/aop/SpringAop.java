package com.in28minutes.spring.basics.learn.aop;

import com.in28minutes.spring.basics.learn.aop.business.Business1;
import com.in28minutes.spring.basics.learn.aop.business.Business2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAop implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Business1 business1;

    @Autowired
    private Business2 business2;

    public static void main(String[] args) {
        SpringApplication.run(SpringAop.class,args);

    }

    @Override
    public void run(String... args) throws Exception {
       logger.info( business1.calculateSomething());
       logger.info( business1.calculateSomething());

    }
}
