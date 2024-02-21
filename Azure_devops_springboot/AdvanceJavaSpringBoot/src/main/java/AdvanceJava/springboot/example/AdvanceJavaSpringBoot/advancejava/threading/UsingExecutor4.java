package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutor4 {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newCachedThreadPool();
        ExecutorService executor1= Executors.newSingleThreadExecutor();// single thread executor not much use
        ExecutorService service=Executors.newFixedThreadPool(5);// use fixed thread ,it is better ,it initalizse all blocking queue mechanism
        // having executors with equal to number of cores is more ideal since in reality this happens only


        // Runnable is task - subset of program-set of instruction grouped together in functions
        Runnable printThreadName=()->{
            for(int i=0;i<5;i++){
                System.out.println("count-"+i+" "+Thread.currentThread().getName());
            }
        };
        for(int i=0;i<20;i++){
            service.execute(printThreadName);
        }
        service.shutdown();

    }
}

