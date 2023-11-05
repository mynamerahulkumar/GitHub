package com.example.cafe.lambda;

import java.util.function.Function;

public class FunctionalInterface1 {
    public String addMethod(String param, Function<String,String> f){
        return f.apply(param);
    }

    public static void main(String[] args) {
        FunctionalInterface1 obj=new FunctionalInterface1();
        Function<String,String>fun=parameter->parameter+" Message from Lambda";
        String result=obj.addMethod("Hi",fun);
        System.out.println(result);
    }
}
