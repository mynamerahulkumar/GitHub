package com.in28minutes.spring.basics.learn.dbopr;

import com.in28minutes.spring.basics.learn.dbopr.jdbc.PersonJdbcDao;
import com.in28minutes.spring.basics.learn.dbopr.jdbc.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringDbOperation implements CommandLineRunner {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PersonJdbcDao personJdbcDao;
    public static void main(String[] args) {
        SpringApplication.run(SpringDbOperation.class,args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("{}",personJdbcDao.getAllPerson());
        int id=10001;
        logger.info("Person info of id{} -{}",id,personJdbcDao.getPersonById(id));
        logger.info("Deleted person- {}",personJdbcDao.deleteById(10002));
        logger.info("Inserted id {} {}",10004,personJdbcDao.insert(
                new Person(10004,"john","Ireland",new Date())
        ));
        logger.info("update id -{} {}",10003,
                new Person(10003,"paul","carlow",new Date()));
    }
}
