package com.in28minutes.spring.basics.learn;

import com.in28minutes.spring.basics.learn.properties.ExternalFile;
import com.in28minutes.spring.basics.learn.properties.SomeExternalService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
@SpringBootApplication
public class SpringProperties {
    private static org.slf4j.Logger LOGGER=  LoggerFactory.getLogger(SpringScopeApplication.class);
    public static void main(String[] args) {
        System.out.println("segsdg");
        ApplicationContext applicationContext= SpringApplication.run(SomeExternalService.class,args);
        SomeExternalService someExternalService=applicationContext.getBean(SomeExternalService.class);
        String resultUrl=someExternalService.getUrl();
        LOGGER.info("{}",resultUrl);
        System.out.println(resultUrl.toString());
    }
}
