package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.threading;

public class Synchronization8_2 {
    static synchronized void sync1(){
        System.out.println(Thread.currentThread().getName()+" start1");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" end1");
    }
    static void sync2(){
        System.out.println(Thread.currentThread().getName()+" start2");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" end2");
    }
    public static void main(String[] args) {
        Thread t1=new Thread(Synchronization8_2::sync1);
        Thread t2=new Thread(Synchronization8_2::sync2);
        /**
         * it will print start first both thread parallely and end parallerly
         *
         */
        t1.start();
        t2.start();

    }
}
