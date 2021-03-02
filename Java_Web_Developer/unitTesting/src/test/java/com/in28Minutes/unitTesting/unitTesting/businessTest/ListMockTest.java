package com.in28Minutes.unitTesting.unitTesting.businessTest;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.nullable;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock=mock(List.class);
    @Test
    public void  size_basic(){
        List mock=mock(List.class);
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }
    @Test
    public void differentSize(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }
    @Test
    public void returnwithOneParamete(){
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));
        assertEquals(null,mock.get(1));
    }
    @Test
    public void returnGenericParameters(){
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));
        assertEquals("in28Minutes",mock.get(1));
    }
    @Test
    public void verificationBasics(){
       // String value=mock.get(0);
        String value1=mock.get(0);
        String value2=mock.get(1);

        //verify
       verify(mock).get(0);
      //  verify(mock).get(anyInt());
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());

      verify(mock,never()).get(2);
    }
    @Test
    public void argumentCapturing(){
        mock.add("SomeString");
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("SomeString",captor.getValue());
    }
    @Test
    public void multipleArgumentCapturing(){
        mock.add("SomeString");
        mock.add("SomeString2");
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());
        List<String> allValues=captor.getAllValues();
        assertEquals("SomeString",allValues.get(0));
        assertEquals("SomeString2",allValues.get(1));
    }
    // you let the action happend and keep observing it
    @Test
    public void spying(){
        ArrayList arrayListSpy=spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size());
        arrayListSpy.add("Test");
        arrayListSpy.add("Test1");
        System.out.println(arrayListSpy.size());
        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.add("Test4");
        System.out.println(arrayListSpy.size());
        verify(arrayListSpy).add("Test4");

    }
}
