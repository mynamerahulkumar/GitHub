package com.mockitoJunit.SpringTest.repositroytest;

import com.mockitoJunit.SpringTest.mvctest.JsonAssertTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.skyscreamer.jsonassert.JSONAssert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// it will launch the entire application from the package
// which has mentioned @SpringbootApplication-it will search and launch the entire package which has this mention
public class IntegratationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String response=this.restTemplate.getForObject("/item-data",String.class);
        System.out.println("response--------------"+response);
        JSONAssert.assertEquals("[{id:2},{id:3},{id:4},{id:5}]",response,false);

    }

}
