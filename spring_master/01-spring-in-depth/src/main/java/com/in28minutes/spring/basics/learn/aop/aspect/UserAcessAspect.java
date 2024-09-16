package com.in28minutes.spring.basics.learn.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//configuration
@Configuration
@Aspect
public class UserAcessAspect {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("com.in28minutes.spring.basics.learn.aop.aspect.CommonJointPointConfig.businessLayerExecution()")
    public void before(JoinPoint joinPoint){
        logger.info("Check for access");
        logger.info("Allowed Execution for {}",joinPoint);
    }
}
