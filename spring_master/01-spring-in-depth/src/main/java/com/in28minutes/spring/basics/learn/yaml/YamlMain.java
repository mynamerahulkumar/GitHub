package com.in28minutes.spring.basics.learn.yaml;

import com.in28minutes.spring.basics.learn.yaml.utility.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YamlMain implements CommandLineRunner {
    @Autowired
    Config config;
    public static void main(String[] args) {
        SpringApplication.run(YamlMain.class,args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println(config);
    }
}
