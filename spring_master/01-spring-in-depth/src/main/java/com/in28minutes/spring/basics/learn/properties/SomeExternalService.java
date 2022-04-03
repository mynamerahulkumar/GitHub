package com.in28minutes.spring.basics.learn.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
public class SomeExternalService {
    @Value("${external.service.url}")
    private String url;
    public   String getUrl(){
        return url;
    }
}
