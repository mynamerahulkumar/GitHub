package com.in28minutes.spring.basics.springin5steps.junit;

import com.in28minutes.spring.basics.learn.junit.SumMethod;
import org.junit.*;

import static org.junit.Assert.*;
public class MyMathTest {
    SumMethod sumMethod=new SumMethod();

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class method");// class level method so static first one to be called-db conn
    }
    @Before
    public void before(){
        System.out.println("Before");
    }
    @Test
    public  void testMethod(){
        // absence of success is failure
        int result=sumMethod.sum(new int[]{1,2,3});
        assertEquals(6,result);
        System.out.println("testing sum method");
    }
    @After
    public  void after(){
        System.out.println("After");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After class");
    }

}
