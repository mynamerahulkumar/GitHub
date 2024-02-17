package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.collections;

import java.util.Arrays;
import java.util.List;

public class StreamOps {
    public static void main(String[] args) {

        var intList=Arrays.asList(34,325,235,235,234,235,2,345253,235,23,52,35,235,235,235);

        intList.forEach(i-> System.out.print(i));
        intList.forEach(i->
                System.out.println(Thread.currentThread().getName()+"---Normal-for-- "+i));// function lambda
            // above is run by single thread -main thread
        intList.
        stream()
                .filter(i->i>100)
                .forEach(System.out::println);// first filtered out i>100 then print

        //map
        intList.stream()
                .map(i->Math.sqrt(i))
                .forEach(System.out::println);
        // reduce
        intList.stream()
                .reduce((accumulator,curr)->accumulator+curr);// accumlator start value=arr[0] or we can intialize also
        // reduce same
      var sum=  intList.stream()
                .reduce(Integer::sum);
        System.out.println("total-sum"+sum);
        System.out.println("----------");
        intList.stream()
                .parallel().forEach(
                        i-> System.out.println(Thread.currentThread().getName()+"   "+i)
                );// it will not be in order since multiple thread runs
                    // default will be no of cores/no of cpu thread
        System.out.println("------");
        // it will be run by different thread even in sequential
        intList.stream().parallel()
                .map(
                        i-> {
                            System.out.println(Thread.currentThread().getName() + " -p-stream--" + i);
                            return i;
                        })
                .sequential()
                .map(
                        i->{
                            System.out.println(Thread.currentThread().getName()+" -s-stream-"+i);
                            return i;

                        }
                )
                .parallel()
                .forEach(i->{
                    System.out.println(Thread.currentThread().getName()+"--pp-stream-"+i);

                });
        // it will be run by main
        intList.stream()
                .map(
                        i-> {
                            System.out.println(Thread.currentThread().getName() + " -p-stream--" + i);
                            return i;
                        })
                .sequential()
                .map(
                        i->{
                            System.out.println(Thread.currentThread().getName()+" -s-stream-"+i);
                            return i;

                        }
                )
                .forEach(i->{
                    System.out.println(Thread.currentThread().getName()+"--pp-stream-"+i);

                });





    }
}
