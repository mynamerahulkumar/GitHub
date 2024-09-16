package com.mockitoJunit.SpringTest.betterassertions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;



public class HamCrestMatcherTest {

    @Test
    public void learning(){
        List<Integer>list= Arrays.asList(12,24,45);
        assertThat(list,hasSize(3));
        assertThat(list,hasItems(12,24));
        assertThat(list,everyItem(greaterThan(10)));
        assertThat(list,everyItem(lessThan(1000)));

        assertThat("",isEmptyString());
        assertThat("ABCD",containsString("AB"));
        assertThat("ABCD",startsWith("AB"));
        assertThat("ABCD",endsWith("CD"));

    }

}
