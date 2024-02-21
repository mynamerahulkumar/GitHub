package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ForkJoinPoolParallel6 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newWorkStealingPool(5);
        Runnable printRunnable=()->{
            for(int i=0;i<5;i++){
               runMethod(i);
            }

        };
        for(int i=0;i<5;i++){
            executorService.execute(printRunnable);
        }
        executorService.shutdown();

    }
    public static void runMethod(int i){
        System.out.println("count-"+i+" "+Thread.currentThread().getName());
    }
}
