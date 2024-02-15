package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.collections;

import java.util.ArrayList;

public class GenericHack2 {
    public static void main(String[] args) {
        ArrayList<String> strList=new ArrayList<>();
        strList.add("af");
        strList.add("wr");
        strList.forEach(st-> System.out.println(st));
        int a=10;

    }
}
