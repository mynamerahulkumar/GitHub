package com.in28minutes.spring.basics.learn;

import com.in28minutes.spring.basics.learn.scope.PersonDAO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;


@Configuration
@ComponentScan("com.in28minutes.spring.basics.learn.scope")
@SpringBootApplication
public class SpringScopeApplication {
    private static org.slf4j.Logger LOGGER=  LoggerFactory.getLogger(SpringScopeApplication.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext=SpringApplication.run(SpringScopeApplication.class,args);
        PersonDAO personDAO=applicationContext.getBean(PersonDAO.class);
        PersonDAO personDAO1=applicationContext.getBean(PersonDAO.class);

        LOGGER.info("{}",personDAO);
        LOGGER.info("{}",personDAO.getJdbcConnection());// different bean is available for jdbconnection
        LOGGER.info("{}",personDAO1);
        LOGGER.info("{}",personDAO1.getJdbcConnection());// different bean is available for jdbconnection

    }
}
