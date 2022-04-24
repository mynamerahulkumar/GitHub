package com.mockitoJunit.SpringTest;

import com.mockitoJunit.SpringTest.business.BussinessApplication;
import com.mockitoJunit.SpringTest.business.service.SomeDataService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.security.RunAs;

import  static org.mockito.Mockito.mock;
import static  org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BusinessMockTest {

    @InjectMocks
    BussinessApplication bussinessApplication;
    @Mock
    SomeDataService someDataServiceMock; // it will automically setter method


    @Test
    public  void  testSumMock(){
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6,bussinessApplication.getSumByDataService());
    }
    @Test
    public void testoneSum(){

        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5,bussinessApplication.getSumByDataService());

    }
    @Test
    public void testEmptySum(){
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0,bussinessApplication.getSumByDataService());
    }
}
