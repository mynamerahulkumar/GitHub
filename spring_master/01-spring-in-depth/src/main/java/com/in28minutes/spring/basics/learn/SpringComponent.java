package com.in28minutes.spring.basics.learn;

import com.in28minutes.spring.basics.learn.component.ComponentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.in28minutes.spring.basics.learn.component")
public class SpringComponent {
  public static Logger LOGGER= LoggerFactory.getLogger(SpringComponent.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext= SpringApplication.run(SpringComponent.class,args);
        ComponentDao componentDao=applicationContext.getBean(ComponentDao.class);
        LOGGER.info("{}",componentDao);

    }
}
