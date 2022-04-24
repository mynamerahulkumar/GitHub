package com.mockitoJunit.SpringTest.betterassertions;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import javax.print.Doc;
import java.util.List;

// JSONpath test help us to test what is inside the json easily
public class JsonPathTest {

    @Test
    public void learning(){
        String responseFromService="[{id:1,price:22,name:apple},{id:2,price:23,name:mango}]";
        DocumentContext context=JsonPath.parse(responseFromService);
        int length=context.read("$.length()");
        assertThat(length).isEqualTo(2);
        List<Integer>ids=context.read("$..id");
        assertThat(ids).containsExactly(1,2);
        System.out.println(context.read("$.[1]").toString());
    }
}
