package com.in28minutes.spring.basics.learn.dbopr;

import com.in28minutes.spring.basics.learn.dbopr.jdbc.entity.Person;
import com.in28minutes.spring.basics.learn.dbopr.jpa.repository.PersonSpringJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJpaInterfaceRepositoryMain implements CommandLineRunner {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PersonSpringJpaRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(SpringJpaInterfaceRepositoryMain.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("JPA Main-{}",repository.findById(10001));
        int id=10002;
        logger.info("update id-{} {}",id,repository.save(new Person(10002,"John1","Ireland",new Date())));
        logger.info("Insert oper {}",repository.save(new Person("john2","Carlow",new Date())));
        logger.info("Delete person {}",id);
        logger.info("All person details-{}",repository.findAll());
    }
}
