package com.in28Minutes.unitTesting.unitTesting.SpringTestMockito;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String actualJson="{\"id\":1,\"name\":\"abc\",\"price\":3,\"quantity\":4}";
    @Test
    public void getJsonAssert() throws JSONException {
        String expectedJson="{\"id\":1,\"name\":\"abc\",\"price\":3,\"quantity\":4}";
        JSONAssert.assertEquals(expectedJson,actualJson,true);
    }
    public void getJsonNotStrict() throws JSONException{
         String expectedJson="{\"id\":1,\"name\":\"abc\",\"price\":3";
         JSONAssert.assertEquals(expectedJson,actualJson,false);

    }


}
