package com.mockitoJunit.SpringTest.betterassertions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
// assertj help us to implement multiple fuction simultaneously
public class AssertJ {

    @Test
    public void learning(){
        List<Integer>numbers= Arrays.asList(12,13,45);
        assertThat(numbers).hasSize(3)
                .contains(12,13)
                .allMatch(x->x>10)
                .allMatch(x->x<100)
                .noneMatch(x->x<10);

        assertThat("").isEmpty();
        assertThat("ABCD").contains("BCD")
                .endsWith("CD");
    }
}
