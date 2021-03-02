package com.in28Minutes.unitTesting.unitTesting.businessTest;

import com.in28Minutes.unitTesting.unitTesting.data.DataService;
import com.in28Minutes.unitTesting.unitTesting.springMockito.DbHandling.ItemRepository;
import com.in28Minutes.unitTesting.unitTesting.springMockito.controller.ItemBusinessService;
import com.in28Minutes.unitTesting.unitTesting.springMockito.model.Item;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import com.in28Minutes.unitTesting.unitTesting.business.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

//class someDataImple implements DataService{
//
//    @Override
//    public int[] dataRetrieval() {
//        return new int[]{1,2,3};
//    }
//}
//class someDataImpleEmpty implements DataService{
//
//    @Override
//    public int[] dataRetrieval() {
//        return new int[]{};
//    }
//}
//class someDataImpleOneElement implements DataService{
//
//    @Override
//    public int[] dataRetrieval() {
//        return new int[]{5};
//    }
//}
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessTestMock {
    @InjectMocks
    businesImpl busines=new businesImpl();

    @Mock
    DataService dataServiceMock;

    @Before
    public void before(){
        System.out.println("Before runnling");
        busines.setDataService(dataServiceMock);
    }
    @Test
    public void calculateSum_Basic(){
        when(dataServiceMock.dataRetrieval()).thenReturn(new int[]{1,2,3});
        int actualResult=busines.calculateSumDataRetrieval();
        int expectedResult=6;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void calculateSum_EmptyBasicTest(){

        when(dataServiceMock.dataRetrieval()).thenReturn(new int[]{});
        int actualResult=busines.calculateSumDataRetrieval();
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void calculateSum_OneBasicTest(){

        when(dataServiceMock.dataRetrieval()).thenReturn(new int[]{5});
        int actualResult=busines.calculateSumDataRetrieval();
        int expectedResult=5;
        assertEquals(expectedResult,actualResult);
    }


}
