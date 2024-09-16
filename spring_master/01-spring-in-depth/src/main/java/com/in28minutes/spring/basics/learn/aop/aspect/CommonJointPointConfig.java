package com.in28minutes.spring.basics.learn.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJointPointConfig {

    @Pointcut("execution(* com.in28minutes.spring.basics.learn.aop.business.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* com.in28minutes.spring.basics.learn.aop.data.*.*(..))")
    public  void businessLayerExecution(){}

    @Pointcut("@annotation(com.in28minutes.spring.basics.learn.aop.aspect.TrackTime)")
    public  void tractTime(){}

}
