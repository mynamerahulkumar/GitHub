package com.in28minutes.spring.basics.learn.dbopr.jpa;

import com.in28minutes.spring.basics.learn.dbopr.jpa.repository.PeopleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringJPAdbOpr  implements CommandLineRunner {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    PeopleRepository peopleRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringJPAdbOpr.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("JPA operation-{}",peopleRepository.findById(20001));
    }
}
