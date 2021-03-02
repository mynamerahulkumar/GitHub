package com.in28Minutes.unitTesting.unitTesting.SpringTestMockito;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // it runs all the test rest service
public class ItemControllerIT {
    @Autowired
    TestRestTemplate restTemplate;
    @Test
    public void contextLoads(){
        String response=this.restTemplate.getForObject("/all-item-db",String.class);
        try {
            JSONAssert.assertEquals("[{id:25},{id:232},{id:2324},{id:2352}]",response,false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
