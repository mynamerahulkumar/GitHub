package com.in28minutes.learning.maven.maveninfewsteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl {

    @Autowired
    @Qualifier("quick")
    private  SortAlgorithm sortAlgorithm;

    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        super();
        this.sortAlgorithm = sortAlgorithm;
    }

    public  int binarySearch(int[] numbers,int numberToSearchFor){
        BubbleSortAlgorithm bubbleSortAlgorithm=new BubbleSortAlgorithm();
        int[]sortedNumber=bubbleSortAlgorithm.sort(numbers);
        // binary search logic
        return 3;
    }

}
