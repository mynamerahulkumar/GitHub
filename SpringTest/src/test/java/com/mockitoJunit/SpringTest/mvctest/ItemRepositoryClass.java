package com.mockitoJunit.SpringTest.mvctest;

import com.mockitoJunit.SpringTest.springmvc.model.Item;
import com.mockitoJunit.SpringTest.springmvc.repository.ItemRepository;
import com.mockitoJunit.SpringTest.springmvc.service.ItemBusinessService;
import com.mockitoJunit.SpringTest.springmvc.service.ItemController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemRepositoryClass {
    @InjectMocks // mocking the service
    ItemBusinessService businessService;

    @Mock
    ItemRepository repository;
    @Test
    public void calculateSumDataServiceBasic(){
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1,40,"apple"),
                new Item(2,90,"mango")));

        List<Item> items=businessService.retriveAllItem();
        assertEquals(80,items.get(0).getValue());
        assertEquals(180,items.get(1).getValue());
    }
}
