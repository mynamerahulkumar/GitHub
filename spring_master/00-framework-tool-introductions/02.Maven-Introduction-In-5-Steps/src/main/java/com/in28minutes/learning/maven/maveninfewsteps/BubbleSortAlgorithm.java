package com.in28minutes.learning.maven.maveninfewsteps;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("bubble")
public class BubbleSortAlgorithm  implements SortAlgorithm{
    @Override
    public int[] sort(int[] numbers) {

        //sorting methods
        return numbers;
    }
}
