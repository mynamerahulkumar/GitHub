package com.in28minutes.spring.basics.springin5steps.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoListInterfaceTest {

    @Test
    public  void testListSize(){
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(10);
        assertEquals(10,listMock.size());
    }
    @Test
    public  void getSpecificParameter(){
        List listMock=mock(List.class);
        when(listMock.get(0)).thenReturn("sdgsg");
        assertEquals("sdgsg",listMock.get(0));
    }
    @Test
    public void getGenericParameter(){
        List listMock=mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("sgsg");
        assertEquals(listMock.get(9),"sgsg");
    }
}
