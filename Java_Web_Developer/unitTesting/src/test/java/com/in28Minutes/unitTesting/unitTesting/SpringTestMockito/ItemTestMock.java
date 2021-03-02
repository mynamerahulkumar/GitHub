package com.in28Minutes.unitTesting.unitTesting.SpringTestMockito;

import com.in28Minutes.unitTesting.unitTesting.springMockito.DbHandling.ItemRepository;
import com.in28Minutes.unitTesting.unitTesting.springMockito.controller.ItemBusinessService;
import com.in28Minutes.unitTesting.unitTesting.springMockito.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemTestMock {
    @InjectMocks
    private ItemBusinessService businessService;// it will create instance
    @Mock
    private ItemRepository repository; // this will be injected into bussinessService

    @Test
    public void calculateSumUsingDataService(){
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(25,"Item2",10,10),
                new Item(25,"Item3",4,5)));
        List<Item> items=businessService.retrieveAllItemsFromDb();
        assertEquals(0,items.get(0).getValue());
        assertEquals(0,items.get(1).getValue());
    }
}
