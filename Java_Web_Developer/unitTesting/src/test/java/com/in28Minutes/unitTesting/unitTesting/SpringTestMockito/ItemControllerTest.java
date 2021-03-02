package com.in28Minutes.unitTesting.unitTesting.SpringTestMockito;

import com.in28Minutes.unitTesting.unitTesting.springMockito.ItemController;
import com.in28Minutes.unitTesting.unitTesting.springMockito.controller.ItemBusinessService;
import com.in28Minutes.unitTesting.unitTesting.springMockito.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ItemBusinessService businessService;
//    @Test
//    public void hello_world(){
//        when(businessService.getRetrieveData()).thenReturn(new Item(1,"def",3,4));
//        RequestBuilder request= MockMvcRequestBuilders.get("/dummy-item").
//                accept(MediaType.APPLICATION_JSON);
//        try{
//            MvcResult result1=mockMvc.perform(request).
//                    andExpect(status().isOk()).andExpect( content().json("{id:1,name:def,price:3,quantity:4}")).
//                    andReturn();
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    @Test
    public void get_all_db_test(){
        when(businessService.retrieveAllItemsFromDb()).thenReturn(
                Arrays.asList(new Item(25,"sensei",3,4),
                        new Item(26,"shinichi",3,4)));// it is calling mock and not with db mapping
        RequestBuilder request= MockMvcRequestBuilders.get("/all-item-db").
                accept(MediaType.APPLICATION_JSON);
        try{
            MvcResult result1=mockMvc.perform(request).
                    andExpect(status().isOk()).andExpect( content().json("[{id:25,name:sensei,price:3,quantity:4}," +
                    "{id:26,name:shinichi,price:3,quantity:4}]")).
                    andReturn();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
//    @Test
//    public void hello_Item_Business(){
//        RequestBuilder request= MockMvcRequestBuilders.get("/business-item").
//                accept(MediaType.APPLICATION_JSON);
//        try{
//            MvcResult result1=mockMvc.perform(request).
//                    andExpect(status().isOk()).andExpect( content().json("{\"id\":25,\"name\":\"sensei\",\"price\":3,\"quantity\":4}")).
//                    andReturn();
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
   // }
}
