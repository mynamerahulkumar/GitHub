package com.mockitoJunit.SpringTest.mvctest;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualValue="{\"id\":1,\"price\":22,\"name\":\"mango\"}";

   @Test
    public void strictMatchJson() throws JSONException {
        String expectedValue="{\"id\":1,\"price\":22,\"name\":\"mango\"}";
        JSONAssert.assertEquals(expectedValue,actualValue,true);
    }
    // here we can remove some key pair
  @Test
    public void strictFalseMatchJson() throws JSONException{
        String expectedValue="{\"id\":1,\"name\":\"mango\"}";
        JSONAssert.assertEquals(expectedValue,actualValue,false);
    }
    // checking without slace
    @Test
    public void matchWithoutSlace() throws JSONException{
        String expectedValue="{id:1,price:22,name:mango}";
        JSONAssert.assertEquals(expectedValue,actualValue,true);// it works with both false and true
    }

}
