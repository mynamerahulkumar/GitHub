package com.mockitoJunit.SpringTest;

import com.mockitoJunit.SpringTest.business.BussinessApplication;
import com.mockitoJunit.SpringTest.business.service.SomeDataService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BussinessData implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}
class BussinessDataOneElement implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}
class BussinessDataEmpty implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}
public class BusinessTest {
    @Test
    public void testSum(){
        BussinessApplication bussinessApplication=new BussinessApplication();
        bussinessApplication.setSomeDataService(new BussinessData());
        int actualResult=bussinessApplication.getSumByDataService();
        int expectedResult=6;
        assertEquals(actualResult,expectedResult);
    }
    @Test
    public void testoneSum(){
        BussinessApplication bussinessApplication=new BussinessApplication();
        bussinessApplication.setSomeDataService(new BussinessDataOneElement());
        int actualResult=bussinessApplication.getSumByDataService();
        int expectedResult=5;
        assertEquals(actualResult,expectedResult);
    }
    @Test
    public void testEmptySum(){
        BussinessApplication bussinessApplication=new BussinessApplication();
        bussinessApplication.setSomeDataService(new BussinessDataEmpty());
        int actualResult=bussinessApplication.getSumByDataService();
        int expectedResult=0;
        assertEquals(actualResult,expectedResult);
    }
}
