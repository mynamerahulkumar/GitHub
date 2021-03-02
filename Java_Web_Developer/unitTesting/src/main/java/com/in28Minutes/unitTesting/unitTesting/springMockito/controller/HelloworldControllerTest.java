package com.in28Minutes.unitTesting.unitTesting.springMockito.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import com.in28Minutes.unitTesting.unitTesting.springMockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloworldControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void hello_worldBasic(){
        RequestBuilder request= MockMvcRequestBuilders.get("/hello-world").
                accept(MediaType.APPLICATION_JSON);
        try {
            MvcResult result=mockMvc.perform(request).
                        andExpect(status().isOk()).andExpect(content().string("Hello World1")).
                    andReturn();


          //  assertEquals("Hello World", result.getResponse().getContentAsString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
