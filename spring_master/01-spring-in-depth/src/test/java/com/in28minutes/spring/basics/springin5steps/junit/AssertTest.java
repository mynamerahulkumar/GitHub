package com.in28minutes.spring.basics.springin5steps.junit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssertTest {

    @Test
    public  void test(){
        boolean cond=true;
        assertEquals(3,3);
        assertTrue(cond);
        assertFalse(false);
        int[]arr={1,2,3};
        assertArrayEquals(arr,new int[]{1,2,3});
    }
}
