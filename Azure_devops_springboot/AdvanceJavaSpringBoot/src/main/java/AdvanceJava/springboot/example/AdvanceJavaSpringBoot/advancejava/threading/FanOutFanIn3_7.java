package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.threading;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FanOutFanIn3_7 {
    /**
     * we have an array of 50 objects
     * print 1-10 objects sequentially in 1 thread
     * then print 11-40 objects using 4 parallel threads
     * then pring 41-50 objects sequentially in 1 thread
     *
     * ->do this only using threads (no executor,no forkjoinpool etc)
     */
    public static void main(String[] args) throws InterruptedException {
            FanOutFanInJob fanOutFanInJob=new FanOutFanInJob(10,4);
            fanOutFanInJob.run();
    }

    static class FanOutFanInJob{

        int[]item;


        ArrayList<Thread> threads;

        public FanOutFanInJob(int count,int thredCount){

            this.threads=new ArrayList<Thread>(thredCount);
            this.item=new int[count];
            this.item[0]=0;

        }
      synchronized   void  printNext(){

                print(item[0]);
                item[0]++;
                notify();// if we don't place then other thread will not get to know if they can pick
                // then whole process will get completed by one thread

        }
        void print(int index){
            System.out.println(Thread.currentThread().getName()+"-"+index);
        }
        void run() throws InterruptedException {
            while(item[0]<=10){
                print(item[0]);
                item[0]++;
            }
            for(int i=0;i<4;i++){
                // thread is created but not started

                threads.add(new Thread(()->{
                    while (item[0]<=40){ // if we use i here then i value might have different in different stack thread
                        printNext();
                    }

                }));
            }
            threads.forEach(Thread ::start);
            for(Thread thread:threads){
                thread.join();
            }
            while (item[0]<=50){
                print(item[0]);
                item[0]++;
            }
        }
    }

}
