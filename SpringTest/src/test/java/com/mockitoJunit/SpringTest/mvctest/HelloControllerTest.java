package com.mockitoJunit.SpringTest.mvctest;

import com.mockitoJunit.SpringTest.springmvc.service.HelloController;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello_world() throws Exception{
        //call GET "hello-world" application/json
        RequestBuilder request= MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc.perform(request).andExpect(status().isOk())
                        .andExpect(content().string("Hello World"))
                        .andReturn();

        // verify hello world
        assertEquals("Hello World",result.getResponse().getContentAsString());

    }
}
