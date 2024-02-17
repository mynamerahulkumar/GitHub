package AdvanceJava.springboot.example.AdvanceJavaSpringBoot.advancejava.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericHack2 {
    public static void main(String[] args) {
        ArrayList<String> strList=new ArrayList<>();
        strList.add("af");
        strList.add("wr");
        strList.forEach(st-> System.out.println(st));
        ArrayList<Object> objList=new ArrayList<>();
        objList.add(10);
        objList.add(true);
        objList.add(new Myclass());
        strList.addAll((List)objList);// at run time it does not differnriate with String and object

      //  strList.forEach(s-> System.out.println(s));
        System.out.println(strList.size());

        int a=10;

    }
    static class Myclass{

    }
}
