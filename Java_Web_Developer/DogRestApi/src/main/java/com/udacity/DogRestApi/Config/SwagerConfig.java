package com.udacity.DogRestApi.Config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwagerConfig {

    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()).useDefaultResponseMessages(false);
    }
    private ApiInfo apiInfo(){
        return new ApiInfo("Dog Rest API",
                "THis api returns a list of dogs",
                "1.0",
                "http://www.udacity.com/tos",
                new Contact("Udacious Student", "www.udacity.com","myeaddress@udacity.com"),
                 "License of API", "http://www.udacity.com/license", Collections.emptyList());
    }
}
