package com.in28minutes.spring.basics.learn.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExectionCalculation {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Around("com.in28minutes.spring.basics.learn.aop.aspect.CommonJointPointConfig.tractTime()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long timestarted=System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long timetaken=System.currentTimeMillis()-timestarted;
        logger.info("time taken by {} is {}",proceedingJoinPoint,timetaken);


    }
}
