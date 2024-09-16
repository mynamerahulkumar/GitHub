package com.in28minutes.spring.basics.springin5steps.mockito;

import com.in28minutes.spring.basics.learn.mockito.DataService;
import com.in28minutes.spring.basics.learn.mockito.SomeBusinessImpl;
import com.in28minutes.spring.basics.springin5steps.cdi.SomeCdiBusiness;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class SomeBusinessTest {

    @Test
    public  void findGreatestFromAllData(){
      //  SomeBusinessImpl someBusiness=new SomeBusinessImpl(new SomeBusinessData());

        DataService dataServiceMock=mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{2,34,4});
        SomeBusinessImpl someBusiness=new SomeBusinessImpl(dataServiceMock);
        int result=someBusiness.greatesofAllData();


        assertEquals(34,result);

    }
    @Test
    public void findGreatestForOneValue(){
        DataService dataServiceMock=mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{15});
        SomeBusinessImpl someBusines=new SomeBusinessImpl(dataServiceMock);
        int result=someBusines.greatesofAllData();
        assertEquals(15,result);
    }
}
