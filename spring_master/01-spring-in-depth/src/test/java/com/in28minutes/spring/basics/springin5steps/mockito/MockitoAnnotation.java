package com.in28minutes.spring.basics.springin5steps.mockito;

import com.in28minutes.spring.basics.learn.mockito.DataService;
import com.in28minutes.spring.basics.learn.mockito.SomeBusinessImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class MockitoAnnotation {
    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Test
    public  void findGreatestFromAllData(){
        //  SomeBusinessImpl someBusiness=new SomeBusinessImpl(new SomeBusinessData());

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{2,34,4});
        int result=someBusiness.greatesofAllData();


        assertEquals(34,result);

    }
}
