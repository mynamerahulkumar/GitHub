package com.mockitoJunit.SpringTest.mvctest;

import com.mockitoJunit.SpringTest.springmvc.model.Item;
import com.mockitoJunit.SpringTest.springmvc.repository.ItemRepository;
import com.mockitoJunit.SpringTest.springmvc.service.ItemBusinessService;
import com.mockitoJunit.SpringTest.springmvc.service.ItemController;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

import  static org.mockito.Mockito.mock;
import static  org.mockito.Mockito.when;
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemBusinessService businessService;

    @Mock
    ItemRepository repository;

    @Test
    public  void get_DummyWorld() throws  Exception{
        RequestBuilder request= MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"price\":22,\"name\":\"mango\"}"))
                .andReturn();

    }

    @Test
    public  void itemFromBusinessService_basics() throws Exception {
        when(businessService.retrieveItemDate()).thenReturn(new Item(1,22,"mango"));

        RequestBuilder request=MockMvcRequestBuilders.get("/business-item").accept(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().json("{id:1,price:22,name:mango}"))
                .andReturn();
    }
    @Test
    public void retriveAllItems() throws Exception{
        when(businessService.retriveAllItem()).thenReturn(Arrays.asList(new Item(1,22,"apple"),
                new Item(2,23,"mango")));

        RequestBuilder request=MockMvcRequestBuilders.get("/item-data").accept(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().json("[{id:1,price:22,name:apple},{id:2,price:23,name:mango}]"))
                .andReturn();
    }
   // @Test
    public void postItems(){
        RequestBuilder request=MockMvcRequestBuilders.post("/save-item")
                .accept(MediaType.APPLICATION_JSON)
                .content("{id:6,price:24,name:papaya}")
                .contentType(MediaType.APPLICATION_JSON);
//        MvcResult result=mockMvc.perform(request)
//                .andExpect(status().isCreated())
//                .andExpect(header().string("location",containssString("/item"))).andReturn()
    }
    @Test
    public void calculateSumDataServiceBasic(){
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1,40,"apple"),
                new Item(2,90,"mango")));

        List<Item>items=businessService.retriveAllItem();
        assertEquals(80,items.get(0).getValue());
    }



}
