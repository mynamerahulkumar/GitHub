package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.generics;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Hello world");

        final int []x={10};
        Runnable r=new Runnable() {
            @Override
            public void run() {
                x[0]++;
            }
        };
        r.run();
    }
    static void mod(int[]a){
        a[0]++;
    }
}
