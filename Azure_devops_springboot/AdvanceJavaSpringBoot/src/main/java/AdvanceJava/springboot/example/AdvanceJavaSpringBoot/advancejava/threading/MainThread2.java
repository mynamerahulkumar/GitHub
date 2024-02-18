package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.threading;

import java.util.ArrayList;

public class MainThread2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");

//        Runnable printThreadName=()->{
//            System.out.println(Thread.currentThread().getName());
//        };
        /**
         * 20 thread will on this but randomly each thread will complete it task with schuler
         */
        Runnable printThreadName=()->{
            for (int i=0;i<5;i++){
                System.out.println("count-"+i+" "+Thread.currentThread().getName());

            }
        };

        var threadList=new ArrayList<Thread>(20);
        for(int i=0;i<20;i++){
            threadList.add(new Thread(printThreadName));// creatting a list of new thread and assigining task
        }

        threadList.forEach(Thread::start);//starting each thread one by one

    }
}
