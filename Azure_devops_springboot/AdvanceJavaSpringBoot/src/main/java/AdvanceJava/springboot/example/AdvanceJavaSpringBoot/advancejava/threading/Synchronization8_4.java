package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.threading;

public class Synchronization8_4 {
    private static final Object lock1=new Object();
    private static final Object lock2=new Object();
    static  void sync1(){
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " start1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " end1");
        }
    }
    static synchronized void sync2(){
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " start2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " end2");
        }
    }
    public static void main(String[] args) {
        Thread t1=new Thread(Synchronization8_4::sync1);
        Thread t2=new Thread(Synchronization8_4::sync2);
        /**
         * it will print start first paralleyly and end parally since both different objects methods are synchronized
         *
         */
        t1.start();
        t2.start();

    }
}
