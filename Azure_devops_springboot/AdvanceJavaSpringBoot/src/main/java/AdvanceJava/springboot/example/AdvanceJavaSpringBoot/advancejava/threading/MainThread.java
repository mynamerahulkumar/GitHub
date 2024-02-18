package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.threading;

public class MainThread {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(Thread.currentThread().getName());

        Thread t=new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        t.start();
    }
}
